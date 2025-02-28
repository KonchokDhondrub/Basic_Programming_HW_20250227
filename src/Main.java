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

        mergedString.add("john:ееееее");
        Map<String, String> unmergedStrings = unmergedStrings(mergedString);
        System.out.println("unMerged: " + unmergedStrings);

    }

    public static List<String> mergeStrings(Map<String, String> map) {
        List<String> result = new ArrayList<>();
        for (var str : map.entrySet()) {
            result.add(str.getKey() + ":" + str.getValue());
        }
        return result;
    }

    public static Map<String, String> unmergedStrings(List<String> mergedString) {
        Map<String, String> result = new HashMap<>();
        for (var str : mergedString) {
            String[] split = str.split(":");
            String key = split[0];
            String newValue = split[1];
            String value = result.get(key);

            result.put(key, value==null? newValue : value + "," + newValue);
        }
        return result;
    }
}