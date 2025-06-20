package com.calcul_panier.model;

public class Professionnel extends Client {
    private final double caAnnuel;

    public Professionnel(int id, double caAnnuel) {
        super(id);
        this.caAnnuel = caAnnuel;
    }

    @Override
    public double getPrix(String typeProduit) {
        boolean gros = caAnnuel > 10_000_000;
        return switch (typeProduit) {
            case "haut_de_gamme" -> gros ? 1000 : 1150;
            case "milieu_de_gamme" -> gros ? 550 : 600;
            case "laptop" -> gros ? 900 : 1000;
            default -> throw new IllegalArgumentException("Type inconnu");
        };
    }
}
