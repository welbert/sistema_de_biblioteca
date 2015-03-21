package graduacao.ufba.eng_software1.usuario;

import graduacao.ufba.eng_software1.biblioteca.Emprestimo;
import graduacao.ufba.eng_software1.material.Exemplar;
import graduacao.ufba.eng_software1.material.Material;

public abstract class Aluno extends Usuario{
	
	public Aluno(Long id, String nome){
		super(id, nome);
	}
	
	@Override
	public Object realizarEmprestimo(Material material) {
		
		String mens = String.format("Nome Usuário: %s\nMaterial: %s", getNome(), material.getTitulo());
		String motivo = RegrasEmprestimoAluno.regras(this, material);
		
		if( motivo != null){ //se infrigiu alguma regra
			return String.format("%s\n%s", mens, motivo);
		}
		

		material.removeReserva(this);
		removeReserva(material);
		
		Exemplar exemplar = material.retornaExemplar();
		Emprestimo emprestimo = new Emprestimo(exemplar, this);
		
		material.incremetaQtdeDisponivel();
		exemplar.setDisponivel(false);
		material.decremetaQtdeDisponivel();
		adicionarEmprestimoAberto(emprestimo);
		exemplar.addEmprestimoAberto(emprestimo);

		
		return String.format("%s\nEmpréstimo realizado com sucesso.", mens);
		
	}
	

}
