package mivotito;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.PreparedStatement;

public class Votante {

    ArrayList<Votante> votante = new ArrayList();
    private int dni;
    private String nombre;
    private String apellido;
    private static int token;
    private int nroInforme = 1;
    LocalDate fecha;
    private Connection con = SqlConnection.getConnection();

    public Votante(String nombre, String apellido, int dni) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.token = (int) (Math.random() * 100000000);
        this.fecha = LocalDate.now();
    }

    public void informe() {

        String text = "";
        text += "---------------\n";
        text += "Informe N°: " + this.nroInforme + " - " + this.fecha;
        this.nroInforme++;
        text += "\n" + "DNI: " + this.dni;
        text += "\n" + "Token: " + this.token + "\n";
        text += "Gracias " + this.nombre + " " + this.apellido + " por votar!!" + "\n";
        text += "---------------";
        System.out.println(text);
    }

    public boolean votoUnico() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT IF (EXISTS (SELECT * FROM votante WHERE dni=?),1 ,0) as response");
        ps.setInt(1, dni);
        ResultSet rs = ps.executeQuery();

        rs.next();

        int respuesta = rs.getInt("response");
        if (respuesta == 1) {
            return true;
        } else {

            return false;
        }

    }

    public void votar() throws SQLException {
        PreparedStatement ps = con.prepareStatement("INSERT INTO votante (nombre, apellido, dni) VALUES(?, ?, ?)");
        ps.setString(1, this.getNombre());
        ps.setString(2, this.getApellido());
        ps.setInt(3, this.getDni());
        ps.executeUpdate();
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

}
