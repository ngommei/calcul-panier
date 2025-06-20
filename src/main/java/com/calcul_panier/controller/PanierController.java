package com.calcul_panier.controller;

import com.calcul_panier.model.Client;
import com.calcul_panier.model.Panier;
import com.calcul_panier.model.Particulier;
import com.calcul_panier.model.Professionnel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PanierController {

    @GetMapping("/")
    public String showForm() {
        return "form";
    }

    @PostMapping("/calculer")
    public String calculerTotal(
            @RequestParam String typeClient,
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String prenom,
            @RequestParam(required = false) Double caAnnuel,
            @RequestParam int haut,
            @RequestParam int milieu,
            @RequestParam int laptop,
            Model model
    ) {
        Client client;
        if ("particulier".equals(typeClient)) {
            client = new Particulier(1, nom, prenom);
        } else {
            client = new Professionnel(2, caAnnuel != null ? caAnnuel : 0);
        }

        Panier panier = new Panier(client, haut, milieu, laptop);
        model.addAttribute("total", panier.calculerTotal());
        return "form";
    }
}