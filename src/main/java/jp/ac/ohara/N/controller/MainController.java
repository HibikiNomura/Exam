package jp.ac.ohara.N.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.ac.ohara.N.model.StudentModel;
import jp.ac.ohara.N.service.StudentService;

@Controller
public class MainController {
    
    @Autowired
    private StudentService studentservice;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "こんにちは");
        return "top";
    }
    
    // 登録ページ
    @GetMapping("/form")
    public ModelAndView add(StudentModel student, ModelAndView model) {
		model.addObject("student", student);
		model.setViewName("form");
		return model;
    }
    
    @PostMapping("/form")
    public String student(StudentModel student,
    		RedirectAttributes result, Model model,
    		RedirectAttributes redirectAttributes) {
        try {
            this.studentservice.save(student);
            redirectAttributes.addFlashAttribute("exception", "");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("exception", e.getMessage());
            System.out.println(student);
            System.out.println(e);
        }
        return "redirect:/";
    }
}
