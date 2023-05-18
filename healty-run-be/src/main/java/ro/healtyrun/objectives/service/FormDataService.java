package ro.healtyrun.objectives.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ro.healtyrun.login.model.User;
import ro.healtyrun.login.repository.UserRepository;
import ro.healtyrun.objectives.exceptions.UserFormDataNotFound;
import ro.healtyrun.objectives.model.FormData;
import ro.healtyrun.objectives.repository.FormDataRepository;

import java.awt.desktop.UserSessionEvent;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FormDataService {

    private final FormDataRepository formDataRepository;

    public List<FormData> getFormDataByUserId(UUID uuid) {
        return formDataRepository.findByUserId(uuid);

    }

    public void saveFormData(FormData formData) {
        formDataRepository.saveAndFlush(formData);
    }
}
