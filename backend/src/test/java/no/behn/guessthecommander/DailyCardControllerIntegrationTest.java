package no.behn.guessthecommander;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Test created byt chatGPT
@SpringBootTest
@AutoConfigureMockMvc
class DailyCardControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // Jackson ObjectMapper to handle JSON

    @Test
    void getDailyCommander_ShouldPrintPrettyCard() throws Exception {
        // Perform the GET request to the /api/card/daily endpoint
        MvcResult result = mockMvc.perform(get("/api/card/daily"))
                                  .andExpect(status().isOk())  // Expect HTTP 200 status
                                  .andReturn();

        // Get the response content as a String
        String content = result.getResponse().getContentAsString();

        // Use Jackson ObjectMapper to pretty-print the JSON
        ObjectWriter prettyWriter = objectMapper.writerWithDefaultPrettyPrinter();
        String prettyJson = prettyWriter.writeValueAsString(objectMapper.readTree(content));

        // Print the pretty-printed JSON
        System.out.println("API Response:\n" + prettyJson);
    }
}

