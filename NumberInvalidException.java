//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class NumberInvalidException extends Exception {

    Leitura leitura = new Leitura();

    public void numberInvalid() { // Mensagem de erro
        System.out.println("Numero invalido! Tente novamente");
    }

    public Escolhas corrigeTipoFone(Escolhas escolha) { // Corrige a escolha do tipo de fone
        try {
            System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo");
            escolha.setTipoFone(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.print("Digite 1 ou 2.\n");
            nie.corrigeTipoFone(escolha);
        } catch (NumberFormatException nfe) {
            System.out.println("\nO valor precisa ser um  numero!\nDigite um 1 ou 2.");
        }
        return escolha;
    }

    public Bluetooth corrigePrecoBluetooth(Bluetooth blue) { // Preço do fone bluetooth

        try {
            blue.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
        } catch (NumberNegatException nne) {
            nne.numNegat();
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
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
            nie.corrigeTipoBluetooth(blue);
        }
        return blue;
    }

    public Bluetooth corrigeDuracaoBat(Bluetooth blue) { // Duração da bateria

        try { // Tenta receber a duração da bateria
            blue.setDuracaoBat(Integer.parseInt(leitura.entDados("\nDuracao da Bateria em horas: ")));
        } catch (NumberFormatException nfe) {
            System.out.println("Erro! Digite um numero inteiro.");
        } catch (NumberNegatException nne) {
            nne.numNegat();
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
            blue.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nConforto..: ")));
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
        } catch (NumberNegatException nne) {
            nne.numNegat();
            System.out.println("Digite um numero de 0 a 5.");
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Digite um numero de 0 a 5.");
            nie.corrigeAvalConfortoBluetooth(blue);
        }
        return blue;
    }

    public ComCabo corrigePrecoComCabo(ComCabo cabo) { // Preço do fone com cabo
        try {
            cabo.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
        } catch (NumberNegatException nne) {
            nne.numNegat();
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
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            nie.corrigeAvalConfortoComCabo(cabo);
        }
        return cabo;
    }

}
