package mivotito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Administrador {
    private int votosP;
    private int votosJ;
    private int id;
    private String nombreAdmin;
    private int contraseña;

    private Connection con = SqlConnection.getConnection();

    public Administrador(String nombreAdmin, int contraseña) throws SQLException {

        this.nombreAdmin = nombreAdmin;
        this.contraseña = contraseña;
    }

    public void estadoDeVotos() throws SQLException {
        PreparedStatement ps = con.prepareStatement("SELECT * FROM  partido ORDER BY cantVotosPresidente DESC");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println("");
            System.out.println("-----------------");
             System.out.println("Votos presidente");
            votosP = rs.getInt("cantVotosPresidente");
            System.out.println(rs.getString("nombre"));
           System.out.println(rs.getInt("cantVotosPresidente"));
           System.out.println("-----------------");
           
            System.out.println("");
            System.out.println("-----------------");
            System.out.println("Votos Jefe de Gobierno");
           System.out.println(rs.getString("nombre"));
           votosJ = rs.getInt("cantVotosJefe");
           System.out.println(rs.getInt("cantVotosJefe"));
           System.out.println("-----------------");
        }
        /*  
        PreparedStatement ps = con.prepareStatement("SELECT * FROM candidatos WHERE cantVotos = ?");
        System.out.println(ps);
         */
    }

}
