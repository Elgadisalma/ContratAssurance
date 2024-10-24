package org.example.assurance.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.assurance.model.Contrat;
import org.example.assurance.model.Utilisateur;
import org.example.assurance.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class AssuranceController {

    @Autowired
    private ContratService contratService;

    @GetMapping()
    public String listerMesContrats(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");
        Long userId = utilisateur.getId();


        System.out.println(userId);
        List<Contrat> contrats = contratService.findContratsByUserId(userId);
        model.addAttribute("contrats", contrats);
        return "home";
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
