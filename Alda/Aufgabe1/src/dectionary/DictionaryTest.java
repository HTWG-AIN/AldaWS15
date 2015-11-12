/*
 * Test der verscheidenen Dictionary-Implementierungen
 *
 * O. Bittel; 5.8.2015
 */
package dectionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DictionaryTest {

    public static void main(String[] args) {
        List<Dictionary<String, String>> dictList = Arrays.asList(
                new SortedArrayDictionary<>(),
                new HashDictionary<>(7),
                new BinaryTreeDictionary<>(),
                new MapDictionary<>(new HashMap<>())
        );

        for (Dictionary<String, String> dict : dictList) {
            System.out.println("teste " + dict.getClass());
            System.out.println(dict.insert("gehen", "go") == null);
            System.out.println(dict.insert("gehen", "walk").equals("go"));
            System.out.println(dict.search("gehen").equals("walk"));
            System.out.println(dict.remove("gehen").equals("walk"));
            System.out.println(dict.remove("gehen") == null);
        }
    }
}
