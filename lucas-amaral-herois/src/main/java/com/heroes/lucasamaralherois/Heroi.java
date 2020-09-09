package com.heroes.lucasamaralherois;

import Interfaces.IHeroi;

public class Heroi extends Humano implements IHeroi
{
    public Heroi(String nome, String sexo) {
        super(nome, sexo);
    }

    @Override
    public boolean EhHeroi() {
        return true;
    }
}