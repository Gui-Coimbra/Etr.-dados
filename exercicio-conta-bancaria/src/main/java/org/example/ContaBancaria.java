package org.example;

public class ContaBancaria {

    private Integer numero;
    private Double saldo;

    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Boolean debitar(Double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Débito realizado. Novo saldo: " + saldo);
            return true;
        } else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    public void creditar(Double valor) {
        saldo += valor;
        System.out.println("Crédito realizado. Novo saldo: " + saldo);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
