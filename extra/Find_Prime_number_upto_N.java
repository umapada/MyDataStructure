package extra;

class Find_Prime_number_upto_N{

    public int countPrimes(int n) {
        int count = 0;
        if(n<=2){
            return 0;
        }else if(n==3){
            return 1;
        } else if (n==4){
            return 2;
        }
        else{
            count = 2;
            boolean found = false;
            for(int i=4; i< n; i++){    
                found = true;
                if (i % 2 == 0 || i % 3 == 0){
                    continue;
                }
                
                for (int j = 5; j * j <= i; j = j + 6) {
                    if (i % j == 0 || i % (j + 2) == 0) {
                        found = false;
                        break;
                    }
                }
                if(found)
                count ++;
           }
        }
        
        return count;
    }


}
