package graduacao.ufba.eng_software1.command;

import graduacao.ufba.eng_software1.biblioteca.Biblioteca;

public class Reservar implements Command{

	public Object execute(String dados[]){
		return Biblioteca.getInstance().reservar(Long.valueOf(dados[1]), 
				Long.valueOf(dados[2]));
	}
}
