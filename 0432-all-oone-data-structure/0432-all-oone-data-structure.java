import java.util.*;

class AllOne {
    private Map<String, Integer> map;
    private TreeMap<Integer, Set<String>> countMap;

    public AllOne() {
        map = new HashMap<>();
        countMap = new TreeMap<>();
    }

    public void inc(String key) {
        int count = map.getOrDefault(key, 0);
        if (count > 0) {
            countMap.get(count).remove(key);
            if (countMap.get(count).isEmpty()) {
                countMap.remove(count);
            }
        }

        count++;
        map.put(key, count);
        countMap.computeIfAbsent(count, k -> new HashSet<>()).add(key);
    }

    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }

        int count = map.get(key);
        countMap.get(count).remove(key);
        if (countMap.get(count).isEmpty()) {
            countMap.remove(count);
        }

        if (count == 1) {
            map.remove(key);
        } else {
            count--;
            map.put(key, count);
            countMap.computeIfAbsent(count, k -> new HashSet<>()).add(key);
        }
    }

    public String getMaxKey() {
        return countMap.isEmpty() ? "" : countMap.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        return countMap.isEmpty() ? "" : countMap.firstEntry().getValue().iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
