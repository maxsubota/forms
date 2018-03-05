package by.epam.subota.forms.controller;

import by.epam.subota.forms.entity.Form;
import by.epam.subota.forms.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AjaxController {

    @Autowired
    FormService formService;

    @RequestMapping("/saveForm")
    public ResponseEntity saveForm(@RequestBody Form form, Model model) {

        formService.saveForm(form);

        model.addAttribute("form", form);

        return new ResponseEntity(form.getUserToken(), HttpStatus.OK);
    }
}
