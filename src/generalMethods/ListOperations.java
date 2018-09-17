package generalMethods;

import java.util.ArrayList;
import java.util.List;

public class ListOperations {
    public static String listToString(ArrayList<Object> list) {
        String string = "";
        for (int i = 0; i < list.size(); i++) {
            string += String.valueOf(list.get(i));
        }
        return string;
    }


    public static String listToString(List<Object> list) {
        String string = "";
        for (int i = 0; i < list.size(); i++) {
            string += String.valueOf(list.get(i));
        }
        return string;
    }

    public static ArrayList<Object> stringToList(String string) {
        ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < string.length(); i++) {
            list.add((String) string.substring(i,i+1));
        }
        return list;
    }
}
