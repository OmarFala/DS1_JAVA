import java.util.HashMap;

public class processor extends Thread{
	
	private MyBuffer buff;
	private String Pname;
	private HashMap<String, Integer> wordCounts;
	
	public processor(String threadName, MyBuffer buff) {
		super();
		this.Pname = threadName;
		this.wordCounts = new HashMap<String, Integer>();
		this.buff = buff;
	}

	public void processe() throws Exception {
		String string = buff.getWord();

		if (!wordCounts.containsKey(string))
			wordCounts.put(string, 1);
		else
			wordCounts.put(string, wordCounts.get(string) + 1);
	}

	public HashMap<String, Integer> getWordsCounts() {
		return wordCounts;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		try {
			while (true && Lecteur.EndFile != -1) {
				processe();

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}

}
