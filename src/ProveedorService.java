import java.util.Scanner;

public class ProveedorService {
    public static void crearProveedor(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el Nombre: ");
        String nombre;
        nombre= sc.nextLine();

        System.out.println("Ingrese la direccion: ");
        String dire;
        dire= sc.nextLine();

        System.out.println("Ingrese su email: ");
        String correo;
        correo= sc.nextLine();
        System.out.println("Ingrese su telefono: ");
        String tele;
        tele= sc.nextLine();

        Proveedor proveedor = new Proveedor();
       proveedor.setNombre(nombre);
       proveedor.setDireccion(dire);
       proveedor.setCorreoElectronico(correo);
       proveedor.setTelefono(tele);
       ProveedorDAO.NuevoPoveedorDB(proveedor);
    }
    public static void listarProveedor(){
        ProveedorDAO.listarProveedorDB();
    }

    public static void eliminarProveedor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del proveedor que desea eliminar: ");
        String nombreProveedorAEliminar = scanner.nextLine();
        ProveedorDAO.eliminarProveedorDB(nombreProveedorAEliminar);
    }
    public static void editarProveedor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nuevo nombre: ");
        String nom= sc.nextLine();
        System.out.println("Escribe el nuevo direccion: ");
        String dire= sc.nextLine();
        System.out.println("Escribe el nuevo correo electronico: ");
        String correo= sc.nextLine();
        System.out.println("Escribe el nuevo telefono: ");
        String telf= sc.nextLine();

        System.out.println("Indica el ID del proveedor a editar: ");
        int id_Provee= sc.nextInt();
        Proveedor actuaProvee = new Proveedor();
        actuaProvee.setNombre(nom);
        actuaProvee.setDireccion(dire);
        actuaProvee.setCorreoElectronico(correo);
        actuaProvee.setTelefono(telf);
        actuaProvee.setId(id_Provee);
        ProveedorDAO.actualizarProveedorDB(actuaProvee);


    }

}
