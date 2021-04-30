//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class Escolhas {
	
	private int tipoFone = 0;

	Leitura leitura = new Leitura();

	public void setTipoFone(int tipoFone) throws NumberInvalidException {	// Define o tipo de fone
		if (tipoFone != 1 && tipoFone != 2) {
			throw new NumberInvalidException();
		} else {
			this.tipoFone = tipoFone;
		}
	}

	public int getTipoFone() {	// Apresenta o valor do fone
		return tipoFone;
	}

	public void setTipoListagem(int tipoFone) throws NumberInvalidException {	// Define o tipo de listagem do fone
		if (tipoFone != 1 && tipoFone != 2 && tipoFone != 3) {
			throw new NumberInvalidException();
		} else {
			this.tipoFone = tipoFone;
		}
	}

	public int getTipoListagem() {	// Apresenta o valor da listagem escolhido
		return tipoFone;
	}
	
	public void sair() { // Testa se o usuário deseja sair da aplicação
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
