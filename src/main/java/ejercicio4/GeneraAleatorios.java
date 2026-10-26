package ejercicio4;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GeneraAleatorios {
    public static void main(String[] args) {
        try {
            ProcessBuilder comandoAleatorios = new ProcessBuilder("java", "-cp",System.getProperty("java.class.path"),"ejercicio4.Aleatorios");
            Process hijo = comandoAleatorios.start();


            PrintWriter haciaHijo = new PrintWriter(hijo.getOutputStream(), true);
            BufferedReader desdeHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

            String linea = Entrada.cadena();
            while (!linea.equals("fin")) {
                haciaHijo.println();
                System.out.println(desdeHijo.readLine());
                linea = Entrada.cadena();
            }

            haciaHijo.close();
            desdeHijo.close();
            hijo.destroy();
        } catch (IOException e) {
            System.err.println("Error al comunicarse con el proceso hijo: " + e.getMessage());
        }
    }
}
