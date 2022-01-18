package Lab4;

public enum EntertainmentTypes implements Described {
    SING("петь"),
    READ("читать"),
    DREAM("мечтать"),
    EAT("покушать"),
    WALK("гулять");

    private final String description;

    EntertainmentTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
