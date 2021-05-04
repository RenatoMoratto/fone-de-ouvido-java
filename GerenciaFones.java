//Nome: Renato Willyan Moratto Filho - RA.: 2266270

public interface GerenciaFones {
    public FoneDeOuvido cadastroFone(FoneDeOuvido fone);
    public void listarFones();
    public FoneDeOuvido consultarModelo(FoneDeOuvido fone);
    public void imprimirFone(FoneDeOuvido fone);
    public void removerFone(FoneDeOuvido fone);
    public void atualizarFone(FoneDeOuvido fone);
}
