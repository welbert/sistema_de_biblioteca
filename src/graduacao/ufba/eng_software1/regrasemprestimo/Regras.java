package graduacao.ufba.eng_software1.regrasemprestimo;

import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.usuario.Usuario;

public abstract class Regras {

	protected Regras sucessor;

	public void setSucessor(Regras sucessor){
		this.sucessor = sucessor;
	}
	
	public abstract String isValid(Usuario usuario, Material material);
	
}
