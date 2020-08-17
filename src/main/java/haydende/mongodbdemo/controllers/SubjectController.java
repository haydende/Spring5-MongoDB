package haydende.mongodbdemo.controllers;

import haydende.mongodbdemo.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/subjects/")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @RequestMapping("/")
    public String findAll(Model model) {
        log.error("Invoking SubjectController.findAll()");
        model.addAttribute("subjects", subjectService.findAll());
        return "subjects/subjects";
    }
}
