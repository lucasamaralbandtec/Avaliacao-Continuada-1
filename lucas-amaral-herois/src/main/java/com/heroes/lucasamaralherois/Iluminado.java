package com.heroes.lucasamaralherois;

import Interfaces.IVilao;

public abstract class Iluminado extends Humano
{
    public Integer nivelPoder;

    public Iluminado(String nome, String sexo, Integer nivelPoder) {
        super(nome, sexo);
        this.nivelPoder = nivelPoder;
    }
}