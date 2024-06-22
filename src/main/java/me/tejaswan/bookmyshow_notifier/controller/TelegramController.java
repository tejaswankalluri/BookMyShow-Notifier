package me.tejaswan.bookmyshow_notifier.controller;

import lombok.AllArgsConstructor;
import me.tejaswan.bookmyshow_notifier.doa.telegram.ReciveMessage;
import me.tejaswan.bookmyshow_notifier.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TelegramController {
    @Autowired
    private final TelegramService telegramService;
    @PostMapping("/telegram/message")
    public String receiveMessage(@RequestBody ReciveMessage messageBody){
        String message = messageBody.getMessage().getText();
        int chatId = messageBody.getMessage().getChat().getId();

        try {
            if (message.startsWith("/enroll")) {
                telegramService.registerUserWithMovieCode(chatId, message);
            } else if (message.equals("/wl")) {
                telegramService.getWaitingList(chatId);
            } else if (message.equals("/venue")) {
                telegramService.messageVenueList(chatId);
            } else if (message.equals("/start")) {
                telegramService.startMessage(chatId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return "OK";
    }
}
