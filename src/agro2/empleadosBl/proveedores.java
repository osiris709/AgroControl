/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agro2.empleadosBl;

/**
 *
 * @author SENA
 */
public class proveedores {
    int Nit, Telefono;
    String Direccion, correo, Rsocial;

    public int getNit() {
        return Nit;
    }

    public void setNit(int Nit) {
        this.Nit = Nit;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRsocial() {
        return Rsocial;
    }

    public void setRsocial(String Rsocial) {
        this.Rsocial = Rsocial;
    }
     
}
