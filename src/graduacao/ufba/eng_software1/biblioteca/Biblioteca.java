package graduacao.ufba.eng_software1.biblioteca;

import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.usuario.Usuario;

import java.util.HashMap;

public class Biblioteca {

	private HashMap<Long, Usuario> usuarios;
	private HashMap<Long, Material> materiais;

	private static Biblioteca instance = new Biblioteca();


	private Biblioteca(){
		usuarios = new HashMap<Long, Usuario>(7);
		materiais = new HashMap<Long, Material>(21);
	}


	public static Biblioteca getInstance(){
		return instance;
	}

	public void cadastraUsuario(Usuario usuario){
		usuarios.put(usuario.getCod(), usuario);
	}

	public void cadastraMaterial(Material material){
		materiais.put(material.getCod(), material);
	}

	public Material buscaMaterial(Long cod){
		return materiais.get(cod);
	}

	public Usuario buscaUsuario(Long cod){
		return usuarios.get(cod);
	}

	public Object realizarEmprestimo(Long codUsuario, Long codMaterial){

		Usuario usuario = buscaUsuario(codUsuario);
		Material material = buscaMaterial(codMaterial);

		//Chain of Responsibility
		if( (usuario != null) && (material != null) )
			return buscaUsuario(codUsuario).realizarEmprestimo(buscaMaterial(codMaterial));

		String mens = "";
		if(usuario == null)
			mens = mens.concat("Usu√°rio inexistente.\n");

		if(material == null)
			mens = mens.concat("Material inexistente.\n");

		return mens.concat("Empr√©stimo n√£o realizado.");
	}

	public String consultarMaterial(Long codMaterial){
		//TODO ...
		Material produto = materiais.get(codMaterial); // evitar que se repita o get
		if(produto!=null){ // verifica se existe
			return produto.toString(); // retorna o toString do objeto
		}else{
			return "Material n„o encontrado"; //TODO alterar retorno
		}
	}
	
	public String consultarUsuario(Long codUsuario){
		Usuario user = usuarios.get(codUsuario);
		if(user!=null){
			return user.toString();
		}else{
			return "Usuario n„o encontrado";
		}
	}

	public Object devolver(Long codUsuario, Long codMaterial){
		//TODO ...
		Usuario user = usuarios.get(codUsuario);
		Material material = materiais.get(codMaterial);
		
		if((user==null)||(material==null)){
			return "Codigo invalido";
		}
		if(user.devolver(material)){
			return "DevoluÁ„o efetuada com sucesso para o usuario "+user.getNome()+"e Material "+material.getTitulo();
		}else{
			return "O usuario n„o possui esse material";
		}
		 //TODO alterar retorno
	}

	public Object reservar(Long codUsuario, Long codMaterial){
		//TODO ...
		Usuario user = usuarios.get(codUsuario);
		Material material = materiais.get(codMaterial);
		if((user==null)||(material==null)){
			return "Codigo invalido";
		}
		
		
		
		if(user.reservar(material)){
			return user.getNome()+" sua reserva para "+material.getTitulo()+" foi efetuado com sucesso";
		}else{
			return "O usuario est· no seu limite de reserva";
		}

		 //TODO alterar retorno
	}

}
