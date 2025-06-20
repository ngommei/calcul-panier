package com.calcul_panier.model;

public class Particulier extends Client {
    private final String nom;
    private final String prenom;

    public Particulier(int id, String nom, String prenom) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public double getPrix(String typeProduit) {
        return switch (typeProduit) {
            case "haut_de_gamme" -> 1500;
            case "milieu_de_gamme" -> 800;
            case "laptop" -> 1200;
            default -> throw new IllegalArgumentException("Type inconnu");
        };
    }
}
