package hw8;

import java.util.Iterator;
import java.util.List;

public class Utils {
    public static String valuesAsString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            sb.append(str);
            if (iter.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
