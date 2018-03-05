package by.epam.subota.forms.repository;

import by.epam.subota.forms.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
