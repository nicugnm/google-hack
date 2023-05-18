package ro.healtyrun.objectives.threads;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ro.healtyrun.login.model.User;
import ro.healtyrun.login.repository.UserRepository;
import ro.healtyrun.objectives.service.GPTService;
import ro.healtyrun.objectives.service.ObjectiveService;

import java.util.List;

@EnableScheduling
@RequiredArgsConstructor
@Component
public class GPTUpdaterObjectives {

    private final GPTService gptService;
    private final UserRepository userRepository;
    private final ObjectiveService objectiveService;

    @Async
    @Scheduled(cron = "0 0 5 * * ?")
    public void run() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (objectiveService.getUserObjectives(user.getId()).isEmpty()) {
                gptService.getGPTObjective(user.getId());
                // TODO: Format String and save to database
            }
        }
    }
}