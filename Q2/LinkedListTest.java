public class Q2_updated {

	public static void main(String[] args) {

		LinkedList<String> alphabet;
		alphabet = new LinkedList<String>();

		alphabet.add("alpha");
		alphabet.add("bravo");
		alphabet.add("charlie");
		alphabet.add("delta");
		alphabet.add("echo");

		System.out.println("\nTesting Q2 Part 1");
		Iterator<String> i;
		i = alphabet.iterator();

		while (i.hasNext()) {
			System.out.println(i.nextIndex());
			System.out.println(i.next());
		}
		System.out.println(i.nextIndex());

		System.out.println("\nTesting Q2 Part 2");
		Iterator<String> j;
		j = alphabet.iterator(3);
		while (j.hasNext()) {
			System.out.println(j.nextIndex());
			System.out.println(j.next());
		}


		System.out.println("\nTesting Q2 Part 3");
		Iterator<String> y;
		y = alphabet.iterator(1);
		Iterator<String> z = alphabet.iterator(y);

		while (z.hasNext() && y.hasNext()) {
			System.out.println(z.nextIndex());
			System.out.println(z.next());
			System.out.println(y.nextIndex());
			System.out.println(y.next());
		}
		

	}
}