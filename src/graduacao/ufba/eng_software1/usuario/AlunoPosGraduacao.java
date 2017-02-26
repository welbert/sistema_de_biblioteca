package graduacao.ufba.eng_software1.usuario;

import graduacao.ufba.eng_software1.data.Data;

public class AlunoPosGraduacao extends Aluno{
	
	private static int tempoEmprestimo = 2;
	private static int limiteEmprestimo = 4;
	
	
	public AlunoPosGraduacao(Long id, String nome){
		
		super(id, nome,4);
	}

	@Override
	public long calcularDataPrevistaDevolucao(long dataEmprestimo) {
		return dataEmprestimo + ( Data.valorDiaEmMilisegundos() * AlunoPosGraduacao.tempoEmprestimo );
	}

	@Override
	public boolean atingiuLimiteEmprestimo() {
		if(limiteEmprestimo == qtdeEmprestimosAbertos())
			return true;
		
		return false;
	}
	
}
