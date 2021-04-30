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

    public ComCabo corrigeMarcaComCabo(ComCabo cabo) { // Marca cabo
        try {
            cabo.setMarca(leitura.entDados("\nMarca...: "));
        } catch (InvalidStringException ise) {
            ise.invString();
            ise.corrigeMarcaComCabo(cabo);
        }
        return cabo;
    }
    public ComCabo corrigeModeloComCabo(ComCabo cabo) { // Modelo cabo
        try {
            cabo.setModelo(leitura.entDados("\nModelo...: "));
        } catch (InvalidStringException ise) {
            ise.invString();
            ise.corrigeModeloComCabo(cabo);
        }
        return cabo;
    }

    public Bluetooth corrigeMarcaBluetooth(Bluetooth blue) { // Marca bluetooth
        try {
            blue.setMarca(leitura.entDados("\nMarca...: "));
        } catch (InvalidStringException ise) {
            ise.invString();
            ise.corrigeMarcaBluetooth(blue);
        }
        return blue;
    }

    public Bluetooth corrigeModeloBluetooth(Bluetooth blue) { // Modelo bluetooth
        try {
            blue.setModelo(leitura.entDados("\nModelo...: "));
        } catch (InvalidStringException ise) {
            ise.invString();
            ise.corrigeModeloBluetooth(blue);
        }
        return blue;
    }
}
