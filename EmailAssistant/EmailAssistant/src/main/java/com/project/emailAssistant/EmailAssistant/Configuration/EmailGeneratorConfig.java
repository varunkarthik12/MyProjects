
package com.project.emailAssistant.EmailAssistant.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmailGeneratorConfig {

    @Value("${gemini.url}")
    private String gemini_api_url;

    @Value("${gemini.apiKey}")
    private String gemini_api_key;

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}

