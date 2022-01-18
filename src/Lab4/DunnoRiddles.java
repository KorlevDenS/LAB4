package Lab4;

public enum DunnoRiddles implements Described, Answerable {
    RIDDLE1("Серый и зубастый, Воет в день ненастный", "Волк"),
    RIDDLE2("Пришла из леса птичница в рыжей шубке, кур посчитать.", "Лиса"),
    RIDDLE3("Кто пчелиный любит мед, Лапу кто зимой сосет?", "Медведь"),
    RIDDLE4("У него два горба, В них и пища и вода", "Верблюд");

    private final String description;
    private final String answer;

    DunnoRiddles(String description, String answer) {
        this.description = description;
        this.answer = answer;
    }

    public String getDescription() {
        return description;
    }

    public String getAnswer() {
        return answer;
    }
}
