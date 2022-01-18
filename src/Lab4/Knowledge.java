package Lab4;

public abstract class Knowledge implements Described {
    public String description;

    public Knowledge(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass())
            return false;
        Knowledge otherObj = (Knowledge) obj;
        return description.equals(otherObj.description);
    }

    public int hashCode() {
        return 31 * this.description.hashCode();
    }

    public String toString() {
        return getClass().getName()
                + "[description=" + description
                + "]";
    }
}
