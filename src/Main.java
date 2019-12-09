import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException{
		// TODO Auto-generated method stub
		
		MyBuffer myBuffer = new MyBuffer(10);
		Lecteur lecteur_thread_1 = new Lecteur("fichier1.txt", "Lecteur", myBuffer);
		processor prcessor_thread_1 = new processor("fichier2.txt", myBuffer);

		lecteur_thread_1.start();
		prcessor_thread_1.start();

		lecteur_thread_1.join();
		prcessor_thread_1.join();

		

		System.out.println("------------------prcessor wordsCounts-------------");
		HashMap<String, Integer> hashMap = prcessor_thread_1.getWordsCounts();

		System.out.println("Word counting");

		Set<String> set = hashMap.keySet();
		Iterator<String> iterator = set.iterator();

		while (iterator.hasNext()) {
			String string = iterator.next();
			System.out.println(string + "// nombre d'occurrence :" + hashMap.get(string));
		}


	}

}
