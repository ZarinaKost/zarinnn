package com.example.demo.controllers;

import com.example.demo.models.Admin;
import com.example.demo.reposotories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

public class AdminController {
    @Autowired
    private AdminRepository adminRepository ;
    private long a;

    @RequestMapping("/add")
    public String showForm(Model model){
        model.addAttribute("Admin",new Admin());
        return "author_add_form";
    }

    @RequestMapping("/addd")
    public String showFormm(Model model){
        model.addAttribute("admin",new Admin());
        return "update";
    }
    @PostMapping("/add")
    public String addAdmin(@ModelAttribute Admin admin){
        adminRepository.save(admin) ;

        return "redirect:/demo/all" ;
    }


    @GetMapping("/all2")
    public @ResponseBody
    Iterable<Admin> allAuthors(){
        return adminRepository.findAll() ;
    }

    @GetMapping("/all")
    public String allAuthors2(Model model){
        List<Admin> authors = (List<Admin>) adminRepository.findAll();
        model.addAttribute("authors", authors) ;
        return "authors" ;
    }

    @PostMapping("/adds")
    public String addsAuthor(@ModelAttribute Admin admin){
        Admin admin1 = new Admin();
        admin1.setId(a);
        admin1.setFirstName(admin.getFirstName());
        admin1.setLastName(admin.getLastName());
        admin1.setEmail(admin.getEmail());
        adminRepository.save(admin1) ;

        return "redirect:/demo/all" ;
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updatAdmins(Model model, @RequestParam("id") long id){
        a=id;
        Optional<Admin> admin = (Optional <Admin> ) adminRepository.findById(id);
        model.addAttribute("adminn",admin);
        return new ModelAndView("update");
    }
    @RequestMapping(value = "/deleteContact",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        adminRepository.deleteById(idd);
        return new ModelAndView("redirect:/demo/all");
    }
}
