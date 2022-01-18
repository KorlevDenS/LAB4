package Lab4;

public enum DayPeriods {
    MORNING("утро"),
    AFTERNOON("день"),
    EVENING("вечер"),
    NIGHT("ночь");

    final private String period;

    DayPeriods(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }
}
