package graduacao.ufba.eng_software1.material;

import java.util.ArrayList;

public class Livro extends Material{

	private String editora;
	private ArrayList<String> autores;
	private String edicao;
	private static final String tipo = "Livro";
	
	public String getTipo(){
		return tipo;
	}
	
	public Livro(Long cod, String titulo, int anoPublicacao, String editora,
			ArrayList<String> autores, String edicao){
		
		super(cod, titulo, anoPublicacao);
		this.editora = editora;
		this.autores = new ArrayList<String>(autores);
		this.edicao = edicao;
	}
	
}
