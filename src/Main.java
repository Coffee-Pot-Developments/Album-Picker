import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        String folderPath = "";
        int numberOfAlbums = 50;
        int maxsizeMB= 1000;

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path file) throws IOException {
                return (Files.isDirectory(file));
            }
        };
        Path dir = FileSystems.getDefault().getPath(folderPath);
        List<String> albums = new ArrayList<String>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, filter)) {
            for (Path path : stream) {
                albums.add(path.getFileName().toString());
            }
            long countroundmb = 0;
            Random rand = new Random();
            for (int i = 0; i < numberOfAlbums; i++) {
                int randomIndex = rand.nextInt(albums.size());
                Path randomPath = dir.resolve(albums.get(randomIndex));
                long albumSizeBytes = getFolderSize(randomPath);
                double albumSizeMB = (double) albumSizeBytes / (1024 * 1024); // Convert bytes to megabytes
                long roundedSizeMB = Math.round(albumSizeMB); // Round to the nearest whole number
                countroundmb += roundedSizeMB;

                if (countroundmb > maxsizeMB) {
                    System.out.print("This is over the maximum size");
                    //System.out.println(albums.get(randomIndex) + " - Size: " + roundedSizeMB + " MB");
                    break;

                } else {
                    System.out.println("Random Album: " + albums.get(randomIndex) + " - Size: " + roundedSizeMB + " MB");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculate the total size of a folder and all its contents.
     *
     * @param  folder   the path to the folder
     * @return          the total size of the folder in bytes
     */
    private static long getFolderSize(Path folder) throws IOException {
        return Files.walk(folder)
                .filter(Files::isRegularFile)
                .mapToLong(p -> {
                    try {
                        return Files.size(p);
                    } catch (IOException e) {
                        return 0L;
                    }
                })
                .sum();
    }
}