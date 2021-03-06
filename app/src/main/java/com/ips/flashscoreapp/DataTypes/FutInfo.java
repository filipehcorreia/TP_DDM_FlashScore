package com.ips.flashscoreapp.DataTypes;

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
    //toString made to look better in the listView
    @Override
    public String toString() {
       return tempo + "'"+"     "+tipo  +"\n"+descricao ;
    }
}
