package com.example.demo.controllers;

import com.example.demo.models.Author;
import com.example.demo.models.Jurnal;
import com.example.demo.reposotories.JurnalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/jurnal")
public class JurnalController {
    @Autowired
    private JurnalRepository jurnalRepository;
    private long a;

    @GetMapping("/main")
    public String allBook(Model model){
        List<Jurnal> jurnals = (List<Jurnal>) jurnalRepository.findAll();
        model.addAttribute("jurnals",jurnals);
        return "jurnals";
    }

    @RequestMapping("/addd")
    public String showFormmm(Model model){
        model.addAttribute("jurnall",new Jurnal());
        return "jurnalupdate";
    }

    @GetMapping("/add")
    public String bookForm(Model model){
        model.addAttribute("jurnal",new Jurnal());
        return "jurnal_add_form";
    }

    @GetMapping("/main2")
    public @ResponseBody
    Iterable<Jurnal> allJurnals(){
        return jurnalRepository.findAll() ;
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Jurnal jurnal){
        jurnalRepository.save(jurnal);
        return "redirect:/jurnal/main";
    }

    @PostMapping("/adds")
    public String addsBooks(@ModelAttribute Jurnal jurnal){
        Jurnal jurnal1 = new Jurnal();
        jurnal1.setId(a);
        jurnal1.setJurnalName(jurnal.getJurnalName());
        jurnal1.setYear(jurnal.getYear());
        jurnalRepository.save(jurnal1) ;

        return "redirect:/book/main" ;
    }

    @RequestMapping(value = "/updateBook",method = RequestMethod.GET)
    public ModelAndView updateAuthors(Model model, @RequestParam("id") long id){
        a=id;
        Optional< Jurnal>  jurnal = (Optional <Jurnal> ) jurnalRepository.findById(id);
        model.addAttribute(" juurnal", jurnal);
        return new ModelAndView(" jurnalupdate");
    }

    @RequestMapping(value = "/deleteBook",method = RequestMethod.GET)
    public ModelAndView deleteContact(@RequestParam("id") long idd){
        jurnalRepository.deleteById(idd);
        return new ModelAndView("redirect:/book/main");
    }
}
