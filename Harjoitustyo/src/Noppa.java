import java.util.Random;
public class Noppa {
	private int value;
	Random rnd = new Random();
	
	public Noppa(){
		value=1;
	}
	public int getValue(){
		return value;
	}
	public void heita(){
		value=rnd.nextInt(6)+1; //arpoo numeron 1-6
	}
}
