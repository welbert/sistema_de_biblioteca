package graduacao.ufba.eng_software1.material;

import graduacao.ufba.eng_software1.biblioteca.Emprestimo;

import java.util.ArrayList;

public class Exemplar {
	private Long codMaterial;
	private Long cod;
	private boolean	disponivel;
	private Emprestimo emprestimosAbertos;
	
	public Exemplar(Long cod){
		this.cod = cod;
		this.disponivel = true;
		emprestimosAbertos = null;;
	}
	
	
	
	public Long getCodMaterial() {
		return codMaterial;
	}



	public void setCodMaterial(Long codMaterial) {
		this.codMaterial = codMaterial;
	}



	public boolean isDisponivel(){
		return disponivel;
	}
	
	public String isDisponivelString(){
		if(disponivel){
			return "Disponivel";
		}else{
			return "Emprestado";
		}
	}
	
	public void setDisponivel(boolean isDisponivel){
		this.disponivel = isDisponivel;
	}
	
	public Long getCod(){
		return cod;
	}
	
	public Emprestimo getEmprestimosAbertos(){
		return emprestimosAbertos;
	}
	
	public void addEmprestimoAberto(Emprestimo emprestimo){
		emprestimosAbertos = emprestimo;
	}
	
	public long getCodigoUsuario(){
		if(emprestimosAbertos!=null){
		return emprestimosAbertos.getUsuario().getCod();
		}
		return 0;
	}
		
	public void devolverExemplar(){
		disponivel=true;
		emprestimosAbertos=null;
	}
	
	public String toString(){
		String result=" Codigo: "+cod+"\n Status: "+isDisponivelString();
		if(emprestimosAbertos!=null){
			result+="\n Emprestado a: "+emprestimosAbertos.toString();
		}
		return result;		
	}
	
}
