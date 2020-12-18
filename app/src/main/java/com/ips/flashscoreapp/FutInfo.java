package com.ips.flashscoreapp;

public class FutInfo {

    public String tempo;
    public String descricao;
    public String tipo;

    public FutInfo(String tempo, String descricao, String tipo) {
        this.tempo = tempo;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "FutInfo{" +
                "tempo='" + tempo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
