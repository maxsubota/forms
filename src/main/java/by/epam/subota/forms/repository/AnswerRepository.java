package by.epam.subota.forms.repository;

import by.epam.subota.forms.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
