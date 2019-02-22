package helpers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader {

    public static String[] readFile(String path) {
        ArrayList<String> list = new ArrayList<>();
        try {
            path = new File("").getAbsolutePath().concat(path);
            FileReader fReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fReader);
            String line = "";
            int index = 0;
            while ((line = reader.readLine()) != null && index < 2000000000) {
                list.add(line.toLowerCase());
                index++;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return list.toArray(new String[list.size()]);
    }

    public static String[] cleanWords(String[] strings) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            String[] words = cleanLine(strings[i]);
            for (String s : words) {
                if (s != null && s.length() > 0) {
                    list.add(s);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static String[] cleanLine(String string) {
        String replaced = string.replaceAll("\\p{Punct}", "");
        return replaced.split(" ");
    }

}
