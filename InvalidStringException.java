//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class InvalidStringException extends Exception {

    Leitura leitura = new Leitura();

    public void invString() { // Mensagem de erro
        System.out.println("Resposta invalida! Tente novamente.");
    }

    public ComCabo corrigeTipoEntrada(ComCabo cabo) { // Tipo de entrada
        try {
            cabo.setTipoEntrada(leitura.entDados("\nTipo de Entrada...: "));

        } catch (InvalidStringException ise) {
            ise.invString();
            System.out.println("Tipos de entrada existentes: p1, p2, p3, p10 e USB");
            ise.corrigeTipoEntrada(cabo);
        }
        return cabo;
    }
}
