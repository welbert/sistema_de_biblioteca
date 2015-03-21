package graduacao.ufba.eng_software1.material;

import java.util.ArrayList;

public class CD extends Material{

	private ArrayList<String> autores;
	private ArrayList<String> faixas;
	
	private static final String tipo = "CD";
	
	public String getTipo(){
		return tipo;
	}
	
	public CD(Long cod, String titulo, int anoPublicacao,
			ArrayList<String> autores, ArrayList<String> faixas){
		
		super(cod, titulo, anoPublicacao);
		this.autores = new ArrayList<String>(autores);
		this.faixas = new ArrayList<String>(faixas);
	}
	
}
