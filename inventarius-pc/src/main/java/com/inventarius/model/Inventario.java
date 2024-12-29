package com.inventarius.model;

import com.inventarius.model.Material;
import java.util.ArrayList;

//pacote de importação referente a exportação de dados em txt.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Inventario {
    private ArrayList<Material> materiais;
    //cria um arraylist que vai usar os itens lá do pacote material, em uma lista materiais.

    // Correção: Inicializando o ArrayList no construtor
    public Inventario() {
        materiais = new ArrayList<>(); // Inicializa a lista de materiais
    }

    public Material consultarMaterial(String nome) {
        for (Material material : materiais) {
            //usa um "enhanced for loop. aqui, ele diz que para itens do tipo (classe) Material,
            // o elemento material será percorrido automaticamente no array materiais.
            // > tipo elemento : lista.

            if (material.getNome().equalsIgnoreCase(nome)) {
                // usa o get.Nome de parâmetro para saber se existe um item de mesmo nome na lista (para consulta).
                // o getNome vai ser usado no futuro através de interface.
                // o equalsIgnoreCase verifica se existe o item, e o IgnoreCase ignora maiúsculas ou minúsculas.
                return material;
            }
        }
        return null;
    }

    // Correção: Mudança para aceitar um objeto Material ao invés de nome e quantidade separadamente
    public void adicionarMaterial(Material material){
        for (Material m : materiais) {
            if (m.getNome().equalsIgnoreCase(material.getNome())) {
                //mesma lógica de for e if explicada no metodo acima.
                System.out.println("Material já existe no inventário.");
                return; // Sai do metodo
            }
        }

        materiais.add(material); // Adiciona o material ao inventário
        System.out.println("Material adicionado com sucesso: " + material.getNome() + " - Quantidade: " + material.getQuantidade());
    }

    public void adicionarQuantidade(String nome, int quantidadeAdicional) {
        for (Material material : materiais) {
            if (material.getNome().equalsIgnoreCase(nome)) {
                // usa a mesma lógica explicada anteriormente para percorrer a lista para o material indicado.
                // se o material existe, a quantidade é igual a ela mesma + quantidade adicional.
                // o return sai do metodo. ele encerra se positivo. retira a necessidade do else.

                material.setQuantidade(material.getQuantidade() + quantidadeAdicional);
                System.out.println("Quantidade atualizada: " + nome + " - Nova Quantidade: " + material.getQuantidade());
                return;
            }
        }

        // se o material não for encontrado, exibe mensagem
        System.out.println("Material não encontrado no inventário.");
    }

    public void diminuirQuantidade(String nome, int quantidadeDiminuida) {
        for (Material material : materiais) {
            if (material.getNome().equalsIgnoreCase(nome)) {
                // mesma logica para percorrer a lista.
                if (quantidadeDiminuida > 0 && material.getQuantidade() >= quantidadeDiminuida) {
                    //essa linha verifica duas coisas: se a quantidade do material é maior que 0, e se a quantidade
                    // no estoque é maior do que a quantidade que o usuário pretende diminuir. isso impede operações como
                    // subtrair 20 itens de um material que possui apenas 10 em estoque.
                    material.setQuantidade(material.getQuantidade() - quantidadeDiminuida);
                    System.out.println("Quantidade atualizada: " + nome + " - Nova Quantidade: " + material.getQuantidade());
                } else {
                    System.out.println("O número de itens em estoque é menor do que a quantidade subtraída.");
                }
                return;
            }
        }
        // Se o material não for encontrado, exibe uma mensagem informando
        System.out.println("Material não encontrado no inventário.");
    }

    // METODO PARA EXPORTAR EM TXT
    public void exportarParaArquivoTxt() {
        //TODO : REVISAR ISSO!!!!!!
        // Obtém o diretório "Downloads" do usuário
        String caminhoDownloads = System.getProperty("user.home") + "/Downloads/inventario.txt";

        File arquivo = new File(caminhoDownloads); // Cria o arquivo na pasta Downloads

        // Verifica se o diretório existe, se não, cria a pasta Downloads
        File downloadsDir = new File(System.getProperty("user.home"), "Downloads");
        if (!downloadsDir.exists()) {
            downloadsDir.mkdir();
        }

        try (FileWriter writer = new FileWriter(arquivo)) {
            //usa a classe/pacote filewriter, para criar uma a função que vai escrever no arquivo
            for (Material material : materiais) {
                writer.write("Nome: " + material.getNome() + " - Quantidade: " + material.getQuantidade() + "\n");
                // escreve no arquivo nome e quantidade do material
            }
            System.out.println("Inventário exportado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();  // se tiver algum erro no caminho, ele trata a exceção e escreve no arquivo qual foi.
        }
    }
}
