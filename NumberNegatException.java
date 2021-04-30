//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class NumberNegatException extends Exception {

    Leitura leitura = new Leitura();

    public void numNegat() { // Mensagem de erro
        System.out.println("\nValor nao pode ser negativo! Tente novamente.");
    }
}