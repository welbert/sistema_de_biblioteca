package graduacao.ufba.eng_software1.data;

/**
 * 
 * Esta classe tem o próposito de fazer as conversões de dia, mes, ano, para milisegundos e, armazenar
 * essas informações numa variável estática, de modo que as conversões só precisem ser realizadas uma única
 * vez, a medida que forem necessárias, podendo ser extendida no futuro.
 * @author Heron Sanches
 */
public abstract class Data {
	private static long dia = 0;
	
	
	private Data(){
		
	}
	
	
	public static long valorDiaEmMilisegundos(){
		if(dia == 0){
			dia = 24*60*60*1000;
		}
			
		return dia;
	}

}
