
package mivotito;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Candidato 
{
   
    private Partido partido;
    private String nombre;

    private int cantVotos;

    public Candidato(String nombre, Partido partido, int cantVotos) 
    {
        
        this.partido = partido;
        this.cantVotos = cantVotos;
        this.nombre = nombre;
       
    }
    public abstract void votar() throws SQLException;
        

   
   
    public Partido getPartido() 
    {
        return partido;
    }

    public void setPartido(Partido partido) 
    {
        this.partido = partido;
    }

    public int getCantVotos() 
    {
        return cantVotos;
    }

    public void setCantVotos(int cantVotos) 
    {
        this.cantVotos = cantVotos;
    }
    
    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }
}

  