package com.inventarius.main;

import com.inventarius.model.Material;
import com.inventarius.model.Inventario;

public class Main {
    public static void main(String[] args) {
        // Criando o inventário
        Inventario inventario = new Inventario();

        // Criando os objetos de material
        Material cimento = new Material("Cimento", 50);
        Material areia = new Material("Areia", 100);

        // Adicionando materiais ao inventário
        inventario.adicionarMaterial(cimento); // Passando o objeto Material diretamente
        inventario.adicionarMaterial(areia);   // Passando o objeto Material diretamente

        // Consultando materiais
        Material consultaCimento = inventario.consultarMaterial("Cimento");
        if (consultaCimento != null) {
            System.out.println("Material encontrado: " + consultaCimento.getNome() + " - Quantidade: " + consultaCimento.getQuantidade());
        } else {
            System.out.println("Material não encontrado.");
        }

        // Tentando subtrair quantidade
        inventario.diminuirQuantidade("Cimento", 20); // Subtrai 20 unidades de cimento
        inventario.diminuirQuantidade("Areia", 50);   // Subtrai 50 unidades de areia
        inventario.diminuirQuantidade("Cimento", 40); // Tentando subtrair mais do que há disponível
        inventario.exportarParaArquivoTxt();
    }
}
