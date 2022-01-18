package Lab4;

public enum DunnoSongs {
    SONG1("Пусть бегут неуклюже", "Крокодил Гена"),
    SONG2("Гимн Незнайки и его друзей", "Незнайка"),
    SONG3("Cadillac", "Оксимирон"),
    SONG4("День Рождения", "народная"),
    SONG5("Чика", "Артур Пирожков");

    private final String songName;
    private final String author;

    DunnoSongs(String songName, String author) {
        this.songName = songName;
        this.author = author;
    }

    public String getSongName() {
        return this.songName;
    }

    public String getAuthor() {
        return this.author;
    }
}
