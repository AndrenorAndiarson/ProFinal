import java.util.Scanner;

public class ProveedorMenu {
    public static void proveedorMenu(){
        Scanner sc =new Scanner(System.in);
        int opcionProvee=0;
        do{
            System.out.println("----MENU PROVEEDORES---");
            System.out.println("1. Crear nuevo proveedor: ");
            System.out.println("2. Listar proveedores");
            System.out.println("3. Editar Proveedores");
            System.out.println("4. Eliminar Proveedor");
            System.out.println("5. Volviendo al menu principal");
            opcionProvee = sc.nextInt();

            switch (opcionProvee) {
                case 1:
                    ProveedorService.crearProveedor();
                    break;
                case 2:
                    ProveedorService.listarProveedor();
                    break;
                case 3:
                    ProveedorService.editarProveedor();
                    break;
                case 4:
                    ProveedorService.eliminarProveedor();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
                    break;
            }
        }while (opcionProvee!=5);

    }

}
