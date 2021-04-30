//Nome: Renato Willyan Moratto Filho - RA.: 2266270

import java.util.List;
import java.util.ArrayList;

public class GerenciaFonesBluetooth {

	private  List<Bluetooth> bdBlue = new ArrayList<Bluetooth>();
	private  Leitura leitura = new Leitura();

	public Bluetooth cadastroFoneBluetooth(Bluetooth blue) {
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

	public void listarFonesBluetooth() {
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
	}

	public Bluetooth consultarModeloBluetooth(Bluetooth blue) { // busca o modelo do fone bluetooth
		for (int i = 0; i < bdBlue.size(); i++) {
			if (blue.getModelo().equalsIgnoreCase(bdBlue.get(i).getModelo())) { // Busca se existe algum fone com o
																				// mesmo modelo
				return bdBlue.get(i);
			}
		}
		return null;
	}

	public void imprimirFoneBluetooth(Bluetooth blue) {
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
	
	public void removerFoneBluetooth(Bluetooth blue) { // Exclui o fone bluetooth em si
		bdBlue.remove(blue);
	}

	public void atualizarFoneBluetooth(Bluetooth blue) {
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
}
