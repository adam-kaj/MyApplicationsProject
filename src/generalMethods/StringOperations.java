package generalMethods;

import java.util.ArrayList;

import static generalMethods.ListOperations.stringToList;

public class StringOperations {

    public static String randomCharacterFromString(String string) {
        ArrayList<Object> list = stringToList(string);
        return String.valueOf(list.get((int) (Math.random() * string.length())));
    }
}
