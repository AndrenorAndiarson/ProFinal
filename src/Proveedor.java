public class Proveedor {
    int id;
    String Nombre;
    String Direccion;
    String CorreoElectronico;
    String Telefono;

    public Proveedor() {
    }

    public Proveedor(int id, String nombre, String direccion, String correoElectronico, String telefono) {
        this.id = id;
        Nombre = nombre;
        Direccion = direccion;
        CorreoElectronico = correoElectronico;
        Telefono = telefono;
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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
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
}
