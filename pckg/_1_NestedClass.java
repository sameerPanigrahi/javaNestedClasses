package pckg;

//using inner class, print output of even indices of an array
public class Example1 {

	// New!!! Hmmm can be declared in a class but not inside a method or inner class
	//interfaces can only be defined in a top-level class, in an interface or in a static context
	interface DataStructureIterator extends java.util.Iterator<Integer> {
	}

	// create an array
	public int[] arrayOfInts = new int[15];

	// constructor
	public Example1() {
		for (int i = 0; i < arrayOfInts.length; i++) {
			arrayOfInts[i] = i;
		}
	}

	public void printEven() {

		DataStructureIterator ei = this.new EvenIterator();

		while (ei.hasNext()) {
			System.out.println(ei.next());
		}

	}

	//check DataStructureInteger interface declared above
	private class EvenIterator implements DataStructureIterator {

		int next = 0;

		@Override
		public boolean hasNext() {
			// note that you have access to outer class arrayOfInt, use it to compute
			// hasNext()
			return next <= arrayOfInts.length;
		}

		@Override
		public Integer next() {
			Integer retValue = Integer.valueOf(arrayOfInts[next]);
			next = next + 2;
			return retValue;
		}

	}

	public static void main(String args[]) {
		Example1 ex1 = new Example1();
		ex1.printEven();
	}
}