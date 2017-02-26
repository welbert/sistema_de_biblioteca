package graduacao.ufba.eng_software1.usuario;

import graduacao.ufba.eng_software1.biblioteca.Emprestimo;
import graduacao.ufba.eng_software1.data.Data;
import graduacao.ufba.eng_software1.material.Exemplar;
import graduacao.ufba.eng_software1.material.Material;

public class Professor extends Usuario{
	
	private static int tempoEmprestimo = 4;


	public Professor(Long id, String nome){
		
		super(id, nome,2,2);
	}

	
	@Override
	public long calcularDataPrevistaDevolucao(long dataEmprestimo) {
		return dataEmprestimo + ( Data.valorDiaEmMilisegundos() * Professor.tempoEmprestimo);
	}

	@Override
	public Object realizarEmprestimo(Material material) {
		
		String mens = String.format("Nome Usuário: %s\nMaterial: %s", getNome(), material.getTitulo());
		String motivo = RegrasEmprestimoProfessor.regras(this, material);
		
		if( motivo != null){ //se infrigiu alguma regra
			return String.format("%s\n%s", mens, motivo);
		}
		
		material.removeReserva(this);
		removeReserva(material);
		
		
		Exemplar exemplar = material.retornaExemplar();
		Emprestimo emprestimo = new Emprestimo(exemplar, this);
		
		material.decremetaQtdeDisponivel();
		exemplar.setDisponivel(false);
		adicionarEmprestimoAberto(emprestimo);
		exemplar.addEmprestimoAberto(emprestimo);

		return String.format("%s\nEmpréstimo realizado com sucesso.", mens);
		
	}

	@Override
	public boolean atingiuLimiteEmprestimo() {
		
		return false;
	}
	
}
