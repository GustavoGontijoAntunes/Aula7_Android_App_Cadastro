package com.example.aula07_appcadastro;

public class Slide {
    int imgRes;
    String descricao;

    public Slide(int imgRes, String descricao) {
        this.imgRes = imgRes;
        this.descricao = descricao;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
