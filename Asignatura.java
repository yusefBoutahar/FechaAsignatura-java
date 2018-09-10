package fechaAsignatura;
import fechaAsignatura.Fecha;

/**
 * 
 * @author boutahar
 *
 */
public class Asignatura implements Cloneable, Comparable<Object>{
	
	String nombre;
	int convocatoria, cod;
	float nota;
	Fecha fechaConvocatoria;
	
	public Asignatura(String n,int c){
		cod = c;
		nombre = n;
		convocatoria = 0;
	}
	public void ponerNota(float nota, Fecha fecha)throws Exception{
		if(nota<0 ||nota > 10){
			throw new Exception ("Error en la nota");
		}
		if(convocatoria == 6 || this.nota >= 5){
		   throw new Exception ("Error en la convocatoria");
		}
		this.nota = nota;
		convocatoria++;
		fechaConvocatoria = fecha;
	}
	public boolean superada(){
		if(nota >= 5) return true;
		return false;  
	}
	public float dameNota()throws Exception{
		if(convocatoria == 0){
			throw new Exception("No evaluada");
		}
		return nota;
	}
	public int dameConvocatoria(){
		return convocatoria;
	}
	
	public int damecodigo(){
		return cod;
	}
	public Fecha fechaUltimaConvocatoria()throws Exception{
		if(convocatoria == 0){
			throw new Exception("No evaluada");
		}
		return fechaConvocatoria;
	}
	
	@Override
	public String toString(){
		String res = "";
		res += "Nombre: " + nombre+"\n" + "Codigo: "+cod+"\n"+"Convocatoria: "+convocatoria+"\n";
		if(convocatoria > 0){
			res+= "Nota: " + nota + "\n" + "Fecha Ultima convocatoria: "+ fechaConvocatoria;
		}
		return res;
	}
	
	@Override
	public Object clone(){
		Asignatura asig = null;
		try{
			asig =(Asignatura)super.clone();
		}catch(CloneNotSupportedException ex){
			System.out.println("No se puede duplicar");
		}
		return asig;
	}
	
	@Override
	public int compareTo(Object asig){
		
		//return this.cod.compareTo((Asignatura)asig).cod);
		// no se puede usar .compareTo para objetos primitivos como int
		
		if(cod < ((Asignatura)asig).cod)return -1;
		if(cod > ((Asignatura)asig).cod)return 1;
		return 0;
		
	}
	
	@Override
	public boolean equals(Object obj){
		
		//return this.cod.equals(((Asignatura)obj).cod);
		// no se puede usar .equals para objetos primitivos como int
		
		if(((Asignatura) obj).cod == cod)return true;
		return false;
	}
	
	
	
	
	
	
}