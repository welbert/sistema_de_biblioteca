package graduacao.ufba.eng_software1.utils;

public class Config {
	public static final String VERSION = "1.0.0";
	public static final String URL_REPOSITORY = "https://github.com/welbert/sistema_de_biblioteca/";
	public static final boolean LOG = true;
	public static boolean WINDOWS = System.getProperty("os.name").contains("Windows");
	
	
	//----- BANCO DE DADOS
	public static final String BDUSER = "root";
	public static final String BDPASSWORD = "usbw";
	public static final String BDURL = "localhost";
	public static final String BDPORT = "3307";
	public static final String BDDATABASE = "mydb";
}
