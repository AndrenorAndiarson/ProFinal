import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection get_conConnection(){

        Connection conection = null;
        try {
            conection= DriverManager.getConnection("jdbc:mysql://localhost:3306/frigobas","root","");
            if (conection!=null){
                System.out.println("Conexion exitosa");
            }
        }catch (SQLException e){
            System.out.println("Error: "+e);
        }

        return conection;
    }

}
