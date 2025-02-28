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

        System.out.println("Merged List in Map 1: " + mergerListInMap(unmergedStrings));
        System.out.println("Merged List in Map 2: " + mergerListInMap2(mergedString));
        System.out.println("Merged List in Map 3: " + mergerListInMap3(mergedString));
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
            result.put(entry.getKey(),
                    Arrays.asList(entry.getValue().split("\\|")));
        }
        return result;
    }

    public static Map<String, List<String>> mergerListInMap2(List<String> list){
        Map<String, List<String>> result = new HashMap<>();
        for (var str : list) {
            String[] split = str.split(":");
            String key = split[0];
            String newValue = split[1];

            List<String> valueList = new ArrayList<>();
            List<String> oldValueList = result.putIfAbsent(key, valueList);
            if (oldValueList == null){
                valueList.add(newValue);
            } else {
                oldValueList.add(newValue);
            }
        }
        return result;
    }

    public static Map<String, List<String>> mergerListInMap3(List<String> list){
        Map<String, List<String>> result = new HashMap<>();
        for (var str : list) {
            String[] split = str.split(":");
            String key = split[0];
            String newValue = split[1];

            List<String> valueList = result.getOrDefault(key, new ArrayList<>());
            valueList.add(newValue);
            result.put(key, valueList);
        }
        return result;
    }
}