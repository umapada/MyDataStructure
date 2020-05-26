package Graph;

public class TEST1 {

	public static void main(String[] args) {
		
		//String input = "ACTACGTTTAGTAACTCGTCT";
		String input = "AACGTCCCGTTTAAGGGGAGTGGAGTGGTTCCAGTAAACTAATTGGGGCGTAGTCCCCGGTTAAGGTTAATTCCAAAAGGCCGGAAACTTTTTACTCCCCAATTAACCAA";
		char inputChar[] = input.toCharArray();
		String a = "ACT";
		String b = "AGT";
		String c = "CGT";
		boolean found = false;
		
		//String pp = "CGTTTTAGTTTTAGTTTTTTTAGTTTTACT";
		int count = 0;
		outer:
		for (int i=0; i<inputChar.length ; i++) {
			
			//System.out.println("i= " + i);
			for (int j=0; j< inputChar.length - 8-i; j++) {
				count = j+(9+i);
				//System.out.println(count);
				String temp = input.substring(j, count);
				//if(temp.length() == 30) {
				//	System.out.println(temp);
				//}
				//System.out.println(temp);
				//if(pp.equals(temp)) {
					//System.out.println(temp);
				//}
				if(temp.contains(a) && temp.contains(b) && temp.contains(c)) {
				 System.out.println("Found =" + temp);
				 found = true;
				break outer;
				}

			}

		}
		
		
		
	}
}
