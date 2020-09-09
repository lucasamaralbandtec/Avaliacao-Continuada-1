package com.heroes.lucasamaralherois;

import Interfaces.IVilao;

public class VilaoIluminado extends Iluminado implements IVilao
{
    public VilaoIluminado(String nome, String sexo, Integer nivelPoder) {
        super(nome, sexo, nivelPoder);
    }

    @Override
    public boolean EhVilao()
    {
    return true;
    }
}