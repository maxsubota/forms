package by.epam.subota.forms.repository;

import by.epam.subota.forms.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FormRepository extends JpaRepository<Form, Integer> {
    Form findByUserToken(@Param("userToken") String userToken);
}
