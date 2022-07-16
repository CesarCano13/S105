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

public class JavaUtil {
	private static ArrayList<String> nombres = new ArrayList<>();
	private static String datos = "";

	public static ArrayList<String> getNombres() {
		return nombres;
	}

	public static void setNombres(ArrayList<String> nombres) {
		JavaUtil.nombres = nombres;
	}

	public static String getDatos() {
		return datos;
	}

	public static void setDatos(String datos) {
		JavaUtil.datos = datos;
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
				datos = (String.format("%s (%s) - %s", archivo.getName(), archivo.isDirectory() ? "Carpeta" : "Archivo",
						sdf.format(archivo.lastModified())));
				System.out.println(datos);
			}
		}
	}

	public static void escribirFichero() {
		String sCarpAct = System.getProperty("user.dir");
		File carpeta = new File(sCarpAct);
		File[] archivos = carpeta.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		try {
			BufferedWriter escritura = new BufferedWriter(
					new FileWriter("C:\\Users\\cesar\\Documents\\Itinerario\\S105\\src\\n1exercici3\\datos.txt"));

			for (int i = 0; i < archivos.length; i++) {
				File archivo = archivos[i];
				datos = (String.format("%s (%s) - %s", archivo.getName(), archivo.isDirectory() ? "Carpeta" : "Archivo",
						sdf.format(archivo.lastModified())));
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
