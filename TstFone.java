//Nome: Renato Willyan Moratto Filho - RA.: 2266270

import java.util.List;
import java.util.ArrayList;

public class TstFone {

	private static Bluetooth blue;
	private static List<Bluetooth> bdBlue = new ArrayList<Bluetooth>();
	private static ComCabo cabo;
	private static List<ComCabo> bdCabo = new ArrayList<ComCabo>();
	private static Leitura leitura = new Leitura();

	public static void main(String arg[]) {

		Escolhas escolha = new Escolhas();
		Imprime imprimir = new Imprime();
		int opcao = 0;

		while (true) {	// Roda o menu
			System.out.println("\n========== Menu de Opcoes ==========\n");
			System.out.println("[ 1 ] - Cadastrar fone de ouvido");
			System.out.println("[ 2 ] - Listar todos os fones");
			System.out.println("[ 3 ] - Consultar fone pelo modelo");
			System.out.println("[ 4 ] - Remover fone pelo modelo");
			System.out.println("[ 5 ] - Atualizar fone pelo modelo");
			System.out.println("[ 6 ] - Sair");

			try {
				opcao = Integer.parseInt(leitura.entDados("Sua escolha: "));
			} catch (NumberFormatException nfe) {
				leitura.entDados("\nValor invalido! Sao aceitos somente numeros. Press <Enter>");
				continue;
			}

			switch (opcao) {
				case 1: // Cadastrar
					System.out.println("\n===== Cadastrar fone de ouvido =====");
					while (true) { // Recebe o tipo de fone (Bluetooth ou Com cabo)
						try {
							System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo");
							escolha.setTipoFone(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
							break;
						} catch (NumberFormatException nfe) {
							System.out.println("\nO valor precisa ser um  numero!\nDigite um 1 ou 2.");
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.print("Digite 1 ou 2.\n");
						}
					}
					if (escolha.getTipoFone() == 1) { // Bluetooth
						blue = new Bluetooth();
						blue = cadastroFoneBluetooth(blue);
					} else { // Com cabo
						cabo = new ComCabo();
						cabo = cadastroFoneComCabo(cabo);
					}
					break;

				case 2: // Listar
					System.out.println("\n===== Listar todos os fones =====");
					listarFones();
					break;

				case 3: // Consultar
					System.out.println("\n===== Consultar fone pelo modelo =====");
					while (true) { // Recebe o tipo de fone (Bluetooth ou Com cabo)
						try {
							System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo");
							escolha.setTipoFone(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
							break;
						} catch (NumberFormatException nfe) {
							System.out.println("\nO valor precisa ser um  numero!\nDigite um 1 ou 2.");
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.print("Digite 1 ou 2.\n");
						}
					}
					if (escolha.getTipoFone() == 1) { // Bluetooth
						blue = new Bluetooth();
						blue.setModelo(leitura.entDados("\nModelo a consultar: "));
						blue = consultarModeloBluetooth(blue);
						if (blue != null) {
							imprimirFoneBluetooth(blue);
						} else {
							leitura.entDados("\nEste modelo de fone bluetooth não existe! Press <Enter>");
						}
					} else { // Com cabo
						cabo = new ComCabo();
						cabo.setModelo(leitura.entDados("\nModelo a consultar: "));
						cabo = consultarModeloComCabo(cabo);
						if (cabo != null) {
							imprimirFoneComCabo(cabo);
						} else {
							leitura.entDados("\nEste modelo de fone com cabo não existe! Press <Enter>");
						}
					}
					break;

				case 4: // Remover
					System.out.println("\n===== Remover fone pelo modelo =====");
					while (true) { // Recebe o tipo de fone (Bluetooth ou Com cabo)
						try {
							System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo");
							escolha.setTipoFone(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
							break;
						} catch (NumberFormatException nfe) {
							System.out.println("\nO valor precisa ser um  numero!\nDigite um 1 ou 2.");
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.print("Digite 1 ou 2.\n");
						}
					}
					if (escolha.getTipoFone() == 1) { // Bluetooth
						blue = new Bluetooth();
						blue.setModelo(leitura.entDados("\nModelo a remover: "));
						blue = consultarModeloBluetooth(blue);
						if (blue != null) {
							removerFoneBluetooth(blue);
						} else {
							leitura.entDados("\nEste modelo de fone bluetooth não existe! Press <Enter>");
						}
					} else { // Com cabo
						cabo = new ComCabo();
						cabo.setModelo(leitura.entDados("\nModelo a remover: "));
						cabo = consultarModeloComCabo(cabo);
						if (cabo != null) {
							removerFoneComCabo(cabo);
						} else {
							leitura.entDados("\nEste modelo de fone com cabo não existe! Press <Enter>");
						}
					}
					break;

				case 5: // Atualizar
					System.out.println("\n===== Atualizar fone pelo modelo =====");
					while (true) { // Recebe o tipo de fone (Bluetooth ou Com cabo)
						try {
							System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo");
							escolha.setTipoFone(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
							break;
						} catch (NumberFormatException nfe) {
							System.out.println("\nO valor precisa ser um  numero!\nDigite um 1 ou 2.");
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.print("Digite 1 ou 2.\n");
						}
					}
					if (escolha.getTipoFone() == 1) { // Bluetooth
						blue = new Bluetooth();
						blue.setModelo(leitura.entDados("\nModelo a atualizar: "));
						blue = consultarModeloBluetooth(blue);
						if (blue != null) {
							atualizarFoneBluetooth(blue);
						} else {
							leitura.entDados("\nEste modelo de fone bluetooth não existe! Press <Enter>");
						}
					} else { // Com cabo
						cabo = new ComCabo();
						cabo.setModelo(leitura.entDados("\nModelo a atualizar: "));
						cabo = consultarModeloComCabo(cabo);
						if (cabo != null) {
							atualizarFoneComCabo(cabo);
						} else {
							leitura.entDados("\nEste modelo de fone com cabo não existe! Press <Enter>");
						}
					}
					break;

				case 6: // Sair
					System.out.println("\n===== Sair =====");
					sair();
					break;

				default:
					leitura.entDados("\nDigite somente numeros de 1 a 6. Press <Enter>");
			}
		}
	}

	public static Bluetooth cadastroFoneBluetooth(Bluetooth blue) {
		blue.mostraFone();
		blue.setMarca(leitura.entDados("\nMarca...: "));
		blue.setModelo(leitura.entDados("\nModelo...: "));

		if (consultarModeloBluetooth(blue) != null) {
			return null;
		}

		blue.setStereo(Boolean.parseBoolean(leitura.entDados("\nE stereo? [true / false]: ")));
		while (true) { // Recebe o Preço
			try {
				blue.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
				break;
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Maior preco existente: R$ 56000.00");
			}
		}
		while (true) { // Recebe tipo Bluetooth
			try {
				blue.setTipoBlue(Float.parseFloat(leitura.entDados("\nTipo de Bluetooth..: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("Valor invalido! Digite somente numeros");
				System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
			}
		}
		while (true) { // Recebe duração da bateria
			try {
				blue.setDuracaoBat(Integer.parseInt(leitura.entDados("\nDuracao da Bateria em horas: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("Erro! Digite um numero inteiro.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Duracao maxima: 200 horas");
			}
		}

		System.out.println("\n===== Acessorios do Fone =====");
		blue.getAcess().setCase(Boolean.parseBoolean(leitura.entDados("\nPossui case (true / false)? ")));
		while (true) { // Recebe o número de borrachas reservas
			try {
				blue.getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nErro! Digite um numero inteiro.");
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Numero maximo de borrachas: 20");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			}
		}
		System.out.println("\n===== Avaliacao do Fone =====");
		System.out.println("De notas de 0 a 5.");
		while (true) { // Recebe a avaliação do material
			try {
				blue.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		while (true) { // Recebe a avaliação da qualidade
			try {
				blue.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		while (true) { // Recebe a avaliação do conforto
			try {
				blue.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		System.out.println("\nNumero de cadastro do fone: " + blue.implementNumCadastro(bdBlue.indexOf(blue)));

		bdBlue.add(blue);
		return blue;
	}

	public static ComCabo cadastroFoneComCabo(ComCabo cabo) {
		cabo.mostraFone();
		cabo.setMarca(leitura.entDados("\nMarca...: "));
		cabo.setModelo(leitura.entDados("\nModelo...: "));

		if (consultarModeloComCabo(cabo) != null) {
			return null;
		}

		cabo.setStereo(Boolean.parseBoolean(leitura.entDados("\nE stereo? [true / false]: ")));
		while (true) {
			try {
				cabo.setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
				break;
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Maior preco existente: R$ 56000.00");
			}
		}
		while (true) {
			try {
				cabo.setCompriCabo(Float.parseFloat(leitura.entDados("\nComprimento do cabo em metros: ")));
				break;
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Comprimento maximo: 6.0 metros");
			} catch (NumberFormatException nfe) {
				System.out.println("\nErro! Digite somente numeros com ponto. Ex.: 2.5");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			}
		}
		while (true) {
			try {
				cabo.setTipoEntrada(leitura.entDados("\nTipo de Entrada...: "));
				break;
			} catch (InvalidStringException ise) {
				ise.invString();
				System.out.println("Tipos de entrada existentes: p1, p2, p3, p10 e USB");
			}
		}
		System.out.println("\n===== Acessorios do Fone =====");
		cabo.getAcess().setCase(Boolean.parseBoolean(leitura.entDados("\nPossui case? [true / false]: ")));
		while (true) {
			try {
				cabo.getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nErro! Digite um numero inteiro.");
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			}
		}

		System.out.println("\n===== Avaliacao do Fone =====");
		System.out.println("De notas de 0 a 5.");
		while (true) {
			try {
				cabo.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		while (true) {
			try {
				cabo.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		while (true) {
			try {
				cabo.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		System.out.println("\nNumero de cadastro do fone: " + cabo.implementNumCadastro(bdCabo.indexOf(cabo)));

		bdCabo.add(cabo);
		return cabo;
	}

	public static void listarFones() {
		for (int i = 0; i < bdBlue.size(); i++) { // Imprime os dados do fone Bluetooth
			System.out.println("\n===== Fone Bluetooth - " + bdBlue.get(i).getMarca() + " =====");
			System.out.println("\nModelo...: " + bdBlue.get(i).getModelo());
			System.out.println("Stereo...: " + bdBlue.get(i).getStereo());
			System.out.println("Preco....: R$ " + bdBlue.get(i).getPreco());
			System.out.println("Tipo de Bluetooth...: " + bdBlue.get(i).getTipoBlue());
			System.out.println("Duracao da Bateria...: " + bdBlue.get(i).getDuracaoBat() + " horas");

			System.out.println("\n===== Acessorios do Fone =====");
			System.out.println("Case...: " + bdBlue.get(i).getAcess().getCase());
			System.out.println("Borrachas reserva...: " + bdBlue.get(i).getAcess().getBorRes());

			System.out.println("\n===== Avaliacao do Fone =====");
			System.out.println("Material...: " + bdBlue.get(i).getAval().getMaterial());
			System.out.println("Qualidade..: " + bdBlue.get(i).getAval().getQualidade());
			System.out.println("Conforto...: " + bdBlue.get(i).getAval().getConforto());
			System.out.println("\nNumero de cadastro do fone bluetooth: " + bdBlue.get(i).implementNumCadastro(i));
		}

		for (int i = 0; i < bdCabo.size(); i++) { // Imprime os dados do fone com cabo

			System.out.println("\n===== Fone com Cabo - " + bdCabo.get(i).getMarca() + " =====");
			System.out.println("Modelo...: " + bdCabo.get(i).getModelo());
			System.out.println("Stereo...: " + bdCabo.get(i).getStereo());
			System.out.println("Preco....: R$ " + bdCabo.get(i).getPreco());
			System.out.println("Comprimento do cabo..: " + bdCabo.get(i).getCompriCabo() + " m");
			System.out.println("Tipo de Entrada...: " + bdCabo.get(i).getTipoEntrada().toUpperCase());

			System.out.println("\n===== Acessorios do Fone =====");
			System.out.println("Case...: " + bdCabo.get(i).getAcess().getCase());
			System.out.println("Borrachas reserva...: " + bdCabo.get(i).getAcess().getBorRes());

			System.out.println("\n===== Avaliacao do Fone =====");
			System.out.println("Material...: " + bdCabo.get(i).getAval().getMaterial());
			System.out.println("Qualidade..: " + bdCabo.get(i).getAval().getQualidade());
			System.out.println("Conforto...: " + bdCabo.get(i).getAval().getConforto());
			System.out.println("\nNumero de cadastro do fone com cabo: " + bdCabo.get(i).implementNumCadastro(i));
		}
	}

	public static Bluetooth consultarModeloBluetooth(Bluetooth blue) { // busca o modelo do fone bluetooth
		for (int i = 0; i < bdBlue.size(); i++) {
			if (blue.getModelo().equalsIgnoreCase(bdBlue.get(i).getModelo())) { // Busca se existe algum fone com o
																				// mesmo modelo
				return bdBlue.get(i);
			}
		}
		return null;
	}

	public static ComCabo consultarModeloComCabo(ComCabo cabo) { // busca o modelo do fone com cabo
		for (int i = 0; i < bdCabo.size(); i++) {
			if (cabo.getModelo().equalsIgnoreCase(bdCabo.get(i).getModelo())) { // Busca se existe algum fone com o
																				// mesmo modelo
				return bdCabo.get(i);
			}
		}
		return null;
	}

	public static void imprimirFoneBluetooth(Bluetooth blue) {
		System.out.println("\n===== Fone Bluetooth - " + blue.getMarca() + " =====");
		System.out.println("\nModelo...: " + blue.getModelo());
		System.out.println("Stereo...: " + blue.getStereo());
		System.out.println("Preco....: R$ " + blue.getPreco());
		System.out.println("Tipo de Bluetooth...: " + blue.getTipoBlue());
		System.out.println("Duracao da Bateria...: " + blue.getDuracaoBat() + " horas");

		System.out.println("\n===== Acessorios do Fone =====");
		System.out.println("Case...: " + blue.getAcess().getCase());
		System.out.println("Borrachas reserva...: " + blue.getAcess().getBorRes());

		System.out.println("\n===== Avaliacao do Fone =====");
		System.out.println("Material...: " + blue.getAval().getMaterial());
		System.out.println("Qualidade..: " + blue.getAval().getQualidade());
		System.out.println("Conforto...: " + blue.getAval().getConforto());
		System.out
				.println("\nNumero de cadastro do fone bluetooth: " + blue.implementNumCadastro(bdBlue.indexOf(blue)));
	}

	public static void imprimirFoneComCabo(ComCabo cabo) {
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
		System.out.println("\nNumero de cadastro do fone com cabo: " + cabo.implementNumCadastro(bdCabo.indexOf(cabo)));
	}

	public static void removerFoneBluetooth(Bluetooth blue) { // Exclui o fone bluetooth em si
		bdBlue.remove(blue);
	}

	public static void removerFoneComCabo(ComCabo cabo) { // Exclui o fone com cabo em si
		bdCabo.remove(cabo);
	}

	public static void atualizarFoneBluetooth(Bluetooth blue) {
		blue.setMarca(leitura.entDados("\nNova marca...: "));
		blue.setStereo(Boolean.parseBoolean(leitura.entDados("\nE stereo? [true / false]: ")));
		while (true) { // Recebe o Preço
			try {
				blue.setPreco(Float.parseFloat(leitura.entDados("\nNovo preco...: R$ ")));
				break;
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Maior preco existente: R$ 56000.00");
			}
		}
		while (true) { // Recebe tipo Bluetooth
			try {
				blue.setTipoBlue(Float.parseFloat(leitura.entDados("\nNovo tipo de Bluetooth..: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("Valor invalido! Digite somente numeros");
				System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
			}
		}
		while (true) { // Recebe duração da bateria
			try {
				blue.setDuracaoBat(Integer.parseInt(leitura.entDados("\nNova duracao da Bateria em horas: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("Erro! Digite um numero inteiro.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Duracao maxima: 200 horas");
			}
		}

		System.out.println("\n===== Novos Acessorios =====");
		blue.getAcess().setCase(Boolean.parseBoolean(leitura.entDados("\nPossui case (true / false)? ")));
		while (true) { // Recebe o número de borrachas reservas
			try {
				blue.getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nErro! Digite um numero inteiro.");
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Numero maximo de borrachas: 20");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			}
		}
		System.out.println("\n===== Nova Avaliacao =====");
		System.out.println("De notas de 0 a 5.");
		while (true) { // Recebe a avaliação do material
			try {
				blue.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		while (true) { // Recebe a avaliação da qualidade
			try {
				blue.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		while (true) { // Recebe a avaliação do conforto
			try {
				blue.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}

		for (int i = 0; i < bdBlue.size(); i++) {
			if (blue.getModelo().equalsIgnoreCase(bdBlue.get(i).getModelo())) {
				bdBlue.set(i, blue);
			}
		}
	}

	public static void atualizarFoneComCabo(ComCabo cabo) {
		cabo.setMarca(leitura.entDados("\nNova marca...: "));
		cabo.setStereo(Boolean.parseBoolean(leitura.entDados("\nE stereo? [true / false]: ")));
		while (true) {
			try {
				cabo.setPreco(Float.parseFloat(leitura.entDados("\nNovo preco...: R$ ")));
				break;
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Maior preco existente: R$ 56000.00");
			}
		}
		while (true) {
			try {
				cabo.setCompriCabo(Float.parseFloat(leitura.entDados("\nNovo comprimento do cabo em metros: ")));
				break;
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("Comprimento maximo: 6.0 metros");
			} catch (NumberFormatException nfe) {
				System.out.println("\nErro! Digite somente numeros com ponto. Ex.: 2.5");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			}
		}
		while (true) {
			try {
				cabo.setTipoEntrada(leitura.entDados("\nNovo tipo de Entrada...: "));
				break;
			} catch (InvalidStringException ise) {
				ise.invString();
				System.out.println("Tipos de entrada existentes: p1, p2, p3, p10 e USB");
			}
		}
		System.out.println("\n===== Novos Acessorios =====");
		cabo.getAcess().setCase(Boolean.parseBoolean(leitura.entDados("\nPossui case? [true / false]: ")));
		while (true) {
			try {
				cabo.getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nErro! Digite um numero inteiro.");
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
				System.out.println("");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			}
		}

		System.out.println("\n===== Nova Avaliacao =====");
		System.out.println("De notas de 0 a 5.");
		while (true) {
			try {
				cabo.getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		while (true) {
			try {
				cabo.getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}
		while (true) {
			try {
				cabo.getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
				break;
			} catch (NumberFormatException nfe) {
				System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
			} catch (NumberNegatException nne) {
				nne.numNegat();
			} catch (NumberInvalidException nie) {
				nie.numberInvalid();
			}
		}

		for (int i = 0; i < bdCabo.size(); i++) {
			if (cabo.getModelo().equalsIgnoreCase(bdCabo.get(i).getModelo())) {
				bdCabo.set(i, cabo);
			}
		}
	}

	public static void sair() { // Testa se o usuário deseja sair da aplicação
		while (true) {
			String sair = leitura.entDados("\nDeseja realmente sair? [ S / N ] ");
			if (sair.equalsIgnoreCase("S")) {
				System.exit(0);
			} else if (sair.equalsIgnoreCase("N")) {
				break;
			} else {
				System.out.println("\nValor invalido! Tente novamente.");
			}
		}
	}
}
