package by.epam.subota.forms.service;


import by.epam.subota.forms.entity.Form;

import java.util.List;

public interface FormService {
    Form saveForm(Form form);

    Form getForm(String userToken);

    List<Form> getAllForms();
}
