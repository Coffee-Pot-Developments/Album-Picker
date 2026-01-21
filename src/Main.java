import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Path root = Path.of("");
        int numberOfAlbums = 10;
        AlbumScanner scanner = new AlbumScanner();
        AlbumSizeCalculator sizeCalc = new AlbumSizeCalculator();
        RandomAlbumPicker picker = new RandomAlbumPicker();
        List<Path> albumPaths = scanner.scan(root);
        List<Album> albums = new ArrayList<>();
        for (Path p : albumPaths) {
            long size = sizeCalc.calculateSize(p);
            albums.add(new Album(p, size));
        }
        List<Album> selected = picker.pickRandom(albums, numberOfAlbums);
        selected.forEach(System.out::println);
    }
}