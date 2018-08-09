import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        //Taking a list of current files
        File folder = new File(System.getProperty("user.dir") + "/src/resources");
        File[] listOfFiles = folder.listFiles();
        List<File> basketballFiles = new ArrayList<>();
        List<File> handballFiles = new ArrayList<>();
        FileManager fileManager = new FileManager();

        if (fileManager.validFileExpressions(Arrays.asList(listOfFiles))) {

            System.out.println("Wrong file format");
            return;

        }

        //Splitting files into 2 different lists
        for (int i = 0; i < listOfFiles.length; i++) {

            //Validating if is a file.
            if (listOfFiles[i].isFile()) {

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(listOfFiles[i]));
                    String matchType = reader.readLine();

                    if (matchType.equals("basketball")) {
                        basketballFiles.add(listOfFiles[i]);
                    } else if (matchType.equals("handball")) {
                        handballFiles.add(listOfFiles[i]);
                    } else {
                        System.out.println("File: " + listOfFiles[i].getName() + "Not a correct match type, reading next file.");
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        if (basketballFiles.size() != 0) {

            League league = new League('b');
            league.initMatches(basketballFiles);
            league.generateMVP();
            fileManager.writeMVP(league.getMvp());
        }

        if (handballFiles.size() != 0) {

            League league = new League('h');
            league.initMatches(handballFiles);
            league.generateMVP();
            fileManager.writeMVP(league.getMvp());
        }

    }
}
