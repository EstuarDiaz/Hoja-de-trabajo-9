import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
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
				System.out.println("Centro: "+G.getCenter());
				// Menu
				String respuesta = "";
				while(!respuesta.equals("6")) {
					System.out.println("Menu:");
					System.out.println("1. Calcular ruta mas corta");
					System.out.println("2. Calcular el centro del grafo");
					System.out.println("3. Editar");
					System.out.println("4. Mostrar matriz de adyacencia");
					System.out.println("5. Mostrar matriz de caminos mas cortos");
					System.out.println("6. Salir");
					Scanner input = new Scanner(System.in);
					respuesta = input.nextLine();
					if(respuesta.equals("1")) {
						System.out.println("Ingrese la ciudad de partida");
						Scanner input2 = new Scanner(System.in);
						String partida = input2.nextLine();
						System.out.println("Ingrese la ciudad de llegada");
						Scanner input3 = new Scanner(System.in);
						String llegada = input3.nextLine();
						G.printShortestPath(partida, llegada);
					}
					else if(respuesta.equals("2")){
						System.out.println("Centro: "+G.getCenter());
					}
					else if(respuesta.equals("3")) {
						System.out.println("1. Quitar camino");
						System.out.println("2. Agregar camino");
						Scanner input5 = new Scanner(System.in);
						String tipo = input5.nextLine();
						System.out.println("Ingrese la ciudad de partida");
						Scanner input2 = new Scanner(System.in);
						String partida = input2.nextLine();
						System.out.println("Ingrese la ciudad de llegada");
						Scanner input3 = new Scanner(System.in);
						String llegada = input3.nextLine();
						if(tipo.equals("2")) {
							System.out.println("Ingrese la distancia");
							Scanner input4 = new Scanner(System.in);
							Float distancia = Float.valueOf(input4.nextLine());
							G.addEdge(partida, llegada, distancia);
						}
						else {
							G.removeEdge(partida, llegada);	
						}
					}
					else if(respuesta.equals("4")) {
						G.printMatrix();
					}
					else if(respuesta.equals("5")) {
						G.printMinimumMatrix();
					}
				}
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