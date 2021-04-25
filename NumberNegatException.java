//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class NumberNegatException extends Exception {

    Leitura leitura = new Leitura();

    public void numNegat() { // Mensagem de erro
        System.out.println("\nValor nao pode ser negativo! Tente novamente.");
    }

    // Bluetooth

    public Bluetooth corrigePrecoBluetooth(Bluetooth blue) { // Preço do fone bluetooth

        try {
            blue.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigePrecoBluetooth(blue);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Maior preco existente: R$ 56000.00");
            nie.corrigePrecoBluetooth(blue);
        }
        return blue;
    }

    public Bluetooth corrigeTipoBluetooth(Bluetooth blue) { // Tipo Bluetooth
        try { // Tenta receber o tipo de bluetooth
            blue.setTipoBlue(Float.parseFloat(leitura.entDados("\nTipo de Bluetooth..: ")));
        } catch (NumberFormatException nfe) {
            System.out.println("Valor invalido! Digite somente numeros");
            System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeTipoBluetooth(blue);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
            nie.corrigeTipoBluetooth(blue);
        }
        return blue;
    }

    public Bluetooth corrigeDuracaoBat(Bluetooth blue) { // Duração da bateria

        try {
            blue.setDuracaoBat(Integer.parseInt(leitura.entDados("\nDuracao da Bateria em horas: ")));
        } catch (NumberFormatException nfe) {
            System.out.println("Erro! Digite um numero inteiro.");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeDuracaoBat(blue);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Duracao maxima: 200 horas");
            nie.corrigeDuracaoBat(blue);
        }
        return blue;
    }

    public Bluetooth corrigeBorResBluetooth(Bluetooth blue) { // Numero de borrachas reservas
        try {
            blue.getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
        } catch (NumberFormatException nfe) {
            System.out.println("\nErro! Digite um numero inteiro.");
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Numero maximo de borrachas: 20");
            nie.corrigeBorResBluetooth(blue);
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeBorResBluetooth(blue);
        }
        return blue;
    }

    public Bluetooth corrigeAvalMaterialBluetooth(Bluetooth blue) {// Avaliação do material
        try {
            blue.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalMaterialBluetooth(blue);
            System.out.println("Digite um numero de 0 a 5.");
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Digite um numero de 0 a 5.");
            nie.corrigeAvalMaterialBluetooth(blue);
        }
        return blue;
    }

    public Bluetooth corrigeAvalQualidadeBluetooth(Bluetooth blue) {// Avaliação da qualidade
        try {
            blue.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalQualidadeBluetooth(blue);
            System.out.println("Digite um numero de 0 a 5.");
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Digite um numero de 0 a 5.");
            nie.corrigeAvalQualidadeBluetooth(blue);
        }
        return blue;
    }

    public Bluetooth corrigeAvalConfortoBluetooth(Bluetooth blue) {// Avaliação do conforto
        try {
            blue.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto..: ")));
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalConfortoBluetooth(blue);
            System.out.println("Digite um numero de 0 a 5.");
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Digite um numero de 0 a 5.");
            nie.corrigeAvalConfortoBluetooth(blue);
        }
        return blue;
    }

    // Com Cabo

    public ComCabo corrigePrecoComCabo(ComCabo cabo) { // Preço do fone com cabo
        try {
            cabo.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigePrecoComCabo(cabo);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Maior preco existente: R$ 56000.00");
            nie.corrigePrecoComCabo(cabo);
        }
        return cabo;
    }

    public ComCabo corrigeCompriCabo(ComCabo cabo) { // Comprimento do cabo
        try { // Tenta receber o comprimento do cabo
            cabo.setCompriCabo(Float.parseFloat(leitura.entDados("\nComprimento do cabo em metros: ")));
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Comprimento maximo: 6.0 metros");
            nie.corrigeCompriCabo(cabo);
        } catch (NumberFormatException nfe) {
            System.out.println("\nErro! Digite somente numeros com ponto. Ex.: 2.5");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeCompriCabo(cabo);
        }

        return cabo;
    }

    public ComCabo corrigeBorResComCabo(ComCabo cabo) { // Numero de borrachas reservas do fone com cabo
        try {
            cabo.getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));

        } catch (NumberFormatException nfe) {
            System.out.println("\nErro! Digite um numero inteiro.");
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            nie.corrigeBorResComCabo(cabo);
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeBorResComCabo(cabo);
        }
        return cabo;
    }

    public ComCabo corrigeAvalMaterialComCabo(ComCabo cabo) { // Avaliação do Material
        try {
            cabo.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));

        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalMaterialComCabo(cabo);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            nie.corrigeAvalMaterialComCabo(cabo);
        }
        return cabo;
    }

    public ComCabo corrigeAvalQualidadeComCabo(ComCabo cabo) { // Avaliação da Qualidade
        try {
            cabo.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade...: ")));

        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalQualidadeComCabo(cabo);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            nie.corrigeAvalQualidadeComCabo(cabo);
        }
        return cabo;
    }

    public ComCabo corrigeAvalConfortoComCabo(ComCabo cabo) { // Avaliação do Conforto
        try {
            cabo.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));

        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalConfortoComCabo(cabo);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            nie.corrigeAvalConfortoComCabo(cabo);
        }
        return cabo;
    }

}
