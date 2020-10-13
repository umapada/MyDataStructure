package TEST;

class MDSP {

    public int findMinimumDeletions(String st) {
        // subtracting the length of Longest Palindromic Subsequence from the length of
        // the input string to get minimum number of deletions
        int a = findLPSLength(st, 0, st.length()-1);
        System.out.println(" MIN = " + a);
        return st.length() - a;
    }

    public int findLPSLength(String st, int s, int e) {
        if(s >= e) return 0;

        if(st.charAt(s) == st.charAt(e)) return findLPSLength(st, s+1, e-1);

        int d1 = 1+ findLPSLength(st, s+1, e);
        int d2 = 1+ findLPSLength(st, s, e-1);

        return Math.min(d1, d2);

    }

    public static void main(String[] args) {
        MDSP mdsp = new MDSP();
        System.out.println(mdsp.findMinimumDeletions("abdbca"));
        System.out.println(mdsp.findMinimumDeletions("cddpd"));
         System.out.println(mdsp.findMinimumDeletions("pqr"));
    }
}
