import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name="Music")
@XmlAccessorType(XmlAccessType.FIELD)
public class Music {

    @XmlElement(name="Song")
    private List<Song> music;

    public List<Song> getCustomerList() {
        return music;
    }

    public void setCustomerList(List<Song> music) {
        this.music = music;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Music{");
        sb.append("Songs=").append(music);
        sb.append('}');
        return sb.toString();
    }
}
