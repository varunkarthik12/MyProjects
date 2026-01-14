package com.project.emailAssistant.EmailAssistant.Service;

import com.project.emailAssistant.EmailAssistant.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

@Service
public class EmailGeneratorService {

    private final WebClient geminiWebClient;

    @Value("${gemini.url}")
    private String gemini_api_url;

    @Value("${gemini.apiKey}")
    private String gemini_api_key;


    public EmailGeneratorService(WebClient.Builder geminiWebClientBuilder) {
        this.geminiWebClient = geminiWebClientBuilder.build();
    }

    public String generateEmail(EmailRequest emailRequest)
    {
        // build a prompt

        String prompt = buildPrompt(emailRequest.getEmailContent(), emailRequest.getTone());

        // craft the request for gemini

        Map<String, Object> requestMap = Map.of(
                "contents", new Object[] {
                        Map.of(
                                "parts", new Object[] {
                                        Map.of("text", prompt)
                                }
                        )
                }
        );

        // Do request and get Response

        String response = "-1Server Error";
        try{
            String formed_url = gemini_api_url+gemini_api_key;

            response = geminiWebClient.post()
                    .uri(formed_url)
                    .header("Content-Type", "application/json")
                    .bodyValue(requestMap)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        }
        finally
        {
            System.out.println("Gemini Call completed");
        }

        // return the reply from gemini

        String extractedResponse = extractResponse(response);


        return (!extractedResponse.isEmpty())? extractedResponse : "ERROR while While Processing the response";

    }

    public String buildPrompt(String emailContent, String tone)
    {
        StringBuilder prompt = new StringBuilder("");

        prompt.append("Generate the reply for the below given email professionally")
                .append("use a ").append(tone).append(" to generate the reply")
                .append("\nthe original email: \n").append(emailContent)
                .append("\ndo not give options , give very accurate as you feel\n")
                .append("Please omit the subject , since it is a reply to the existing email and don't give any title , just giv e only the email reply content");

        return prompt.toString();
    }

    public String extractResponse(String response)
    {
        if(response.startsWith("-1"))
            return response;

        String responseEmail = "";

        try
        {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode node = objectMapper.readTree(response);
             responseEmail = node.path("candidates").get(0)
                    .path("content")
                    .path("parts").get(0)
                    .path("text").toString();

        }
        catch (Exception e)
        {
            System.out.println("ERROR : ERROR in processing the response");
            e.printStackTrace();
        }

        return responseEmail;

    }
}
