import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Conexion db_conexion = new Conexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try (Connection conexion = db_conexion.get_conConnection()){
            String query= "SELECT * FROM cliente";
            ps = conexion.prepareStatement(query);
            rs= ps.executeQuery();
            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("NOMBRE: "+rs.getString("Nombre"));
                System.out.println("TELEFONO: "+rs.getString("Telefono"));
                System.out.println("DIRECCION: "+rs.getString("Direccion"));
                System.out.println("CORREO ELECTRONICO: "+rs.getString("CorreoElectronico"));
                System.out.println("------------------------------");
            }

        } catch (SQLException e){
            System.out.println(e);
        }
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
