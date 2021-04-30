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
}
