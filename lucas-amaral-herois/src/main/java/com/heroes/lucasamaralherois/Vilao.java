package com.heroes.lucasamaralherois;

import Interfaces.IVilao;

public class Vilao extends Humano implements IVilao
{
    public Vilao(String nome, String sexo)
    {
        super(nome, sexo);
    }

    @Override
    public boolean EhVilao() {
        return true;
    }
}