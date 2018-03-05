package by.epam.subota.forms.controller;

import by.epam.subota.forms.entity.Form;
import by.epam.subota.forms.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @Autowired
    FormService formService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("forms", formService.getAllForms());
        return "index";
    }

    @RequestMapping("/new-form")
    public String newForm(Model model) {
        model.addAttribute("form", new Form());
        return "new-form";
    }

    @RequestMapping("/public-form{token}")
    public String publicForm(@RequestParam String userToken, Model model) {
        Form form = formService.getForm(userToken);
        model.addAttribute(form);

        return "public-form";
    }






}
