import java.util.Collections;
import java.util.List;

public class RandomAlbumPicker {

    public List<Album> pickRandom(List<Album> albums, int count) {
        Collections.shuffle(albums);
        return albums.subList(0, Math.min(count, albums.size()));
    }
}
