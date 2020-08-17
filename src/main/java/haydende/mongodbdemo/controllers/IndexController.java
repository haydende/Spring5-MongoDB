package haydende.mongodbdemo.controllers;

import haydende.mongodbdemo.service.StudentService;
import haydende.mongodbdemo.service.SubjectService;
import haydende.mongodbdemo.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final StudentService studentService;

    public IndexController(TeacherService teacherService, SubjectService subjectService, StudentService studentService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String getAll(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "index";
    }
}
