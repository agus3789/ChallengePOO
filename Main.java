package verificarPassword;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		
		Scanner leer = new Scanner(System.in);
		Password c = new Password(10); /// Constructor para generar una contraseña random con una longitud especifica
		System.out.println("Ingrese una contraseña: ");
		String contra = leer.nextLine();
		Password contra1 = new Password(contra);
		
	
		
		
		
	}

}
