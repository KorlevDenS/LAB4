package Lab4;

public class EquipmentNotFoundException extends Exception {

    public EquipmentNotFoundException() {
    }

    public EquipmentNotFoundException(String message) {
        super(message);
    }

    @Override

    public String toString() {
        return "There is no such equipment to perform this action.";
    }
}
