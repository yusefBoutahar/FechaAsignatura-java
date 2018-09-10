package fechaAsignatura;

import java.util.*;

public class Fecha implements Cloneable, Comparable<Object>{
	
	private GregorianCalendar calen;
	
	public Fecha(int d, int m, int y)throws Exception{
		if(compruebaFecha(d,m,y)){
		    calen = new GregorianCalendar(y,m-1,d);
		}else{
		    throw new Exception("Fecha incorrecta");// si ocurre algun error, tenemos la excepcion controlada
		}
	}
	
	public static boolean compruebaFecha(int d, int m, int y){	// creo que se podria hacer con expresiones regulares 
		if(y > 1000 && y < 10000 && d > 0 && d <= 31){
			switch(m){
			case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :	// casos en los que los meses tienen 31 dias
			    if(d <= 31) return true;
			case 4 : case 6 : case 9 : case 11: // casos en los que los meses tienen 30 dias
			    if(d <= 30) return true;
			case 2 :
			    if((y%4 == 0 && y%100 != 0) || y%400 == 0){ // caso bisiesto
			    	   if(d <= 29) return true; 
			    }else{
			    	   if(d <= 28) return true;
			    }
			default : return false;
			}
		}
		return false;
	}
	
	public void anadeDias (int day)throws Exception{
		if(day > 30 || day < 0){
			throw new Exception("Error en el numero de dias");
		}else{
			calen.add(Calendar.DAY_OF_MONTH,day);
		}
	}
	
	public int diferencia(Fecha f)throws Exception{
		long res = (calen.getTimeInMillis() - f.calen.getTimeInMillis())/(1000*60*60*24);
		// para tener los dias, dividimos los milis entre 1000 y por los segundos de un dia
		if(res < 0 || res > 30){
			throw new Exception("Error en la diferencia de fechas");
		}
		return (int) res;
	}
	
	@Override
	public String toString(){
		String res = "";
		if(calen.get(Calendar.DAY_OF_MONTH)<10) res+="0";
		res+=calen.get(Calendar.DAY_OF_MONTH)+"-";
		
		if((calen.get(Calendar.MONTH)+1)<10) res+="0";
		res+=(calen.get(Calendar.MONTH)+1)+"-";
		
		return res+calen.get(Calendar.YEAR);
	}
	
	@Override
	public Object clone() {
		Fecha f = null;
		try{
			f = (Fecha)super.clone();
			// super.clone();, es el clone de Object. copiamos las direcciones de memoria, SON 2 OBJETOS APUNTANDO AL MISMO BLOQUE DE MEMORIA
			f.calen = (GregorianCalendar)this.calen.clone(); 
			// f.calen.clone(), es el clone de la clase GregorianCalendar (va a su clase y lo copia) y sale un Object, hay q hacer CAST
			
		}catch(CloneNotSupportedException ex){	
		//  Object java.lang.Object.clone() throws CloneNotSupportedException, al usar .clone() de object estamos obligados a 
		//	controlar la excepcion
			System.out.println("No se puede duplicar");
		}
		return f;
	}
	
	@Override
	public int compareTo(Object f){
		return this.calen.compareTo(((Fecha)f).calen);
		// hacemos la comparacion entre el this.calen(fecha actual) y el objeto f(otra fecha) pasada por parametro
	}
	
	@Override
	public boolean equals (Object f){
		return this.calen.equals(((Fecha)f).calen);
		// hacemos la comparaci�n de igualdad entre el this.calen(fecha actual) y el objeto f(otra fecha) pasada por parametro
	}
	
	
}