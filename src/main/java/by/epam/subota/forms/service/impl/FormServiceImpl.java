package by.epam.subota.forms.service.impl;

import by.epam.subota.forms.entity.Form;
import by.epam.subota.forms.entity.Question;
import by.epam.subota.forms.repository.FormRepository;
import by.epam.subota.forms.service.FormService;
import by.epam.subota.forms.service.QuestionService;
import by.epam.subota.forms.util.SecureRandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormServiceImpl implements FormService {

    private static final int USER_TOKEN_LENGTH = 32;
    private static final int ADMIN_TOKEN_LENGTH = 128;

    private final FormRepository formRepository;

    private final QuestionService questionService;


    @Autowired
    public FormServiceImpl(FormRepository formRepository, QuestionService questionService) {
        this.formRepository = formRepository;
        this.questionService = questionService;
    }


    @Override
    public Form saveForm(Form form) {
        SecureRandomString secureRandomString = new SecureRandomString();

        form.setUserToken(secureRandomString.getSecureRandomString(USER_TOKEN_LENGTH));
        form.setAdminToken(secureRandomString.getSecureRandomString(ADMIN_TOKEN_LENGTH));

        Form savedForm = formRepository.save(form);

        for (Question question : savedForm.getQuestions()) {
            question.setForm(form);
            questionService.saveQuestion(question);
        }

        return savedForm;
    }

    @Override
    public Form getForm(String userToken) {
        return formRepository.findByUserToken(userToken);
    }

    @Override
    public List<Form> getAllForms() {
        return formRepository.findAll();
    }
}
