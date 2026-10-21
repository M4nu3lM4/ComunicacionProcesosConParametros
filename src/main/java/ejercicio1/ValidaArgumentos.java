package ejercicio1;



public class ValidaArgumentos {
    public static void main(String[] args) {

        if (args.length < 1){
            System.exit(1);
            System.out.println("No hay argumentos...");
        }

        try{
            int numero = Integer.parseInt(args[0]);


            if (numero < 0){
                System.exit(3);

            }else {

                System.exit(4);
            }
        } catch (NumberFormatException e) {
            System.exit(2);
            System.out.println("ERROR: No se puede convertir a numero es una cadena");
        }
    }
}
