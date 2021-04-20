//Nome: Renato Willyan Moratto Filho - RA.: 2266270

final public class Bluetooth extends FoneDeOuvido implements Informacoes{

	private int duracaoBateria = 0;
	private float tipoBluetooth = 0;

	public void mostraFone(){
		System.out.println("\nTipo de fone de ouvido: Bluetooth.");
	}

	public String implementNumCadastro(int index){
		String numCadastro = "B"+ (1000 + index * 3);
		return numCadastro;
	}

//=====================================================

	public float getTipoBlue(){
		return tipoBluetooth;
	}

	public int getDuracaoBat(){
		return duracaoBateria;
	}

//=====================================================

	public void setTipoBlue(float tipoBluetooth) throws NumberInvalidException, NumberNegatException{
		if(tipoBluetooth < 0){
			throw new NumberNegatException();
		} else if(tipoBluetooth == 0 || tipoBluetooth > 5){
			throw new NumberInvalidException();
		} else{
			this.tipoBluetooth = tipoBluetooth;
		}
	}

	public void setDuracaoBat(int duracaoBateria) throws NumberNegatException, NumberInvalidException{
		if(duracaoBateria < 0){
			throw new NumberNegatException();
		} else if(duracaoBateria > 200){
			throw new NumberInvalidException();
		} else {
			this.duracaoBateria = duracaoBateria;
		}
	}
}