package graduacao.ufba.eng_software1.command;

import graduacao.ufba.eng_software1.biblioteca.Biblioteca;

public class ConsultarUsuario implements Command{

	public Object execute(String dados[]){
		return Biblioteca.getInstance().consultarUsuario(Long.valueOf(dados[1]));
	}

}
