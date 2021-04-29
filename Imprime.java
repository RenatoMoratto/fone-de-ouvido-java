//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public class Imprime {

	public void foneBluetooth(Bluetooth blue, int totFones) {	// Imprime os dados do fone bluetooth
		System.out.println("\n===== Fone Bluetooth - " + blue.getMarca() + " =====");
		System.out.println("\nModelo...: " + blue.getModelo());
		System.out.println("Stereo...: " + blue.getStereo());
		System.out.println("Preco....: R$ " + blue.getPreco());
		System.out.println("Tipo de Bluetooth...: " + blue.getTipoBlue());
		System.out.println("Duracao da Bateria...: " + blue.getDuracaoBat() + " horas");

		// Acessorios
		System.out.println("\n===== Acessorios do Fone =====");
		System.out.println("Case...: " + blue.getAcess().getCase());
		System.out.println("Borrachas reserva...: " + blue.getAcess().getBorRes());

		// Avaliação
		System.out.println("\n===== Avaliacao do Fone =====");
		System.out.println("Material...: " + blue.getAval().getMaterial());
		System.out.println("Qualidade..: " + blue.getAval().getQualidade());
		System.out.println("Conforto...: " + blue.getAval().getConforto());
		System.out.println("\nNumero de cadastro do fone bluetooth: " + blue.implementNumCadastro(totFones));
	}

	public void foneComCabo(ComCabo cabo, int totFones) {	// Imprime os dados do fone com cabo

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
		System.out.println("\nNumero de cadastro do fone com cabo: " + cabo.implementNumCadastro(totFones));
	}
}
