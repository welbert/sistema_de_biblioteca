package graduacao.ufba.eng_software1.terminal;

import graduacao.ufba.eng_software1.biblioteca.Biblioteca;
import graduacao.ufba.eng_software1.command.Command;
import graduacao.ufba.eng_software1.command.ConsultarMaterial;
import graduacao.ufba.eng_software1.command.ConsultarUsuario;
import graduacao.ufba.eng_software1.command.Devolver;
import graduacao.ufba.eng_software1.command.RealilzarEmprestimo;
import graduacao.ufba.eng_software1.command.Reservar;
import graduacao.ufba.eng_software1.material.CD;
import graduacao.ufba.eng_software1.material.DVD;
import graduacao.ufba.eng_software1.material.Exemplar;
import graduacao.ufba.eng_software1.material.Livro;
import graduacao.ufba.eng_software1.material.Material;
import graduacao.ufba.eng_software1.material.Revista;
import graduacao.ufba.eng_software1.usuario.AlunoGraduacao;
import graduacao.ufba.eng_software1.usuario.AlunoPosGraduacao;
import graduacao.ufba.eng_software1.usuario.Professor;
import graduacao.ufba.eng_software1.usuario.Usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Esta classe será resposável por ler os comandos e mostrar as respostas na tela.
 */
//Trabalho por Heron Sanches e Welbert Serra
public class Terminal {
	
	private static HashMap<String, Command> comandos;


	public static void main(String[] args) {
		criarComandos();
		carregarDados();
		
		Scanner in = new Scanner(System.in);
		String entrada = "", dados[] = new String[3];
		Object saida = null;
		
		while (true){
			entrada = in.nextLine();
			dados = entrada.split(" ");
			
			if(comandos.containsKey(dados[0])){
				saida = comandos.get(dados[0]).execute(dados);
				
				if(saida != null)
					System.out.println(saida);
				
			}else{
				System.out.println("Comando inválido");
			}
			
		}

	}
	
	
	private static void criarComandos(){
		comandos = new HashMap<String, Command>();
		comandos.put("emp", new RealilzarEmprestimo());
		comandos.put("dev", new Devolver());
		comandos.put("res", new Reservar());
		comandos.put("mat", new ConsultarMaterial());
		comandos.put("user", new ConsultarUsuario());
		//TODO verificar qual comando para consultar usuários, item 4.b enunciado do trabalho
	}
	
	private static void carregarDados(){
		//usuarios iniciais
		Usuario usuario;
		usuario = new AlunoGraduacao(Long.valueOf(123), "João da Silva");
		Biblioteca.getInstance().cadastraUsuario(usuario);
		
		usuario = new AlunoPosGraduacao(Long.valueOf(456), "Luiz Fernando Rodrigues");
		Biblioteca.getInstance().cadastraUsuario(usuario);
		
		usuario = new AlunoGraduacao(Long.valueOf(789), "Pedro Paulo");
		Biblioteca.getInstance().cadastraUsuario(usuario);
		
		usuario = new Professor(Long.valueOf(100), "Carlos Lucena");
		Biblioteca.getInstance().cadastraUsuario(usuario);
		
		//materiais iniciais, livros
		Material material;
		ArrayList<String> nomes = new ArrayList<String>();
		
		nomes.add("Ian Sommervile");
		material = new Livro(Long.valueOf(100), "Engenharia de	Software", 2000, "Addison Wesley",
				nomes, "6ª");
		Biblioteca.getInstance().cadastraMaterial(material);
		
		nomes.clear();
		nomes.add("Grady Booch");
		nomes.add("James Rumbaugh");
		nomes.add("Ivar Jacobson");
		material = new Livro(Long.valueOf(101), "UML - Guia do Usuário", 2000, "Campus",
				nomes, "7ª");
		Biblioteca.getInstance().cadastraMaterial(material);
		
		//revistas
		material = new Revista(Long.valueOf(200), "IEE Transactions on Software Engineering",
				2006, "53", "Setembro");
		Biblioteca.getInstance().cadastraMaterial(material);
		
		material = new Revista(Long.valueOf(201), "IEE Transactions on Software Engineering",
				2006, "54", "Outubro");
		Biblioteca.getInstance().cadastraMaterial(material);
		
		//CDS
		nomes.clear();
		nomes.add("Rehab");
		nomes.add("You know I'm No Good");
		nomes.add("Me & Mr Jones");
		ArrayList<String> nomes2 = new ArrayList<String>();
		nomes2.add("Amy Winehouse");
		material = new CD(Long.valueOf(300), "Back to Black", 2006, nomes2, nomes);
		Biblioteca.getInstance().cadastraMaterial(material);
		
		nomes.clear();
		nomes.add("Longe");
		nomes.add("Invejoso");
		nomes.add("Envelhecer");
		nomes2.clear();
		nomes2.add("Arnaldo Antunes");
		material = new CD(Long.valueOf(301), "Iê Iê Iê", 2009, nomes2, nomes);
		Biblioteca.getInstance().cadastraMaterial(material);
		nomes2.clear();
		
		//DVDs
		nomes.clear();
		nomes.add("Harrison Ford");
		nomes.add("Cate Blanchett");
		material = new DVD(Long.valueOf(400), "Indiana Jones and the Kingdom of the Crystal Skull",
				2008, nomes, "4");
		Biblioteca.getInstance().cadastraMaterial(material);
		
		nomes.clear();
		nomes.add("William Hurt");
		nomes.add("Tim Blake Nelson");
		material = new DVD(Long.valueOf(401), "Incredible Hulk",
				2008, nomes, "4");
		Biblioteca.getInstance().cadastraMaterial(material);
		
		//exemplares
		Biblioteca.getInstance().buscaMaterial(Long.valueOf(100))
			.inserirExemplar(new Exemplar(Long.valueOf(1)));
		
		Biblioteca.getInstance().buscaMaterial(Long.valueOf(100))
		.inserirExemplar(new Exemplar(Long.valueOf(2)));
		
		Biblioteca.getInstance().buscaMaterial(Long.valueOf(101))
		.inserirExemplar(new Exemplar(Long.valueOf(3)));
		
		Biblioteca.getInstance().buscaMaterial(Long.valueOf(200))
		.inserirExemplar(new Exemplar(Long.valueOf(4)));
		
		Biblioteca.getInstance().buscaMaterial(Long.valueOf(201))
		.inserirExemplar(new Exemplar(Long.valueOf(5)));
		
		Biblioteca.getInstance().buscaMaterial(Long.valueOf(300))
		.inserirExemplar(new Exemplar(Long.valueOf(6)));
		
		Biblioteca.getInstance().buscaMaterial(Long.valueOf(300))
		.inserirExemplar(new Exemplar(Long.valueOf(7)));
		
		Biblioteca.getInstance().buscaMaterial(Long.valueOf(400))
		.inserirExemplar(new Exemplar(Long.valueOf(8)));
		
		Biblioteca.getInstance().buscaMaterial(Long.valueOf(400))
		.inserirExemplar(new Exemplar(Long.valueOf(9)));
		
	}

}
