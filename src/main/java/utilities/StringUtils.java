package utilities;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    private StringUtils(){}

    public static List<String> toLower(String[] arr) {
        List<String> lowerList = new ArrayList<>();
        for (String s : arr) {
            lowerList.add(s.toLowerCase());
        }
        return lowerList;

    }
}
