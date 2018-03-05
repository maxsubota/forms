package by.epam.subota.forms.service.impl;

import by.epam.subota.forms.entity.Answer;
import by.epam.subota.forms.entity.Question;
import by.epam.subota.forms.repository.QuestionRepository;
import by.epam.subota.forms.service.AnswerService;
import by.epam.subota.forms.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private final AnswerService answerService;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, AnswerService answerService) {
        this.questionRepository = questionRepository;
        this.answerService = answerService;
    }

    @Override
    public Question saveQuestion(Question question) {
        Question savedQuestion = questionRepository.save(question);

        for (Answer answer : savedQuestion.getAnswers()) {
            answer.setQuestion(question);
            answerService.saveAnswer(answer);
        }

        return savedQuestion;
    }
}
