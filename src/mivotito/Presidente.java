package mivotito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Presidente extends Candidato {
    private int votos;
    public Presidentes presidente;
    private Connection con = SqlConnection.getConnection();
    private int id;
    public Presidente(String nombre, Presidentes presidente, Partido partido, int cantVotos) throws SQLException {
        super(nombre, partido, cantVotos);
        this.presidente = presidente;
        PreparedStatement ps = con.prepareStatement("SELECT * FROM candidatos WHERE nombre = ?");
        ps.setString(1, this.getNombre());
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        this.id = rs.getInt("id");
        this.votos = rs.getInt("cantVotos");
        
    }

  
    @Override
    public void votar() throws SQLException {
        this.votos++;
        PreparedStatement ps = con.prepareStatement("UPDATE candidatos SET cantVotos = ? WHERE id = ?");
        ps.setInt(1, this.votos);
        ps.setInt(2, this.id);
        ps.executeUpdate();
        this.getPartido().agregarVotoP();
    }

    @Override
    public String toString() {
        return "Presidente: " + presidente;
    }

}
