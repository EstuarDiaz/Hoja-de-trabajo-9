import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
        /* Leer archivo */
		System.out.println("Ingrese el nombre del archivo del grafo.");
//		Scanner input = new Scanner(System.in);
//		File file = new File(input.nextLine());
		File file = new File("C:\\Users\\lisbe\\Documents\\Estuar\\Algoitmos y estructura de datos\\HDT9\\Hoja-de-trabajo-9\\guategrafo.txt");
		try {
			Scanner scanner = new Scanner(file);
	        if(scanner.hasNextLine()) {
	        	LinkedList<String> listadoCiudades = new LinkedList<String>();
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					if(!line.trim().isEmpty()) {
						String[] ciudades = line.split(" ");
						if(!listadoCiudades.contains(ciudades[0])) {
							listadoCiudades.add(ciudades[0]);
						}
						if(!listadoCiudades.contains(ciudades[1])) {
							listadoCiudades.add(ciudades[1]);
						}
					}
				}
				GraphMatrix<String,Float> G = new GraphMatrixDirected<String,Float>(listadoCiudades.size());
				scanner.close();
				scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine(); 
					if(!line.trim().isEmpty()) {
						String[] ciudades = line.split(" ");
						G.addEdge(ciudades[0].trim(),ciudades[1].trim(), Float.parseFloat(ciudades[2].trim()));
					}
				}
				G.printMatrix();
				G.printMinimumMatrix();
				G.printShortestPath(3, 2);
				System.out.println("Centro: "+G.getCenter());
	        }
	        else {
	        	System.out.println("El archivo esta vacio.");
	        	scanner.close();
//	        	input.close();
	        }
		}
		catch (Exception e){
			System.out.println("Error: " + e.toString());
		}
	}
}