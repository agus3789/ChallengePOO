package verificarPassword;

import java.util.Random;

public class Password 
{
	private int longitud = 8;		// Variables de clase
	private String contra = "";
	
	

	
	

	public Password(String contra) //Constructor por defecto
	{
		super();
		this.contra = contra;
		
		if(esFuerte() == true)
		{
			System.out.println("Es fuerte");
		}
		else
		{
			System.out.println("Es debil");
		}
	}

	public Password(int longitud) //Constructor para generar una contraseña aleatoria con una longitud especifica
	{
		this.longitud = longitud;
		
		contra = generarContraseña();
		System.out.println("La contraseña generada es: " + contra);
		if(esFuerte() == true)
		{
			System.out.println("La contraseña generada es fuerte");
		}
		else 
		{
			System.out.println("La contraseña generada es debil");
		}
	}

	
	public int getLongitud() 
	{ 
		return longitud;
	}
	
	public void setLongitud(int longitud) 
	{
		this.longitud = longitud;
	}
	
	public String getContra() 
	{
		return contra;
	}
	
	public String generarContraseña() /// Funcion para generar una contraseña aleatoria
	{
		String pass = "";
		
		String[] alfa = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		
		String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		 Random aleatorio = new Random();
		 
         for (int i = 0; i < longitud; i++)
         {
             int LetraAleatoria = aleatorio.nextInt(0, 100);  //Elige un numero de 0 a 100 y lo guarda en letre aleatoria
             int NumeroAleatorio = aleatorio.nextInt(0, 9);  // Lo mismo pero de 0 a 9 y lo guarda en numero aleatorio

             if (LetraAleatoria < alfa.length)	//Aca pregunta si el numero guardado en letra aleatoria es menor que la longitud del alfabeto
             {
                 pass += alfa[LetraAleatoria];	//Guarda la letra que esta en la posicion que salio
             }
             else
             {
                 pass += nums[NumeroAleatorio]; // Si no en caso que que el numero que salio es mayor se guarda en la pass un numero del char nums segun el numero que salio
             }
         }
		
		return pass;
	}
	
	 
	public boolean esFuerte() // Funcion para consultar si la contraseña es fuerte o no
	{
		
		int cmayus = 0;
		int cminus = 0;
		int nums = 0;
		
		for(int i=0; i<longitud;i++) // Con este for hago que recorra la palabra segun la longitud que tenga
		{
	        char mayus = contra.charAt(i);
	        char minus = contra.charAt(i);			//Aca lo que hago es guardar en un char el caracter en la posicion de i para despues poder contarlos
	        char numeros = contra.charAt(i);
	        
	        if(Character.isUpperCase(mayus))  //Para despues poder consultar si hay mayusculas, minusculas y numeros
	        {
	            cmayus++;
	        }
	        if(Character.isLowerCase(minus))  // Si es que hay estos se guardan en contadores y si superan lo pedido es verdadero o sino es falso
	        {
	        	cminus++;
	        }
	        if(Character.isDigit(numeros))
	        {
	        	nums++;
	        }
	        if(cmayus >= 2 && cminus >= 1 && nums >= 3)  
	        {
	        	return true;
	        }
		}
		return false;
	}
	
	
	
}
