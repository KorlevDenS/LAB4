package Lab4;

public interface Thinkable extends Knowable {
    String imagine(String description, String place, int year, int month, int day, DunnoEmotions emotion);

    String strainMind();

    String tryToRememberSth(Object obj);
}
