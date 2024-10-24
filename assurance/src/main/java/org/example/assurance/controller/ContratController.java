package org.example.assurance.controller;

import org.example.assurance.model.Contrat;
import org.example.assurance.model.Document;
import org.example.assurance.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    private ContratService contratService;

    @PostMapping("submitContrat")
    public String submitContrat(@RequestParam("assuranceId") Long assuranceId,
                                @RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                                @RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin,
                                @RequestParam("montant") double montant,
                                @RequestParam(value = "documents", required = false) MultipartFile[] documents) {

        Contrat contrat = new Contrat();
        contrat.setAssuranceId(assuranceId);
        contrat.setDateDebut(dateDebut);
        contrat.setDateFin(dateFin);
        contrat.setMontant(montant);
        contrat.setResilier(false);

        contratService.saveContrat(contrat);

        if (documents != null && documents.length > 0) {
            for (MultipartFile file : documents) {
                if (!file.isEmpty()) {
                    try {
                        String filePath = saveFile(file);
                        Document document = new Document();
                        document.setPath(filePath);
                        document.setContrat(contrat);

                        contratService.saveDocument(document);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long contratId, Model model) {
        Contrat contrat = contratService.findById(contratId);
        model.addAttribute("contrat", contrat);
        return "editContrat";
    }

    @PostMapping("/resilier/{id}")
    public String resilierContrat(@PathVariable("id") Long contratId) {
        Contrat contrat = contratService.findById(contratId);
        if (contrat != null && !contrat.isResilier()) {
            contrat.setResilier(true);
            contratService.editContrat(contrat);
        }
        return "redirect:/home";
    }


    @PostMapping("/update")
    public String updateContrat(@RequestParam("assuranceId") Long assuranceId,
                                @RequestParam("id") Long id,
                                @RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                                @RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin,
                                @RequestParam("montant") double montant,
                                @RequestParam(value = "documents", required = false) MultipartFile[] documents) {

        Contrat contrat = new Contrat();
        contrat.setId(id);
        contrat.setAssuranceId(assuranceId);
        contrat.setDateDebut(dateDebut);
        contrat.setDateFin(dateFin);
        contrat.setMontant(montant);
        contrat.setResilier(false);

        contratService.editContrat(contrat);
        return "redirect:/home";
    }


    private String saveFile(MultipartFile file) throws IOException {
        //chemin vers le dossier uploads
        String uploadDirectory = "uploads";

        File uploadDir = new File(uploadDirectory);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        //le chemin complet du fichier à sauvegarder
        //path to uploads directory     file.separator = /   file.getOriginalFilename() = nom du fichier juste ajoute
        String filePath = uploadDirectory + File.separator + file.getOriginalFilename();

        //sauvegarder le fichier
        File yy = new File(filePath);
        file.transferTo(yy);

        //retourne le chemin du file
        return filePath;
    }

}
