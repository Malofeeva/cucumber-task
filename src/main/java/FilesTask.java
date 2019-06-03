import java.io.IOException;
import java.nio.file.*;

public class FilesTask {

    private final String fileName;
    private final String filePath;

    public FilesTask(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;
    }

    public void createFile() throws IOException {
        Files.createFile(Paths.get(filePath, fileName));
    }

    public String getPath() {
        return filePath + fileName;
    }

}
