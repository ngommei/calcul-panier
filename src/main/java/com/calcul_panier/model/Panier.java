package com.calcul_panier.model;

public class Panier {
    private final Client client;
    private final int qteHauteGamme;
    private final int qteMilieuGamme;
    private final int qteLaptop;

    public Panier(Client client, int qteHaut, int qteMilieu, int qteLaptop) {
        this.client = client;
        this.qteHauteGamme = qteHaut;
        this.qteMilieuGamme = qteMilieu;
        this.qteLaptop = qteLaptop;
    }

    public double calculerTotal() {
        return client.getPrix("haut_de_gamme") * qteHauteGamme +
                client.getPrix("milieu_de_gamme") * qteMilieuGamme +
                client.getPrix("laptop") * qteLaptop;
    }
}