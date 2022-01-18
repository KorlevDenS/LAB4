package Lab4;

public class Song extends Knowledge {
    private final String songName;
    private final String author;
    private final String duration;
    private final String stile;


    public Song(String songName, String author, String stile, int duration) {
        super(songName + " " + author + " "
                + duration + " " + stile);
        this.songName = songName;
        this.author = author;
        this.stile = stile;
        this.duration = duration + " sec.";
    }

    public Song(String songName, String author) {
        super(songName + " " + author);
        this.songName = songName;
        this.author = author;
        this.stile = "mixed";
        this.duration = "unknown";
    }

    public String getSongName() {
        return this.songName;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getStile() {
        return this.stile;
    }

    public String getDuration() {
        return this.duration;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass())
            return false;
        Song otherObj = (Song) obj;
        return songName.equals(otherObj.songName)
                && author.equals(otherObj.author)
                && duration.equals(otherObj.duration)
                && stile.equals(otherObj.stile);
    }

    public int hashCode() {
        return this.songName.hashCode()
                + 31 * this.author.hashCode()
                + 31 * this.duration.hashCode()
                + 31 * this.stile.hashCode();
    }

    public String toString() {
        return getClass().getName()
                + "[songName=" + songName
                + ";author=" + author
                + ";duration=" + duration
                + ";stile=" + stile
                + "]";
    }

}
