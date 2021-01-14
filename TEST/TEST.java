package TEST;

import java.util.*;

class TEST {
    public static void main(String[] nums) throws Exception{
        String [] words = {"sameer", "kumar", "sam", "kiran", "sanu"};

        Trie root = buildTrie(words);
        System.out.println(search(root,"same"));

        List<String> list = new ArrayList<>();
        findAll(root.children['a'], list);

        System.out.println(list);

        Map<String, Integer> map = new HashMap<>();

        map.put("abc", 30);
        map.put("sdfe", 70);
        map.put("wefg", 20);
        map.put("qwe", 100);
        map.put("dfhdf", 90);
        map.put("ydfg", 80);

        List<String> set = new ArrayList(map.keySet());

        Collections.sort(set, (x, y) -> map.get(y) - map.get(x));

        System.out.println(set.subList(0,1));








    }

    static void findAll(Trie root, List<String> list ){
        if(root == null) return;
        for(Trie t: root.children){
            if(t != null && t.word != null) list.add(t.word);
            findAll(t, list);
        }
    }

    static boolean search(Trie root, String word){
        char [] chrs = word.toCharArray();
        for(char c:chrs){
            if(root.children[c] != null){
                root = root.children[c];
            }else{
                return false;
            }
        }
        if(root != null && root.word != null) return true;


        return false;
    }

    static Trie buildTrie(String [] words){
        Trie root = new Trie();

        for(String w:words){
            Trie temp = root;
            char [] chrs = w.toCharArray();
            for(char c:chrs){
               if(temp.children[c] == null){
                   Trie node = new Trie();
                   temp.children[c] = node;
               }
               temp = temp.children[c];
            }
            temp.word = w;
        }

        return root;
    }

}


class Trie{
    Trie [] children = new Trie[128];
    String word;
}







