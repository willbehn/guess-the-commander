package no.behn.guessthecommander.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import no.behn.guessthecommander.model.Card;
import no.behn.guessthecommander.service.DailyCommanderService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class DailyCommanderController {

    private final DailyCommanderService dailyCommanderService;
    
    @Autowired
    public DailyCommanderController(DailyCommanderService dailyCommanderService){
        this.dailyCommanderService = dailyCommanderService;
    }

    @GetMapping("/card/daily")
    public Card getDailyCommander() throws IOException, InterruptedException {
        
        return dailyCommanderService.getCard();
    }
    
}
