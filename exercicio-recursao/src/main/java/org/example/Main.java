package org.example;

public class Main {

    public static int soma(int n){
        int soma = 0;
        for(int i = 0; i <= n; i++){
            soma+=i;
        }
        return soma;
    }

    public static int somaRecursiva(int n){
        if (n <= 0) {
            return 0;
        } else {
            return n + somaRecursiva(n - 1);
        }
    }

    public static int somaVetor(int[] v){
        int soma = 0;
        for(int i = 0; i < v.length; i++){
            soma+=v[i];
        }
        return soma;
    }

    public static int somaVetorRecursivo(int[] v, int indice){
        if(indice == v.length){
            return 0;
        }
        return v[indice] + somaVetorRecursivo(v, indice + 1);
    }

    public static int somaPares(int[] v){
        int somaPares = 0;
        for(int i = 0; i < v.length; i++){
            if(v[i] % 2 == 0) {
                somaPares += v[i];
            }
        }
        return somaPares;
    }

    public static int somaParesRecursivo(int[] v, int indice){
        if (indice == v.length) {
            return 0;
        }
        int soma = 0;
        if(v[indice] % 2 == 0){
            soma+=v[indice];
        }
        return soma + somaParesRecursivo(v, indice + 1);
    }

    public static int somaImpares(int[] v){
        int somaImpares = 0;
        for(int i = 0; i < v.length; i++){
            if(v[i] % 2 != 0) {
                somaImpares += v[i];
            }
        }
        return somaImpares;
    }

    public static int somaImparesRecursivo(int[] v, int indice){
        if (indice == v.length) {
            return 0;
        }
        int somaImpares = 0;
        if(v[indice] % 2 != 0){
            somaImpares+=v[indice];
        }
        return somaImpares + somaImparesRecursivo(v, indice + 1);
    }

    public static String countOcorrencias(int[] v, int x){
        int vezes = 0;
        for(int i = 0; i < v.length; i++){
            if(v[i] == x) {
                vezes ++;
            }
        }
        return "O valor " + x + " ocorre " + vezes + " vezes";
    }

    public static String countOcorrenciasRecursivo(int[] v, int x, int index, int vezes) {
        if (index == v.length) {
            return "O valor " + x + " ocorre " + vezes + " vezes";
        }

        if (v[index] == x) {
            vezes++;
        }

        return countOcorrenciasRecursivo(v, x, index + 1, vezes);
    }

    // Método sobrecarregado para facilitar a chamada inicial com apenas o vetor e o valor a ser buscado
    public static String countOcorrenciasRecursivo(int[] v, int x) {
        return countOcorrenciasRecursivo(v, x, 0, 0);
    }

    public static int mdc(int numero1, int numero2) {
        while (numero2 != 0) {
            int resto = numero1 % numero2;
            numero1 = numero2;
            numero2 = resto;
        }
        return numero1;
    }

    public static int mdcRecursivo(int numero1, int numero2) {
        if (numero2 == 0) {
            return numero1;
        }
        int resto = numero1 % numero2;

        return mdcRecursivo(numero2, resto);
    }

    public static int maior(int[] v){
        int maior = v[0];
        for(int i = 0; i < v.length; i++){
            if(v[i] > maior){
                maior = v[i];
            }
        }
        return maior;
    }

    public static int maiorRecursivo(int[] v, int indice) {
        if (indice == v.length - 1) {
            return v[indice];
        }
            // Chama a si mesmo de forma recursiva para encontrar o maior elemento do subarray a partir do próximo índice
            int maiorDoRestante = maiorRecursivo(v, indice + 1);

            // Compara o maior elemento do subarray com o elemento do índice atual e retorna o maior valor
            if (v[indice] > maiorDoRestante) {
                return v[indice];
            } else {
                return maiorDoRestante;
            }
    }

    public static int maiorRecursivo(int[] v) {
        return maiorRecursivo(v, 0);
    }

    public static int somaDosDigitos(int numero) {
        int soma = 0;
        while (numero != 0) {
            int digito = numero % 10;
            soma += digito;
            numero /= 10;
        }
        return soma;
    }

    public static int somaDosDigitosRecursivo(int numero) {
        if (numero < 10) {
            return numero;
        } else {
            int digito = numero % 10;

            int somaDoRestante = somaDosDigitosRecursivo(numero / 10);

            return somaDoRestante + digito;
        }
    }

    public static String inteiroBinario(int numero) {
        StringBuilder binario = new StringBuilder();
        while (numero > 0) {
            int resto = numero % 2;
            binario.append(resto);
            numero /= 2;
        }
        if (binario.length() == 0) {
            binario.append("0");
        }
        return binario.reverse().toString();
    }

    public static String inteiroBinarioRecursivo(int numero) {
        if (numero <= 0) {
            return "0";
        } else {
            int resto = numero % 2;
            return inteiroBinario(numero / 2) + resto;
        }
    }

    public static void main(String[] args) {

        int[] vetor = {1, 4, 6, 10, 5, 3, 20, 45, 5, 1, 6};

        System.out.println("-".repeat(30));
        System.out.println("Soma iterativa: " + soma(54));
        System.out.println("Soma recursiva: " + somaRecursiva(54));
        System.out.println("-".repeat(30));
        System.out.println("-".repeat(30));
        System.out.println("Soma vetor iterativa: " + somaVetor(vetor));
        System.out.println("Soma vetor recursiva: " + somaVetorRecursivo(vetor, 0));
        System.out.println("-".repeat(30));
        System.out.println("-".repeat(30));
        System.out.println("Soma pares iterativa: " + somaPares(vetor));
        System.out.println("Soma pares recursiva: " + somaParesRecursivo(vetor, 0));
        System.out.println("-".repeat(30));
        System.out.println("-".repeat(30));
        System.out.println("Soma impares iterativa: " + somaImpares(vetor));
        System.out.println("Soma impares recursiva: " + somaImparesRecursivo(vetor, 0));
        System.out.println("-".repeat(30));
        System.out.println("-".repeat(30));
        System.out.println("Quantidade de ocorrencias iterativa: " + countOcorrencias(vetor, 5));
        System.out.println("Quantidade de ocorrencias recursiva: " + countOcorrenciasRecursivo(vetor, 5));
        System.out.println("-".repeat(30));
        System.out.println("-".repeat(30));
        System.out.println("MDS iterativa: " + mdc(90, 54));
        System.out.println("MDS recursiva: " + mdcRecursivo(90, 54));
        System.out.println("-".repeat(30));
        System.out.println("-".repeat(30));
        System.out.println("maior iterativa: " + maior(vetor));
        System.out.println("maior recursiva: " + maiorRecursivo(vetor));
        System.out.println("-".repeat(30));
        System.out.println("-".repeat(30));
        System.out.println("Soma dos digitos iterativa: " + somaDosDigitos(112));
        System.out.println("Soma dos digitos recursiva: " + somaDosDigitosRecursivo(112));
        System.out.println("-".repeat(30));
        System.out.println("-".repeat(30));
        System.out.println("Inteiro para binario iterativa: " + inteiroBinario(45));
        System.out.println("Inteiro para binario recursiva: " + inteiroBinarioRecursivo(45));
        System.out.println("-".repeat(30));
    }
}