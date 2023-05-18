package ro.healtyrun.objectives.service;

import com.lilittlecat.chatgpt.offical.ChatGPT;
import jakarta.transaction.Transactional;
import kong.unirest.json.JSONObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.healtyrun.objectives.model.QuestionsAnswers;
import ro.healtyrun.objectives.model.dto.FormDataDto;
import ro.healtyrun.objectives.payload.response.MessageResponse;
import ro.healtyrun.objectives.repository.QuestionsAnswersRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GPTService {

    private final FormDataService formDataService;
    private final QuestionsAnswersRepository questionsAnswersRepository;

    @Transactional
    public MessageResponse getGPTObjective(UUID uuid) {
        List<QuestionsAnswers> formDataDtoList = formDataService.getFormDataByUserId(uuid).stream()
                .map(formData -> questionsAnswersRepository.findById(formData.getQuestionsAnswersId()).get())
                .toList();

        String questionsAnswers = formDataDtoList.stream()
                .map(qa -> qa.getQuestion() + qa.getAnswer())
                .collect(Collectors.joining(","));

        System.out.println("QA: " + questionsAnswers);

        String url = "https://api.openai.com/v1/completions";

        try {
            JSONObject data = new JSONObject();
            data.put("model", "text-davinci-003");
            data.put("prompt", "Provide me some objectives based on the these questions and answers:" + questionsAnswers);
            data.put("max_tokens", 4000);
            data.put("temperature", 0);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer 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")
                    .POST(HttpRequest.BodyPublishers.ofString(data.toString()))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Error: " + response.body());
            }

            return MessageResponse.builder()
                    .message(new JSONObject(response.body()).getJSONArray("choices").getJSONObject(0).getString("text"))
                    .build();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return MessageResponse.builder()
                .message("Error!")
                .build();
    }
}
