package graduacao.ufba.eng_software1.regrasemprestimo;

import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.usuario.Usuario;

public class Regra3 extends Regras{

	
	public String isValid(Usuario usuario, Material material) {
		if(usuario.atingiuLimiteEmprestimo()){
			return "Quantidade máxima de empréstimos atinginda.\n";
		}else{
			if(sucessor !=null){
				return sucessor.isValid(usuario, material);
			}
				return "";
		}
		
	}

	

}
