package Lab4;

public class Rocket {
    private final int maxSpeed;
    public final Double maxPassengerHeight;
    private final int maxFuelReserve;
    public int currentSpeed;
    public int currentFuelReserve;

    public Rocket(int maxSpeed, int maxFuelReserve, Double maxPassengerHeight) throws IncorrectDataForObjectException {
        if ((maxSpeed < 20000) || (maxFuelReserve < 1000) || (maxPassengerHeight < 67))
            throw new IncorrectDataForObjectException("Rocket with such params cannot exist.");
        this.maxSpeed = maxSpeed;
        this.maxFuelReserve = maxFuelReserve;
        this.maxPassengerHeight = maxPassengerHeight;
        this.currentFuelReserve = 0;
        this.currentSpeed = 0;
    }

    public String refuel(int fuel) {
        fuel = Math.abs(fuel);
        if (fuel > maxFuelReserve) {
            currentFuelReserve = maxFuelReserve;
            return " Полный бак, лишнее топливо: " + (fuel - maxFuelReserve) + "л.";
        } else {
            currentFuelReserve += fuel;
            return " Топливо добавлено ";
        }
    }

    public String flyUp() {
        if (currentFuelReserve > maxFuelReserve / 2) {
            currentSpeed = maxSpeed;
            return "Ракета поднялась в воздух";
        } else {
            return "Недостаточно топлива для взлёта";
        }
    }

    public String land() {
        currentSpeed = 0;
        return "Ракета приземлилась";
    }

    public String getCondition() {
        if (this.currentSpeed == 0)
            return "Ракета стоит на месте";
        else return "Ракета в полёте";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass())
            return false;
        Rocket otherObj = (Rocket) obj;
        return (maxPassengerHeight.equals(otherObj.maxPassengerHeight))
                && (maxFuelReserve == otherObj.maxFuelReserve)
                && (maxSpeed == otherObj.maxSpeed);
    }

    public int hashCode() {
        return 31 * this.maxPassengerHeight.hashCode()
                + 31 * maxSpeed
                + 31 * maxFuelReserve;
    }

    public String toString() {
        return getClass().getName()
                + "[maxSpeed=" + maxSpeed
                + ";maxFuelReserve=" + maxFuelReserve
                + ";maxPassengerHeight=" + maxPassengerHeight
                + "]";
    }
}
