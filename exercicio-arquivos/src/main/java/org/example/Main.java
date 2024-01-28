package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void gravaArquivoCsv(List<Jogador> lista, String nomeArq) {
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            for (Jogador jogador : lista) {
                saida.format("%d;%s;%d;%.2f;%s;%s;%b\n",
                        jogador.getId(), jogador.getNome(), jogador.getIdade(),
                        jogador.getSalario(), jogador.getNacionalidade(),
                        jogador.getTime(), jogador.isMelhorDoMundo());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }


    /* Método leExibeArquivoCsv - recebe o nome do arquivo sem a extensao .csv
       Lê o arquivo e exibe os dados do arquivo com saída formatada, em colunas
     */
    public static void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        try {
            System.out.printf("%-15s %-9s %-6s %-15s %-15s %-13s\n",
                    "NOME", "IDADE", "SALÁRIO", "NACIONALIDADE", "TIME", "MELHOR DO MUNDO");
            while (entrada.hasNext()) {
                String nome = entrada.next();
                int idade = entrada.nextInt();
                double salario = entrada.nextDouble();
                String nacionalidade = entrada.next();
                String time = entrada.next();
                boolean melhorDoMundo = entrada.nextBoolean();

                System.out.printf("%-15s %-9d %-6.2f %-15s %-15s %-13b\n", nome, idade, salario, nacionalidade, time, melhorDoMundo);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            erro.printStackTrace();
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            erro.printStackTrace();
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }

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

    public static void gravaArquivoTxt(List<Jogador> lista, String nomeArq) {
        int contaRegistroDado = 0;

        // Monta o registro de header
        String header = "00NOTA20232";
        header+= LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header+= "01";

        // Grava o registro de header
        gravaRegistro(nomeArq, header);

        // Monta e grava o corpo (registros de dados)
        for (Jogador a : lista) {
            String corpo = "02";
            corpo += String.format("%-50.50s",a.getNome());
            corpo += String.format("%-10.10s",a.getTime());
            corpo += String.format("%-10.10s",a.getNacionalidade());
            corpo += String.format("%b", a.isMelhorDoMundo());
            corpo += String.format("%5.2f",a.getSalario());
            corpo += String.format("%03d",a.getIdade());
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
        String Time, Nacionalidade, nome;
        Boolean isMelhorDoMundo;
        Double salario;
        int idade;
        int contaRegDadosLidos = 0;
        int contaRegDadosGravados = 0;

        // Cria uma listaLida para armazenar os dados lidos dos alunos
        List<Jogador> listaLida = new ArrayList<>();

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
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("eh um registro de dados");
                    nome = registro.substring(2,52).trim();
                    Time = registro.substring(52,62).trim();
                    Nacionalidade = registro.substring(62,72).trim();
                    isMelhorDoMundo = Boolean.valueOf(registro.substring(72,77).trim());
                    salario = Double.valueOf(registro.substring(77,82).replace(',','.'));
                    idade = Integer.parseInt(registro.substring(82,84));

                    contaRegDadosLidos++;

                    // Cria um objeto Aluno com os dados lidos
                    Jogador a = new Jogador(nome, idade, salario, Nacionalidade, Time, isMelhorDoMundo);

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
        for (Jogador a : listaLida) {
            System.out.println(a);
        }

        // Nesse ponto, tb seria possivel fazer um repository.saveAll() para salvar a lista
        // toda no banco de dados
    }



    public static void main(String[] args) {

        List<Jogador> jogadores = new ArrayList<>();
        Scanner leitor = new Scanner(System.in);
        boolean continuar = true;
        int opcao;

        while (continuar){
            System.out.println("Opção 1 - Adicionar um jogador na lista (cadastro)");
            System.out.println("Opção 2 - Exibir os jogadores cadastrados");
            System.out.println("Opção 3 - Grava arquivo CSV");
            System.out.println("Opção 4 - Lê arquivo CSV e exibe dados lidos");
            System.out.println("Opção 5 - Gravar arquivo TXT");
            System.out.println("Opção 6 - Lê arquivo TXT");
            System.out.println("Opção 7 - Fim do programa (encerrar)");
            opcao = leitor.nextInt();
            switch (opcao){
                case 1:
                    leitor.nextLine();
                    System.out.println("Informe o nome do jogador: ");
                    String nome = leitor.nextLine();
                    System.out.println("Informe a idade do jogador: ");
                    int idade = Integer.parseInt(leitor.nextLine());
                    System.out.println("Informe o salario do jogador: ");
                    double salario = Double.parseDouble(leitor.nextLine());
                    System.out.println("Informe a nacionalidade do jogador: ");
                    String nacionalidade = leitor.nextLine();
                    System.out.println("Informe o time do jogador: ");
                    String time = leitor.nextLine();
                    System.out.println("Informe se o jogador é ou ja foi melhor do mundo " +
                            "(1 - sim, 2 - não): ");
                    int melhor = Integer.parseInt(leitor.nextLine());
                    boolean melhorDoMundo = (melhor == 1);
                    Jogador novo = new Jogador(nome, idade, salario, nacionalidade, time, melhorDoMundo);
                    jogadores.add(novo);
                    System.out.println("Jogador cadastrado com sucesso!");
                    break;
                case 2:
                    if (!jogadores.isEmpty()) {
                        for (Jogador jogador : jogadores) {
                            System.out.println(jogador.toString());
                        }
                    } else {
                        System.out.println("Lista vazia!");
                    }
                    break;
                case 3:
                    if (jogadores.isEmpty()) {
                        System.out.println("Lista de jogadores vazia");
                    } else {
                        leitor.nextLine();
                        System.out.println("Informe o nome do arquivo CSV (sem a extensão .csv): ");
                        String nomeArquivo = leitor.nextLine();
                        gravaArquivoCsv(jogadores, nomeArquivo);
                        System.out.println("Arquivo CSV gravado com sucesso!");
                    }
                    break;
                case 4:
                    System.out.println("Informe o nome do arquivo CSV que deseja ler (sem a extensão .csv): ");
                    String nomeArquivoLeitura = leitor.nextLine();
                    leExibeArquivoCsv(nomeArquivoLeitura);
                    break;
                case 5:
                    if(jogadores.isEmpty()){
                        System.out.println("Lista vazia. Não há nada a gravar!");
                    }else {
                        gravaArquivoTxt(jogadores, "jogador.txt");
                        System.out.println("Gravação efetuada com sucesso!");
                    }
                    break;
                case 6:
                    System.out.println();
                    leArquivoTxt("jogador.txt");
                    break;
                case 7:
                    continuar = false;
                    break;
            }
        }
    }
}