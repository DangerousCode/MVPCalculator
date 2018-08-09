import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        //Taking a list of current files
        File folder = new File(System.getProperty("user.dir") + "/src/resources");
        List<File> listOfFiles = Arrays.asList(folder.listFiles());
        FileManager fileManager = new FileManager(listOfFiles);

        if (!fileManager.validFileExpressions()) {

            System.out.println("Wrong file format");
            return;

        }

        fileManager.splitFilesBySport().forEach((sport, matches) -> {

            League league = new League(sport);
            league.initMatches(matches);
            league.generateMVP();
            fileManager.writeMVP(league.getMvp());

        });

    }
}
