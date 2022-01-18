package Lab4;

public class MainCharacterFriend extends Human implements Likeable {

    public MainCharacterFriend(String Name, Double Height) {
        super(Name, Height);
    }

    public String sitIntoRocket(Rocket rocket) {
        if (rocket.getCondition().equals("Ракета стоит на месте")) {
            if (rocket.maxPassengerHeight >= this.Height)
                return Name + " сел в ракету";
            else return Name + " не поместился в ракету";
        } else {
            return " Посадка невозможна, ракета в полёте";
        }
    }

    public String likeDoingSth(EntertainmentTypes entertainment) {
        var favoriteActivity = new Described() {

            private String determineActivity(EntertainmentTypes e){
                return e.getDescription();
            }

            public String getDescription(){
                return determineActivity(entertainment);
            }
        };
        return Name + " любит " + favoriteActivity.getDescription();
    }
}
