package org.example.assurance.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.assurance.model.Habitation;
import org.example.assurance.model.Sante;
import org.example.assurance.model.Utilisateur;
import org.example.assurance.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/habitation")
public class HabitationController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping()
    public ModelAndView displayformHabitation(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            return new ModelAndView("formHabitation");
        }
        return new ModelAndView("login");
    }

    @PostMapping("submitHabitation")
    public String addHabitation(@ModelAttribute("habitation") Habitation habitation, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            habitation.setUserId(utilisateur.getId());
            assuranceService.saveHabitation(habitation);

            double montantDevis = assuranceService.devisHabitation(habitation);

            model.addAttribute("montantDevis", montantDevis);

            return "formHabitation";
        }

        return "redirect:/auth/login";
    }

    @PostMapping("accepterAssurance")
    public String accepterAssurance(@RequestParam("id") Long habitationId, Model model) {
        Habitation habitation = assuranceService.findHabitationById(habitationId);
        if (habitation != null) {
            habitation.setAccepte(true);
            assuranceService.saveHabitation(habitation);
            model.addAttribute("assuranceId", habitation.getId());
            model.addAttribute("montant", assuranceService.devisHabitation(habitation));

            return "creerContrat";
        }

        return "redirect:/home";
    }
}
