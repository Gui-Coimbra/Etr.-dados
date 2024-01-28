package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    /* Método gravaArquivoCsv - Recebe um List de Cachorro e o nome do arquivo a ser gravado,
       sem a extensão .csv.
       Esse método grava em arquivo os dados de cada objeto Cachorro que está no list recebido.
       Não grava a linha de títulos das colunas no arquivo.
     */
    public static void gravaArquivoCsv(List<Cachorro> lista, String nomeArq) {
        FileWriter arq = null;  // objeto que representa o arquivo para escrita
        Formatter saida = null; // objeto que sera usado para escrita no arquivo
        Boolean deuRuim = false;

        nomeArq += ".csv";  // acrescenta a extensao .csv ao nome do arquivo

        // Bloco try-catch para abrir o arquivo
        try {
            // instancia o objeto de FileWriter - equivale a abrir o arquivo
            arq = new FileWriter(nomeArq);
            // instancia o objeto de Formatter, associando com o arq
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);     // encerra o programa com status de erro
        }

        // Bloco try-catch para gravar o arquivo
        try {
            // Percorre a lista de cachorros, obtendo um objeto dog por vez
            for (Cachorro dog : lista) {
                // Grava os dados do objeto dog no arquivo, separando o valor de cada
                // atributo por um ;
                // IMPORTANTE: NÃO DEIXE ESPAÇOS ENTRE OS VALORES E O ;, NEM ANTES NEM DEPOIS
                // TB NÃO COLOQUE UM ; ANTES DO \n
                // o \n representa um final de registro no arquivo
                // se for inteiro, use %d, sem espaçamento
                // se for String, use %s
                // se for Double, pode usar %f, ou %.1f, ou %.2f, dependendo de qtas casas decimais desejar
                saida.format("%d;%s;%s;%.2f\n",dog.getId(),
                        dog.getNome(), dog.getPorte(), dog.getPeso());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;   // sinaliza que deu erro, pois ainda precisa fechar o arquivo
        }
        finally {
            saida.close();    // fecha o objeto saida
            try {
                arq.close();    // fecha o arquivo
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {      // se deu erro,
                System.exit(1);  // encerra o programa com status de erro
            }
        }
    }

    /* Método leExibeArquivoCsv - recebe o nome do arquivo sem a extensao .csv
       Lê o arquivo e exibe os dados do arquivo com saída formatada, em colunas
     */
    public static void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null;  // objeto que representa o arquivo para leitura
        Scanner entrada = null; // objeto usado para ler do arquivo
        Boolean deuRuim = false;

        nomeArq += ".csv";      // acrescenta a extensao .csv ao nome do arquivo

        // Bloco try-catch para abrir o arquivo
        try {
            // Abre o arquivo
            arq = new FileReader(nomeArq);
            // Instancia o objeto do Scanner, associando ao arquivo
            // Define que o delimitador do campo é o ; OU \n
            // Se não definir, o delimitador padrão é o caractere espaço
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para ler o arquivo
        try {
            // Exibe a linha de títulos das colunas
            System.out.printf("%-4s %-15s %-9s %4s\n", "ID",
                    "NOME", "PORTE", "PESO");
            // Enquanto não chegar ao final do arquivo
            while (entrada.hasNext()) {
                // Le os dados de um cachorro, como se fosse do teclado
                // Para String, pode usar next(), pois o delimitador definido é o ; ou  \n
                // Nao use nextLine() para ler String, pois ele leria ate o final do registro
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                String porte = entrada.next();
                Double peso = entrada.nextDouble();
                // Exibe na console os dados lidos, usando saída formatada
                // Espacamento dos valores nos % deve ser igual ao espacamento usado na exibicao dos titulos
                System.out.printf("%04d %-15s %-9s %4.1f\n",id,nome,porte,peso);
            }
        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            erro.printStackTrace();
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            erro.printStackTrace();
            deuRuim = true;
        }
        finally {
            entrada.close();    // fecha a entrada
            try {
                arq.close();    // fecha o arquivo
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {      // se deu erro
                System.exit(1);    // encerra o programa com status de erro
            }
        }
    }

    public static void main(String[] args) {
        // Cria um List de Cachorro
        List<Cachorro> listaDog = new ArrayList<>();

        // Adiciona objetos Cachorro na listaDog
        // O dog de id 6, coloquei 2 palavras no nome, para voces verem que o next()
        // consegue ler as 2 palavras, pq o delimitador da leitura esta definido que nao eh o espaco
        listaDog.add(new Cachorro(1, "Spike","Medio", 15.0));
        listaDog.add(new Cachorro(2, "Pierre","Grande", 15.0));
        listaDog.add(new Cachorro(3, "Satanas","Grande", 20.0));
        listaDog.add(new Cachorro(4, "Cruel","Pequeno", 9.0));
        listaDog.add(new Cachorro(5, "Virugo","Grande", 40.0));
        listaDog.add(new Cachorro(6, "Choco Late","Pequeno", 20.0));
        listaDog.add(new Cachorro(7, "Coragem","Pequeno", 15.0));

        // Exibe a listaDog
        for (Cachorro dog : listaDog) {
            System.out.println(dog);
        }

        // Grava a listaDog no arquivo dogs.csv
        // Se nao especificar um caminho onde sera gravado o arquivo
        // O arquivo eh gravado na pasta raiz do projeto
        gravaArquivoCsv(listaDog, "dogs");

        // Le o arquivo dogs.csv e exibe na console com saida formatada
        System.out.println("\nExibicao dos dados do arquivo:");
        leExibeArquivoCsv("dogs");
    }
}