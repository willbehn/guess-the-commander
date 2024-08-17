package no.behn.guessthecommander;

import no.behn.guessthecommander.model.Card;
import no.behn.guessthecommander.service.DailyCardService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class DailyCardServiceTest {

    @Autowired
    private DailyCardService dailyCommanderService;

    @Test
    public void testGetCard() throws IOException, InterruptedException {
        Card card = dailyCommanderService.getCard();
        System.out.println("Card: " + card);
    }
}
