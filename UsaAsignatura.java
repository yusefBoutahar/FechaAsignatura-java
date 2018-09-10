package fechaAsignatura;

public class UsaAsignatura {
	public static void main(String []args){
		
		try{
			
			// -------- oye ------------------------------ PRUEBA FECHA  ------------------------------------------------------------------
			
			System.out.println("------------------Prueba Fecha.----------------------");
			Fecha f = new Fecha(27,2,2012);
			System.out.println("f : "+f);// esta implicito el toString(), f = f.toString()
			Fecha f1 = new Fecha(20,9,2013);
			System.out.println("f1 : "+f1);
			Fecha f2 = new Fecha(25,2,2014);
			System.out.println("f2 : "+f2+"\n");
			
			Fecha f3 = (Fecha) f.clone();
			System.out.println("f = f3 : " + f.equals(f3));
			f3.anadeDias(10);
			System.out.println("f3 + 10 dias : " + f3);
			System.out.println("Compara f3 y f : "+ f3.compareTo(f));// devuelve 1 ya que f3 es posterior a f
			System.out.println("Compara f y f3 : "+ f.compareTo(f3));
			System.out.println("Diferencia f3 y f1 : "+ f3.diferencia(f)+"\n");// diferencia entre una fechas mayor con una menor
			f3 = (Fecha) f1.clone();
			System.out.println("f1 = f3 : " + f1.equals(f3));
			f3.anadeDias(30);
			System.out.println("f3 + 30 dias : " + f3);
			System.out.println("Compara f3 y f : "+ f3.compareTo(f1));
			System.out.println("Compara f y f3 : "+ f1.compareTo(f3));
			System.out.println("Diferencia f3 y f1 : "+ f3.diferencia(f1)+"\n");
			f3 = (Fecha) f2.clone();
			System.out.println("f2 = f3 : " + f2.equals(f3));
			f3.anadeDias(1);
			System.out.println("f3 + 1 dias : " + f3);
			System.out.println("Compara f3 y f : "+ f3.compareTo(f2));
			System.out.println("Compara f y f3 : "+ f2.compareTo(f3));
			System.out.println("Diferencia f3 y f1 : "+ f3.diferencia(f2)+"\n");
			
			// -------------------------------------- PRUEBA ASIGNATURA  ------------------------------------------------------------------
			
			System.out.println("-----------------PRUEBA ASIGNATURA.---------------------");
			Asignatura a = new Asignatura("Pr1",1040);
			System.out.println(a);
			Asignatura a1 = new Asignatura("Pr2",1050);
			System.out.println(a1);
			Asignatura a2 = new Asignatura("Pr3",1060);
			System.out.println(a2);
			a.ponerNota(3, f);
			System.out.println("Codigo Pr1 : "+ a.damecodigo());
			System.out.println("Pr1 superada : "+a.superada());
			System.out.println("Pr1 nota : "+a.dameNota());
			System.out.println("Num convocatorias Pr1 : "+a.dameConvocatoria());
			System.out.println("ultima convocatoria : "+a.fechaUltimaConvocatoria()+"\n");
			a1.ponerNota(5, f1);
			System.out.println("Codigo Pr2 : "+ a1.damecodigo());
			System.out.println("Pr1 superada : "+a1.superada());
			System.out.println("Pr1 nota : "+a1.dameNota());
			System.out.println("Num convocatorias Pr1 : "+a1.dameConvocatoria());
			System.out.println("ultima convocatoria : "+a1.fechaUltimaConvocatoria()+"\n");
			a.ponerNota(7, f1);
			System.out.println("Codigo Pr1 : "+ a.damecodigo());
			System.out.println("Pr1 superada : "+a.superada());
			System.out.println("Pr1 nota : "+a.dameNota());
			System.out.println("Num convocatorias Pr1 : "+a.dameConvocatoria());
			System.out.println("Ãšltma convocatoria : "+a.fechaUltimaConvocatoria()+"\n");
			a2.ponerNota(10, f2);
			System.out.println("Codigo Pr3 : "+ a2.damecodigo());
			System.out.println("Pr1 superada : "+a2.superada());
			System.out.println("Pr1 nota : "+a2.dameNota());
			System.out.println("Num convocatorias Pr1 : "+a2.dameConvocatoria());
			System.out.println("ultima convocatoria : "+a2.fechaUltimaConvocatoria()+"\n");
			System.out.println(a+"\n");
			System.out.println(a1+"\n");
			System.out.println(a2+"\n");
			Asignatura a3 = (Asignatura) a.clone();
			System.out.println("a3 = a : "+a3.equals(a));
			System.out.println("Compara a3 y a : "+a3.compareTo(a)+"\n");
			a3 = (Asignatura) a1.clone();
			System.out.println("a3 = a1 : "+a3.equals(a1));
			System.out.println("Compara a3 y a1 : "+a3.compareTo(a1)+"\n");
			a3 = (Asignatura) a2.clone();
			System.out.println("a3 = a2 : "+a3.equals(a2));
			System.out.println("Compara a3 y a2 : "+a3.compareTo(a2)+"\n");
			 
		}catch(Exception e){
			System.out.println(e.getMessage());
			/**
			 * *getMessage
				public String getMessage​()
				Returns the detail message string of this throwable.
				*Returns:
				the detail message string of this Throwable instance (which may be null).
			 */
		}
	}
}