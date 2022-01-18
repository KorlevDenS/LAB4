package Lab4;

public interface Riddles extends Knowable {
    String makeARiddle(DunnoRiddles riddle);

    String solveARiddle(Riddle riddle, String answer);
}
