
package mivotito;

public enum Presidentes {
    MILEI("milei"), MASSA("massa"), GRABOIS("grabois"), LARRETA("larreta"), BULLRICH("bullrich");
    private String presidentes;

    private Presidentes(String presidente) {
        this.presidentes = presidente;
    }

    public String getPresidentes() {
        return presidentes;
    }
    
}
