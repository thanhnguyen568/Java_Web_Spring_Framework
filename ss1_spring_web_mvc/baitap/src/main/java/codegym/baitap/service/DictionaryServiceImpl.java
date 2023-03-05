package codegym.baitap.service;

import codegym.baitap.model.Dictionary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictionaryServiceImpl {
    private static Map<String, Dictionary> dictionaries = new HashMap<>();

    static {
        dictionaries.put("hello", new Dictionary("hello", "xin chao"));
        dictionaries.put("dog", new Dictionary("dog", "con cho"));
        dictionaries.put("cat", new Dictionary("cat", "con meo"));
        dictionaries.put("ahihi", new Dictionary("ahihi", "do cho"));
        dictionaries.put("goodbye", new Dictionary("goodbye", "tam biet"));
        dictionaries.put("rat", new Dictionary("rat", "con chuot"));
    }

    public List<Dictionary> findAll() {
        return new ArrayList<>(dictionaries.values());
    }
}
