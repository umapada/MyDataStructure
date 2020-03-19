package DROP_BOX;

import java.util.*;

/*
Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a
special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences
that have prefix the same as the part of sentence already typed. Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have
the same degree of hot, you need to use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, then just return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Your job is to implement the following functions:

The constructor function:

AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is
a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your
system should record these historical data.

Now, the user wants to input a new sentence. The following function will provide the next character the user types:

List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case
letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded
in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.


Example:
Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
The system have already tracked down the following sentences and their corresponding times:
"i love you" : 5 times
"island" : 3 times
"ironman" : 2 times
"i love leetcode" : 2 times
Now, the user begins another search:

Operation: input('i')
Output: ["i love you", "island","i love leetcode"]
Explanation:
There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree.
Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only
need to output top 3 hot sentences, so "ironman" will be ignored.

Operation: input(' ')
Output: ["i love you","i love leetcode"]
Explanation:
There are only two sentences that have prefix "i ".

Operation: input('a')
Output: []
Explanation:
There are no sentences that have prefix "i a".

Operation: input('#')
Output: []
Explanation:
The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following
input will be counted as a new search.
 */

public class SearchAutocompleteSystem {

    Trie trie;
    StringBuilder sb;
    int count;
    public SearchAutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        trie.addListOfWords(sentences, times);
        sb = new StringBuilder();
        count = 0;
    }

    public List<String> input(char c) {

        if(c!='#') {
            sb.append(c);
            return trie.get(c);
        } else {
            count++;
            trie.addListOfWords(new String[]{sb.toString()}, new int[]{1});
            trie.resetTempRoot();
            sb = new StringBuilder();
            return new ArrayList<>();
        }
    }

    class TrieNode {
        Map<Character, TrieNode> map;
        public Map<String, Integer> wordFrequency;

        TrieNode(Map<Character, TrieNode> map) {
            this.map = map;
            wordFrequency = new TreeMap<>();
        }


        public TrieNode add(char c, String word, Integer frequency) {
            if(!map.containsKey(c)) {
                map.put(c,new TrieNode(new TreeMap<>()));
            }
            TrieNode result = map.get(c);
            if(result.wordFrequency.containsKey(word)) {
                result.wordFrequency.put(word, result.wordFrequency.get(word)+1);
            } else {
                result.wordFrequency.put(word, frequency);
            }
            return result;
        }

        public TrieNode get(char c) {
            return map.get(c);
        }
    }
    class Trie {
        TrieNode root;
        public TrieNode tempRoot;

        Trie() {
            root = new TrieNode(new TreeMap<>());
            tempRoot = root;
        }

        public void addListOfWords(String[] sentences, int [] times) {

            for(int j = 0;j<sentences.length;j++) {
                TrieNode temp = root;
                for(int i=0;i<sentences[j].length();i++) {
                    temp = temp.add(sentences[j].charAt(i), sentences[j], times[j]);
                }
            }
        }

        public void resetTempRoot() {
            tempRoot = root;
        }

        public List<String> get(char c) {
            if(tempRoot == null) return new ArrayList<>();
            tempRoot = tempRoot.get(c);
            if(tempRoot == null) return new ArrayList<>();
            List<String> result = new ArrayList<>();
            Queue<String> pq = new PriorityQueue<>(new Comparator<String>(){

                public int compare(String s1, String s2) {
                    int diff = tempRoot.wordFrequency.get(s2) - tempRoot.wordFrequency.get(s1);
                    if(diff==0) return s1.compareTo(s2);
                    return diff;
                }
            });

            for(String key: tempRoot.wordFrequency.keySet()) {
                pq.offer(key);
            }
            while(!pq.isEmpty()) {
                result.add(pq.poll());
                if(result.size()==3) return result;
            }
            return result;
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */



// Another Trie implementation

class Node {
    String sentence;
    int times;

    Node(String st, int t) {
        sentence = st;
        times = t;
    }
}

class Trie {
    int times;
    Trie[] branches = new Trie[27];
}

class AutocompleteSystem {
    private Trie root;
    private String cur_sent = "";

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], times[i]);
        }
    }

    private int toInt(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    private void insert(Trie t, String s, int times) {
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[toInt(s.charAt(i))] == null) {
                t.branches[toInt(s.charAt(i))] = new Trie();
            }
            t = t.branches[toInt(s.charAt(i))];
        }
        t.times += times;
    }

    private List<Node> lookup(Trie t, String s) {
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[toInt(s.charAt(i))] == null) {
                return new ArrayList<>();
            }
            t = t.branches[toInt(s.charAt(i))];
        }
        traverse(s, t, list);
        return list;
    }

    private void traverse(String s, Trie t, List<Node> list) {
        if (t.times > 0) list.add(new Node(s, t.times));
        for (char i = 'a'; i <= 'z'; i++) {
            if (t.branches[i - 'a'] != null) {
                traverse(s + i, t.branches[i - 'a'], list);
            }
        }
        if (t.branches[26] != null) {
            traverse(s + ' ', t.branches[26], list);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            insert(root, cur_sent, 1);
            cur_sent = "";
        } else {
            cur_sent += c;
            List<Node> list = lookup(root, cur_sent);
            Collections.sort(
                    list,
                    (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            for (int i = 0; i < Math.min(3, list.size()); i++) res.add(list.get(i).sentence);
        }
        return res;
    }
}