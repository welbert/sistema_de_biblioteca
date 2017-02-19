package graduacao.ufba.eng_software1.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;

import graduacao.ufba.eng_software1.utils.Config;

public class BancoDados {
	private static BancoDados instance;
	private String dberror_msg = "";
	private String exception_msg = "";
	private boolean dberror;
	
	Connection connection = null;
	
	public static BancoDados getInstance(){
		if(instance==null)
			instance = new BancoDados();
		
		return instance;
	}
	
	private BancoDados(){
		String user,password,port,database,url,connString;
		user = Config.BDUSER;
		password = Config.BDPASSWORD;
		port = Config.BDPORT;
		database = Config.BDDATABASE;	
		url = Config.BDURL;
		connString = "jdbc:mysql://"+url+":"+port+"/"+database+"";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connString,user,password);
			connection.setAutoCommit(false);
			dberror=false;
		} catch (Exception e) {
			dberror = true;
			dberror_msg = "Error 001 :\n" + e.getClass().getName() + ": " + e.getMessage() + "\n";
			exception_msg = "Error 001 : " + e.getClass().getName() + ": " + e.getMessage();
		}		
	}
	
	public String get_dberror(){
		String aux = dberror_msg;
		dberror_msg = "";
		dberror = false;
		return aux;
	}
	
	public boolean hasDberror(){
		return dberror;
	}
	
	public String get_ExceptionMsg(){
		String aux = exception_msg;
		exception_msg = "";
		return aux;
	}
	
	public boolean isConnected(){
		try {
			return (connection != null && !connection.isClosed());
		} catch (Exception e) {
			return false;
		}
	}
	
	public void resetConnection(){
		String user,password,port,database,url,connString;
		user = Config.BDUSER;
		password = Config.BDPASSWORD;
		port = Config.BDPORT;
		database = Config.BDDATABASE;	
		url = Config.BDURL;
		connString = "jdbc:mysql://"+url+":"+port+"/"+database+"";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connString,user,password);
			connection.setAutoCommit(false);
			dberror=false;
		} catch (Exception e) {
			dberror = true;
			dberror_msg = "Error 001 :\n" + e.getClass().getName() + ": " + e.getMessage() + "\n";
			exception_msg = "Error 001 : " + e.getClass().getName() + ": " + e.getMessage();
		}		
	}
	
	public void commit(){
		try {
			connection.commit();
		} catch (SQLException e) {
			dberror = true;
			exception_msg = "Error 002 : " + e.getClass().getName() + ": " + e.getMessage();
			dberror_msg += "Error 002 :\nN�o foi possivel enviar as modifica��es para o banco\n";
		}
	}
	
	public void rollback(){
		try{
		connection.rollback();
		}catch (SQLException e){
			dberror = true;
			exception_msg = "Error 003 : " + e.getClass().getName() + ": " + e.getMessage();
			dberror_msg += "Error 003 :\nN�o foi possivel reverter as modifica��es para o banco\n";
		}
	}
	
	public int insertInformation(String tabela,Map<String, Object> map){
		java.util.Iterator<Entry<String, Object>> it = map.entrySet().iterator();
		String concatKeys = null;
		String concatValues = null;
		Map.Entry<String, Object> entry;
			
		entry = it.next();
		concatKeys = entry.getKey();
		concatValues = "'"+entry.getValue().toString()+"'";
		it.remove();
		
		while(it.hasNext()){
			entry = it.next();
			concatKeys += ", "+entry.getKey();
			concatValues += ", '"+entry.getValue().toString()+"'";
			it.remove();
		}
		try{
			Statement stm = connection.createStatement();
			String sql = "INSERT INTO "+tabela+" ("+concatKeys+") VALUES ("+concatValues+");";
			stm.executeUpdate(sql);
			ResultSet rs = connection.createStatement().executeQuery("SELECT last_insert_rowid() FROM " + tabela+";");
			if(rs.next())
				return rs.getInt(1);
		}catch(Exception e){
			dberror = true;
			exception_msg = "Error 004 : " + e.getClass().getName() + ": " + e.getMessage();
			dberror_msg += "Error 004 :\nN�o foi possivel inserir as informa��es no banco\n";
			return 0;
		}
		return 0;
	}
	
	public int updateInformation(String tabela,Map<String, Object> setValue,Map<String, Object> setWhere){
		
		String clauseWhere = null;
		String clauseSet = null;
		
		java.util.Iterator<Entry<String, Object>> it = setWhere.entrySet().iterator();
		Map.Entry<String, Object> entry;
		//Set<Entry<String, Object>> clauseSet = setValue.entrySet();
			
		entry = it.next();
		clauseWhere = entry.getKey()+" = '"+entry.getValue()+"'";
		it.remove();
		
		while(it.hasNext()){
			entry = it.next();
			clauseWhere += " AND "+entry.getKey()+" = '"+entry.getValue()+"'";
			it.remove();
		}
		
		it = setValue.entrySet().iterator();		
		entry = it.next();
		clauseSet = entry.getKey()+" = '"+entry.getValue()+"'";
		it.remove();
		
		while(it.hasNext()){
			entry = it.next();
			clauseSet += ", "+entry.getKey()+" = '"+entry.getValue()+"'";
			it.remove();
		}
		
		try{
			Statement stm = connection.createStatement();
			String sql = "Update "+tabela+" set " + clauseSet +" WHERE "+ clauseWhere+";";
			return stm.executeUpdate(sql);
		}catch(Exception e){
			dberror = true;
			exception_msg = "Error 005 : " + e.getClass().getName() + ": " + e.getMessage();
			dberror_msg += "Error 005 :\nN�o foi possivel atualizar as informa��es no banco\n";
			return 0;
		}

	}
	
	public int deleteInformation(String tabela,String where){
		try{
			String sql;
			Statement stm;
			stm = connection.createStatement();
			
			sql = "DELETE FROM "+tabela+" WHERE "+where+";";
			return stm.executeUpdate(sql);
			
		}catch(Exception e){
			dberror = true;
			exception_msg = "Error 006 : " + e.getClass().getName() + ": " + e.getMessage();
			dberror_msg += "Error 006 :\nN�o foi possivel deletar as informa��es no banco\n";
			return 0;
		}		
	}
	
	public ResultSet selectInformation(String select,String tabela,String where){
		try{
			Statement stm;
			stm = connection.createStatement();
			
			return stm.executeQuery("Select "+select+" From "+tabela+" WHERE "+where+";");
		}catch(Exception e){
			dberror = true;
			exception_msg = "Error 007 : " + e.getClass().getName() + ": " + e.getMessage();
			dberror_msg += "Error 007 :\nN�o foi possivel recuperar as informa��es no banco\n";
			return null;
		}		
	}
	
	public ResultSet selectAll(String tabela){
		try{
			Statement stm;
			stm = connection.createStatement();
			
			return stm.executeQuery("Select * From "+tabela+";");
		}catch(Exception e){
			dberror = true;
			exception_msg = "Error 008 : " + e.getClass().getName() + ": " + e.getMessage();
			dberror_msg += "Error 008 :\nN�o foi possivel recuperar as informa��es no banco\n";
			return null;
		}
	}
	
	public Object sqlQuery(String sql){
		
		try{
			Statement stm;
			stm = connection.createStatement();
			
			if(sql.charAt(0)=='U'||sql.charAt(0)=='I'||sql.charAt(0)=='D')
				return stm.executeUpdate(sql);
			else
				return stm.executeQuery(sql);
		}catch(Exception e){
			dberror = true;
			exception_msg = "Error 009 : " + e.getClass().getName() + ": " + e.getMessage();
			dberror_msg += "Error 009 :\nN�o foi possivel realizar o comando:\n"+sql+"\n";
			return null;
		}
	
	}
	
}
