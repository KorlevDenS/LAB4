package Lab4;

public class CityLightningProcessor {

    private int currentHour;
    private DayPeriods period;

    public CityLightningProcessor(int currentHour) throws IncorrectDataForObjectException {
        if ((currentHour < 0) || (currentHour > 23))
            throw new IncorrectDataForObjectException("There is no hour with this number.");
        this.currentHour = currentHour;
        this.determinePeriod();
    }

    public void manageAllTheLightning(Reservoir.Embankment e, Reservoir.Bridge b) {
        switch (period) {
            case NIGHT:
                System.out.println(e.illuminate(100));
                System.out.println(b.illuminate(100));
                break;
            case MORNING:
            case AFTERNOON:
                try {
                    System.out.println(e.turnOffLightning());
                } catch (EquipmentNotFoundException exception) {
                    b.illuminate(50);
                    System.out.println("Освещеие моста установлено, проверено и выключено");
                }
                try {
                    System.out.println(b.turnOffLightning());
                } catch (EquipmentNotFoundException exception) {
                    b.illuminate(50);
                    System.out.println("Освещеие моста установлено, проверено и выключено");
                }
                break;
            case EVENING:
                System.out.println(e.illuminate(70));
                System.out.println(b.illuminate(70));
                break;
        }
    }

    public void determinePeriod() {
        if ((currentHour >= 0) && (currentHour < 4)) {
            this.period = DayPeriods.NIGHT;
        }
        if ((currentHour >= 4) && (currentHour < 12)) {
            this.period = DayPeriods.MORNING;
        }
        if ((currentHour >= 12) && (currentHour < 16)) {
            this.period = DayPeriods.AFTERNOON;
        }
        if ((currentHour >= 16) && (currentHour <= 23)) {
            this.period = DayPeriods.EVENING;
        }
    }

    public void setCurrentHour(int currentHour) throws IncorrectDataForObjectException {
        if ((currentHour < 0) || (currentHour > 23))
            throw new IncorrectDataForObjectException("There is no hour with this number.");
        this.currentHour = currentHour;
        this.determinePeriod();
        System.out.println("Текущее время: " + this.currentHour + " ч. "
                + "Наступившее время суток: " + this.period.getPeriod());
    }
}
