package mivotito;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Partido {

    private int votos;
    private String nombreP;
    private int votoP;
    private int votoJ;
   
    private Connection con = SqlConnection.getConnection();
    private int id;
    public Partido(String nombreP) throws SQLException {
        this.nombreP = nombreP;
     
        
        PreparedStatement ps = con.prepareStatement("SELECT * FROM partido WHERE nombre = ?");
        ps.setString(1, nombreP);
        ResultSet rs = ps.executeQuery();
        rs.next();

        
        this.id = rs.getInt("id");
        this.votoP = rs.getInt("cantVotosPresidente");
        this.votoJ = rs.getInt("cantVotosJefe");
        
    }
    public void agregarVotoP() throws SQLException{
        this.votoP++;
         PreparedStatement ps = con.prepareStatement("UPDATE partido SET cantVotosPresidente = ? WHERE id = ?");
         ps.setInt(1, this.votoP);
         ps.setInt(2, this.id);
         ps.executeUpdate();
    }
    public void agregarVotoJ() throws SQLException{
        this.votoP++;
         PreparedStatement ps = con.prepareStatement("UPDATE partido SET cantVotosJefe = ? WHERE id = ?");
         ps.setInt(1, this.votoJ);
         ps.setInt(2, this.id);
         ps.executeUpdate();
    }
    public void agregarVotos() throws SQLException {
        votos++;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    

}
