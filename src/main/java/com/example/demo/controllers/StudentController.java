package com.example.demo.controllers;


import com.example.demo.models.Student;
import com.example.demo.reposotories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository ;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("publisher",new Student());
        return "student_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model) {
        model.addAttribute("student", new Student());
        return "student_update";
    }
    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student){
        studentRepository.save(student) ;
        return "redirect:/pub/all" ;
    }

    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Student> allStudent(){
        return studentRepository.findAll() ;
    }


    @GetMapping("/all")
    public String allStudent2(Model model){
        List<Student> students = (List<Student>) studentRepository.findAll();
        model.addAttribute("students", students) ;
        return "students" ;
    }

    @PostMapping("/adds")
    public String addsStudent(@ModelAttribute Student student){
        Student student1 = new Student();
        student1.setId(a);
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setPhone(student.getPhone());
        student1.setAddress(student.getAddress());
        studentRepository.save(student1) ;
        return "redirect:/pub/all" ;
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateStudents(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Student> student = (Optional <Student> ) studentRepository.findById(id);
        model.addAttribute("studentt",student);
        return new ModelAndView("student_update");
    }



    @RequestMapping(value = "/deletePublisher", method = RequestMethod.GET)
    public ModelAndView deleteContact (@RequestParam("id")long idd){
        studentRepository.deleteById(idd);
        return new ModelAndView("redirect:/pub/all");
    }
}
