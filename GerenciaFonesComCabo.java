//Nome: Renato Willyan Moratto Filho - RA.: 2266270

import java.util.List;
import java.util.ArrayList;

public class GerenciaFonesComCabo {
    
	private  List<ComCabo> bdCabo = new ArrayList<ComCabo>();
	private  Leitura leitura = new Leitura();
    
	public ComCabo cadastroFoneComCabo(ComCabo cabo) {
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
    
    public void listarFonesComCabo() {
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
	
    public ComCabo consultarModeloComCabo(ComCabo cabo) { // busca o modelo do fone com cabo
		for (int i = 0; i < bdCabo.size(); i++) {
			if (cabo.getModelo().equalsIgnoreCase(bdCabo.get(i).getModelo())) { // Busca se existe algum fone com o
																				// mesmo modelo
				return bdCabo.get(i);
			}
		}
		return null;
	}

    public void imprimirFoneComCabo(ComCabo cabo) {
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
    
	public void removerFoneComCabo(ComCabo cabo) { // Exclui o fone com cabo em si
		bdCabo.remove(cabo);
	}

	public void atualizarFoneComCabo(ComCabo cabo) {
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
}
