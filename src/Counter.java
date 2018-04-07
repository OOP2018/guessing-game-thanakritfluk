/**
 * A simple counter.
 */

public class Counter extends java.util.Observable {
	private int count;
	
	public Counter() {
		this.count = 0;
	}
	
	public void add(int howmuch) {
		count += howmuch;
		// Its like if the Bank sends you an SMS whenever money
		// is deposited in your account. If the SMS just says 
		// "you received a deposit" then you need to login to check it.
		// If the SMS says "you received 5,000 Bt from xxx" then you
		// have everything you need.
		setChanged();
		notifyObservers();
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
