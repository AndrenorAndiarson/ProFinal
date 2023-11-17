import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedorDAO {
public static void NuevoPoveedorDB(Proveedor proveedor){
    Conexion db_connect = new Conexion();
    try (Connection conexion = db_connect.get_conConnection()) {
        try {
            String basedatos = "INSERT INTO `frigobas`.`proveedor` (`Nombre`,`Direccion`, `CorreoElectronico`, `Telefono`) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conexion.prepareStatement(basedatos)) {
                ps.setString(1, proveedor.getNombre());
                ps.setString(2, proveedor.getDireccion());
                ps.setString(3, proveedor.getCorreoElectronico());
                ps.setString(4, proveedor.getTelefono());

                ps.executeUpdate();
            }
                System.out.println("Proveedor insertado correctamente.");

            }catch (Exception ex){
                System.out.println(ex);
}
    }catch (Exception e){
        System.out.println(e);
    }
}

public static void listarProveedorDB(){
        Conexion db_connect = new Conexion();
    Conexion db_conexion = new Conexion();
    PreparedStatement ps=null;
    ResultSet rs=null;
    try (Connection conexion = db_conexion.get_conConnection()){
        String query= "SELECT * FROM proveedor";
        ps = conexion.prepareStatement(query);
        rs= ps.executeQuery();
        while (rs.next()){
            System.out.println("ID: "+rs.getInt("id"));
            System.out.println("NOMBRE: "+rs.getString("Nombre"));
            System.out.println("DIRECCION: "+rs.getString("Direccion"));
            System.out.println("CORREO ELECTRONICO: "+rs.getString("CorreoElectronico"));
            System.out.println("TELEFONO: "+rs.getString("Telefono"));
            System.out.println("------------------------------");
        }

    } catch (SQLException e){
        System.out.println(e);
    }
}

    public static void eliminarProveedorDB(int nombreProveedor) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "DELETE FROM `frigobas`.`proveedor` WHERE `id` = ?";
                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setInt(1, nombreProveedor);
                    int filasAfectadas = ps.executeUpdate();
                    if (filasAfectadas > 0) {
                        System.out.println("Proveedor eliminado correctamente.");
                    } else {
                        System.out.println("No se encontro el Proveedor con el id proporcionado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizarProveedorDB (Proveedor proveedor) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "UPDATE `frigobas`.`proveedor` SET `Nombre` = ?, `Direccion` = ?, `CorreoElectronico`= ?, `Telefono` = ? WHERE `id` = ?";
                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setString(1, proveedor.getNombre());
                    ps.setString(2, proveedor.getDireccion());
                    ps.setString(3, proveedor.getCorreoElectronico());
                    ps.setString(4, proveedor.getTelefono());
                    ps.setInt(5, proveedor.getId());

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Proveedor actualizado correctamente.");
                    } else {
                        System.out.println("No se encontro el Proveedor con la ID proporcionada.");
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
