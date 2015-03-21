package graduacao.ufba.eng_software1.regrasemprestimo;

import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.usuario.Usuario;

public class Regra5 extends Regras{


	public String isValid(Usuario usuario, Material material) {
		if(material.isEmprestimo(usuario)){
			return "O usuario já possui esse material";
		}else{
			if(sucessor !=null){
				return sucessor.isValid(usuario, material);
			}
				return "";
		}
	}



}
