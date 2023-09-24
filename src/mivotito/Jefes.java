
package mivotito;

public enum Jefes {
    MARRA("marra"), MACRI("macri"), LOUSTEAU("lousteau"), SANTORO("santoro");
    private String jefes;

    private Jefes(String jefes) {
        this.jefes = jefes;
    }

    public String getJefes() {
        return jefes;
    }
    
}
