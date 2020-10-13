package CoinChange;

class CoinChange1 {

    public int countChange(int[] denominations, int total) {
        int result = this.countChangeRecursive(denominations, total, 0);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    private int countChangeRecursive(int[] denominations, int total, int currentIndex) {
        // base check
        if (total == 0)
            return 0;

        if(denominations.length == 0 || currentIndex >= denominations.length)
            return Integer.MAX_VALUE;

        // recursive call after selecting the coin at the currentIndex
        // if the coin at currentIndex exceeds the total, we shouldn't process this
        int count1 = Integer.MAX_VALUE;
        if( denominations[currentIndex] <= total ) {
            int res = 0;
             res = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex);
            if(res != Integer.MAX_VALUE){
                count1 = res + 1;
            }
        }

        // recursive call after excluding the coin at the currentIndex
        int count2 = countChangeRecursive(denominations, total, currentIndex + 1);

        return Math.min(count1, count2);
    }

    public static void main(String[] args) {
        CoinChange1 cc = new CoinChange1();
        int[] denominations = {1, 2, 3};
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[]{3, 5};
        System.out.println(cc.countChange(denominations, 7));
    }
}