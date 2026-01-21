import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AlbumScanner {

    public List<Path> scan(Path root) throws IOException {
        List<Path> albums = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(root, Files::isDirectory)) {
            for (Path p : stream) {
                albums.add(p);
            }
        }
        return albums;
    }
}