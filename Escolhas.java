//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class Escolhas {
    
        private int tipoFone = 0;
        
        Leitura leitura = new Leitura();

    public boolean continuar(){
        String a = "";        
        
        while(true){
                a = leitura.entDados("\nDeseja cadastrar mais um fone? [S / N]: ");
            if(a.equalsIgnoreCase("s")){
                return true;
            } else if(a.equalsIgnoreCase("n")){
                return false;
            } else{
                System.out.println("Valor invalido! Digite S ou N.");
            }
        }
    }
    
	public void setTipoFone(int tipoFone) throws NumberInvalidException{
		if(tipoFone != 1 && tipoFone != 2){
			throw new NumberInvalidException();
		} else {
			this.tipoFone = tipoFone;
		}
	}

    public int getTipoFone(){
		return tipoFone;
	}
}
