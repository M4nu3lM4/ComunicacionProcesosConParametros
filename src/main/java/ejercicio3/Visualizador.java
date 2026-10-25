package ejercicio3;

public class Visualizador {
    public static void main(String[] args) {

        if (args.length < 1 || args[0].isBlank()){
            System.out.println("Cadena vacía");
            System.exit(1);
        }

        int numeroVeces = 0;
        try {
            numeroVeces = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Número de veces no válido");
            System.exit(1);
        }

        for (int i = 1; i <= numeroVeces; i++) {
            System.out.println(i + ". " + args[0]);
        }
    }
}
