import java.time.LocalDate;
import java.util.Scanner;

public class EmpleadoService {

    public static void crearEmpleado(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el nombre del nuevo empleado: ");
        String nombre;
        nombre=sc.nextLine();
        System.out.println("Ingrese Cargo: ");
        String cargo;
        cargo= sc.nextLine();
        System.out.println("Ingrese su e-mail: ");
        String correo;
        correo= sc.nextLine();
        System.out.println("Ingrese Telefono: ");
        String telf;
        telf= sc.nextLine();
        LocalDate nuevafecha = LocalDate.now();
        System.out.println("Ingrese Direccion: ");
        String direccion;
        direccion= sc.nextLine();


        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setCargo(cargo);
        empleado.setCorreoElectronico(correo);
        empleado.setTelefono(telf);
        empleado.setFechaContratacion(nuevafecha);
        empleado.setDireccion(direccion);
        EmpleadoDAO.crearEmpleadoDB(empleado);
    }

    public static void listarEmpleados(){
        EmpleadoDAO.leerEmpleadoDB();
    }
    public static void eliminarEmpleado() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del empleado que desea eliminar: ");
        String nombreEmpleadoEliminar = scanner.nextLine();
        EmpleadoDAO.eliminarEmpleado(nombreEmpleadoEliminar);
    }



    public static void editarEmpleado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nuevo nombre: ");
        String nom= sc.nextLine();
        System.out.println("Escribe el nuevo cargo");
        String cargo= sc.nextLine();
        System.out.println("Escribe el nuevo correo electronico: ");
        String correo= sc.nextLine();
        System.out.println("Escribe el nuevo telefono: ");
        String telf= sc.nextLine();
        LocalDate nuevaFechaContratacion = null;
        System.out.println("¿Quieres actualizar la fecha de contratacion? (y/n): ");
        String respuesta = sc.nextLine().toLowerCase();
        if (respuesta.equals("y")) {
            System.out.println("Escribe la nueva fecha de contratacion en formato yyyy-MM-dd: ");
            String fechaContratacionStr = sc.nextLine();
            nuevaFechaContratacion = LocalDate.parse(fechaContratacionStr);
        }
        System.out.println("Escribe la nueva direccion: ");
        String dire= sc.nextLine();


        System.out.println("Indica el ID del empleado a editar: ");
        int id_emp= sc.nextInt();
        Empleado actuaEmpleado = new Empleado();
        actuaEmpleado.setNombre(nom);
        actuaEmpleado.setCargo(cargo);
        actuaEmpleado.setCorreoElectronico(correo);
        actuaEmpleado.setTelefono(telf);
        actuaEmpleado.setFechaContratacion(nuevaFechaContratacion);
        actuaEmpleado.setDireccion(dire);
        actuaEmpleado.setId(id_emp);

        EmpleadoDAO.actualizarEmpleado(actuaEmpleado);
    }

}

