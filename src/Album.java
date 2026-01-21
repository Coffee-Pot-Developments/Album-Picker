import java.nio.file.Path;

public class Album {
    private final Path path;
    private final long sizeBytes;

    public Album(Path path, long sizeBytes) {
        this.path = path;
        this.sizeBytes = sizeBytes;
    }

    public Path getPath() {
        return path;
    }

    public long getSizeBytes() {
        return sizeBytes;
    }

    public long getSizeMB() {
        return sizeBytes / (1024 * 1024);
    }

    @Override
    public String toString() {
        return path.getFileName() + " (" + getSizeMB() + " MB)";
    }
}