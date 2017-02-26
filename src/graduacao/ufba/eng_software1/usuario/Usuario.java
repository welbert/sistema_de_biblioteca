package graduacao.ufba.eng_software1.usuario;

import java.util.ArrayList;

import graduacao.ufba.eng_software1.biblioteca.Emprestimo;
import graduacao.ufba.eng_software1.biblioteca.Reserva;
import graduacao.ufba.eng_software1.material.Exemplar;
import graduacao.ufba.eng_software1.material.Material;

public abstract class Usuario {

	private Long cod;
	private String nome;
	private int nivel_usuario=1;
	private int tipo_usuario = 0;

	private ArrayList<Emprestimo> emprestimosAbertos;
	private ArrayList<Emprestimo> emprestimosConluidos;
	private ArrayList<Reserva> reservas;


	public Usuario(Long id, String nome, int tipo_usuario, int nivel_usuario){

		this.cod = id;
		this.nome = nome;
		this.tipo_usuario = tipo_usuario;
		emprestimosAbertos = new ArrayList<Emprestimo>();
		emprestimosConluidos = new ArrayList<Emprestimo>();
		reservas = new ArrayList<Reserva>();
	}


	public abstract long calcularDataPrevistaDevolucao(long dataEmprestimo);
	public abstract boolean atingiuLimiteEmprestimo();
	public abstract Object realizarEmprestimo(Material material);


	public boolean devolver(Material material){
		Exemplar exemplar = material.getExemplardoUsuario(cod);//pega um exemplar que contenha o user
		if(exemplar==null){
			return false;
		}
		Emprestimo emprestimo = null;
		for (int i=0;i<emprestimosAbertos.size();i++){
			if(emprestimosAbertos.get(i).getExemplar().equals(exemplar)){//pega o emprestimo que contenha o exemplar
				emprestimo = emprestimosAbertos.get(i);
				break;
			}
		}
		if(emprestimo == null){
			return false;
		}

		material.incremetaQtdeDisponivel();
		exemplar.devolverExemplar();//Torna o exemplar disponivel
		emprestimo.setDataDevolucao(System.currentTimeMillis());//Devolucao tem a data de hj
		emprestimosConluidos.add(emprestimo);
		emprestimosAbertos.remove(emprestimo);

		return true; //TODO ...
	}

	public boolean reservar(Material material){
		if(reservas.size()<3){
			material.addReserva(this);
			reservas.add(new Reserva(material, this));
			return true;
		}
	
		return false;

	}

	public int qtdeEmprestimosAbertos(){
		return emprestimosAbertos.size();
	}

	public Long getCod(){
		return cod;
	}

	public boolean isDevedor(){

		for(Emprestimo emprestimo: emprestimosAbertos){
			if(System.currentTimeMillis() > emprestimo.getDataPrevistaDevolucao())
				return true;
		}

		return false;
	}

	public void adicionarEmprestimoAberto(Emprestimo emprestimo){
		emprestimosAbertos.add(emprestimo);
	}


	public String getNome() {
		return nome;
	}
	
	public boolean removeReserva(Material material){
		for(int i=0;i<reservas.size();i++){
			if(reservas.get(i).getMaterial().equals(material)){
				reservas.remove(i);
				return true;
			}
		}
		return false;
	}

	public String getInformacaoEmprestimo(ArrayList<Emprestimo> emp){
		String result = "";
		for (int i =0;i<emp.size();i++){
			result+="\n"+emp.get(0).toStringUser();
		}
		return result;
	}

	public String getReservas(){
		String result="";
		for (int i=0;i<reservas.size();i++){
			result+=reservas.get(i).toString();
		}
		return result;
	}

	public String toString(){
		return "Nome: "+nome+"\n Emprestimos em abertos: "+getInformacaoEmprestimo(emprestimosAbertos)+"\n\n Emprestimos Passados: "+getInformacaoEmprestimo(emprestimosConluidos)+"\n\n Reservas: "+getReservas();
	}


	public int getNivel_usuario() {
		return nivel_usuario;
	}


	public void setNivel_usuario(int nivel_usuario) {
		this.nivel_usuario = nivel_usuario;
	}


	public int getTipoUsuario() {
		return tipo_usuario;
	}


}
