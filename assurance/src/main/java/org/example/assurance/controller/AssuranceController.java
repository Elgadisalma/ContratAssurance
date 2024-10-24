package org.example.assurance.controller;

import org.example.assurance.model.Contrat;
import org.example.assurance.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class AssuranceController {

    @Autowired
    private ContratService contratService;

    @GetMapping()
    public ModelAndView hh() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Contrat> contrats = contratService.findAllContrats();
        modelAndView.addObject("contrats", contrats);
        return modelAndView;
    }

    @PostMapping("/subscribe")
    public String assuranceChoix(@RequestParam("assuranceType") String assuranceType) {
        if ("sante".equals(assuranceType)) {
            return "redirect:/sante";
        } else if ("automobile".equals(assuranceType)) {
            return "redirect:/automobile";
        } else if ("habitation".equals(assuranceType)) {
            return "redirect:/habitation";
        } else {
            return "redirect:/home";
        }
    }

}
