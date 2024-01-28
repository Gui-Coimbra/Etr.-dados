package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;

        // Abre o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
            erro.printStackTrace();
        }

        // Grava o registro e finaliza
        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar ou fechar o arquivo");
            erro.printStackTrace();
        }
    }

    public static void gravaArquivoTxt(List<Aluno> lista, String nomeArq) {
        int contaRegistroDado = 0;

        // Monta o registro de header
        String header = "00NOTA20232";
        header+= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header+= "01";

        // Grava o registro de header
        gravaRegistro(nomeArq, header);

        // Monta e grava o corpo (registros de dados)
        for (Aluno a : lista) {
            String corpo = "02";
            corpo += String.format("%-5.5s",a.getCurso());
            corpo += String.format("%-8.8s",a.getRa());
            corpo += String.format("%-50.50s",a.getNome());
            corpo += String.format("%-40.40s",a.getDisciplina());
            corpo += String.format("%05.2f",a.getMedia());
            corpo += String.format("%03d",a.getQtdFalta());
            gravaRegistro(nomeArq, corpo);
            contaRegistroDado++;
        }

        // Monta o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegistroDado);

        // Grava o registro de trailer
        gravaRegistro(nomeArq, trailer);
    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String curso, ra, nome, disciplina;
        Double media;
        int qtdFalta;
        int contaRegDadosLidos = 0;
        int contaRegDadosGravados = 0;

        // Cria uma listaLida para armazenar os dados lidos dos alunos
        List<Aluno> listaLida = new ArrayList<>();

        // Abre o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo");
            erro.printStackTrace();
        }

        // Leitura do arquivo
        try {
            registro = entrada.readLine();

            while (registro != null) { // enqto nao chegou ao final do arquivo
                // obtem os 2 primeiros caracteres do registro, que informa
                // qual eh o tipo de registro
                // substring recebe o indice inicial da substring desejada
                // e recebe como 2o argumento o indice final + 1 da substring desejada
                tipoRegistro = registro.substring(0,2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("eh um registro de header");
                    System.out.println("Tipo do arquivo: " + registro.substring(2,6));
                    System.out.println("Ano e semestre: " + registro.substring(6,11));
                    System.out.println("Data e hora de gravacao: " + registro.substring(11,30));
                    System.out.println("Versao do documento de layout: " + registro.substring(30,32));
                }
                else if (tipoRegistro.equals("01")) {
                    System.out.println("eh um registro de trailer");
                    contaRegDadosGravados = Integer.parseInt(registro.substring(2,12));
                    if (contaRegDadosGravados == contaRegDadosLidos) {
                        System.out.println("Quantidade de registros de dados lidos eh compativel com " +
                                "quantidade de registros de dados gravados");
                    }
                    else {
                        System.out.println("Quantidade de registros de dados lidos eh incompativel com " +
                                "quantidade de registros de dados gravados");
                    }
                }
                else if (tipoRegistro.equals("02")) {
                    System.out.println("eh um registro de dados");
                    curso = registro.substring(2,7).trim();
                    ra = registro.substring(7,15).trim();
                    nome = registro.substring(15,65).trim();
                    disciplina = registro.substring(65,105).trim();
                    media = Double.valueOf(registro.substring(105,110).replace(',','.'));
                    qtdFalta = Integer.parseInt(registro.substring(110,113));

                    contaRegDadosLidos++;

                    // Cria um objeto Aluno com os dados lidos
                    Aluno a = new Aluno(ra, nome, curso, disciplina, media, qtdFalta);

                    // Para importar no banco de dados, pode-se fazer:
                    // repository.save(a)

                    // No nosso caso, como não estamos conectados a Banco de Dados,
                    // vamos adicionar o aluno a na listaLida
                    listaLida.add(a);

                }
                else {
                    System.out.println("tipo de registro invalido");
                }
                // Le o proximo registro
                registro = entrada.readLine();
            }
            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo");
            erro.printStackTrace();
        }

        // Printa a lista lida do arquivo
        System.out.println("\nDados lidos do arquivo:");
        for (Aluno a : listaLida) {
            System.out.println(a);
        }

        // Nesse ponto, tb seria possivel fazer um repository.saveAll() para salvar a lista
        // toda no banco de dados
    }

    public static void main(String[] args) {
        // Criando uma lista de alunos
        List<Aluno> lista = new ArrayList();

        // Preenchendo a lista com alunos
        lista.add(new Aluno("02221000","Maria Eduarda", "CCO",
                "Programacao Web", 8.0, 7));
        lista.add(new Aluno("02211000","Abner Biscassi", "CCO",
                "Estrutura de Dados", 7.5, 10));
        lista.add(new Aluno("01231015","Jose da Silva", "ADS",
                "Sistemas Operacionais", 10.0, 5));
        lista.add(new Aluno("03231030","Ana Beatriz", "SIS",
                "Analise de Requisitos", 7.25, 15));
        lista.add(new Aluno("04232020","Mario Sousa", "REDES",
                "Cabeamento Estruturado", 8.25, 8));

        // Exibe a lista
        System.out.println("Dados da lista de alunos:");
        for (Aluno a : lista) {
            System.out.println(a);
        }

        // Grava o arquivo TXT
        gravaArquivoTxt(lista, "aluno.txt");

        // Le o arquivo TXT
        System.out.println();
        leArquivoTxt("aluno.txt");

    }
}