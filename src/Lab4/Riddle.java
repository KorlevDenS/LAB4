package Lab4;

public class Riddle extends Knowledge implements Answerable {
    private final String answer;

    public Riddle(String description, String answer) {
        super(description);
        this.answer = answer;
    }

    public boolean tryCheckAnswer(String answer) {
        return this.answer.equals(answer);
    }

    public String getAnswer() {
        return this.answer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass())
            return false;
        Riddle otherObj = (Riddle) obj;
        return description.equals(otherObj.description) && answer.equals(otherObj.answer);
    }

    public int hashCode() {
        return this.description.hashCode()
                + 31 * this.answer.hashCode();
    }

    public String toString() {
        return getClass().getName()
                + "[description=" + description
                + ";answer=" + answer
                + "]";
    }
}
