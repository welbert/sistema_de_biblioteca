package graduacao.ufba.eng_software1.biblioteca;



import java.sql.Date;

import graduacao.ufba.eng_software1.material.Exemplar;
import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.usuario.Usuario;

public class Emprestimo {

	private Exemplar exemplar;
	private Usuario usuario;
	private boolean emAberto;
	private long dataEmprestimo;
	private long dataPrevistaDevolucao;
	//private long dataDevolucao;
	
	
	public Emprestimo(Exemplar exemplar, Usuario usuario){
		this.exemplar = exemplar;
		this.usuario = usuario;
		this.emAberto = true;
		this.dataEmprestimo = System.currentTimeMillis();
		this.dataPrevistaDevolucao = usuario.calcularDataPrevistaDevolucao(dataEmprestimo);
	}
	
	
	public void setEmAberto(boolean emAberto){
		this.emAberto = emAberto;
	}
	
	public boolean isEmAberto(){
		return emAberto;
	}

	public void setDataDevolucao(long dataDevolucao) {
		this.dataPrevistaDevolucao = dataDevolucao;
	}
	
	public long getDataPrevistaDevolucao(){
		return dataPrevistaDevolucao;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public String getDataEmprestimo(){
		Date date = new Date(dataEmprestimo);
		return date.toString();
	}
	
	public String getDataDevolucao(){
		Date date = new Date(dataPrevistaDevolucao);
		return date.toString();

	}
	
	public String toStringUser(){
		Material mat = Biblioteca.getInstance().buscaMaterial(exemplar.getCodMaterial()); // Busca um metodo mais eficiente, preciso pegar o nome do material e o tipo
		return "\nTitulo: "+mat.getTitulo()+"Tipo: "+mat.getTipo()+"\nData de Emprestimo: "+getDataEmprestimo()+"\nData de devolução: "+
				getDataDevolucao();
	}
	
	public String toString(){
		return "\nNome: "+usuario.getNome()+"\nData de Emprestimo: "+getDataEmprestimo()+"\nData de devolução: "+
	getDataDevolucao();
	}
	
}
