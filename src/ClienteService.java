import java.util.Scanner;

public class ClienteService {
    public static void crearCliente(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el nombre del nuevo cliente: ");
        String nombre;
        nombre=sc.nextLine();
        System.out.println("Ingrese Telefono: ");
        String telf;
        telf= sc.nextLine();
        System.out.println("Ingrese Direccion: ");
        String direccion;
        direccion= sc.nextLine();
        System.out.println("Ingrese su e-mail: ");
        String correo;
        correo= sc.nextLine();

        Cliente cliente= new Cliente();
        cliente.setNombre(nombre);
        cliente.setCorreoElectronico(correo);
        cliente.setTelefono(telf);
        cliente.setDireccion(direccion);
        ClienteDAO.crearClienteDB(cliente);
    }
    public static void listarClientes(){

    }
    public static void eliminarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del cliente que desea eliminar: ");
        String nombreClienteAEliminar = scanner.nextLine();

        ClienteDAO.eliminarCliente(nombreClienteAEliminar);

        scanner.close();
    }



    public static void editarCliente(){

    }

}
