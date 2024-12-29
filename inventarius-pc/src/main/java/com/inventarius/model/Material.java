package com.inventarius.model;

public class Material {
    private String nome;
    private int quantidade;
    //Cria a variável nome e a variável quantidade. Ela quem vai armazenar as informações inseridas.

    // construtor java
    public Material(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    // getter e setter de nome e quantidade para alterar o valor das variáveis.
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
