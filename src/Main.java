import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        /*do {
            System.out.println("---  ***  ---");
            System.out.println("MENU");
            System.out.println("1- Crear cliente");
            System.out.println("2- Listar cliente");
            System.out.println("3- Editar cliente");
            System.out.println("4- Eliminar cliente");
            System.out.println("5- Salir");
            System.out.println(" >>> ");
            opcion= sc.nextInt();
        switch (opcion){
            case 1:
                ClienteService.crearCliente();
                break;
            case 2:
                ClienteService.listarClientes();
                break;
            case 3:
                ClienteService.editarCliente();
                break;
            case 4:
                ClienteService.eliminarCliente();
                break;
            default:
                break;
        }
        } while (opcion!=5);*/
        do {
            System.out.println("==== MENU PRINCIPAL ====");
            System.out.println("1- Gestionar Clientes");
            System.out.println("2- Gestionar Empleados");
            System.out.println("3- Gestionar Proveedores");
            System.out.println("4- Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    ClienteMenu.menuClientes();
                    break;
                case 2:
                    EmpleadoMenu.menuEmpleados();
                    break;
                case 3:
                    System.out.println("hola2");
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
            }

        } while (opcion != 4);{
        sc.close();



    }
}}