package at.htl.restaurant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping(path = "/greetings")
@RestController
public class GreetingService {

    private static Logger logger = LoggerFactory.getLogger(GreetingService.class);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/hallo", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hallo(){
        logger.info("Moinsn!");
        return "Moinsn!";
    }
}
