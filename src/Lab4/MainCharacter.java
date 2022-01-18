package Lab4;

public class MainCharacter extends Human implements Thinkable, Reactive, Riddles, Singable {
    public double thinkingPeriod;
    public String currentMood;

    public MainCharacter(String Name, Double Height, double thinkingPeriod) {
        super(Name, Height);
        this.thinkingPeriod = thinkingPeriod;
        this.currentMood = DunnoEmotions.ORDINARY.getDescription();
        for (DunnoSongs song : DunnoSongs.values())
            knowledge.add(new Song(song.getSongName(), song.getAuthor()));
        for (DunnoRiddles riddle : DunnoRiddles.values())
            knowledge.add(new Riddle(riddle.getDescription(), riddle.getAnswer()));
        for (DunnoFolklore saying : DunnoFolklore.values())
            knowledge.add(new Folklore(saying.getDescription()));
    }

    public boolean know(Knowledge obj) {
        return (knowledge.contains(obj));
    }

    public void reactToSituation(LifeCase situation) {
        currentMood = situation.getEmotion();
        System.out.println(Name + " " + currentMood);
    }

    public String addKnowledge(Knowledge obj) {
        knowledge.add(obj);
        return Name + " теперь знает: " + obj.getDescription();
    }

    public String imagine(String description, String place, int year, int month, int day, DunnoEmotions emotion) {
        LifeCase imagineCase = new LifeCase(description, place, year, month, day, emotion);
        return Name + " вообразил: " + imagineCase.getDescription();
    }

    public String strainMind() {
        if (thinkingPeriod > 1) {
            thinkingPeriod /= 2;
            System.out.println(Name + " теперь думает в 2 раза быстрее");
        }

        Described entertainment = new Described() {

            private String comeUpWithEntertainment() {
                int index = (int) (Math.random() * EntertainmentTypes.values().length);
                return EntertainmentTypes.values()[index].getDescription();
            }

            public String getDescription() {
                return comeUpWithEntertainment();
            }
        };

        return Name + " придумал развлечение: " + entertainment.getDescription();
    }

    public String tryToRememberSth(Object obj) {
        if (obj instanceof Knowledge) {
            Knowledge f = (Knowledge) obj;
            if (this.know(f)) {
                if (Math.random() > 0.2)
                    return Name + " вспомнил: " + f.getDescription();
                else return Name + " знает это, но не может вспомнить";
            }
        }
        if (obj instanceof MainCharacterFriend) {
            MainCharacterFriend friend = (MainCharacterFriend) obj;
            return Name + " вспомнил своего друга по имени " + friend.Name;
        }
        return Name + " никогда такого и не знал";
    }


    public String sitUnderBridge(Reservoir.Bridge bridge) {
        if (bridge.getHeight() > Height)
            return Name + " сел под мост ";
        else return Name + " не поместился ";
    }

    public String makeARiddle(DunnoRiddles riddle) {
        Riddle rid = new Riddle(riddle.getDescription(), riddle.getAnswer());
        return Name + " загадал загадку: " + rid.getDescription();
    }

    public String solveARiddle(Riddle riddle, String answer) {
        if (riddle.tryCheckAnswer(answer)) {
            return Name + " разгадал загадку \"" + riddle.getDescription() + "\""
                    + " Ответ: " + riddle.getAnswer();
        } else {
            return Name + " не знает ответа на эту загадку ";
        }
    }

    public String sing(Song song) {
        if (this.know(song))
            return Name + " спел песню " + song.getSongName() + ", автор которой: " + song.getAuthor();
        else return Name + " не знает такую песню";
    }
}
