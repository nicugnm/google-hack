package ro.healtyrun.objectives.threads;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ro.healtyrun.login.model.User;
import ro.healtyrun.login.repository.UserRepository;
import ro.healtyrun.objectives.repository.ObjectiveRepository;
import ro.healtyrun.objectives.service.GPTService;
import ro.healtyrun.objectives.service.ObjectiveService;

import java.util.List;
import java.util.Objects;

@Async
@EnableScheduling
@RequiredArgsConstructor
public class GPTUpdaterObjectives {

    private final GPTService gptService;
    private final UserRepository userRepository;
    private final ObjectiveService objectiveService;

    @Scheduled(fixedRate = 1000 * 10)
    public void run() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            if (objectiveService.getUserObjectives(user.getId()).isEmpty()) {
                gptService.getGPTObjective(user.getId());
            }
        }
    }
}
