package Lab4;

public enum DunnoEmotions implements Described {
    STRIVE("загрустил"),
    CRY("заплакал"),
    LAUGH("засмеялся"),
    FUN("развеселился"),
    BORING("заскучал"),
    AFRAID("испугался"),
    ORDINARY("в обычном настроении"),
    GRIEVE("загоревал");

    private final String description;

    DunnoEmotions(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
