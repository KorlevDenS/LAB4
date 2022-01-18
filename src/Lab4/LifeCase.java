package Lab4;

public class LifeCase extends Knowledge {
    private final int year;
    private final int month;
    private final int day;
    private final String place;
    private final String emotion;

    public LifeCase(String description, String place, int year, int month, int day, DunnoEmotions emotion) {
        super(description);
        this.place = place;
        this.year = year;
        this.month = month;
        this.day = day;
        this.emotion = emotion.getDescription();
    }

    public void complementDescription(String addDescription) {
        this.description = this.description + " " + addDescription;
    }

    public void resetDescription(String newDescription) {
        this.description = newDescription;
    }

    public String getEmotion() {
        return emotion;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass())
            return false;
        LifeCase otherObj = (LifeCase) obj;
        return description.equals(otherObj.description)
                && place.equals(otherObj.place)
                && (year == otherObj.year)
                && (month == otherObj.month)
                && (day == otherObj.day)
                && emotion.equals(otherObj.emotion);
    }

    public int hashCode() {
        return this.description.hashCode()
                + 31 * this.place.hashCode()
                + 31 * (this.year + this.month + this.day)
                + 31 * (this.emotion.hashCode());
    }

    public String toString() {
        return getClass().getName()
                + "[description=" + description
                + ";place=" + place
                + ";date=" + day + "." + month + "." + year
                + ";emotion=" + emotion
                + "]";
    }
}
