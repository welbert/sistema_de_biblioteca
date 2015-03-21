package graduacao.ufba.eng_software1.usuario;

import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.regrasemprestimo.Regra1;
import graduacao.ufba.eng_software1.regrasemprestimo.Regra2;
import graduacao.ufba.eng_software1.regrasemprestimo.Regras;

public abstract class RegrasEmprestimoProfessor {
	
	private RegrasEmprestimoProfessor(){
		
	}
	
	
public static String regras(Usuario usuario, Material material){
	String mens = "";
		
		
		Regras r1 = new Regra1();
		Regras r2 = new Regra2();
		r1.setSucessor(r2);
		
		mens = r1.isValid(usuario, material);
		if(mens == "") //se passou por todas as regras
			return null;
		
		return mens.concat("Empréstimo não realizado\n");
	}

}
