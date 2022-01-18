package Lab4;

public class FlashLight {

    private final double height;
    public boolean turnedOn;
    private boolean equippedWithLamp;
    private int brightness;

    public FlashLight(double height) throws IncorrectDataForObjectException {
        if ((height < 1) || (height > 20))
            throw new IncorrectDataForObjectException("Flashlights with such height cannot exist.");
        this.height = height;
        this.equippedWithLamp = false;
        this.turnedOn = false;
        this.brightness = 0;
    }

    public void turnOn() throws EquipmentNotFoundException {
        if (equippedWithLamp) turnedOn = true;
        else throw new EquipmentNotFoundException("No lamp to tern on the flashlight.");
    }

    public void turnOff() {
        turnedOn = false;
    }

    public void installTheLamp(int brightness) throws IncorrectDataForObjectException {
        class Lamp {

            private final int brightness;

            public Lamp(int brightness) {
                this.brightness = brightness;
                FlashLight.this.equippedWithLamp = true;
                FlashLight.this.brightness = brightness;
            }

            public int getBrightness() {
                return this.brightness;
            }
        }
        if ((brightness < 1) || (brightness > 100))
            throw new IncorrectDataForObjectException("Lamps with such brightness cannot exist.");
        Lamp lamp = new Lamp(brightness);
    }

    public double getHeight() {
        return this.height;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public boolean isEquippedWithLamp() {
        return equippedWithLamp;
    }

    @Override

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass())
            return false;
        FlashLight otherObj = (FlashLight) obj;
        return (height == otherObj.height);
    }

    public int hashCode() {
        return 31 * Double.hashCode(height);
    }
}
