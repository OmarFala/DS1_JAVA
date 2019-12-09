import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Lecteur extends Thread{
	private String filename;
	private String threadNme;
	private MyBuffer buff;
	FileInputStream fis;
	public static int EndFile = 6;

	public Lecteur(String filename, String threadNme, MyBuffer buff) throws IOException {
		this.filename = filename;
		this.threadNme = threadNme;
		this.buff = buff;
		fis = new FileInputStream(new File(filename));
	}

	public String readWord() throws IOException {

		String str = "";
		byte[] _byte_ = new byte[1];

		while ((EndFile = fis.read(_byte_)) != -1 && Character.toString((char) _byte_[0]).matches("\\w")) {

			str += Character.toString((char) _byte_[0]);

		}

		return str;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			while (true && EndFile != -1) {
				
				String string = readWord();
				if (string != "")
					this.buff.addWord(string);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	

}
