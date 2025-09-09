package germanstory.adapters.llm;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import germanstory.application.port.out.StoryGeneratorPort;

@Service
public class OpenAIAdapter implements StoryGeneratorPort {

    private final WebClient webClient;

    @Value("${openai.api.key}")
    private String openAiApiKey;

    public OpenAIAdapter(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1/chat/completions").build();
    }

    @Override
    public String requestStory(String prompt) {
        
        var request = Map.of(
            "model", "gpt-4o-mini",
            "messages", List.of(Map.of("role", "user", "content", prompt))
        );

        return webClient.post()
               .header("Authorization", "Bearer " + openAiApiKey)
               .bodyValue(request)
               .retrieve()
               .bodyToMono(Map.class)
               .map(response -> {
                    var choices = (List<Map<String, Object>>) response.get("choices");

                    if(choices != null && !choices.isEmpty()) {
                        Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                        return (String) message.get("content");
                    }
                    else return "Error generating story";
               }).block();
    }
    
}
