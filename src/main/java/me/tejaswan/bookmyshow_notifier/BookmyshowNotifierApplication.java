package me.tejaswan.bookmyshow_notifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookmyshowNotifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowNotifierApplication.class, args);
	}

}
