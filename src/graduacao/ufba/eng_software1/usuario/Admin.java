package graduacao.ufba.eng_software1.usuario;

import graduacao.ufba.eng_software1.material.Material;

public class Admin extends Usuario{

	
	public Admin(Long id, String nome) {
		super(id, nome,1,3);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public long calcularDataPrevistaDevolucao(long dataEmprestimo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean atingiuLimiteEmprestimo() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object realizarEmprestimo(Material material) {
		// TODO Auto-generated method stub
		return null;
	}

}
