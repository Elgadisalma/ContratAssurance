package org.example.assurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class AssuranceController {

    @GetMapping()
    public ModelAndView hh() {
        return new ModelAndView("home");
    }

    @GetMapping("sante")
    public ModelAndView hs() {
        return new ModelAndView("formSante");
    }

    @GetMapping("automobile")
    public ModelAndView ha() {
        return new ModelAndView("formAutomobile");
    }


    @PostMapping("/subscribe")
    public String assuranceChoix(@RequestParam("assuranceType") String assuranceType) {
        if ("sante".equals(assuranceType)) {
            return "redirect:/home/sante";
        } else if ("automobile".equals(assuranceType)) {
            return "redirect:/home/automobile";
        } else if ("habitation".equals(assuranceType)) {
            return "redirect:/habitation";
        } else {
            return "redirect:/home";
        }
    }

}
