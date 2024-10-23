package org.example.assurance.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.assurance.model.Automobile;
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
@RequestMapping("/automobile")
public class AutomobileController {

    @Autowired
    private AssuranceService assuranceService;

    @GetMapping()
    public ModelAndView hb() {
        return new ModelAndView("formAutomobile");
    }

    @PostMapping("submitAutomobile")
    public ModelAndView addAutomobile(@ModelAttribute("automobile") Automobile automobile, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Utilisateur utilisateur = (Utilisateur) session.getAttribute("user");

        if (utilisateur != null) {
            automobile.setUserId(utilisateur.getId());
            assuranceService.saveAutomobile(automobile);
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("redirect:/auth/login");
    }

}
