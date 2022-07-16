package n1exercici1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class JavaUtil {

	private static ArrayList<String> nombres = new ArrayList<>();

	public static ArrayList<String> getNombres() {
		return nombres;
	}

	public static void setNombres(ArrayList<String> nombres) {
		JavaUtil.nombres = nombres;
	}

	public static void leerArchivo() {
		String cadena;

		try {
			FileReader fr = new FileReader(
					"C:\\Users\\cesar\\Documents\\Itinerario\\S105\\src\\n1exercici1\\nombres.txt");
			BufferedReader br = new BufferedReader(fr);
			while ((cadena = br.readLine()) != null) {
				nombres.add(cadena);
			}
			// Para cerrar el flujo de datos
			br.close();
		} catch (IOException e) {
			System.out.println("No se ha encontrado el archivo");
		}
	}

	// Para ordenar el ArrayList de forma alfabetica
	public static void ordenar() {
		Collections.sort(nombres);
	}

}
