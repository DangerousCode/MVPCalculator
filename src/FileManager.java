import java.io.*;
import java.util.*;

public class FileManager {

    private List<File> files;

    public FileManager(List<File> files) {
        this.files = files;
    }

    public boolean validFileExpressions() {

        for (File file :
                files) {

            if (file.isFile()) {

                BufferedReader br = null;

                try {
                    br = new BufferedReader(new FileReader(file));
                    //We need to know what kind of match is
                    String matchType = br.readLine();

                    String currentLine;
                    while ((currentLine = br.readLine()) != null) {
                        String[] splitted = currentLine.split(";");

                        if (splitted.length < 8 || splitted.length > 8) {
                            br.close();
                            return false;


                        } else if (!splitted[3].equals("Team A")
                                && !splitted[3].equals("Team B")) {
                            br.close();
                            return false;

                        } else if (!splitted[5].matches("\\d+")) {
                            br.close();
                            return false;
                        } else if (!splitted[6].matches("\\d+")) {
                            br.close();
                            return false;
                        } else if (!splitted[7].matches("\\d+")) {
                            br.close();
                            return false;
                        }

                        switch (matchType) {
                            case "basketball":
                                if (!splitted[4].equals("G")
                                        && !splitted[4].equals("F")
                                        && !splitted[4].equals("C")) {
                                    br.close();
                                    return false;
                                }
                                break;
                            case "handball":
                                if (!splitted[4].equals("G")
                                        && !splitted[4].equals("F")) {
                                    br.close();
                                    return false;
                                }
                                break;
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Could not open writer");
                    }
                }

            }
        }
        return true;
    }

    public Map<String, List<File>> splitFilesBySport() {

        Map<String, List<File>> mapSportsSplitted = new HashMap<>();

        for (File file :
                files) {

            BufferedReader reader = null;

            try {
                reader = new BufferedReader(new FileReader(file));
                String matchType = reader.readLine();

                if (mapSportsSplitted.containsKey(matchType))
                    mapSportsSplitted.get(matchType).add(file);
                else
                    mapSportsSplitted.put(matchType, new ArrayList<File>(Arrays.asList(new File[]{file})));

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(reader != null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Reader is null");
                }
            }

        }

        return mapSportsSplitted;
    }

    public void writeMVP(Player mvp) {

        PrintWriter printWriter = null;

        try {

            if (mvp instanceof BasketPlayer) {
                printWriter = new PrintWriter(new FileOutputStream(new File("MVP Basket.txt")));
                printWriter.println(mvp.toString());
            } else if (mvp instanceof HandballPlayer) {
                printWriter = new PrintWriter(new FileOutputStream(new File(("MVP Handball.txt"))));
                printWriter.println(mvp.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }


    }

}
