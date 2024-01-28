package org.example;

public class Empregado {

    // Atributos
    private String primeiroNome;
    private String sobrenome;
    private double salario;
    private String departamento;

    // Construtor

    public Empregado(String primeiroNome, String sobrenome, double salario, String departamento) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.departamento = departamento;
    }

    // toString()

    @Override
    public String toString() {
        return "Empregado{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", salario=" + salario +
                ", departamento='" + departamento + '\'' +
                '}';
    }

    // Getters e Setters

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
