package graduacao.ufba.eng_software1.biblioteca;

import java.sql.Date;

import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.usuario.Usuario;

public class Reserva {

	private Material material;
	private Usuario usuario;
	private long data;
	
	
	public Reserva(Material material, Usuario usuario){
		this.material = material;
		this.usuario = usuario;
		this.data = System.currentTimeMillis();
	}
	
	public Material getMaterial(){
		return material;
	}

	public long getData(){
		return data;
	}
	
	public String getDataString(){
		Date date = new Date(data);
		return date.toString();
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String toString(){
		return "\nTitulo: "+material.getTitulo()+"\nData da reserva: "+getDataString();
	}
	
}
