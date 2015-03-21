package graduacao.ufba.eng_software1.regrasemprestimo;

import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.usuario.Usuario;

public class Regra4 extends Regras{

	
	public String isValid(Usuario usuario, Material material) {
		if(!material.qtdeResevasMenorQtdeExemplaresDisponiveis()){
			if(!material.isReservaDoUsuario(usuario)){
				return "O usuario não possui reserva para esse material";
			}
		}
		return sucessor.isValid(usuario, material);
	}

	

}
