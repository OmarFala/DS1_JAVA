import java.util.LinkedList;

public class MyBuffer {
	
	private LinkedList<String> data = new LinkedList<String>();
	private int size = 0;
	private int maxSize;
	boolean setValue = true;
	
	
	public MyBuffer(int size) {
		this.maxSize = size;
		this.data = new LinkedList<String>();
	}
	
	public LinkedList<String> getData() {
		return data;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public synchronized void addWord(String e) throws InterruptedException {
		if (!setValue || size >= maxSize) {
 			wait();
		}
		System.out.println("- addWord: " + e);
		data.add(e);
		size++;
		setValue = false;
		notify();

	}

	public synchronized String getWord() throws InterruptedException {
		if (setValue || size <= 0) {
			wait();
		}		
		String string = data.get(size - 1);
		System.out.println("- getWord: " + string);
		data.remove(--size);
		setValue = true;
		notify();
		return string;
	}

	public LinkedList<String> getWords() {
		return this.data;
	}
	
	

}
