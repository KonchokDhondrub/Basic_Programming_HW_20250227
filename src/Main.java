import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("jack","qwer13");
        map.put("john","zxc45");

        System.out.println("Orig: " + map);
        List<String> mergedString = mergeStrings(map);
        System.out.println("Merged: " + mergedString);

        mergedString.add("john:ееееее");
        mergedString.add("john:drgsgsdsd");
        Map<String, String> unmergedStrings = unmergedStrings(mergedString);
        System.out.println("unMerged: " + unmergedStrings);

        Map<String, List<String>> mergedListAndMap = mergerListInMap(unmergedStrings);
        System.out.println("Merged List in Map: " + mergedListAndMap);

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

            result.put(key, value==null ? newValue : value + "|" + newValue);
        }
        return result;
    }

    public static Map<String, List<String>> mergerListInMap(Map<String, String> map){
        Map<String, List<String>> result = new HashMap<>();
        for (var entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = Arrays.asList(entry.getValue().split("\\|"));
            result.put(key,value);
        }
        return result;
    }
}