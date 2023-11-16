import java.util.Scanner;

public class EmpleadoMenu {

    public static void menuEmpleados() {
        Scanner scanner = new Scanner(System.in);
        int opcionEmpleado;

        do {
            System.out.println("---  ***  ---");
            System.out.println("MENU EMPLEADOS");
            System.out.println("1- Crear empleado");
            System.out.println("2- Listar empleados");
            System.out.println("3- Editar empleado");
            System.out.println("4- Eliminar empleado");
            System.out.println("5- Volver al menu principal");

            opcionEmpleado = scanner.nextInt();
            scanner.nextLine();

            switch (opcionEmpleado) {
                case 1:
                    EmpleadoService.crearEmpleado();
                    break;
                case 2:
                    EmpleadoService.listarEmpleados();
                    break;
                case 3:
                    EmpleadoService.editarEmpleado();
                    break;
                case 4:
                    EmpleadoService.eliminarEmpleado();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
                    break;
            }
        } while (opcionEmpleado != 5);

    }
}
