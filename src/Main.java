import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("jack","qwer13");
        map.put("john","zxc45");

        System.out.println("Orig: " + map);
        List<String> mergedString = mergeStrings(map);
        System.out.println("Merged: " + mergedString);

        Map<String, String> unmergedStrings = unmergedStrings(mergedString)

    }

    public static List<String> mergeStrings(Map<String, String> map) {
        List<String> result = new ArrayList<>();
        for (var str : map.entrySet()) {
            result.add(str.getKey() + ":" + str.getValue());
        }
        return result;
    }

    public static Map<String, String> unmergedStrings(List<String> mergedString) {
        List<String> result = new ArrayList<>();
        for (var str : map.entrySet()) {
            result.add(str.getKey() + ":" + str.getValue());
        }
        return result;
    }
}