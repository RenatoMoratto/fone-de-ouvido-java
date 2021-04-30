//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class MenuFones {
    
	private Bluetooth blue;
	private ComCabo cabo;
	private Leitura leitura = new Leitura();
    private GerenciaFonesBluetooth gerenciaBlue = new GerenciaFonesBluetooth();
    private GerenciaFonesComCabo gerenciaCabo = new GerenciaFonesComCabo();

    public void geraMenuFones() {

		Escolhas escolha = new Escolhas();
		int opcao = 0;

		while (true) {	// Roda o menu
			System.out.println("\n========== Menu de Opcoes ==========\n");
			System.out.println("[ 1 ] - Cadastrar fone de ouvido");
			System.out.println("[ 2 ] - Listar fones");
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
						blue = gerenciaBlue.cadastroFoneBluetooth(blue);
					} else { // Com cabo
						cabo = new ComCabo();
						cabo = gerenciaCabo.cadastroFoneComCabo(cabo);
					}
					break;

				case 2: // Listar
					System.out.println("\n===== Listar fones =====");
					while (true) { // Recebe o tipo de fone (Bluetooth ou Com cabo)
						try {
							System.out.println("\nDeseja listar os fones:");
							System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo\n[ 3 ] - Todos");
							escolha.setTipoListagem(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
							break;
						} catch (NumberFormatException nfe) {
							System.out.println("\nO valor precisa ser um  numero!\nDigite um 1, 2 ou 3.");
						} catch (NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.print("Digite 1, 2 ou 3.\n");
						}
					}
					switch(escolha.getTipoListagem()){
						case 1:
							gerenciaBlue.listarFonesBluetooth();
							break;
						case 2:
							gerenciaCabo.listarFonesComCabo();
							break;
						default:
							gerenciaBlue.listarFonesBluetooth();
							gerenciaCabo.listarFonesComCabo();
					}
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
						try {
							blue.setModelo(leitura.entDados("\nModelo a consultar: "));
						} catch (InvalidStringException ise) {
							ise.invString();
							ise.corrigeModeloBluetooth(blue);
						}
						
						blue = gerenciaBlue.consultarModeloBluetooth(blue);
						if (blue != null) {
							gerenciaBlue.imprimirFoneBluetooth(blue);
						} else {
							leitura.entDados("\nEste modelo de fone bluetooth não existe! Press <Enter>");
						}
					} else { // Com cabo
						cabo = new ComCabo();
						try{
						cabo.setModelo(leitura.entDados("\nModelo a consultar: "));
							} catch(InvalidStringException ise){
								ise.invString();
								cabo = ise.corrigeModeloComCabo(cabo);
							}
						cabo = gerenciaCabo.consultarModeloComCabo(cabo);
						if (cabo != null) {
							gerenciaCabo.imprimirFoneComCabo(cabo);
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
						try {
							blue.setModelo(leitura.entDados("\nModelo a remover: "));
						} catch (InvalidStringException ise) {
							ise.invString();
							blue = ise.corrigeModeloBluetooth(blue);
						}
						blue = gerenciaBlue.consultarModeloBluetooth(blue);
						if (blue != null) {
							gerenciaBlue.removerFoneBluetooth(blue);
						} else {
							leitura.entDados("\nEste modelo de fone bluetooth não existe! Press <Enter>");
						}
					} else { // Com cabo
						cabo = new ComCabo();try{
							cabo.setModelo(leitura.entDados("\nModelo a remover: "));
							} catch(InvalidStringException ise){
								ise.invString();
								cabo = ise.corrigeModeloComCabo(cabo);
							}
						cabo = gerenciaCabo.consultarModeloComCabo(cabo);
						if (cabo != null) {
							gerenciaCabo.removerFoneComCabo(cabo);
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
						try {
							blue.setModelo(leitura.entDados("\nModelo a atualizar: "));
						} catch (InvalidStringException ise) {
							ise.invString();
							blue = ise.corrigeModeloBluetooth(blue);
						}
						blue = gerenciaBlue.consultarModeloBluetooth(blue);
						if (blue != null) {
							gerenciaBlue.atualizarFoneBluetooth(blue);
						} else {
							leitura.entDados("\nEste modelo de fone bluetooth não existe! Press <Enter>");
						}
					} else { // Com cabo
						cabo = new ComCabo();
						try{
							cabo.setModelo(leitura.entDados("\nModelo a atualizar: "));
							} catch(InvalidStringException ise){
								ise.invString();
								cabo = ise.corrigeModeloComCabo(cabo);
							}
						cabo = gerenciaCabo.consultarModeloComCabo(cabo);
						if (cabo != null) {
							gerenciaCabo.atualizarFoneComCabo(cabo);
						} else {
							leitura.entDados("\nEste modelo de fone com cabo não existe! Press <Enter>");
						}
					}
					break;

				case 6: // Sair
					System.out.println("\n===== Sair =====");
					escolha.sair();
					break;

				default:
					leitura.entDados("\nDigite somente numeros de 1 a 6. Press <Enter>");
			}
		}
	}
}
