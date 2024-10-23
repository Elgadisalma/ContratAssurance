package org.example.assurance.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.assurance.model.Sante;
import org.example.assurance.model.Utilisateur;
import org.example.assurance.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sante")
public class SanteController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping("")
    public ModelAndView hs() {
        return new ModelAndView("formSante");
    }

    @PostMapping("submitSante")
    public ModelAndView addSante(@ModelAttribute("sante") Sante sante, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            sante.setUserId(utilisateur.getId());
            assuranceService.saveSante(sante);
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("redirect:/auth/login");
    }

}
