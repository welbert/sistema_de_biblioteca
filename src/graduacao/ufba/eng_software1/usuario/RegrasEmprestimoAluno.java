package graduacao.ufba.eng_software1.usuario;

import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.regrasemprestimo.Regra1;
import graduacao.ufba.eng_software1.regrasemprestimo.Regra2;
import graduacao.ufba.eng_software1.regrasemprestimo.Regra3;
import graduacao.ufba.eng_software1.regrasemprestimo.Regra4;
import graduacao.ufba.eng_software1.regrasemprestimo.Regra5;
import graduacao.ufba.eng_software1.regrasemprestimo.Regras;

public abstract class RegrasEmprestimoAluno {
	
	private RegrasEmprestimoAluno(){
		
	}
	
	public static String regras(Usuario usuario, Material material){
		String mens = "";
		
		
		
		Regras r1 = new Regra1();
		Regras r2 = new Regra2();
		Regras r3 = new Regra3();
		Regras r4 = new Regra4();
		Regras r5 = new Regra5();
		r1.setSucessor(r2);
		r2.setSucessor(r3);
		r3.setSucessor(r4);
		r4.setSucessor(r5);
		
		mens = r1.isValid(usuario, material);
		
		if(mens == "") //se passou por todas as regras
			return null;
		
		return mens.concat("\nEmpréstimo não realizado\n");
	}
	

}
