package com.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a sorted dictionary of an alien language, find order of characters
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 * Examples:
 *
 * Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 * Output: Order of characters is 'b', 'd', 'a', 'c'
 * Note that words are sorted and in the given language "baa"
 * comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 *
 * Input:  words[] = {"caa", "aaa", "aab"}
 * Output: Order of characters is 'c', 'a', 'b'
 */

/**
 * The idea is to create a graph of characters and then find topological sorting of the created graph.
 * Following are the detailed steps.
 *
 * 1) Create a graph g with number of vertices equal to the size of alphabet in the given alien language.
 * For example, if the alphabet size is 5, then there can be 5 characters in words. Initially there are no edges in graph.
 *
 * 2) Do following for every pair of adjacent words in given sorted array.
 * …..a) Let the current pair of words be word1 and word2. One by one compare characters of both words and
 * find the first mismatching characters.
 * …..b) Create an edge in g from mismatching character of word1 to that of word2.
 *
 * 3) Print topological sorting of the above created graph.
 *
 * Following is the implementation of the above algorithm.
 */
//Progress => //4
//FB
 class AlienDictionary {

    // An array representing the graph as an adjacency list
    private final List<Integer>[] adjacencyList;

    AlienDictionary(int nVertices)
    {
        adjacencyList = new LinkedList[nVertices];
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++)
        {
            adjacencyList[vertexIndex] = new LinkedList<>();
        }
    }

    // function to add an edge to graph
    void addEdge(int startVertex, int endVertex)
    {
        adjacencyList[startVertex].add(endVertex);
    }

    private int getNoOfVertices()
    {
        return adjacencyList.length;
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int currentVertex, boolean[] visited, Stack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[currentVertex] = true;
        // Recur for all the vertices adjacent to this vertex
        for (int adjacentVertex : adjacencyList[currentVertex])
        {
            if (!visited[adjacentVertex])
            {
                topologicalSortUtil(adjacentVertex, visited, stack);
            }
        }
        // Push current vertex to stack which stores result
        stack.push(currentVertex);
    }

    // prints a Topological Sort of the complete graph
    void topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();
        // Mark all the vertices as not visited
        boolean[] visited = new boolean[getNoOfVertices()];
        for (int i = 0; i < getNoOfVertices(); i++)
        {
            visited[i] = false;
        }
        // Call the recursive helper function to store Topological
        // Sort starting from all vertices one by one
        for (int i = 0; i < getNoOfVertices(); i++)
        {
            if (!visited[i])
            {
                topologicalSortUtil(i, visited, stack);
            }
        }
        // Print contents of stack
        while (!stack.isEmpty())
        {
            System.out.print((char)('a' + stack.pop()) + " ");
        }
    }
}

 class OrderOfCharacters
{
    // This function finds and prints order of character from a sorted array of words.
    // alpha is number of possible alphabets starting from 'a'. For simplicity, this
    // function is written in a way that only first 'alpha' characters can be there
    // in words array. For example if alpha is 7, then words[] should contain words
    // having only 'a', 'b','c' 'd', 'e', 'f', 'g'

    private static void printOrder(String[] words, int alpha)
    {
        // Create a graph with 'aplha' edges
        AlienDictionary graph = new AlienDictionary(alpha);

        for (int i = 0; i < words.length - 1; i++)
        {
            // Take the current two words and find the first mismatching character
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++)
            {
                // If we find a mismatching character, then add an edge from character of word1 to that of word2
                if (word1.charAt(j) != word2.charAt(j))
                {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j)- 'a');
                    break;
                }
            }
        }
        // Print topological sort of the above created graph
        graph.topologicalSort();
    }
    // Driver program to test above functions
    public static void main(String[] args)
    {
        String[] words = {"caa", "aaa", "aab"};
        printOrder(words, 3);
    }
}
