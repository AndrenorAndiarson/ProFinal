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
    public static void eliminarCliente(int idCliente) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query ="DELETE FROM `frigobas`.`cliente` WHERE `id` = ?";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setInt(1, idCliente);

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Cliente eliminado correctamente.");
                    } else {
                        System.out.println("No se encontro el cliente con el id proporcionado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void actualizarCliente(Cliente cliente) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "UPDATE `frigobas`.`cliente` SET `Nombre` = ?, `Telefono` = ?, `Direccion` = ?, `CorreoElectronico` = ? WHERE `id` = ?";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setString(1, cliente.getNombre());
                    ps.setString(2, cliente.getTelefono());
                    ps.setString(3, cliente.getDireccion());
                    ps.setString(4, cliente.getCorreoElectronico());
                    ps.setInt(5, cliente.getId());

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Cliente actualizado correctamente.");
                    } else {
                        System.out.println("No se encontro el cliente con la ID proporcionada.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
