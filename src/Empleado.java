import java.time.LocalDate;

public class Empleado {
    int id;
    String Nombre;
    String Cargo;
    String CorreoElectronico;
    String Telefono;
    LocalDate FechaContratacion;
    String Direccion;

    public Empleado(){

    }

    public Empleado(int id, String nombre, String cargo, String correoElectronico, String telefono, LocalDate fechaContratacion, String direccion) {
        this.id = id;
        Nombre = nombre;
        Cargo = cargo;
        CorreoElectronico = correoElectronico;
        Telefono = telefono;
        FechaContratacion = fechaContratacion;
        Direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        CorreoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public LocalDate getFechaContratacion() {
        return FechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        FechaContratacion = fechaContratacion;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
}
