package graduacao.ufba.eng_software1.command;

import graduacao.ufba.eng_software1.biblioteca.Biblioteca;

public class RealilzarEmprestimo implements Command {

	public Object execute(String dados[]){
		//TODO tratar excessoes caso venha faltando algum dado, será que precisa?
		return Biblioteca.getInstance().realizarEmprestimo(Long.valueOf(dados[1]),
				Long.valueOf(dados[2]));
		
	}
}
