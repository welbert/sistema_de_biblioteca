package graduacao.ufba.eng_software1.bd;

import graduacao.ufba.eng_software1.utils.Config;

public class BancoDados {
	private static BancoDados instance;

	public static BancoDados getInstance(){
		if(instance==null)
			instance = new BancoDados();
		
		return instance;
	}
	
	private BancoDados(){
		String user,password,port,database;
		user = Config.BDUSER;
		password = Config.BDPASSWORD;
		port = Config.BDPORT;
		database = Config.BDDATABASE;		
	}
	
	public Object executeQuery(String asSQL){ return null;}
	
}
