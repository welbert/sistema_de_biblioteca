package graduacao.ufba.eng_software1.material;

import graduacao.ufba.eng_software1.biblioteca.Emprestimo;
import graduacao.ufba.eng_software1.biblioteca.Reserva;
import graduacao.ufba.eng_software1.usuario.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public abstract class Material {

	private Long cod;
	private String titulo;
	private int qtdeTotal;
	private int qtdeDisponivel;
	private HashMap<Long, Exemplar> exemplares;
	private ArrayList<Reserva> reservas;
	private int anoPublicacao;


	public Material(Long cod, String titulo, int anoPublicacao){

		this.cod = cod;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.exemplares = new HashMap<Long, Exemplar>(14);
		this.reservas = new ArrayList<Reserva>();

	}


	public Long getCod(){
		return cod;
	}

	public void inserirExemplar(Exemplar exemplar){
		exemplar.setCodMaterial(cod);
		exemplares.put(exemplar.getCod(), exemplar);
		qtdeDisponivel++;
		qtdeTotal++;
	}

	public void decremetaQtdeDisponivel(){
		qtdeDisponivel--;
	}

	public void incremetaQtdeDisponivel(){
		qtdeDisponivel++;
	}

	public Exemplar retornaExemplar(){
		if(qtdeDisponivel > 0){
			for(Exemplar exemplar: exemplares.values()){
				if(exemplar.isDisponivel())
					return exemplar;
			}
		}

		return null;
	}

	public boolean isDisponivelExemplar(long cod){
		if(exemplares.containsKey(cod) && exemplares.get(cod).isDisponivel())
			return true;

		return false;
	}

	public boolean isReservaDoUsuario(Usuario usuario){
		for(Reserva reserva: reservas){
			if(reserva.getUsuario().equals(usuario))
				return true;
		}

		return false;
	}

	public boolean qtdeResevasMenorQtdeExemplaresDisponiveis(){
		if(reservas.size() < qtdeDisponivel)
			return true;

		return false;
	}
	
	public void addReserva(Usuario usuario){
		reservas.add(new Reserva(this, usuario));
	}
	
	public void removeReserva(Usuario usuario){
		for(int i =0;i<reservas.size();i++){
			if(reservas.get(i).getUsuario().equals(usuario)){
				reservas.remove(i);
			}
		}
	}

	public boolean isEmprestimo(Usuario usuario){

		for(Exemplar exemplar: exemplares.values()){
			try{
				if(exemplar.getEmprestimosAbertos().getUsuario().equals(usuario))
					return true;
			}catch(NullPointerException e){
				
			}
		}
		return false;
	}


	public String getTitulo() {
		return titulo;
	}

	public String getNomeReserva(){// retorna uma string de todas as reservas, é usada em toString
		if(reservas.size()!=0){
			String reserva="\nReserva realizada por: ";
			for(int i=0;i<reservas.size();i++){
				reserva+="\n "+reservas.get(i).getUsuario().getNome();
			}
			return reserva;
		}else{
			return "";
		}
	}

	public String getInformacaoExemplar(){
		if(!exemplares.isEmpty()){
			String exemplar ="";
			Set<Long> keys = exemplares.keySet();
			for(Long key : keys){
				if(key!=null){
					exemplar+=exemplares.get(key).toString();
				}
			}	
			return exemplar;
		}else{
			return "";
		}
	}
	
	public Exemplar getExemplardoUsuario(long coduser){
		for(Exemplar exemplar: exemplares.values()){
			if(exemplar.getCodigoUsuario() == coduser)
				return exemplar;
		}
		return null;
	}

	public String toString(){

		return "Titulo: "+titulo+"\nQuantidade de Reservas: "+reservas.size()+
				getNomeReserva()+"\n"+getInformacaoExemplar();
	}

	
	
	public abstract String getTipo();
	
}
