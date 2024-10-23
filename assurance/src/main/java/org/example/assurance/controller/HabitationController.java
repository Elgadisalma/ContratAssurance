package org.example.assurance.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.assurance.model.Habitation;
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
@RequestMapping("/habitation")
public class HabitationController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping()
    public ModelAndView hb() {
        return new ModelAndView("formHabitation");
    }

    @PostMapping("submitHabitation")
    public ModelAndView addHabitation(@ModelAttribute("habitation") Habitation habitation, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            habitation.setUserId(utilisateur.getId());
            assuranceService.saveHabitation(habitation);
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("redirect:/auth/login");
    }
}
