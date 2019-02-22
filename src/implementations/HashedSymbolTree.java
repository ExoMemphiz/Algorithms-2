package implementations;

import java.util.HashMap;

public class HashedSymbolTree {

    private HashMap<String, Integer> map;

    public HashedSymbolTree() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        if (!map.containsKey(word)) {
            map.put(word, 1);
        } else {
            map.put(word, map.get(word) + 1);
        }
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }
}
