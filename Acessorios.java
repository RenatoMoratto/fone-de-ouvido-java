//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class Acessorios {

	private boolean case0 = false;
	private int borrachaReserva = 0;

	public boolean getCase() {
		return case0;
	}

	public int getBorRes() {
		return borrachaReserva;
	}

	// ========================================================================

	public void setCase(boolean case0) {
		this.case0 = case0;
	}

	public void setBorRes(int borrachaReserva) throws NumberNegatException, NumberInvalidException {
		if (borrachaReserva < 0) {
			throw new NumberNegatException();
		} else if (borrachaReserva > 20) {
			throw new NumberInvalidException();
		} else {
			this.borrachaReserva = borrachaReserva;
		}
	}
}