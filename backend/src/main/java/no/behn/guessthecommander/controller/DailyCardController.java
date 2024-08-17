package no.behn.guessthecommander.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.behn.guessthecommander.model.Card;
import no.behn.guessthecommander.service.DailyCardService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class DailyCardController {

    private final DailyCardService dailyCommanderService;
    
    @Autowired
    public DailyCardController(DailyCardService dailyCommanderService){
        this.dailyCommanderService = dailyCommanderService;
    }

    @GetMapping("/card/daily")
    public Card getDailyCommander() throws IOException, InterruptedException {
        return dailyCommanderService.getCard();
    }
    
}
