package com.amit.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	private final Logger logger = LoggerFactory.getLogger(getClass());

  @RequestMapping("/")
  public String home(@RequestParam(name = "userName", required = false, defaultValue = "there!, ") String userName) {
	  logger.info("[Stating] executing handler home()");
	  logger.info(String.format("userName: %s", userName));
	  logger.info("[End] executing handler home()");
	  
	  if(userName != null)
		  return String.format("Hello %s Docker containarized world!", userName);
   
	  return "Hello Docker containarized world!";
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}

