
//Nome: Renato Willyan Moratto Filho - RA.: 2266270
import java.util.List;
import java.util.ArrayList;

public class TstFone {

	private static Bluetooth blue = new Bluetooth();
	private static List<Bluetooth> bdBlue = new ArrayList<Bluetooth>();
	private static ComCabo cabo = new ComCabo();
	private static List<ComCabo> bdCabo = new ArrayList<ComCabo>();
	private static Leitura leitura = new Leitura();

	public static void main(String arg[]) {

		blue = new Bluetooth();
		cabo = new ComCabo();
		Escolhas escolha = new Escolhas();
		Imprime imprimir = new Imprime();

		do { // Continua o programa enquanto o usuário desejar

			System.out.println("\n===== Cadastro de Fones de Ouvido =====\n");
			System.out.print(((bdBlue.size() + bdCabo.size()) + 1) + " Fone de ouvido:");

			try { // Recebe o tipo de fone
				System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo");
				escolha.setTipoFone(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.print("Digite 1 ou 2.\n");
				escolha = nie.corrigeTipoFone(escolha);
			} catch (NumberFormatException nfe) {
				System.out.print("Digite 1 ou 2.\n");
				while (true) {
					try {
						System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo");
						escolha.setTipoFone(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
						break;
					} catch (NumberInvalidException nie) {
						nie.numberInvalid();
						System.out.print("Digite 1 ou 2.\n");
						escolha = nie.corrigeTipoFone(escolha);
						break;
					} catch (NumberFormatException nfe2) {
						System.out.print("Digite 1 ou 2.\n");
					}
				}
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
					blue = nne.corrigePrecoBluetooth(blue);
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Maior preco existente: R$ 56000.00");
					blue = nie.corrigePrecoBluetooth(blue);
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
					while (true) {
						try { // Tenta receber o preço
							blue.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							blue = nne.corrigePrecoBluetooth(blue);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Maior preco existente: R$ 56000.00");
							blue = nie.corrigePrecoBluetooth(blue);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
						}
					}
				}

				try { // Tenta receber o tipo de bluetooth
					blue.setTipoBlue(Float.parseFloat(leitura.entDados("\nTipo de Bluetooth..: ")));
				} catch (NumberNegatException nne) {
					nne.numNegat();
					blue = nne.corrigeTipoBluetooth(blue);
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
					blue = nie.corrigeTipoBluetooth(blue);
				} catch (NumberFormatException nfe) {
					System.out.println("Valor invalido! Digite somente numeros");
					System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
					while (true) {
						try { // Tenta receber o tipo de bluetooth
							blue.setTipoBlue(Float.parseFloat(leitura.entDados("\nTipo de Bluetooth..: ")));
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							blue = nne.corrigeTipoBluetooth(blue);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
							blue = nie.corrigeTipoBluetooth(blue);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("Valor invalido! Digite somente numeros");
							System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
						}
					}
				}

				try { // Tenta receber a duração da bateria
					blue.setDuracaoBat(Integer.parseInt(leitura.entDados("\nDuracao da Bateria em horas: ")));
				} catch (NumberNegatException nne) {
					nne.numNegat();
					blue = nne.corrigeDuracaoBat(blue);
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Duracao maxima: 200 horas");
					blue = nie.corrigeDuracaoBat(blue);
				} catch (NumberFormatException nfe) {
					System.out.println("Erro! Digite um numero inteiro.");
					while (true) {
						try { // Tenta receber a duração da bateria
							blue.setDuracaoBat(Integer.parseInt(leitura.entDados("\nDuracao da Bateria em horas: ")));
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							blue = nne.corrigeDuracaoBat(blue);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Duracao maxima: 200 horas");
							blue = nie.corrigeDuracaoBat(blue);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("Erro! Digite um numero inteiro.");
						}
					}
				}

				System.out.println("\n===== Acessorios do Fone =====");
				blue.getAcess().setCase(Boolean.parseBoolean(leitura.entDados("\nPossui case (true / false)? ")));

				try { // Tenta receber o numero de borrachas reservas
					blue.getAcess()
							.setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Numero maximo de borrachas: 20");
					blue = nie.corrigeBorResBluetooth(blue);
				} catch (NumberNegatException nne) {
					nne.numNegat();
					blue = nne.corrigeBorResBluetooth(blue);
				} catch (NumberFormatException nfe) {
					System.out.println("\nErro! Digite um numero inteiro.");
					while (true) {
						try { // Tenta receber o numero de borrachas reservas
							blue.getAcess().setBorRes(
									Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Numero maximo de borrachas: 20");
							blue = nie.corrigeBorResBluetooth(blue);
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							blue = nne.corrigeBorResBluetooth(blue);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nErro! Digite um numero inteiro.");
						}
					}
				}

				System.out.println("\n===== Avaliacao do Fone =====");
				System.out.println("De notas de 0 a 5.");

				try { // Tenta receber a avaliação do material
					blue.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
				} catch (NumberNegatException nne) {
					nne.numNegat();
					System.out.println("Digite um numero de 0 a 5.");
					blue = nne.corrigeAvalMaterialBluetooth(blue);
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Digite um numero de 0 a 5.");
					blue = nie.corrigeAvalMaterialBluetooth(blue);
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
					while (true) {
						try {
							blue.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							System.out.println("Digite um numero de 0 a 5.");
							blue = nne.corrigeAvalMaterialBluetooth(blue);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Digite um numero de 0 a 5.");
							blue = nie.corrigeAvalMaterialBluetooth(blue);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
					}
				}

				try { // Tenta receber a avaliação da qualidade
					blue.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));

				} catch (NumberNegatException nne) {
					nne.numNegat();
					System.out.println("Digite um numero de 0 a 5.");
					blue = nne.corrigeAvalQualidadeBluetooth(blue);
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Digite um numero de 0 a 5.");
					blue = nie.corrigeAvalQualidadeBluetooth(blue);
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
					while (true) {
						try {
							blue.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));
							break;

						} catch (NumberNegatException nne) {
							nne.numNegat();
							System.out.println("Digite um numero de 0 a 5.");
							blue = nne.corrigeAvalQualidadeBluetooth(blue);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Digite um numero de 0 a 5.");
							blue = nie.corrigeAvalQualidadeBluetooth(blue);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
					}
				}

				try { // Tenta receber a avaliação do conforto
					blue.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
				} catch (NumberNegatException nne) {
					nne.numNegat();
					blue = nne.corrigeAvalConfortoBluetooth(blue);
					System.out.println("Digite um numero de 0 a 5.");
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Digite um numero de 0 a 5.");
					blue = nie.corrigeAvalConfortoBluetooth(blue);
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
					while (true) {
						try {
							blue.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							System.out.println("Digite um numero de 0 a 5.");
							blue = nne.corrigeAvalConfortoBluetooth(blue);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Digite um numero de 0 a 5.");
							blue = nie.corrigeAvalConfortoBluetooth(blue);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
					}
				}

				bdBlue.add(blue); // Adiciona o fone cadastrado ao pseudo banco de dados

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
					cabo = nne.corrigePrecoComCabo(cabo);
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Maior preco existente: R$ 56000.00");
					cabo = nie.corrigePrecoComCabo(cabo);
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
					while (true) {
						try { // Tenta receber preço
							cabo.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
						} catch (NumberNegatException nne) {
							nne.numNegat();
							cabo = nne.corrigePrecoComCabo(cabo);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Maior preco existente: R$ 56000.00");
							cabo = nie.corrigePrecoComCabo(cabo);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
						}
					}
				}

				try { // Tenta receber o comprimento do cabo
					cabo.setCompriCabo(Float.parseFloat(leitura.entDados("\nComprimento do cabo em metros: ")));
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.println("Comprimento maximo: 6.0 metros");
					cabo = nie.corrigeCompriCabo(cabo);
				} catch (NumberNegatException nne) {
					nne.numNegat();
					cabo = nne.corrigeCompriCabo(cabo);
				} catch (NumberFormatException nfe) {
					System.out.println("\nErro! Digite somente numeros com ponto. Ex.: 2.5");
					while (true) {
						try {
							cabo.setCompriCabo(Float.parseFloat(leitura.entDados("\nComprimento do cabo em metros: ")));
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Comprimento maximo: 6.0 metros");
							cabo = nie.corrigeCompriCabo(cabo);
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							cabo = nne.corrigeCompriCabo(cabo);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nErro! Digite somente numeros com ponto. Ex.: 2.5");
						}
					}
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
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					cabo = nie.corrigeBorResComCabo(cabo);
				} catch (NumberNegatException nne) {
					nne.numNegat();
					cabo = nne.corrigeBorResComCabo(cabo);
				} catch (NumberFormatException nfe) {
					System.out.println("\nErro! Digite um numero inteiro.");
					while (true) {
						try { // Tenta receber a quantidade de borrachas
							cabo.getAcess().setBorRes(
									Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							cabo = nie.corrigeBorResComCabo(cabo);
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							cabo = nne.corrigeBorResComCabo(cabo);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nErro! Digite um numero inteiro.");
						}
					}
				}

				System.out.println("\n===== Avaliacao do Fone =====");
				System.out.println("De notas de 0 a 5.");

				try { // Tenta receber a avaliação do material
					cabo.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));

				} catch (NumberNegatException nne) {
					nne.numNegat();
					cabo = nne.corrigeAvalMaterialComCabo(cabo);
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					cabo = nie.corrigeAvalMaterialComCabo(cabo);
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
					while (true) {
						try { // Tenta receber a avaliação do material
							cabo.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							cabo = nne.corrigeAvalMaterialComCabo(cabo);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							cabo = nie.corrigeAvalMaterialComCabo(cabo);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
					}
				}

				try { // Tenta receber a avaliação da qualidade
					cabo.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));

				} catch (NumberNegatException nne) {
					nne.numNegat();
					cabo = nne.corrigeAvalQualidadeComCabo(cabo);
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					cabo = nie.corrigeAvalQualidadeComCabo(cabo);
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
					while (true) {
						try { // Tenta receber a avaliação da qualidade
							cabo.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));
							break;

						} catch (NumberNegatException nne) {
							nne.numNegat();
							cabo = nne.corrigeAvalQualidadeComCabo(cabo);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							cabo = nie.corrigeAvalQualidadeComCabo(cabo);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
					}
				}

				try { // Tenta receber a avaliação do conforto
					cabo.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
				} catch (NumberNegatException nne) {
					nne.numNegat();
					cabo = nne.corrigeAvalConfortoComCabo(cabo);
				} catch (NumberInvalidException nie) {
					nie.numberInvalid();
					cabo = nie.corrigeAvalConfortoComCabo(cabo);
				} catch (NumberFormatException nfe) {
					System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
					while (true) {
						try { // Tenta receber a avaliação do conforto
							cabo.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
							break;
						} catch (NumberNegatException nne) {
							nne.numNegat();
							cabo = nne.corrigeAvalConfortoComCabo(cabo);
							break;
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							cabo = nie.corrigeAvalConfortoComCabo(cabo);
							break;
						} catch (NumberFormatException nfe1) {
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
					}
				}

				bdCabo.add(cabo); // Adiciona o fone cadastrado ao pseudo banco de dados

				break;
			}

			System.out.println("\nObrigado por informar!\n\n");
		} while (escolha.continuar()); // Recebe se o usuário deseja fazer mais cadastros

		System.out.println("\nForam cadastrados " + bdBlue.size() + " fone(s) bluetooths e " + bdCabo.size()
				+ " fone(s) com cabo. Obrigado!");

		if (escolha.listarFones()) {

			System.out.println("\n========== Imprimindo os Fones ===========\n");

			for (Bluetooth blue2 : bdBlue) {
				imprimir.foneBluetooth(blue2, bdBlue.size());
			}
			for (ComCabo cabo2 : bdCabo) {
				imprimir.foneComCabo(cabo2, bdCabo.size());
			}
		}
	}
}
