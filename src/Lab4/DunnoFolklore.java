package Lab4;

public enum DunnoFolklore implements Described {
    PROVERB1("Кому пироги да пышки, а нам синяки да шишки"),
    PROVERB2("Слышит ухо, что не сыто брюхо"),
    PROVERB3("Яков лаком, съел кошку с маком");

    private final String description;

    DunnoFolklore(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
