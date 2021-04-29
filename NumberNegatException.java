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
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Maior preco existente: R$ 56000.00");
            nie.corrigePrecoBluetooth(blue);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
            while (true) {
                try {
                    blue.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigePrecoBluetooth(blue);
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    System.out.println("Maior preco existente: R$ 56000.00");
                    nie.corrigePrecoBluetooth(blue);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
                }
            }
        }
        return blue;
    }

    public Bluetooth corrigeTipoBluetooth(Bluetooth blue) { // Tipo Bluetooth
        try { // Tenta receber o tipo de bluetooth
            blue.setTipoBlue(Float.parseFloat(leitura.entDados("\nTipo de Bluetooth..: ")));
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeTipoBluetooth(blue);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
            nie.corrigeTipoBluetooth(blue);
        } catch (NumberFormatException nfe) {
            System.out.println("Valor invalido! Digite somente numeros");
            System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
            while (true) {
                try { // Tenta receber o tipo de bluetooth
                    blue.setTipoBlue(Float.parseFloat(leitura.entDados("\nTipo de Bluetooth..: ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigeTipoBluetooth(blue);
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
                    nie.corrigeTipoBluetooth(blue);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("Valor invalido! Digite somente numeros");
                    System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
                }
            }
        }
        return blue;
    }

    public Bluetooth corrigeDuracaoBat(Bluetooth blue) { // Duração da bateria

        try {
            blue.setDuracaoBat(Integer.parseInt(leitura.entDados("\nDuracao da Bateria em horas: ")));
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeDuracaoBat(blue);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Duracao maxima: 200 horas");
            nie.corrigeDuracaoBat(blue);
        } catch (NumberFormatException nfe) {
            System.out.println("Erro! Digite um numero inteiro.");
            while (true) {
                try {
                    blue.setDuracaoBat(Integer.parseInt(leitura.entDados("\nDuracao da Bateria em horas: ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigeDuracaoBat(blue);
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    System.out.println("Duracao maxima: 200 horas");
                    nie.corrigeDuracaoBat(blue);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("Erro! Digite um numero inteiro.");
                }
            }
        }
        return blue;
    }

    public Bluetooth corrigeBorResBluetooth(Bluetooth blue) { // Numero de borrachas reservas
        try {
            blue.getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Numero maximo de borrachas: 20");
            nie.corrigeBorResBluetooth(blue);
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeBorResBluetooth(blue);
        } catch (NumberFormatException nfe) {
            System.out.println("\nErro! Digite um numero inteiro.");
            while (true) {
                try {
                    blue.getAcess()
                            .setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    System.out.println("Numero maximo de borrachas: 20");
                    nie.corrigeBorResBluetooth(blue);
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigeBorResBluetooth(blue);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nErro! Digite um numero inteiro.");
                }
            }
        }
        return blue;
    }

    public Bluetooth corrigeAvalMaterialBluetooth(Bluetooth blue) {// Avaliação do material
        try {
            blue.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
        } catch (NumberNegatException nne) {
            nne.numNegat();
            System.out.println("Digite um numero de 0 a 5.");
            nne.corrigeAvalMaterialBluetooth(blue);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Digite um numero de 0 a 5.");
            nie.corrigeAvalMaterialBluetooth(blue);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
            while (true) {
                try {
                    blue.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    System.out.println("Digite um numero de 0 a 5.");
                    nne.corrigeAvalMaterialBluetooth(blue);
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    System.out.println("Digite um numero de 0 a 5.");
                    nie.corrigeAvalMaterialBluetooth(blue);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
                }
            }
        }
        return blue;
    }

    public Bluetooth corrigeAvalQualidadeBluetooth(Bluetooth blue) {// Avaliação da qualidade
        try {
            blue.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));
        } catch (NumberNegatException nne) {
            nne.numNegat();
            System.out.println("Digite um numero de 0 a 5.");
            nne.corrigeAvalQualidadeBluetooth(blue);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Digite um numero de 0 a 5.");
            nie.corrigeAvalQualidadeBluetooth(blue);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
            while (true) {
                try {
                    blue.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    System.out.println("Digite um numero de 0 a 5.");
                    nne.corrigeAvalQualidadeBluetooth(blue);
                    break;                    
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    System.out.println("Digite um numero de 0 a 5.");
                    nie.corrigeAvalQualidadeBluetooth(blue);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
                }
            }
        }
        return blue;
    }

    public Bluetooth corrigeAvalConfortoBluetooth(Bluetooth blue) {// Avaliação do conforto
        try {
            blue.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto..: ")));
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalConfortoBluetooth(blue);
            System.out.println("Digite um numero de 0 a 5.");
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Digite um numero de 0 a 5.");
            nie.corrigeAvalConfortoBluetooth(blue);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
            while (true) {
                try {
                    blue.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto..: ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    System.out.println("Digite um numero de 0 a 5.");
                    nne.corrigeAvalConfortoBluetooth(blue);
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    System.out.println("Digite um numero de 0 a 5.");
                    nie.corrigeAvalConfortoBluetooth(blue);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
                }
            }
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
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            System.out.println("Maior preco existente: R$ 56000.00");
            nie.corrigePrecoComCabo(cabo);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
            while (true) {
                try {
                    cabo.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigePrecoComCabo(cabo);
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    System.out.println("Maior preco existente: R$ 56000.00");
                    nie.corrigePrecoComCabo(cabo);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
                }
            }
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
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeCompriCabo(cabo);
        } catch (NumberFormatException nfe) {
            System.out.println("\nErro! Digite somente numeros com ponto. Ex.: 2.5");
            while (true) {
                try { // Tenta receber o comprimento do cabo
                    cabo.setCompriCabo(Float.parseFloat(leitura.entDados("\nComprimento do cabo em metros: ")));
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    System.out.println("Comprimento maximo: 6.0 metros");
                    nie.corrigeCompriCabo(cabo);
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigeCompriCabo(cabo);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nErro! Digite somente numeros com ponto. Ex.: 2.5");
                }
            }
        }

        return cabo;
    }

    public ComCabo corrigeBorResComCabo(ComCabo cabo) { // Numero de borrachas reservas do fone com cabo
        try {
            cabo.getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            nie.corrigeBorResComCabo(cabo);
        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeBorResComCabo(cabo);
        } catch (NumberFormatException nfe) {
            System.out.println("\nErro! Digite um numero inteiro.");
            while (true) {
                try {
                    cabo.getAcess()
                            .setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    nie.corrigeBorResComCabo(cabo);
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigeBorResComCabo(cabo);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nErro! Digite um numero inteiro.");
                }
            }
        }
        return cabo;
    }

    public ComCabo corrigeAvalMaterialComCabo(ComCabo cabo) { // Avaliação do Material
        try {
            cabo.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));

        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalMaterialComCabo(cabo);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            nie.corrigeAvalMaterialComCabo(cabo);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
            while (true) {
                try {
                    cabo.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigeAvalMaterialComCabo(cabo);
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    nie.corrigeAvalMaterialComCabo(cabo);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
                }
            }
        }
        return cabo;
    }

    public ComCabo corrigeAvalQualidadeComCabo(ComCabo cabo) { // Avaliação da Qualidade
        try {
            cabo.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade...: ")));

        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalQualidadeComCabo(cabo);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            nie.corrigeAvalQualidadeComCabo(cabo);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
            while (true) {
                try {
                    cabo.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade...: ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigeAvalQualidadeComCabo(cabo);
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    nie.corrigeAvalQualidadeComCabo(cabo);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
                }
            }
        }
        return cabo;
    }

    public ComCabo corrigeAvalConfortoComCabo(ComCabo cabo) { // Avaliação do Conforto
        try {
            cabo.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));

        } catch (NumberNegatException nne) {
            nne.numNegat();
            nne.corrigeAvalConfortoComCabo(cabo);
        } catch (NumberInvalidException nie) {
            nie.numberInvalid();
            nie.corrigeAvalConfortoComCabo(cabo);
        } catch (NumberFormatException nfe) {
            System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
            while (true) {
                try {
                    cabo.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
                    break;
                } catch (NumberNegatException nne) {
                    nne.numNegat();
                    nne.corrigeAvalConfortoComCabo(cabo);
                    break;
                } catch (NumberInvalidException nie) {
                    nie.numberInvalid();
                    nie.corrigeAvalConfortoComCabo(cabo);
                    break;
                } catch (NumberFormatException nfe1) {
                    System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
                }
            }
        }
        return cabo;
    }

}
