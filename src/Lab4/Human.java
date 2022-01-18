package Lab4;

import java.util.ArrayList;

public abstract class Human {

    public String Name;
    public Double Height;
    public ArrayList<Knowledge> knowledge = new ArrayList<>();

    public Human(String Name, Double Height) throws IncorrectDataForObjectException {
        if ((Height < 67) || (Height > 272))
            throw new IncorrectDataForObjectException("People with such height cannot exist.");
        this.Name = Name;
        this.Height = Height;
    }

    @Override
    public boolean equals(Object obj) {
        // быстрая проверка на идентичность
        if (this == obj) return true;
        // проверка на null явного параметра
        if (obj == null) return false;
        // проверка на совпадение классов
        if (this.getClass() != obj.getClass())
            return false;
        Human otherObj = (Human) obj;
        return Name.equals(otherObj.Name) && Height.equals(otherObj.Height);
    }

    public int hashCode() {
        return this.Name.hashCode()
                + this.Height.hashCode();
    }

    public String toString() {
        return getClass().getName()
                + "[name=" + Name
                + ";height=" + Height
                + "]";
    }

}
