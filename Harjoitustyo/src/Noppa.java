import java.util.Random;
public class Noppa {
	private int value;
	
	public Noppa(){
		value=1;
	}
	public int getValue(){
		return value;
	}
	public void heita(){
		Random rnd = new Random();
		value=rnd.nextInt(6)+1; //arpoo numeron 1-6
	}
}
