package com.heroes.lucasamaralherois;

import Interfaces.IHeroi;

public class HeroiIluminado extends Iluminado implements IHeroi
{
    public HeroiIluminado(String nome, String sexo, Integer nivelPoder) {
        super(nome, sexo, nivelPoder);
    }

    @Override
    public boolean EhHeroi()
    {
        return true;
    }
}