import java.util.Scanner;

public class TIENDAS_EL {
    public static void main(String[] args) {
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
            double precio = 0;
            switch (opcion) {
                case 2:
                    precio = casual(sc);
                    break;
                case 1:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Gracias por su compra");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
            System.out.print("Ingrese cantidad: ");
            int cantidad = sc.nextInt();
            double subtotal = comprar(precio, cantidad);
            String pago = tipoPago(sc);
            System.out.println("Sub total: S/" + subtotal);
            System.out.print("Ingrese monto a pagar: ");
            double monto = sc.nextDouble();
            double vuelto = monto - subtotal;
            if (monto>=subtotal){
                System.out.println("------BOLETA------");
                System.out.println("Precio: S/" + precio);
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Subtotal: S/" + subtotal);
                System.out.println("Pago: " + pago);
                System.out.println("Monto recibido: S/" + monto);
                System.out.println("Vuelto: S/" + vuelto);
                System.out.println("------------------");
            }
            else {
                System.out.println("Compra cancelada");
            }
        }
    }
    public static double casual(Scanner sc) {
        int opcion;
        double precio = 0;
        System.out.println("=== CASUAL ===");
        System.out.println("1: CAMISA ML DRILL IGOR VERDE S/79.90");
        System.out.println("2: CAMISA RAUL CON TEJIDO ELÁSTICO BLANCO S/139.90");
        System.out.println("3: CAMISA MC GABO ROSADO DONATELLI S/ 80.90");
        System.out.println("4: CAMIISA ML SFILATA CELESTE DONATELLI S/ 109.90");
        System.out.println("5: SACO PAOLO CORDUROY AZUL MARINO DONATELLI S/ 249.90");
        System.out.println("6: SACO RENATO II AZUL JOHN S/ 399.90");
        System.out.println("7: POLO DUCATI 100% ALGODON VINO DONATELLI S/ 49.90");
        System.out.println("8: PANTALÓN ADRIANO NEGRO DONATELLI S/ 89.90");
        System.out.println("9: PANTALÓN JEAN DEREK CELESTE DONATELLI S/ 39.90");
        System.out.println("10: SHORT FIOR III VERDE DONATELLI S/ 59.90");
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                precio = 79.90;
                break;
            case 2:
                precio = 139.90;
                break;
            case 3:
                precio = 80.90;
                break;
            case 4:
                precio = 109.90;
                break;
            case 5:
                precio = 249.90;
                break;
            case 6:
                precio = 399.90;
                break;
            case 7:
                precio = 49.90;
                break;
            case 8:
                precio = 89.90;
                break;
            case 9:
                precio = 39.90;
                break;
            case 10:
                precio = 59.90;
                break;
            default:
                System.out.println("Opcion invalida");
        }
        return precio;
    }
    public static void formal(Scanner sc) {
        System.out.println("=== FORMAL ===");
    }
    public static void ropaInterior(Scanner sc) {
        System.out.println("=== ROPA INTERIOR ===");
    }
    public static void accesorios(Scanner sc) {
        System.out.println("=== ACCESORIOS ===");
    }
    public static double comprar(double precio, int cantidad) {
        double sub_total;
        sub_total = precio * cantidad;
        return sub_total;
    }
    public static String tipoPago(Scanner sc) {
        int opcion;
        System.out.println("Metodo de pago:");
        System.out.println("1: Efectivo");
        System.out.println("2: Tarjeta");
        opcion = sc.nextInt();
        if (opcion == 1) {
            return "Efectivo";
        } else if (opcion == 2) {
            return "Tarjeta";
        } else {
            return "Desconocido";
        }
    }
}
