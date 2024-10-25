package org.example.assurance.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.assurance.model.Automobile;
import org.example.assurance.model.Habitation;
import org.example.assurance.model.Utilisateur;
import org.example.assurance.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/automobile")
public class AutomobileController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping()
    public ModelAndView diplayformAutomobile(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            return new ModelAndView("formAutomobile");
        }

        return new ModelAndView("login");
    }

    @PostMapping("submitAutomobile")
    public String addAutomobile(@ModelAttribute("automobile") Automobile automobile, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            automobile.setUserId(utilisateur.getId());
            assuranceService.saveAutomobile(automobile);

            double montantDevis = assuranceService.devisAutomobile(automobile);

            model.addAttribute("montantDevis", montantDevis);

            return "formAutomobile";
        }

        return "redirect:/auth/login";
    }

    @PostMapping("accepterAssurance")
    public String accepterAssurance(@RequestParam("id") Long automobileId, Model model) {
        Automobile automobile = assuranceService.findAutomobileById(automobileId);
        if (automobile != null) {
            automobile.setAccepte(true);
            assuranceService.saveAutomobile(automobile);
            model.addAttribute("assuranceId", automobile.getId());
            model.addAttribute("montant", assuranceService.devisAutomobile(automobile));

            return "creerContrat";
        }

        return "redirect:/home";
    }

}
