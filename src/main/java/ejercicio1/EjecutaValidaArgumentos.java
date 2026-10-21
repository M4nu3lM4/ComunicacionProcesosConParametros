package ejercicio1;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjecutaValidaArgumentos {
    public static void main(String[] args) {
        System.out.println("Introduce un numero o cadena(dejar vacio no envia nada): ");
        String argumento = Entrada.cadena();

        List<String> comandoArgumentos = new ArrayList<>();
        comandoArgumentos.add("java");
        comandoArgumentos.add("-cp");
        comandoArgumentos.add(System.getProperty("java.class.path"));
        comandoArgumentos.add("ejercicio1.ValidaArgumentos");
        if (!argumento.isEmpty()) {
            comandoArgumentos.add(argumento);
        }
        try {
            Process procesoArgumentos = new ProcessBuilder(comandoArgumentos).start();
            int valorSalida = procesoArgumentos.waitFor();

            System.out.println("Valor de salida: "+valorSalida);
            switch (valorSalida){
                case 1 -> System.out.println("No hay argumentos");
                case 2 -> System.out.println("Es una cadena");
                case 3 -> System.out.println("El numero es negativo");
                case 4 -> System.out.println("Numero mayor o igual que 0");
                default -> System.out.println("Valor de salida no esperado");
            }

        } catch (IOException | InterruptedException ioe) {
            System.out.println("ERROR: al lanzar el proceso." + ioe.getMessage());
        }
    }
}
