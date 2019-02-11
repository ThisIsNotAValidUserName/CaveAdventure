package Main.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> loadFile(String fileDir) {
        List<String> strings = new ArrayList<>();
        File file = new File(fileDir);
        try {
            InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String str;
            while ((str = br.readLine()) != null) {
                strings.add(str);
            }
            br.close();
            isr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

}
