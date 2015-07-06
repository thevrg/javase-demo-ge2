package hu.dpc.edu.javase.demo;

/**
 *
 * @author IQJB
 */
public enum Season {
    WINTER("Tel"),
    SPRING("Tavasz"),
    SUMMER("Nyar"),
    AUTUMN("Osz");

    private final String description;
    
    Season(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return "Hello, " + name() + ", " + getDescription();
    }
    
    
}
