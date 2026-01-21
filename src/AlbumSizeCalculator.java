import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AlbumSizeCalculator {

    public long calculateSize(Path folder) throws IOException {
        try (var walk = Files.walk(folder)) {
            return walk
                    .filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try { return Files.size(p); }
                        catch (IOException e) { return 0L; }
                    })
                    .sum();
        }
    }
}