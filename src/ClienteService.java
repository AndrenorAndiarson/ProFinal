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
ClienteDAO.leerClienteDB();
    }
    public static void eliminarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el id del cliente que desea eliminar: ");
        int idClienteAEliminar = scanner.nextInt();

        ClienteDAO.eliminarCliente(idClienteAEliminar);

    }



    public static void editarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nuevo nombre: ");
        String nom= sc.nextLine();
        System.out.println("Escribe el nuevo telefono: ");
        String telf= sc.nextLine();
        System.out.println("Escribe el nuevo direccion: ");
        String dire= sc.nextLine();
        System.out.println("Escribe el nuevo correo electronico: ");
        String correo= sc.nextLine();

        System.out.println("Indica el ID del cliente a editar: ");
        int id_cli= sc.nextInt();
        Cliente actuaCliente = new Cliente();
        actuaCliente.setNombre(nom);
        actuaCliente.setTelefono(telf);
        actuaCliente.setDireccion(dire);
        actuaCliente.setCorreoElectronico(correo);
        actuaCliente.setId(id_cli);

        ClienteDAO.actualizarCliente(actuaCliente);
    }

}
