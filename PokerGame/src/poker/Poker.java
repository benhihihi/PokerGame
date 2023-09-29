package poker;

public class Poker {
	// Sorting
	public static void sortCard(String cards[]) {
		if (cards == null) return;
	    for (int i = 0; i < cards.length; i++) {
	        for (int j = 0; j < cards.length - i - 1; j++) {
	            if (cards[j].charAt(1) > cards[j + 1].charAt(1)) {
	                String temp = cards[j];
	                cards[j] = cards[j + 1];
	                cards[j + 1] = temp;
	            }
	        }
	    }
	}
	
	
	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isFullHouse(String cards[], int n) {
		sortCard(cards);
		return isThreeOfaKind(cards, n) && isTwoPairs(cards, n);
	}

	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isThreeOfaKind(String cards[], int n) {
		int count = 0;
		for (int i=0; i<n-2; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1) &&
					cards[i+1].charAt(1) == cards[i+2].charAt(1)) {
				count++;
				
			}		
		}

		if(count == 1) {
			return true;
		}
		return false;
		
//		for (int i=0; i<n-2; i++) {
//			if (cards[i].charAt(1) == cards[i+1].charAt(1) &&
//					cards[i+1].charAt(1) == cards[i+2].charAt(1))
//					return true;
//		}
//
//		return false;
		
	}

	// Precondition: A hand of n cards have been sorted by card number.
	public boolean isTwoPairs(String cards[], int n) {
		int count = 0;
		for (int i=0; i<n-1; i++) {
			if (cards[i].charAt(1) == cards[i+1].charAt(1)) {
				count++;
				i++;
			}
		}
		if (count == 2)
			return true;
		else
			return false;
	}
	
	public boolean isFourOfKind(String cards[], int n) {
		sortCard(cards);
		for(int i = 0; i < 2; i++) {
			if(cards[i].charAt(1) == cards[i+1].charAt(1) && cards[i].charAt(1) == cards[i+2].charAt(1) && cards[i].charAt(1) == cards[i+3].charAt(1)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		System.out.println(new Poker().isFullHouse(
			new String[] {"C2", "D2", "H2", "S3", "S4"}, 5));

	}
}
// end of Poker.java
