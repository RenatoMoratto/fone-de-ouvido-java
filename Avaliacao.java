//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class Avaliacao{

	private int material = 0; 
	private int qualidade = 0; 
	private int conforto = 0; 
	
	public int getMaterial(){
		return material;
	}
	
	public int getQualidade(){
		return qualidade;
	}

	public int getConforto(){
		return conforto;
	}

//=====================================================

	public void setMaterial(int material) throws NumberNegatException, NumberInvalidException{
		if(material < 0){
			throw new NumberNegatException();		
		} else if(material > 5) {
			throw new NumberInvalidException();
		} else{
			this.material = material;
		}
	}

	public void setQualidade(int qualidade) throws NumberNegatException, NumberInvalidException{
		if(qualidade < 0){
			throw new NumberNegatException();		
		} else if(qualidade > 5) {
			throw new NumberInvalidException();
		} else{
			this.qualidade = qualidade;
		}
	}

	public void setConforto(int conforto) throws NumberNegatException, NumberInvalidException{
		if(conforto < 0){
			throw new NumberNegatException();		
		} else if(conforto > 5) {
			throw new NumberInvalidException();
		} else{
			this.conforto = conforto;
		}
	}
}
