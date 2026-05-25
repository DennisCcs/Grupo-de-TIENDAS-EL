import java.util.Scanner;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class TIENDAS_EL_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion=0;
        menupricipal(sc);
        seleccionmetodoP(sc,opcion);
    }
    public  static void menupricipal(Scanner sc){
        boolean acceso;
        int opciones;
        String correoGuardado = "";
        String contraGuardado = "";

        while (true){
            System.out.println("Bienvenido a TIEDAS El");
            System.out.println("Iniciar session");
            System.out.println("Registrarse");
            System.out.println("continuar como invitado");
            System.out.println("Salir");
            opciones = sc.nextInt();
            switch (opciones){
                case 1:
                    acceso = iniciarSeccion(sc,correoGuardado,contraGuardado);
                    if (acceso){
                        System.out.println("Binevenido a categoterias");
                        categorias(sc);
                    }
                    break;
                case 2:
                    correoGuardado = registrarCorreo(sc);
                    contraGuardado = registroContrasenia(sc);
                    break;
                case 3:
                    System.out.println("Modo invitado");
                    categorias(sc);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion invalida");

            }
        }

    }
    public static boolean iniciarSeccion(Scanner sc,String miCorreo,String miContra){
        String correo,contra;
        sc.nextLine();
        System.out.println("Ingrese su correo");
        correo = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        contra = sc.nextLine();
        if (contra.equals(miContra) && correo.equals(miCorreo)) {
            System.out.println("Inicio de seccion extitosa");
            return true;
        }
        else {
            System.out.println("El correo o la contraseña son incorrectos");
            return false;
        }

    }

    public static String registrarCorreo(Scanner sc){
        String cooreo;
        boolean registroExitoso = false;
        do {
            sc.nextLine();
            System.out.println("Ingrese su correo");
            cooreo = sc.nextLine();
            boolean estructuraCorreo = cooreo.contains("@") && cooreo.endsWith(".com");
            if (!estructuraCorreo){
                System.out.println("El correo debe contener @ y terminar en . com");
            } else if (estructuraCorreo) {
                registroExitoso = true;
            }
        }while (!registroExitoso);
        return cooreo;
    }
    public static String registroContrasenia(Scanner sc){
        String contra;
        boolean registroExitoso = false;
        do {
            System.out.println("Ingrese su contraseña");
            contra = sc.nextLine();
            boolean estructuraContra = contra.length()>=8 && (contra.contains("@") || contra.contains("#"));
            if (!estructuraContra){
                System.out.println("La contraseña debe tener minimo 8 caracteres y uno de estos caracteres especiales: # @)");
            } else if (estructuraContra) {
                registroExitoso = true;
            }
        }
        while (!registroExitoso);
        return contra;
    }
    public static void categorias(Scanner sc){
        String NombreMetodoP;
        String producto ;
        double precio ;
        String talla;
        System.out.println("---- CATEGORIAS ----");
        System.out.println("1.- Formal");
        System.out.println("2.- Casual");
        System.out.println("3.- Ropa interior");
        System.out.println("4.- Accesorio");
        System.out.println("5.- Salir");
        int opocion = sc.nextInt();
        switch (opocion){
            case 1:
                break;
            case 2:
                int opcionPreoducto = casual(sc);
                producto = producoCasual(opcionPreoducto);
                precio= precioCasual(sc,opcionPreoducto);
                if (precio == 0){
                    return;
                }
                System.out.println("precio "+precio);
                System.out.println("producto "+producto);
                talla = talla(sc);
                double subTotal = subTotal(sc,precio);

                System.out.println("total a pagar es: "+subTotal);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.out.println("gracias por su visita");
                menupricipal(sc);
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }
    public static int casual(Scanner sc){
        int opcion;
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
        System.out.println("11: Salir");
        opcion = sc.nextInt();
        return opcion;
    }
    public static double precioCasual (Scanner sc,int opcion){
        double precio = 0;
        switch (opcion){
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
            case 11:
                categorias(sc);
                return 0;
            default:
                System.out.println("Opcion invalida");
                break;
        }
        return precio;
    }
    public static String producoCasual(int opcion){
        String producto = "";
        switch (opcion){
            case 1:
                producto = "CAMISA ML DRILL IGOR VERDE";
                break;
            case 2:
                producto ="CAMISA RAUL CON TEJIDO ELÁSTICO BLANCO";

                break;
            case 3:
                producto ="CAMISA MC GABO ROSADO DONATELLI";

                break;
            case 4:
                producto ="CAMIISA ML SFILATA CELESTE DONATELLI";

                break;
            case 5:
                producto ="SACO PAOLO CORDUROY AZUL MARINO DONATELLI";

                break;
            case 6:
                producto ="SACO RENATO II AZUL JOHN";

                break;
            case 7:
                producto ="POLO DUCATI 100% ALGODON VINO DONATELLI";

                break;
            case 8:
                producto ="PANTALÓN ADRIANO NEGRO DONATELLI";

                break;
            case 9:
                producto ="PANTALÓN JEAN DEREK CELESTE DONATELLI";

                break;
            case 10:
                producto ="SHORT FIOR III VERDE DONATELLI";

                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }
        return producto;
    }
    public static double subTotal(Scanner sc,double precio){
        System.out.println("Ingrese la cantidad");
        int cantidad = sc.nextInt();

        return cantidad * precio;
    }
    public static String talla(Scanner sc){
        String talla = "";
        System.out.println("sellecione su talla");
        System.out.println("1.- S");
        System.out.println("2.- M");
        System.out.println("3.- L");
        int opcion = sc.nextInt();
        switch (opcion){
            case 1:
                talla = "S";
                break;
            case 2:
                talla = "M";
                break;
            case 3:
                talla = "L";
                break;
            default:
                System.out.println("opcion invalida");
        }
        return talla;
    }
    public static int seleccionmetodoP(Scanner sc,int opcion){
        System.out.println("selccione el metodo de pago");
        System.out.println("1: efectivo");
        System.out.println("2: tarjeta");
        opcion = sc.nextInt();
        switch (opcion){
            case 1:
                break;
            case 2:
                break;
            default:
                System.out.println("Opcion invalida");
        }
        return opcion;
    }
    public static String nombreMetodoPago(int opcion){
        String metodoPago = "";
        switch (opcion){
            case 1:
                metodoPago = "efectivo";
                return metodoPago;
            case 2:
                metodoPago = "tarjeta";
                return metodoPago;
        }
        return metodoPago;
    }
    public static void pagoTARJETA(Scanner sc,double total){
        String nomTARJETA,fecVENCIMIENTO,cvv,numTARJETA;
        boolean paAPROBADO;
        System.out.println("el monto a pagar es de: "+total);
        do{
            System.out.println("INGRESAR EL NOMBRE SE DU TARJETA (Visa, Mastercard, American Express, Diners Club)");
            System.out.println("¡INGRESAR NOMBRE COMPLETO!");
            nomTARJETA= sc.nextLine();
            System.out.println("INGRESAR LOS 16 DIGITOS DE SU TARJETA");
            numTARJETA= sc.nextLine();
            System.out.println("INGRESAR FECHA DE VENCIMIENTO (MM/AA)");
            fecVENCIMIENTO= sc.nextLine();
            System.out.println("INGRESAR CVV");
            cvv = sc.nextLine();
            boolean tarjetaOK=(numTARJETA.length()==16);
            boolean cvvOK=(cvv.length()==3);
            boolean fechaESTRUCTURAok=(fecVENCIMIENTO.length()==5&&fecVENCIMIENTO.contains("/"));
            boolean fechaNOvencida=false;
            if (nomTARJETA.equalsIgnoreCase("visa")||nomTARJETA.equalsIgnoreCase("mastercard")||nomTARJETA.equalsIgnoreCase("american express")||nomTARJETA.equalsIgnoreCase("diners club")){
                if (fechaESTRUCTURAok){

                }
            }else{
                System.out.println("EL NOMBRE ES INCORRECTO O ESA TARJETA NO ES VALIDA");
            }
        }while ()
    }
    public static void pagoEfectivo(Scanner sc,double total,String producto,String talla){
        double vuelto,igv,subTotal;
        System.out.println("el monto a pagar es de: "+total);
        System.out.println("Ingrese el total a pagar");
        double monto = sc.nextDouble();
        if (monto>=total){
            vuelto = monto - total;
            igv = 0.18 * total;
            subTotal = total

        }
    }
}

