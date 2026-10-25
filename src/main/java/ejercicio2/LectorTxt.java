package ejercicio2;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LectorTxt {
    public static void main(String[] args) {
        try{
        ProcessBuilder comandoCadena = new ProcessBuilder("java", "-cp",System.getProperty("java.class.path"),"ejercicio2.TransformadorTxt");
        Process hijo = comandoCadena.start();


        PrintWriter haciaHijo = new PrintWriter(hijo.getOutputStream(), true);

        BufferedReader desdeHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));

        String linea = Entrada.cadena();
        while (!linea.equals("fin")) {
            haciaHijo.println(linea);
            System.out.println(desdeHijo.readLine());
            linea = Entrada.cadena();
        }


        haciaHijo.close();
        desdeHijo.close();

    } catch (
    IOException e) {
        System.err.println("Error al comunicarse con el proceso hijo: " + e.getMessage());
        }
    }
}
