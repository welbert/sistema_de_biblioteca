package graduacao.ufba.eng_software1.material;

public class Revista extends Material{

	private String edicao;
	private String mes;
	private static final String tipo = "Revista";
	
	public String getTipo(){
		return tipo;
	}
	
	
	public Revista(Long cod, String titulo, int anoPublicacao,
			String edicao, String mes){
		
		super(cod, titulo, anoPublicacao);
		this.edicao = edicao;
		this.mes = mes;
		
	}
}
