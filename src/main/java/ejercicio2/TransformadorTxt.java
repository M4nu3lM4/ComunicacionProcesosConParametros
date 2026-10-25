package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransformadorTxt {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea.toUpperCase());
                System.out.flush();
            }
        } catch (IOException ioe) {
            System.err.println("Error de lectura:" + ioe);
        }
    }
}
