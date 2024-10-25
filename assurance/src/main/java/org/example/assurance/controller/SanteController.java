package org.example.assurance.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.assurance.model.Sante;
import org.example.assurance.model.Utilisateur;
import org.example.assurance.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sante")
public class SanteController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping()
    public ModelAndView displayformSante(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            return new ModelAndView("formSante");
        }
        return new ModelAndView("login");
    }

    @PostMapping("submitSante")
    public String addSante(@ModelAttribute("sante") Sante sante, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            sante.setUserId(utilisateur.getId());
            assuranceService.saveSante(sante);

            double montantDevis = assuranceService.devisSante(sante);

            model.addAttribute("montantDevis", montantDevis);

            return "formSante";
        }

        return "redirect:/auth/login";
    }

    @PostMapping("accepterAssurance")
    public String accepterAssurance(@RequestParam("id") Long santeId, Model model) {
        Sante sante = assuranceService.findSanteById(santeId);
        if (sante != null) {
            sante.setAccepte(true);
            assuranceService.saveSante(sante);
            model.addAttribute("assuranceId", sante.getId());
            model.addAttribute("montant", assuranceService.devisSante(sante));

            return "creerContrat";
        }

        return "redirect:/home";
    }

}
