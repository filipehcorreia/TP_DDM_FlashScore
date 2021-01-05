package com.ips.flashscoreapp;

import java.io.Serializable;

public class FutInfo implements Serializable {

    public String tempo;
    public String descricao;
    public String tipo;

    public FutInfo(String tempo, String descricao, String tipo) {
        this.tempo=tempo;
        this.descricao = descricao;
        this.tipo = tipo;

    }

    @Override
    public String toString() {
       return tempo + "'"+"     "+tipo  +"\n"+descricao ;
    }
}
