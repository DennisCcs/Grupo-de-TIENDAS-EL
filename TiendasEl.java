import java.util.Scanner;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
public class Tiendas_el {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menupricipal(sc);

    }
    public  static void menupricipal(Scanner sc){
        boolean acceso;
        int opciones;
        String correoGuardado = "";
        String contraGuardado = "";

        while (true){
            System.out.println("====Bienvenido a TIEDAS El====");
            System.out.println("1.-Iniciar session");
            System.out.println("2.-Registrarse");
            System.out.println("3.-continuar como invitado");
            System.out.println("4.-Salir");
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
                    if (correoGuardado.equalsIgnoreCase("N")){
                        correoGuardado = "";
                        System.out.println("Registro cancelado");
                        break;
                    }
                    contraGuardado = registroContrasenia(sc);
                    if (contraGuardado.equalsIgnoreCase("N")){
                        correoGuardado = "";
                        contraGuardado = "";
                        System.out.println("Registro cancelado");
                        break;
                    }
                    break;
                case 3:
                    System.out.println("Modo invitado");
                    categorias(sc);
                    break;
                case 4:
                    System.out.println("gracias por su visita");
                    System.exit(0);
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
        if (contra.equals(miContra) && correo.equals(miCorreo) && !contra.equalsIgnoreCase("")) {
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
                System.out.println("desea continuar S / N");
                cooreo = sc.nextLine();
                if (cooreo.equalsIgnoreCase("S")){
                    continue;
                } else if (cooreo.equalsIgnoreCase("N")) {
                    return cooreo;

                }
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
                System.out.println("desea continuar S / N");
                contra = sc.nextLine();
                if (contra.equalsIgnoreCase("S")){
                    continue;
                } else if (contra.equalsIgnoreCase("N")) {
                    return contra;

                }
            } else if (estructuraContra) {
                registroExitoso = true;
            }
        }
        while (!registroExitoso);
        return contra;
    }
    public static void categorias(Scanner sc){
        String producto ="";
        double precio =0;
        String talla="";
        double total=0;
        System.out.println("---- CATEGORIAS ----");
        System.out.println("1.- Formal");
        System.out.println("2.- Casual");
        System.out.println("3.- Ropa interior");
        System.out.println("4.- Accesorio");
        System.out.println("5.- Salir");
        int opocion = sc.nextInt();
        switch (opocion){
            case 1:
                int opcionPruducto = formal(sc);
                producto = productoFormal(opcionPruducto);
                precio = precioFormal(sc,opcionPruducto);
                if (precio == 0){
                    return;
                }
                System.out.println("precio "+precio);
                System.out.println("producto "+producto);
                talla = talla(sc);
                total = subTotal(sc,precio);

                System.out.println("total a pagar es: "+total);
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
                total = subTotal(sc,precio);

                System.out.println("total a pagar es: "+total);
                break;
            case 3:
                int ropaIN = ropaINTERIOR(sc);
                producto = productoROPAinterior(ropaIN);
                precio= precioROPAinterior(sc,ropaIN);
                if (precio == 0){
                    return;
                }
                System.out.println("precio "+precio);
                System.out.println("producto "+producto);
                talla = talla(sc);
                total = subTotal(sc,precio);

                System.out.println("total a pagar es: "+total);
                break;
            case 4:
                int opcionACCESORIO=accesorios(sc);
                producto=productoACCESORIO(opcionACCESORIO);
                precio=precioACCESORIO(sc,opcionACCESORIO);

                if (precio == 0){
                    return;
                }
                System.out.println("precio "+precio);
                System.out.println("producto "+producto);
                talla = talla(sc);
                total = subTotal(sc,precio);

                System.out.println("total a pagar es: "+total);
                break;
            case 5:
                System.out.println("gracias por su visita");
                menupricipal(sc);
                break;
            default:
                System.out.println("Opcion invalida");
        }
        if (total>0) {
            int metodo = seleccionmetodoP(sc);
            String metodoPAGO=nombreMetodoPago(metodo);
            switch (metodo){
                case 1:
                    pagoEfectivo(sc,total,producto,talla,metodoPAGO);
                    break;
                case 2:
                    pagoTARJETA(sc, total,producto,talla,metodoPAGO);
                    break;
                default:
                    System.out.println("METODO INVALIDO");
            }
        }
    }
    public static int formal(Scanner sc) {
        int opcion;
        System.out.println("1.- TERNO DANE II AZUL JOHN HOLDEN S/ 599.90");
        System.out.println("2.- TERNO NERO JOHN HOLDEN S/ 349.00");
        System.out.println("3.- TERNO ALFRED MINIMATE NEGRO DONATELLI S/ 299.90");
        System.out.println("4.- CAMISA ALESSANDRO NEGRO DONATELLI S/ 49.90");
        System.out.println("5.- CAMISA MILEY COMFORT ROSADO JOHN HOLDEN S/ 169.90");
        System.out.println("6.- CAMISA ML VANCOUVER 100% ALGODÓN BLANCO VAN HEUSEN S/ 279.90");
        System.out.println("7.- SACO PAOLO CORDUROY AZUL MARINO DONATELLI S/ 249.90");
        System.out.println("8.- SACO CARTER II AZUL DONATELLI S/ 359.90");
        System.out.println("9.- PANTALON SANTINO AZUL DONATELLI S/ 115.90");
        System.out.println("10.- PANTALON SANTINO GRIS DONATELLI S/ 115.90");
        System.out.println("11.- Salir");
        opcion = sc.nextInt();
        return opcion;
    }
    public static String productoFormal(int opcion) {
        String producto = "";
        switch (opcion) {
            case 1:
                producto = "TERNO DANE II AZUL JOHN HOLDEN";
                break;
            case 2:
                producto = "TERNO NERO JOHN HOLDEN";
                break;
            case 3:
                producto = "TERNO ALFRED MINIMATE NEGRO DONATELLI";
                break;
            case 4:
                producto = "CAMISA ALESSANDRO NEGRO DONATELLI";
                break;
            case 5:
                producto = "CAMISA MILEY COMFORT ROSADO JOHN HOLDEN";
                break;
            case 6:
                producto = "CAMISA ML VANCOUVER 100% ALGODÓN BLANCO VAN HEUSEN";
                break;
            case 7:
                producto = "SACO PAOLO CORDUROY AZUL MARINO DONATELLI";
                break;
            case 8:
                producto = "SACO CARTER II AZUL DONATELLI";
                break;
            case 9:
                producto = "PANTALON SANTINO AZUL DONATELLI";
                break;
            case 10:
                producto = "PANTALON SANTINO GRIS DONATELLI";
                break;
            case 11:
                System.out.println("saliendo...");
                break;
            default:
                System.out.println("Opcion invalida");
        }
        return producto;
    }
    public static double precioFormal(Scanner sc,int opcion){
        double precio = 0;
        switch (opcion){
            case 1:
                precio = 599.90;
                break;
            case 2:
                precio = 349.00;
                break;
            case 3:
                precio = 299.90;
                break;
            case 4:
                precio = 49.90;
                break;
            case 5:
                precio = 169.90;
                break;
            case 6:
                precio = 279.90;
                break;
            case 7:
                precio = 249.90;
                break;
            case 8:
                precio = 359.90;
                break;
            case 9:
                precio = 115.90;
                break;
            case 10:
                precio = 115.90;
                break;
            case 11:
                categorias(sc);
                precio = 0;
                break;
        }
        return precio;
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
                precio = 0;
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
            case 11:
                System.out.println("saliendo...");
                break;

            default:
                System.out.println("Opcion invalida");
                break;
        }
        return producto;
    }
    public static int ropaINTERIOR(Scanner sc){
        System.out.println("=== BOXER ===");
        System.out.println("1: BOXER HUDSON SURTIDO NEGRO JOHN HOLDEN S/ 89.90");
        System.out.println("2: BOXER 3PACK MARTINO MEL/GRIS/NEG JOHN HOLDEN UNDERWEAR S/ 79.90");
        System.out.println("3: BOXER 3PACK MARTINO AZUL MARINO JOHN HOLDEN UNDERWEAR S/ 79.90");
        System.out.println("4: BOXER TRIPACK MASSIMO SURTIDO COLOR DONATELLI S/ 49.90");
        System.out.println("5: BOXER HUDSON SURTIDO AZUL JOHN HOLDEN S/ 89.90");
        int opcion = sc.nextInt();
        return opcion;
    }
    public static double precioROPAinterior(Scanner sc, int opcion){
        double precio=0;
        switch (opcion) {
            case 1:
                precio = 89.90;
                break;
            case 2:
                precio = 79.90;
                break;
            case 3:
                precio = 79.90;
                break;
            case 4:
                precio = 49.90;
                break;
            case 5:
                precio = 89.90;
                break;
            default:
                System.out.println("Opcion invalida");
        }
        return precio;

    }
    public static String productoROPAinterior(int opcion){
        String producto="";
        switch (opcion){
            case 1:
                producto = " BOXER HUDSON SURTIDO NEGRO JOHN HOLDEN";
                break;
            case 2:
                producto ="BOXER 3PACK MARTINO MEL/GRIS/NEG JOHN HOLDEN UNDERWEAR";
                break;
            case 3:
                producto ="BOXER 3PACK MARTINO AZUL MARINO JOHN HOLDEN UNDERWEAR";
                break;
            case 4:
                producto ="BOXER TRIPACK MASSIMO SURTIDO COLOR DONATELLI";
                break;
            case 5:
                producto ="BOXER HUDSON SURTIDO AZUL JOHN HOLDEN";
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
        return producto;
    }
    public static int accesorios(Scanner sc){
        System.out.println("===ACCESORIOS===");
        System.out.println("1: MOCHILA EDWARD 3MCHD047 NEGRO (DONATELLI) S/ 99.90");
        System.out.println("2: CORBATA MICHI (DONATELLI) S/ 29.99" );
        System.out.println("3: CORBATERO PLATA (DONATELLI) S/ 14.90");
        System.out.println("4: TIRANTE LIAM NEGRO (JOHN HOLDEN) S/ 79.90");
        System.out.println("5: CORREA 3BPF0024 MARRON/NEGRO (DONATELLI) S/ 44.90");
        System.out.println("6: CORREA 3BPD0012 REVERSIBLE NEGRO/MARRÓN (DONATELLI) S/ 59.90");
        System.out.println("7: RELOJ METAL 3WDCM704 SILVER (DONATELLI) S/ 75.90");
        System.out.println("8: RELOJ PU VALERIO NEGRO (JOHN HOLDEN) S/ 99.90");
        System.out.println("9: RELOJ PU OSCAR MARRON OSCURO (JOHN HOLDEN) S/ 99.90");
        System.out.println("10: RELOJ METAL DUSTIN SILVER (JOHN HOLDEN) S/ 99.90");
        System.out.println("====================================================================================");
        int opcion= sc.nextInt();
        return opcion;
    }
    public static double precioACCESORIO(Scanner sc, int opcion){
        double precio=0;
        String color;
        switch (opcion){
            case 1:
                precio=99.90;
                break;
            case 2:
                System.out.println("SELCCIONE EL COLOR");
                System.out.println("VINO");
                System.out.println("AZUL");
                System.out.println("NEGRO");
                color= sc.next();
                if (color.equalsIgnoreCase("vino")||color.equalsIgnoreCase("azul")||color.equalsIgnoreCase("negro")){
                    System.out.println("SU COLOR ELEGIDO ES: "+color);
                }else {
                    System.out.println("ESA OPCION NO ESTA DISPONIBLE");
                }
                precio=29.99;
                break;
            case 3:
                precio=14.90;
                break;
            case 4:
                precio=79.90;
                break;
            case 5:
                precio=44.90;
                break;
            case 6:
                precio=59.90;
                break;
            case 7:
                precio=75.90;
                break;
            case 8:
                precio=99.90;
                break;
            case 9:
                precio=99.90;
                break;
            case 10:
                precio=99.90;
                break;
            default:
                System.out.println("OPCION INVALIDA");
                System.exit(0);
        }
        System.out.println("LA CANTIDAD ES DE: "+precio);
        return precio;
    }
    public static String productoACCESORIO(int opcion){
        String producto="";
        switch (opcion){
            case 1:
                producto = "MOCHILA EDWARD 3MCHD047 NEGRO (DONATELLI)";
                break;
            case 2:
                producto ="CORBATA MICHI (DONATELLI)";
                break;
            case 3:
                producto ="CORBATERO PLATA (DONATELLI)";
                break;
            case 4:
                producto ="TIRANTE LIAM NEGRO (JOHN HOLDEN)";
                break;
            case 5:
                producto ="CORREA 3BPF0024 MARRON/NEGRO (DONATELLI)";
                break;
            case 6:
                producto ="CORREA 3BPD0012 REVERSIBLE NEGRO/MARRÓN (DONATELLI)";
                break;
            case 7:
                producto ="RELOJ METAL 3WDCM704 SILVER (DONATELLI)";
                break;
            case 8:
                producto ="RELOJ PU VALERIO NEGRO (JOHN HOLDEN)";
                break;
            case 9:
                producto ="RELOJ PU OSCAR MARRON OSCURO (JOHN HOLDEN)";
                break;
            case 10:
                producto ="RELOJ METAL DUSTIN SILVER (JOHN HOLDEN)";
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
    public static int seleccionmetodoP(Scanner sc){
        int opcion;
        System.out.println("selccione el metodo de pago");
        System.out.println("1: efectivo");
        System.out.println("2: tarjeta");
        opcion = sc.nextInt();
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
    public static void pagoTARJETA(Scanner sc,double total,String producto,String talla,String metodoPago){
        double igv;
        double subTotal;
        double vuelto = 0;
        double monto = total;
        sc.nextLine();
        String nomTARJETA,fecVENCIMIENTO,cvv,numTARJETA;
        boolean paAPROBADO=false;
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
            Random numrandom=new Random();
            int codigoPAGO=100000+numrandom.nextInt(900000);
            boolean tarjetaOK=(numTARJETA.length()==16);
            boolean cvvOK=(cvv.length()==3);
            boolean fechaESTRUCTURAok=(fecVENCIMIENTO.length()==5&&fecVENCIMIENTO.contains("/"));
            boolean fechaNOvencida=false;
            if (nomTARJETA.equalsIgnoreCase("visa")||nomTARJETA.equalsIgnoreCase("mastercard")||nomTARJETA.equalsIgnoreCase("american express")||nomTARJETA.equalsIgnoreCase("diners club")){
                if (fechaESTRUCTURAok){
                    try{
                        DateTimeFormatter formateador=DateTimeFormatter.ofPattern("MM/yy");
                        YearMonth fechaTARJETA=YearMonth.parse(fecVENCIMIENTO,formateador);
                        YearMonth fechaACTUAL=YearMonth.now();
                        if (fechaTARJETA.isAfter(fechaACTUAL)||fechaTARJETA.equals(fechaACTUAL)){
                            fechaNOvencida=true;
                        }
                    }
                    catch (DateTimeParseException e){
                        fechaESTRUCTURAok=false;
                    }
                }
                if (tarjetaOK&&fechaESTRUCTURAok&&fechaNOvencida&&cvvOK){
                    System.out.println("AUTORIZANDO FONDOS...");
                    System.out.println("TRANSACCION EXITOSA");
                    igv = total * 0.18;
                    subTotal = total - igv;
                    boleta(total,igv,subTotal,monto,vuelto,producto,talla,codigoPAGO,metodoPago);
                    paAPROBADO=true;
                    System.exit(0);
                }else {
                    System.out.println("OPRECAION DENEGADA POR LA PASARELA BANCARIA");
                }
                if (!tarjetaOK){
                    System.out.println("EL NUMERO DE SU TARJETA DEBE CONTENER 16 DIGITOS");
                }
                if (!fechaESTRUCTURAok){
                    System.out.println("FORMATO DE FECHA INCORRECTO");
                }
                if (fechaESTRUCTURAok&&!fechaNOvencida){
                    System.out.println("FECHA DESU TARJETA CADUCADA");
                }
                if (!cvvOK) {
                    System.out.println("EL CVV DEBE TENER 3 DIJITOS");
                }
            }else{
                System.out.println("EL NOMBRE ES INCORRECTO O ESA TARJETA NO ES VALIDA");
            }
        }while (!paAPROBADO);
    }
    public static void pagoEfectivo(Scanner sc,double total,String producto,String talla,String metodoPago){
        double vuelto=0,igv=0,subTotal=0;
        Random numrandom=new Random();
        int opcion;
        int codigoPAGO=100000+numrandom.nextInt(900000);
        System.out.println("SU CODIGO DE PAGO ES EL NUMERO: "+codigoPAGO);
        System.out.println("RECOJA SU PEDIDO Y PAGUE CON ESE CODIGO");
        System.out.println("el monto a pagar es de: "+total);
        System.out.println("Ingrese el total a pagar");
        double monto = sc.nextDouble();
        if (monto>=total){
            vuelto = monto - total;
            igv = 0.18 * total;
            subTotal = total - igv;
            do {
                System.out.println("¿YA RECOGIO SU PEDIDO?");
                System.out.println("1.- SI");
                System.out.println("2.- NO");
                opcion=sc.nextInt();
                if (opcion==1){
                    System.out.println("SU BOLETA ELECTRONICA");
                    boleta(subTotal,total,igv,monto,vuelto,producto,talla,codigoPAGO,metodoPago);
                    System.exit(0);
                }else {
                    System.out.println("RECOJA SU PEDIDO LO ANTES POSIBLE");
                }
            }while (opcion==2);
        }else {
            System.out.println("MONTO INCOMPLETO");
        }
    }
    public static void boleta(double subtotal,double total,double igv,double monto,double vuelto, String producto, String talla,int codigoPAGO,String metodoPago){
        System.out.println("------------------------------");
        System.out.println("          TIENDAS ÉL          ");
        System.out.println(" ROPA Y ACCESORIOS PARA VARÓN ");
        System.out.println("------------------------------");
        System.out.println("RUC: 20100123456");
        System.out.println("BOLETA DE VENTA ELECTRÓNICA");
        System.out.println("------------------------------");
        System.out.println("CODIGO DE PAGO: "+codigoPAGO);
        System.out.println("METODO DE PAGO: "+metodoPago);
        System.out.println("PRODUCTO: " + producto);
        System.out.println("TALLA: " + talla);
        System.out.println("MONTO DE PAGO: S/"+monto);
        System.out.println("SUB TOTAL: S/ " + subtotal);
        System.out.println("IGV: S/ " + igv);
        System.out.println("VUELTO: S/ " + vuelto);
        System.out.println("TOTAL: S/ " + total);
        System.out.println("===============================");
        System.out.println("   ¡GRACIAS POR SU COMPRA!");
        System.out.println("===============================");



    }
}

