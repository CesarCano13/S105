package n1exercici3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Main3 {

	public static void main(String[] args) {
		/*String ruta = "";

		if (args.length > 1) {
			System.out.println("Hay demasiados parámetros, solo debe pasar 1");
		} else if (args.length == 0) {
			System.out.println("Falta introducir el parámetro");
		} else {
			ruta = args[0];
			
			//JavaUtil.leerArchivo(ruta);
			// JavaUtil.ordenar();
			// JavaUtil.listarDirectorios();
		}*/

		JavaUtil.escribirFichero();

	}

	public class JavaUtil {
		private static ArrayList<String> nombres = new ArrayList<>();
		private static String datos = "";

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
			// Para mostrar por pantalla
			for (int i = 0; i < nombres.size(); i++) {
				System.out.println(nombres.get(i));
			}
		}

		public static void listarDirectorios() {
			String sCarpAct = System.getProperty("user.dir");
			File carpeta = new File(sCarpAct);
			File[] archivos = carpeta.listFiles();
			if (archivos == null || archivos.length == 0) {
				datos = "No hay elementos dentro de la carpeta actual";
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				for (int i = 0; i < archivos.length; i++) {
					File archivo = archivos[i];
					datos = (String.format("%s (%s) - %s", archivo.getName(),
							archivo.isDirectory() ? "Carpeta" : "Archivo", sdf.format(archivo.lastModified())));
					System.out.println(datos);
				}
			}
		}

		public static void escribirFichero() {
			String directorio = "src\\n1exercici3\\datos.txt";
			String sCarpAct = System.getProperty("user.dir");
			File carpeta = new File(sCarpAct);
			File[] archivos = carpeta.listFiles();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			try {
				BufferedWriter escritura = new BufferedWriter(new FileWriter(directorio));
				for (int i = 0; i < archivos.length; i++) {
					File archivo = archivos[i];
					datos = (String.format("%s (%s) - %s", archivo.getName(),
							archivo.isDirectory() ? "Carpeta" : "Archivo", sdf.format(archivo.lastModified())));
					escritura.write("\n" + datos);
				}

				// Cerramos elflujo de datos
				escritura.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Se ha creado correctamente el archivo txt");
		}

	}

}
