package TEST;
/*
Given two very big file, which have more than billion lines. Print all the lines, which exists in both the files.
 */

/*
// Solution

Maintain a hash table with the following structure.

1. Use a Pair object with (line#, count) elements
2. Key of hash table would be the hashcode(something like MD5) of the string and value would be an arraylist of Pair objects.
[hashCodeOfString]-> ArrayList<Pair>()

For the first file, for each of the lines, compute the hashcode for key.. As it's value, store the corresponding line#
and the initial count set to 1.

For the second file, for each of the lines, compute the hash code and if the hashcode matches, from the Pair object,
match the current line with the corresponding lines from the 1st file. If the string comparison also matches increment
the count field of the pair object.

Iterate over the hash table and print those lines with count > 1

 */
public class ComparingTwoBigFiles {

}
