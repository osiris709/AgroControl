package Clases;

/**
 *
 * @author SENA
 */
public class Proveedor {

    String NIt,Nombre, Direccion, Correo, Telefono;

    public Proveedor() {
        this.NIt = NIt;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }

    public String getNIt() {
        return NIt;
    }

    public void setNIt(String NIt) {
        this.NIt = NIt;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
}
