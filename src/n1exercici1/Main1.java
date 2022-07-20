package n1exercici1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main1 {

	public static void main(String[] args) {

		String ruta = "";

		if (args.length > 1) { // si hay más de 1 parámetro
			System.out.println("Hay demasiados parámetros. Debe escribir: saludo nombrePersona");
		} else if (args.length == 0) { // si no hay parámetros
			System.out.println("Falta el nombre de la persona");
		} else {
			ruta = args[0];
		}

		JavaUtil.leerArchivo(ruta);

		JavaUtil.ordenar();

	}

	public class JavaUtil {

		private static ArrayList<String> nombres = new ArrayList<>();

		public static void leerArchivo(String ruta) {
			String cadena;

			try {
				FileReader fr = new FileReader(ruta);
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
			System.out.println(nombres);
		}

	}

}
