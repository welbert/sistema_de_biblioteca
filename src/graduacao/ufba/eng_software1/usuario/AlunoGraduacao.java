package graduacao.ufba.eng_software1.usuario;

import graduacao.ufba.eng_software1.data.Data;

public class AlunoGraduacao extends Aluno{
	
	private static int tempoEmprestimo = 1;
	private static int limiteEmprestimo = 3;

	
	public AlunoGraduacao(Long id, String nome){
		
		super(id, nome,3);
	}


	@Override
	public long calcularDataPrevistaDevolucao(long dataEmprestimo) {
		return dataEmprestimo + ( Data.valorDiaEmMilisegundos() * AlunoGraduacao.tempoEmprestimo );
	}

	@Override
	public boolean atingiuLimiteEmprestimo() {
		if(limiteEmprestimo == qtdeEmprestimosAbertos())
			return true;
		
		return false;
	}

}
