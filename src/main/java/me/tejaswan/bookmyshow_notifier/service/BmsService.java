package me.tejaswan.bookmyshow_notifier.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import me.tejaswan.bookmyshow_notifier.doa.bmsEvent.BmsEvent;
import me.tejaswan.bookmyshow_notifier.doa.bmsEvent.ChildEvent;
import me.tejaswan.bookmyshow_notifier.entity.UserRequest;
import me.tejaswan.bookmyshow_notifier.repository.UserRequestRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class BmsService {
    private final String appCode = "MOBAND2";
    private final String appVersion = "12.0.7";
    private UserRequestRepository requestRepository;
    private TelegramService telegramService;

    @Scheduled(cron = "0 * * * * *")
    public void reminderJob() {
        try {
            Iterable<UserRequest> requestsIterable = requestRepository.findAll();
            List<UserRequest> requests = StreamSupport.stream(requestsIterable.spliterator(), false)
                    .collect(Collectors.toList());
            for (UserRequest request : requests) {
                Date date = request.getDate(); // Assuming date is stored as LocalDateTime in UserRequest
                LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), java.time.ZoneId.systemDefault());
                String formattedDate = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

                // Perform your business logic here, e.g., check booking status
                boolean res = checkBooking(request.getMovieCode(), request.getVenueCode(), formattedDate);
                if (res) {
                    telegramService.sendMessageToUser(request.getChatId(),
                            "Movie tickets started for: " + request.getMovieCode() + " " + request.getVenueCode());
                    requestRepository.delete(request); // Delete the request from repository
                }
            }

            System.out.println("Cron job ran at: " + LocalDateTime.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkBooking(String movieCode, String venueCode, String dateCode) {
        ArrayList<BmsEvent> events = getShowTimes(venueCode, dateCode);
        for (BmsEvent event : events) {
            List<ChildEvent> childEvent = event.getChildEvents();
            if (childEvent.isEmpty()) {
                return false;
            }
            String code = event.getChildEvents().get(0).getEventCode();
            if (code.equals(movieCode)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<BmsEvent> getShowTimes(String venueCode, String dateCode) {
        WebDriver driver = null;
        ArrayList<BmsEvent> result = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Set up Chrome options for headless mode
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments(
                    "user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/110.0");
            // Initialize WebDriver
            driver = new ChromeDriver(options);

            // Construct the URL
            String url = String.format(
                    "https://in.bookmyshow.com/api/v2/mobile/showtimes/byvenue?appCode=%s&appVersion=%s&venueCode=%s&dateCode=%s",
                    appCode, appVersion, venueCode, dateCode);

            // Navigate to the URL
            driver.get(url);

            // Extract the body text
            WebElement body = driver.findElement(By.tagName("body"));
            String bodyText = body.getText();
            JsonNode jsonResponse = objectMapper.readTree(bodyText);
            JsonNode showDetailsNode = jsonResponse.get("ShowDetails");
            // Parse the text as JSON
            if (showDetailsNode != null && showDetailsNode.isArray()) {
                for (JsonNode showDetail : showDetailsNode) {
                    JsonNode eventNode = showDetail.get("Event");
                    if (eventNode != null && eventNode.isArray()) {
                        for (JsonNode event : eventNode) {
                            BmsEvent bmsEvent = objectMapper.convertValue(event, BmsEvent.class);
                            result.add(bmsEvent);
                        }
                    }
                }
            }
//            System.out.println(result.get(0).getChildEvents().get(0).getEventCode());
        } catch (Exception e) {
            // result.put("error", e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }

        return result;
    }
}
