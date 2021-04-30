//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public abstract class FoneDeOuvido{

	private float preco = 0;
	private boolean stereo = false;
	private String marca = "";
	private String modelo = "";
	
	private Acessorios acessorio = new Acessorios(); 
	private Avaliacao avaliacao = new Avaliacao();

//=====================================================

	public abstract void mostraFone();

//=====================================================

	public float getPreco(){
		return preco;
	}

	public boolean getStereo(){
		return stereo;
	}

	public String getMarca(){
		return marca;
	}

	public String getModelo(){
		return modelo;
	}

	public Acessorios getAcess(){
		return acessorio;
	}

	public Avaliacao getAval(){
		return avaliacao;
	}

//=====================================================

	public void setPreco(float preco) throws NumberNegatException, NumberInvalidException{
		if(preco < 0){
			throw new NumberNegatException();
		} else if(preco > 57000.00) {
			throw new NumberInvalidException();
		} else {
			this.preco = preco;
		}
	}

	public void setStereo(boolean stereo) {
			this.stereo = stereo;
	}

	public void setMarca(String marca) throws InvalidStringException{
		if(marca.isBlank() || marca.equals(null)){
			throw new InvalidStringException();
		} else{
		this.marca = marca;
		}
	}

	public void setModelo(String modelo) throws InvalidStringException{
		if(modelo.isBlank() || modelo.equals(null)){
			throw new InvalidStringException();
		} else{
			this.modelo = modelo;	
		}
	}

	public void setAcess(Acessorios acessorio){
		this.acessorio = acessorio;
	}

	public void setAval(Avaliacao avaliacao){
		this.avaliacao = avaliacao;
	}
}