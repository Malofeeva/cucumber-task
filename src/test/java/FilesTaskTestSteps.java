import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesTaskTestSteps {

    private static final String testDirectory = FilesTaskTestSteps.class.getProtectionDomain().getCodeSource().getLocation().getPath().substring(1).replace("/", "\\");

    @Дано("У меня есть объект типа FilesTask, где fileName равен {string}")
    public void уМеняЕстьОбъектТипаFilesTaskГдеFileNameРавен(String fileName) {
        FilesTaskTestContext.filePath = Paths.get(testDirectory, fileName);
        FilesTaskTestContext.testInstance = new FilesTask(fileName, testDirectory);
        System.out.println("Тестовая директория: " + testDirectory);
        System.out.println("Имя файла: " + fileName);
        System.out.println("Создание объекта FilesTask");
    }

    @Когда("Я вызываю метод создания файла")
    public void яВызываюМетодСозданияФайла() throws IOException {
        FilesTaskTestContext.testInstance.createFile();
        System.out.println("Создание файла");
    }

    @Тогда("Файл создается")
    public void файлСоздается() throws IOException {
        Assertions.assertTrue(Files.exists(FilesTaskTestContext.filePath));
        Files.delete(FilesTaskTestContext.filePath);
        System.out.println("Файл успешно создан");
    }
}
