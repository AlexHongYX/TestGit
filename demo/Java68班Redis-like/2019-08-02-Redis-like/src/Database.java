import java.util.*;

public class Database {
    private static Database instance = new Database();
    public static Database getInstance() {
        return instance;
    }

    // string 类型
    private Map<String, String> strings;
    // hash 类型
    private Map<String, Map<String, String>> hashes;
    // list 类型
    private Map<String, List<String>> lists;
    // set 类型
    private Map<String, Set<String>> sets;
    // zset 类型
    private Map<String, LinkedHashSet<String>> zsets;

    private Database() {
        strings = new HashMap<>();
        hashes = new HashMap<>();
        lists = new HashMap<>();
        sets = new HashMap<>();
        zsets = new HashMap<>();
    }

    public List<String> getList(String key) {
        List<String> list =  lists.get(key);
        if (list == null) {
            list = new ArrayList<>();
            lists.put(key, list);
        }

        return list;
    }
}
