//Nome: Renato Willyan Moratto Filho - RA.: 2266270

final public class ComCabo extends FoneDeOuvido implements Informacoes{

	private float compriCabo = 0;
	private String tipoEntrada = "";

	public void mostraFone(){
		System.out.println("\nTipo de fone de ouvido: Com cabo.");
	}
	
	public String implementNumCadastro(int index){
		String numCadastro = "C" + (1000 + index * 5);
		return numCadastro;
	}

//=====================================================

	public float getCompriCabo(){
		return compriCabo;
	}

	public String getTipoEntrada(){
		return tipoEntrada;
	}

//=====================================================

	public void setCompriCabo(float compriCabo) throws NumberNegatException, NumberInvalidException{
		if(compriCabo < 0.0){
			throw new NumberNegatException();
		} else if(compriCabo > 6.0) {
			throw new NumberInvalidException();
		} else {
			this.compriCabo = compriCabo;
		}
	}

	public void setTipoEntrada(String tipoEntrada) throws InvalidStringException{
		if(tipoEntrada.equalsIgnoreCase("p1") || tipoEntrada.equalsIgnoreCase("p2") || tipoEntrada.equalsIgnoreCase("p3") || tipoEntrada.equalsIgnoreCase("p10") || tipoEntrada.equalsIgnoreCase("usb")){
			this.tipoEntrada = tipoEntrada;
		} else {
			throw new InvalidStringException();
		}
	}
}
