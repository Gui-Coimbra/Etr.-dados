package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PilhaObj<Operacao> pilha = new PilhaObj<>(10);
        FilaObj<Operacao> fila = new FilaObj<>(10);
        int contador = 0;

        Scanner leitor = new Scanner(System.in);

        ContaBancaria conta1 = new ContaBancaria(1, 700.0);
        ContaBancaria conta2 = new ContaBancaria(2, 1500.0);

        boolean continuar = true;

        while(continuar) {
            System.out.println("1- Debitar valor");
            System.out.println("2- Creditar (Depositar) valor");
            System.out.println("3- Desfazer operação");
            System.out.println("4- Agendar operação");
            System.out.println("5- Executar operações agendadas");
            System.out.println("6- Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = leitor.nextInt();


            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    int numeroContaDebito = leitor.nextInt();
                    System.out.print("Valor do débito: ");
                    double valorDebito = leitor.nextDouble();


                        ContaBancaria contaDebito = (numeroContaDebito == conta1.getNumero()) ? conta1 : conta2;
                        if (contaDebito.debitar(valorDebito)) {
                            Operacao operacaoDebito = new Operacao(contaDebito, "debito", valorDebito);
                            try {
                                pilha.push(operacaoDebito);
                                contador++;

                             } catch (IllegalStateException e) {
                                 System.out.println("Erro: " + e.getMessage());
                            }
                        }
                    break;
                case 2:
                    System.out.print("Número da conta: ");
                    int numeroContaCredito = leitor.nextInt();
                    System.out.print("Valor do crédito: ");
                    double valorCredito = leitor.nextDouble();

                    ContaBancaria contaCredito = (numeroContaCredito == conta1.getNumero()) ? conta1 : conta2;
                    contaCredito.creditar(valorCredito);
                    Operacao operacaoCredito = new Operacao(contaCredito, "credito", valorCredito);
                    try {
                        pilha.push(operacaoCredito);
                        contador++;
                    } catch (IllegalStateException e){
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Quantidade de operações a desfazer: ");
                    int quantidadeDesfazer = leitor.nextInt();
                    if (quantidadeDesfazer > contador) {
                        System.out.println("Quantidade inválida");
                    } else {
                        for (int i = 0; i < quantidadeDesfazer; i++) {
                            Operacao operacaoDesfazer = pilha.pop();
                            ContaBancaria contaDesfazer = operacaoDesfazer.getObjConta();
                            if (operacaoDesfazer.getTipoOperacao().equals("debito")) {
                                contaDesfazer.creditar(operacaoDesfazer.getValor());
                            } else {
                                contaDesfazer.debitar(operacaoDesfazer.getValor());
                            }
                            contador--;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Tipo de operação (debito ou credito): ");
                    String tipoOperacao = leitor.next();
                    System.out.print("Número da conta: ");
                    int numeroConta = leitor.nextInt();
                    System.out.print("Valor da operação: ");
                    double valorOperacao = leitor.nextDouble();

                    ContaBancaria conta = (numeroConta == conta1.getNumero()) ? conta1 : conta2;
                    Operacao operacaoAgendada = new Operacao(conta, tipoOperacao, valorOperacao);
                    try {
                        fila.insert(operacaoAgendada);
                    } catch (IllegalStateException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;

                case 5:
                    if (fila.isEmpty()) {
                        System.out.println("Não há operações agendadas");
                    } else {
                        while (!fila.isEmpty()) {
                            Operacao operacaoAgendada2 = fila.poll();
                            ContaBancaria contaAgendada = operacaoAgendada2.getObjConta();
                            if (operacaoAgendada2.getTipoOperacao().equals("debito")) {
                                contaAgendada.debitar(operacaoAgendada2.getValor());
                            } else {
                                contaAgendada.creditar(operacaoAgendada2.getValor());
                            }
                        }
                    }
                    break;

                case 6:
                    System.out.println("Fim do programa");
                    continuar = false;
                    break;

                default:
                    System.out.println("--- Opção inválida ---");
                    break;
            }
        }
    }
}