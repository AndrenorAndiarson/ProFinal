import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmpleadoDAO {

    public static void crearEmpleadoDB(Empleado empleado) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "INSERT INTO `frigobas`.`empleado` (`Nombre`, `Cargo`, `CorreoElectronico`, `Telefono`, `FechaContratacion`, `Direccion`) VALUES (?, ?, ?, ?, ?, ?)";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setString(1, empleado.getNombre());
                    ps.setString(2, empleado.getCargo());
                    ps.setString(3, empleado.getCorreoElectronico());
                    ps.setString(4, empleado.getTelefono());

                    // Convertir LocalDate a java.sql.Date
                    Date fechaContratacionSql = Date.valueOf(empleado.getFechaContratacion());
                    ps.setDate(5, fechaContratacionSql);

                    ps.setString(6, empleado.getDireccion());

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Empleado insertado correctamente.");
                    } else {
                        System.out.println("No se pudo insertar el empleado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void leerEmpleadoDB(){
        Conexion db_conexion = new Conexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try (Connection conexion = db_conexion.get_conConnection()){
            String query= "SELECT * FROM `empleado`";
            ps = conexion.prepareStatement(query);
            rs= ps.executeQuery();
            while (rs.next()){
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("NOMBRE: "+rs.getString("Nombre"));
                System.out.println("CARGO: "+rs.getString("Cargo"));
                System.out.println("CORREO ELECTRONICO: "+rs.getString("CorreoElectronico"));
                System.out.println("TELEFONO: "+rs.getString("Telefono"));
                //System.out.println("FECHA CONTRATACION: "+rs.getDate(query));

                java.sql.Date fechaContratacionSql = rs.getDate("FechaContratacion");
                LocalDate fechaContratacion = fechaContratacionSql.toLocalDate();

                System.out.println("DIRECCION: "+rs.getString("Direccion"));
                System.out.println("------------------------------");
            }

        } catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void eliminarEmpleado(int nombreEmpleado) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "DELETE FROM `frigobas`.`empleado` WHERE `id` = ?";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setInt(1, nombreEmpleado);

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Empleado eliminado correctamente.");
                    } else {
                        System.out.println("No se encontro el empleado con el id proporcionado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void actualizarEmpleado(Empleado empleado) {
        Conexion db_connect = new Conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "UPDATE `frigobas`.`empleado` SET `Nombre` = ?, `Cargo` = ?, `CorreoElectronico` = ?, `Telefono` = ?, `FechaContratacion` = ?, `Direccion`= ? WHERE `id` = ?";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {

                    ps.setString(1, empleado.getNombre());
                    ps.setString(2, empleado.getCargo());
                    ps.setString(3, empleado.getCorreoElectronico());
                    ps.setString(4, empleado.getTelefono());
                    if (empleado.getFechaContratacion() != null) {
                        ps.setDate(5, Date.valueOf(empleado.getFechaContratacion()));
                    } else {
                        ps.setDate(5, Date.valueOf(LocalDate.now()));
                    }
                    ps.setString(6, empleado.getDireccion());
                    ps.setInt(7, empleado.getId());

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Empleado actualizado correctamente.");
                    } else {
                        System.out.println("No se encontro el empleado con la ID proporcionada.");
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

