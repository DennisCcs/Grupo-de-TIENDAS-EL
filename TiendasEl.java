import java.util.Scanner;

public class Tiendas_el {
    public static void main(String[] args) {
        int opcion;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a TIENDAS EL");
        System.out.println("COMPRA HASTA 3 CUOTAS SIN INTERESES CON BBVA Y DINERS* exclusivo online");
        System.out.println("DELIVERY GRATIS A LIMA METROPOLITANA POR COMPRAS SUPERIORES A S/299.9");
        System.out.println("Compras por Whatsapp +51 989 174 974");
        while (true) {
            System.out.println("==== SELECCIONE SU CATEGORIA ====");
            System.out.println("1: FORMAL");
            System.out.println("2: CASUAL");
            System.out.println("3: ROPA INTERIOR");
            System.out.println("4: ACCESORIOS");
            System.out.println("5: SALIR");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    casual(sc);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("===ACCESORIOS===");
                    System.out.println("1: MOCHILA EDWARD 3MCHD047 NEGRO (DONATELLI) S/ 99.90");
                    System.out.println("2: CORBATA MICHI (DONATELLI) S/ 29.99");
                    System.out.println("3: CORBATERO PLATA (DONATELLI) S/ 14.90");
                    System.out.println("4: TIRANTE LIAM NEGRO (JOHN HOLDEN) S/ 79.90");
                    System.out.println("5: CORREA 3BPF0024 MARRON/NEGRO (DONATELLI) S/ 44.90");
                    System.out.println("6: CORREA 3BPD0012 REVERSIBLE NEGRO/MARRÓN (DONATELLI) S/ 59.90");
                    System.out.println("7: RELOJ METAL 3WDCM704 SILVER (DONATELLI) S/ 75.90");
                    System.out.println("8: RELOJ PU VALERIO NEGRO (JOHN HOLDEN) S/ 99.90");
                    System.out.println("9: RELOJ PU OSCAR MARRON OSCURO (JOHN HOLDEN) S/ 99.90");
                    System.out.println("10: RELOJ METAL DUSTIN SILVER (JOHN HOLDEN) S/ 99.90");
                    System.out.println("====================================================================================");

                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }

    }
    public static double casual(Scanner sc) {

        int opcion;
        double precio = 0;

        System.out.println("=== CASUAL ===");
        System.out.println("1: CAMISA ML DRILL IGOR VERDE S/79.90");
        System.out.println("2: CAMISA RAUL AZUL S/139.90");

        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                precio = 79.90;
                break;
            case 3:
                precio = 139.90;
                break;
            default:
                System.out.println("Opción inválida");
        }

        return precio;
    }

}
