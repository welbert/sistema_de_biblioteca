package graduacao.ufba.eng_software1.material;

import java.util.ArrayList;

public class DVD extends Material{

	private ArrayList<String> autores;
	private String regiao;
	private static final String tipo = "DVD";
	
	public String getTipo(){
		return tipo;
	}
	
	
	public DVD(Long cod, String titulo, int anoPublicacao,
			ArrayList<String> autores, String regiao){
		
		super(cod, titulo, anoPublicacao);
		this.autores = new ArrayList<String>(autores);
		this.regiao = regiao;
		
	}
}
