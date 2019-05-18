import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
        /* Leer archivo */
		GraphMatrix<String,String> G = new GraphMatrixDirected<String,String>(10);
		G.addEdge("ciudad", "ciudad2", "km");
    	System.out.println("Ingrese el nombre del archivo del grafo.");
		Scanner input = new Scanner(System.in);
		File file = new File(input.nextLine());
		try {
			Scanner scanner = new Scanner(file);
	        if(scanner.hasNextLine()) {
	        	
	        }
	        else {
	        	System.out.println("El archivo esta vacio.");
	        	scanner.close();
	        	input.close();
	        }
		}
		catch (Exception e){
			System.out.println("Error: " + e.toString());
		}
	}
}