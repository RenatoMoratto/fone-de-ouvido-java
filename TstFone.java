//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class TstFone{

	public static void main(String arg[]){

		int i = 0;

		Leitura leitura = new Leitura();
		Bluetooth blue[] = new Bluetooth[100];
		ComCabo cabo[] = new ComCabo[100];
		Escolhas escolha = new Escolhas();

		do{
			blue[i] = new Bluetooth();
			cabo[i] = new ComCabo();
//==================================== Definindo ====================================
			System.out.println("\n===== Cadastro de Fones de Ouvido =====\n");
			System.out.print((i + 1)+" Fone de ouvido:");

			while (true) {
				try {
					System.out.println("\n[ 1 ] - Bluetooth\n[ 2 ] - Com cabo");
					escolha.setTipoFone(Integer.parseInt(leitura.entDados("\nQual o tipo de fone? ")));
					break;
				}
				catch(NumberFormatException nfe) {
					System.out.println("\nO valor precisa ser um  numero!\nDigite um 1 ou 2.");
				}
				catch(NumberInvalidException nie) {
					nie.numberInvalid();
					System.out.print("Digite 1 ou 2.\n");
				}
			}

			switch(escolha.getTipoFone()) {
				case 1:		// Bluetooth
					blue[i].mostraFone();
					blue[i].setMarca(leitura.entDados("\nMarca...: "));
					blue[i].setModelo(leitura.entDados("\nModelo...: "));
					blue[i].setStereo(Boolean.parseBoolean(leitura.entDados("\nE stereo? [true / false]: ")));
					while(true){
						try {
							blue[i].setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
							break;
						} 
						catch(NumberNegatException nne){
							nne.numNegat();
						}
						catch(NumberFormatException nfe) {
							System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
						}
						catch(NumberInvalidException nie) {
							nie.numberInvalid();
							System.out.println("Maior preco existente: R$ 56000.00");
						}
					}
					while(true){
						try {
							blue[i].setTipoBlue(Float.parseFloat(leitura.entDados("\nTipo de Bluetooth..: ")));
							break;
						} 
						catch (NumberFormatException nfe) {
							System.out.println("Valor invalido! Digite somente numeros");
							System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
						}
						catch (NumberNegatException nne){
							nne.numNegat();
						}
						catch (NumberInvalidException nie){
							nie.numberInvalid();
							System.out.println("Versoes existentes de bluetooth: 1, 2, 3, 4 e 5");
						}
					}
					while(true){
						try {
							blue[i].setDuracaoBat(Integer.parseInt(leitura.entDados("\nDuracao da Bateria em horas: ")));
							break;
						} 
						catch (NumberFormatException nfe) {
							System.out.println("Erro! Digite um numero inteiro.");
						}
						catch (NumberNegatException nne){
							nne.numNegat();
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
							System.out.println("Duracao maxima: 200 horas");
						}
					}

					System.out.println("\n===== Acessorios do Fone =====");
					blue[i].getAcess().setCase(Boolean.parseBoolean(leitura.entDados("\nPossui case (true / false)? ")));
					while(true){
						try{
							blue[i].getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
							break;
						}
						catch(NumberFormatException nfe){
							System.out.println("\nErro! Digite um numero inteiro.");
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
							System.out.println("Numero maximo de borrachas: 20");
						}
						catch(NumberNegatException nne){
							nne.numNegat();
						}
					}
					System.out.println("\n===== Avaliacao do Fone =====");
					System.out.println("De notas de 0 a 5.");
					while(true){
						try {
							blue[i].getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
							break;
						} 
						catch (NumberFormatException nfe){
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
						catch (NumberNegatException nne) {
							nne.numNegat();
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
						}
					}
					while(true){
						try {
							blue[i].getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));	
							break;					
						} 
						catch (NumberFormatException nfe){
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
						catch (NumberNegatException nne) {
							nne.numNegat();
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
						}
					}
					while(true){
						try {
							blue[i].getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
							break;						
						} 
						catch (NumberFormatException nfe){
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
						catch (NumberNegatException nne) {
							nne.numNegat();
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
						}
					}
					break;

				case 2:		// Com cabo
					cabo[i].mostraFone();
					cabo[i].setMarca(leitura.entDados("\nMarca...: "));
					cabo[i].setModelo(leitura.entDados("\nModelo...: "));
					cabo[i].setStereo(Boolean.parseBoolean(leitura.entDados("\nE stereo? [true / false]: ")));
					while(true){
						try {
						cabo[i].setPreco(Float.parseFloat(leitura.entDados("\nPreco...: R$ ")));
						break;
						} 
						catch(NumberNegatException nne){
							nne.numNegat();
						}
						catch(NumberFormatException nfe) {
							System.out.println("\nValor Invalido! Digite somente numeros com ponto. Ex.: 00.00");
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
							System.out.println("Maior preco existente: R$ 56000.00");
						}
					}
					while(true){
						try {
							cabo[i].setCompriCabo(Float.parseFloat(leitura.entDados("\nComprimento do cabo em metros: ")));
							break;
						} 
						catch(NumberInvalidException nie){
							nie.numberInvalid();
							System.out.println("Comprimento maximo: 6.0 metros");
						}
						catch (NumberFormatException nfe) {
							System.out.println("\nErro! Digite somente numeros com ponto. Ex.: 2.5");
						}
						catch (NumberNegatException nne){
							nne.numNegat();
						}
					}
					while(true){
						try{
							cabo[i].setTipoEntrada(leitura.entDados("\nTipo de Entrada...: "));
							break;
						}
						catch(InvalidStringException ise){
							ise.invString();
							System.out.println("Tipos de entrada existentes: p1, p2, p3, p10 e USB");
						}
					}
					System.out.println("\n===== Acessorios do Fone =====");
					cabo[i].getAcess().setCase(Boolean.parseBoolean(leitura.entDados("\nPossui case? [true / false]: ")));
					while(true){
						try{
							cabo[i].getAcess().setBorRes(Integer.parseInt(leitura.entDados("\nPossui quantas borrachas reserva? ")));
							break;
						}
						catch(NumberFormatException nfe){
							System.out.println("\nErro! Digite um numero inteiro.");
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
							System.out.println("");
						}
						catch(NumberNegatException nne){
							nne.numNegat();
						}
					}
					
					System.out.println("\n===== Avaliacao do Fone =====");
					System.out.println("De notas de 0 a 5.");
					while(true){
						try {
							cabo[i].getAval().setMaterial(Integer.parseInt(leitura.entDados("\nMaterial...: ")));
							break;
						} 
						catch (NumberFormatException nfe){
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
						catch (NumberNegatException nne) {
							nne.numNegat();
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
						}
					}
					while(true){
						try {
							cabo[i].getAval().setQualidade(Integer.parseInt(leitura.entDados("\nQualidade..: ")));	
							break;					
						} 
						catch (NumberFormatException nfe){
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
						catch (NumberNegatException nne) {
							nne.numNegat();
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
						}
					}
					while(true){
						try {
							cabo[i].getAval().setConforto(Integer.parseInt(leitura.entDados("\nConforto...: ")));
							break;						
						} 
						catch (NumberFormatException nfe){
							System.out.println("\nValor invalido! Digite um numero de 0 a 5.");
						}
						catch (NumberNegatException nne) {
							nne.numNegat();
						}
						catch(NumberInvalidException nie){
							nie.numberInvalid();
						}
					}
					System.out.println("\nNumero de cadastro do fone: "+cabo[i].implementNumCadastro(i));
					break;
			}
			
			System.out.println("\nObrigado por informar!\n\n");
					
//==================================== Imprimindo====================================

			// Fone de Ouvido
			switch(escolha.getTipoFone()) {
				case 1:		// Bluetooth
					System.out.println("===== Fone Bluetooth - "+blue[i].getMarca()+" =====");
					System.out.println("\nModelo...: "+blue[i].getModelo());
					System.out.println("Stereo...: "+blue[i].getStereo());
					System.out.println("Preco....: R$ "+blue[i].getPreco());
					System.out.println("Tipo de Bluetooth...: "+blue[i].getTipoBlue());
					System.out.println("Duracao da Bateria...: "+blue[i].getDuracaoBat()+" horas");

					// Acessorios
					System.out.println("\n===== Acessorios do Fone =====");
					System.out.println("Case...: "+blue[i].getAcess().getCase());
					System.out.println("Borrachas reserva...: "+blue[i].getAcess().getBorRes());

					// Avaliação
					System.out.println("\n===== Avaliacao do Fone =====");
					System.out.println("Material...: "+blue[i].getAval().getMaterial());
					System.out.println("Qualidade..: "+blue[i].getAval().getQualidade());
					System.out.println("Conforto...: "+blue[i].getAval().getConforto());
					System.out.println("\nNumero de cadastro do fone bluetooth: "+blue[i].implementNumCadastro(i));
					break;

				case 2:		// Com cabo
					System.out.println("\n===== Fone com Cabo - "+cabo[i].getMarca()+" =====");
					System.out.println("Modelo...: "+cabo[i].getModelo());
					System.out.println("Stereo...: "+cabo[i].getStereo());
					System.out.println("Preco....: R$ "+cabo[i].getPreco());
					System.out.println("Comprimento do cabo..: "+cabo[i].getCompriCabo()+" m");
					System.out.println("Tipo de Entrada...: "+cabo[i].getTipoEntrada().toUpperCase());	

					// Acessorios
					System.out.println("\n===== Acessorios do Fone =====");
					System.out.println("Case...: "+cabo[i].getAcess().getCase());
					System.out.println("Borrachas reserva...: "+cabo[i].getAcess().getBorRes());

					// Avaliação
					System.out.println("\n===== Avaliacao do Fone =====");
					System.out.println("Material...: "+cabo[i].getAval().getMaterial());
					System.out.println("Qualidade..: "+cabo[i].getAval().getQualidade());
					System.out.println("Conforto...: "+cabo[i].getAval().getConforto());
					System.out.println("\nNumero de cadastro do fone com cabo: "+cabo[i].implementNumCadastro(i));
					break;
			}
			i++;
		} while (escolha.continuar());

		System.out.println("\nForam cadastrados "+i+" fone(s)! Obrigado!");
	}
}
