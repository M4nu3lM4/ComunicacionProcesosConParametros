package ejercicio3;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaVisualizador {
    private static final int NUMERO_VECES = 5;

    public static void main(String[] args) {
        System.out.print("Introduce una cadena: ");
        String cadena = Entrada.cadena();

        try {
            Process hijo = new ProcessBuilder("java", "-cp",
                    System.getProperty("java.class.path"), "ejercicio3.Visualizador",
                    cadena, String.valueOf(NUMERO_VECES)).start();

            // Se lee todo lo que el hijo escribe en su salida estándar
            BufferedReader salidaHijo = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
            String linea;
            while ((linea = salidaHijo.readLine()) != null) {
                System.out.println(linea);
            }
            salidaHijo.close();

            int valorSalida = hijo.waitFor();
            System.out.println("Valor de salida: " + valorSalida);
            if (valorSalida == 0) {
                System.out.println("Final Correcto");
            } else {
                System.out.println("Final Incorrecto");
            }
        } catch (IOException e) {
            System.err.println("Error al lanzar el proceso: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Se ha interrumpido la espera del proceso hijo.");
            Thread.currentThread().interrupt();
        }
    }
}
