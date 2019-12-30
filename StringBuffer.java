import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class StringBuffer {

	static ArrayDeque<String> deque;
	static int size; // buffer'ýn size'ý 5 olacak

	StringBuffer(int n) { 
		deque = new ArrayDeque<>();
		size = n;
	}

	public void guncelle(String x) { // dizinin her bir elemaný x
		if (deque.size() == size) {
			String sil = deque.removeLast();
		} else {

			int index = 0, i = 0;

			Iterator<String> iterator = deque.iterator();
			while (iterator.hasNext()) { // hala okunacak string varsa
				if (iterator.next() == x) {
					System.out.println("Iterator: " + iterator);
					index = i;

					break;
				}
				i++;
			}
			deque.remove(index);
		}
		deque.push(x); 
	}

	public void bellekGoster() {
		Iterator<String> bellekIterator = deque.iterator();
		while (bellekIterator.hasNext()) {
			System.out.print(bellekIterator.next() + "   "); // en yeni 5 eleman gösterildi
		}
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Cümle giriniz: ");
		String cumle = input.nextLine();
		String[] string = cumle.split(" ");

		for (int i = 0; i < string.length; i++) {
			System.out.println((i + 1) + "." + string[i]);
		}
		System.out.println();

		StringBuffer stringBuffer = new StringBuffer(5); // 5 kelimelik buffer

		for (String buffer : string) {

			stringBuffer.guncelle(buffer);
		}

		System.out.println("Güncel kelimeler: ");
		stringBuffer.bellekGoster();
	}

}