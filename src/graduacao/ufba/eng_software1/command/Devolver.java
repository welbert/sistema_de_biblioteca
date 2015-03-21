package graduacao.ufba.eng_software1.command;

import graduacao.ufba.eng_software1.biblioteca.Biblioteca;

public class Devolver implements Command{

	public Object execute(String dados[]){
		return Biblioteca.getInstance().devolver(Long.valueOf(dados[1]), 
				Long.valueOf(dados[2]));
	}
}
