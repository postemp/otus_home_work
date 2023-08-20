package hw13.transport;
public enum Terrain {
    FOREST( "Дремучий лес"),
    PLAIN( "Равнина"),
    SWAMP("Болото")
    ;

    private String description;

    Terrain( String description) {
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
