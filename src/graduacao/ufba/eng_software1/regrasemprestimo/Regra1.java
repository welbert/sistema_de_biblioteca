package graduacao.ufba.eng_software1.regrasemprestimo;

import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.usuario.Usuario;

public class Regra1 extends Regras{


	public String isValid(Usuario usuario, Material material) {
		if(material.retornaExemplar() == null){
			return "Sem exemplar disponível.\n";
		}else{
			if(sucessor !=null){
				return sucessor.isValid(usuario, material);
			}
				return "";
		}
	}



}
