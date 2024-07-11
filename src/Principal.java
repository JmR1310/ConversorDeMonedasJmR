import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        int opcion=0;
        while (opcion==0){
            System.out.println("\n");
            System.out.println("*****************************************");
            System.out.println("          CONVERSOR DE MONEDAS           ");
            System.out.println("*****************************************");
            System.out.println("\n ");
            System.out.println("1. Dolar            ==>  Peso Argentino");
            System.out.println("2. Peso Argentino   ==>  Dolar");
            System.out.println("3. Dolar            ==>  Real Brasilenio");
            System.out.println("4. Real Brasilenio  ==>  Dolar");
            System.out.println("5. Dolar            ==>  Peso colombiano");
            System.out.println("6. Peso colombiano  ==>  Dolar");
            System.out.println("7. Salir");
            System.out.println("\nElija una opcion: ");

            try{
                opcion = lectura.nextInt();
                String codigoDeMoneda="";
                String monedaCambio="";
                switch (opcion){
                    case 1:
                        codigoDeMoneda = "USD";
                        monedaCambio = "ARS";
                        break;

                    case 2:
                        codigoDeMoneda = "ARS";
                        monedaCambio = "USD";
                        break;

                    case 3:
                        codigoDeMoneda = "USD";
                        monedaCambio = "BRL";
                        break;

                    case 4:
                        codigoDeMoneda = "BRL";
                        monedaCambio = "USD";
                        break;

                    case 5:
                        codigoDeMoneda = "USD";
                        monedaCambio = "COP";
                        break;

                    case 6:
                        codigoDeMoneda = "COP";
                        monedaCambio = "USD";
                        break;

                    case 7:
                        System.out.println("...");
                        System.out.println("Programa Finalizado.");
                        return;
                    default:
                        System.out.println("ERROR: Opcion invalida.");
                        System.out.println("Cerrando programa...");
                        return;
                }

                Moneda moneda = consulta.buscaMoneda(codigoDeMoneda);
                Map valor = (Map<String,Double>) moneda.conversion_rates();
                System.out.println("Escriba la cantidad de dinero (" + codigoDeMoneda +") que desea cambiar a " + monedaCambio + " : ");
                Double cantidad = lectura.nextDouble();
                System.out.println("Al cambio actual ("+valor.get(monedaCambio)+") por "
                        + cantidad +" "+ codigoDeMoneda+" tendrias la siguiente suma: ");
                System.out.println(" " + (cantidad * (double)valor.get(monedaCambio))+" "+monedaCambio);

                System.out.println("");
                int i=0;
                while (opcion != 0 && opcion!=7){

                    if (i>0){
                        System.out.println("Error: Opcion invalida.\n");
                    }

                    System.out.println("Elija una opcion: ");
                    System.out.println("0. Regresar al menu     /     7. Finalizar el programa");
                    opcion = lectura.nextInt();
                    i++;
                    if (opcion==7){
                        System.out.println("...");
                        System.out.println("Programa Finalizado.");
                    }
                }

            }catch (NumberFormatException e){
                System.out.println("Numero no encontrado " + e.getMessage());
            } catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Finalizando aplicacion");
            }
        }


    }
}
