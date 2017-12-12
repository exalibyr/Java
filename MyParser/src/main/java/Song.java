import javax.xml.bind.annotation.*;
@XmlRootElement(name = "Song")
@XmlAccessorType(XmlAccessType.FIELD)
public class Song {
    @XmlElement(name="Title")
    private String title;
    @XmlElement(name="Author")
    private String author;
    @XmlElement(name="Album")
    private String album;
    @XmlElement(name="Duration")
    private String duration;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Song{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author=").append(author);
        sb.append(", album=").append(album);
        sb.append(", duration=").append(duration);
        sb.append('}');
        return sb.toString();
    }
}
