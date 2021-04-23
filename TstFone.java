//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class TstFone {

	public static void main(String arg[]) {

		int totFones = 0; // Numero de fones cadastrados

		Leitura leitura = new Leitura();
		Bluetooth blue = new Bluetooth();
		ComCabo cabo = new ComCabo();
		Escolhas escolha = new Escolhas();

		do { // Continua o programa enquanto o usuário desejar

			// ==================================== Definindo
			// ====================================
			System.out.println("\n===== Cadastro de Fones de Ouvido =====\n");
			System.out.print((totFones + 1) + " Fone de ouvido:");

			try {
				System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo");
				escolha.setTipoFone(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.print("Digite 1 ou 2.\n");
				escolha = nie.corrigeTipoFone(escolha);
			} catch (NumberFormatException nfe) {
				System.out.println("\nO valor precisa ser um  numero!\nDigite um 1 ou 2.");
				// escolha = nfe.corrigeTipoFone(escolha);
			}

			switch (escolha.getTipoFone()) {
			case 1: // Bluetooth
				blue.mostraFone();
				blue.setMarca(leitura.entDados("\nMarca...: "));
				blue.setModelo(leitura.entDados("\nModelo...: "));
				blue.setStereo(Boolean.parseBoolean(leitura.entDados("\nE stereo? [true / false]: ")));

				try { // Tenta receber o preço
					blue.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
				} catch (NumberNegatException nne) {
					nne.numNegat();
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Maior preco existente: R$ 56000.00");
					blue = nie.corrigePrecoBluetooth(blue);
				}

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
					blue = nie.corrigeTipoBluetooth(blue);
				}

				try { // Tenta receber a duração da bateria
					blue.setDuracaoBat(Integer.parseInt(leitura.entDados("\nDuracao da Bateria em horas: ")));
				} catch (NumberFormatException nfe) {
					System.out.println("Erro! Digite um numero inteiro.");
				} catch (NumberNegatException nne) {
					nne.numNegat();
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Duracao maxima: 200 horas");
					blue = nie.corrigeDuracaoBat(blue);
				}

				System.out.println("\n===== Acessorios do Fone =====");
				blue.getAcess().setCase(Boolean.parseBoolean(leitura.entDados("\nPossui case (true / false)? ")));

				try { // Tenta receber o numero de borrachas reservas
					blue.getAcess()
							.setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
				} catch (NumberFormatException nfe) {
					System.out.println("\nErro! Digite um numero inteiro.");
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Numero maximo de borrachas: 20");
					blue = nie.corrigeBorResBluetooth(blue);
				} catch (NumberNegatException nne) {
					nne.numNegat();
				}

				System.out.println("\n===== Avaliacao do Fone =====");
				System.out.println("De notas de 0 a 5.");
				try { // Tenta receber a avaliação do material
					blue.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
				} catch (NumberNegatException nne) {
					nne.numNegat();
					System.out.println("Digite um numero de 0 a 5.");
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Digite um numero de 0 a 5.");
					blue = nie.corrigeAvalMaterialBluetooth(blue);
				}

				try { // Tenta receber a avaliação da qualidade
					blue.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));

				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
				} catch (NumberNegatException nne) {
					nne.numNegat();
					System.out.println("Digite um numero de 0 a 5.");
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Digite um numero de 0 a 5.");
					blue = nie.corrigeAvalQualidadeBluetooth(blue);
				}

				try { // Tenta receber a avaliação do conforto
					blue.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
				} catch (NumberNegatException nne) {
					nne.numNegat();
					System.out.println("Digite um numero de 0 a 5.");
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Digite um numero de 0 a 5.");
					blue = nie.corrigeAvalConfortoBluetooth(blue);
				}

				break;

			case 2: // Com cabo
				cabo.mostraFone();
				cabo.setMarca(leitura.entDados("\nMarca...: "));
				cabo.setModelo(leitura.entDados("\nModelo...: "));
				cabo.setStereo(Boolean.parseBoolean(leitura.entDados("\nE stereo? [true / false]: ")));

				try { // Tenta receber preço
					cabo.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
				} catch (NumberNegatException nne) {
					nne.numNegat();
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Maior preco existente: R$ 56000.00");
					cabo = nie.corrigePrecoComCabo(cabo);
				}
				try { // Tenta receber o comprimento do cabo
					cabo.setCompriCabo(Float.parseFloat(leitura.entDados("\nComprimento do cabo em metros: ")));
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Comprimento maximo: 6.0 metros");
					cabo = nie.corrigeCompriCabo(cabo);
				} catch (NumberFormatException nfe) {
					System.out.println("\nErro! Digite somente numeros com ponto. Ex.: 2.5");
				} catch (NumberNegatException nne) {
					nne.numNegat();
				}

				try { // Tenta receber o tipo de entrada do fone
					cabo.setTipoEntrada(leitura.entDados("\nTipo de Entrada...: "));

				} catch (InvalidStringException ise) {
					ise.invString();
					System.out.println("Tipos de entrada existentes: p1, p2, p3, p10 e USB");
					cabo = ise.corrigeTipoEntrada(cabo);
				}
				System.out.println("\n===== Acessorios do Fone =====");
				cabo.getAcess().setCase(Boolean.parseBoolean(leitura.entDados("\nPossui case? [true / false]: ")));

				try { // Tenta receber a quantidade de borrachas
					cabo.getAcess()
							.setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));

				} catch (NumberFormatException nfe) {
					System.out.println("\nErro! Digite um numero inteiro.");
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					cabo = nie.corrigeBorResComCabo(cabo);
				} catch (NumberNegatException nne) {
					nne.numNegat();
				}

				System.out.println("\n===== Avaliacao do Fone =====");
				System.out.println("De notas de 0 a 5.");

				try { // Tenta receber a avaliação do material
					cabo.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));

				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
				} catch (NumberNegatException nne) {
					nne.numNegat();
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					cabo = nie.corrigeAvalMaterialComCabo(cabo);
				}

				try { // Tenta receber a avaliação da qualidade
					cabo.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));

				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
				} catch (NumberNegatException nne) {
					nne.numNegat();
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					cabo = nie.corrigeAvalQualidadeComCabo(cabo);
				}

				try { // Tenta receber a avaliação do conforto
					cabo.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
				} catch (NumberNegatException nne) {
					nne.numNegat();
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					cabo = nie.corrigeAvalConfortoComCabo(cabo);
				}

				System.out.println("\nNumero de cadastro do fone: " + cabo.implementNumCadastro(totFones));
				break;
			}

			System.out.println("\nObrigado por informar!\n\n");

			// ====================================
			// Imprimindo====================================

			// Fone de Ouvido
			switch (escolha.getTipoFone()) { // Recebe o tipo de fone
			case 1: // Bluetooth
				System.out.println("===== Fone Bluetooth - " + blue.getMarca() + " =====");
				System.out.println("\nModelo...: " + blue.getModelo());
				System.out.println("Stereo...: " + blue.getStereo());
				System.out.println("Preco....: R$ " + blue.getPreco());
				System.out.println("Tipo de Bluetooth...: " + blue.getTipoBlue());
				System.out.println("Duracao da Bateria...: " + blue.getDuracaoBat() + " horas");

				// Acessorios
				System.out.println("\n===== Acessorios do Fone =====");
				System.out.println("Case...: " + blue.getAcess().getCase());
				System.out.println("Borrachas reserva...: " + blue.getAcess().getBorRes());

				// Avaliação
				System.out.println("\n===== Avaliacao do Fone =====");
				System.out.println("Material...: " + blue.getAval().getMaterial());
				System.out.println("Qualidade..: " + blue.getAval().getQualidade());
				System.out.println("Conforto...: " + blue.getAval().getConforto());
				System.out.println("\nNumero de cadastro do fone bluetooth: " + blue.implementNumCadastro(totFones));
				break;

			case 2: // Com cabo
				System.out.println("\n===== Fone com Cabo - " + cabo.getMarca() + " =====");
				System.out.println("Modelo...: " + cabo.getModelo());
				System.out.println("Stereo...: " + cabo.getStereo());
				System.out.println("Preco....: R$ " + cabo.getPreco());
				System.out.println("Comprimento do cabo..: " + cabo.getCompriCabo() + " m");
				System.out.println("Tipo de Entrada...: " + cabo.getTipoEntrada().toUpperCase());

				// Acessorios
				System.out.println("\n===== Acessorios do Fone =====");
				System.out.println("Case...: " + cabo.getAcess().getCase());
				System.out.println("Borrachas reserva...: " + cabo.getAcess().getBorRes());

				// Avaliação
				System.out.println("\n===== Avaliacao do Fone =====");
				System.out.println("Material...: " + cabo.getAval().getMaterial());
				System.out.println("Qualidade..: " + cabo.getAval().getQualidade());
				System.out.println("Conforto...: " + cabo.getAval().getConforto());
				System.out.println("\nNumero de cadastro do fone com cabo: " + cabo.implementNumCadastro(totFones));
				break;
			}
			totFones++; // incrementa o numero de fones cadastrados
		} while (escolha.continuar()); // Recebe se o usuário deseja fazer mais cadastros

		System.out.println("\nForam cadastrados " + totFones + " fone(s)! Obrigado!");
	}
}
