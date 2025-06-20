package com.calcul_panier.model;

public abstract class Client {
    protected int id;
    public Client(int id) {
        this.id = id;
    }
    public abstract double getPrix(String typeProduit);
}
