import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public static void crearClienteDB(Cliente cliente) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "INSERT INTO `frigobas`.`cliente` (`Nombre`, `Telefono`, `Direccion`, `CorreoElectronico`) VALUES (?, ?, ?, ?)";
                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setString(1, cliente.getNombre());
                    ps.setString(2, cliente.getTelefono());
                    ps.setString(3, cliente.getDireccion());
                    ps.setString(4, cliente.getCorreoElectronico());

                    // Ejecutar la consulta de inserción
                    ps.executeUpdate();

                    System.out.println("Cliente insertado correctamente.");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void leerClienteDB(){

    }
    public static void eliminarCliente(String nombreCliente) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "DELETE FROM `frigobas`.`cliente` WHERE `Nombre` = ?";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setString(1, nombreCliente);

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Cliente eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró el cliente con el nombre proporcionado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizarCliente(Cliente cliente){

    }

}
