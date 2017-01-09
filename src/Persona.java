
public class Persona {

	//Variables
	
		int numPersona;
		String nombre, pelo, ojos;
		boolean gafas, bigote, barba, genero, sombrero,piel;
	
	//Constructor vacio
		
		public Persona(){
			
			numPersona=0;
			nombre="";
			pelo="";
			ojos="";
			gafas=false;
			bigote=false;
			barba=false;
			genero=false;
			sombrero=false;
			piel=false;
			
		}
		
	//Constructor por parámetros
		
		public Persona(int numPersona,String nombre, String pelo, String ojos, boolean gafas, boolean bigote, boolean barba, boolean genero, boolean sombrero,boolean piel){
			
			this.numPersona=numPersona;
			this.nombre=nombre;
			this.pelo=pelo;
			this.ojos=ojos;
			this.gafas=gafas;
			this.bigote=bigote;
			this.barba=barba;
			this.genero=genero;
			this.sombrero=sombrero;
			this.piel=piel;
						
		}
		
	//Método para comprobar si hemos acertado
		
		public boolean compruebaPersona(int numSeleccion, int num){
			
			boolean resultado=false;
			
			if(numSeleccion==num){
				
				resultado=true;	
				
			}
			
			System.out.println("El resultado devuelto es: "+resultado);
			
			return resultado;
						
		}
		
}
