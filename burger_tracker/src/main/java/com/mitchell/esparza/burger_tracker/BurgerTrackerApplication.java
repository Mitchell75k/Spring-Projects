package com.mitchell.esparza.burger_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//importing this to make the delete method work in our edit.jsp html file
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class BurgerTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BurgerTrackerApplication.class, args);
	}

	// This is needed to make the delete method work in our edit.jsp html file
	@Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }

}
