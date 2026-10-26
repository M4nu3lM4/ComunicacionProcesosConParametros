package ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Aleatorios {
    public static void main(String[] args) {
        Random generador = new Random();

        try (BufferedReader lector = new BufferedReader(new InputStreamReader(System.in))) {
            while (lector.readLine() != null) {
                System.out.println(generador.nextInt(11));
                System.out.flush();
            }
        } catch (IOException e) {
            System.err.println("Error de lectura: " + e.getMessage());
        }
    }
}
