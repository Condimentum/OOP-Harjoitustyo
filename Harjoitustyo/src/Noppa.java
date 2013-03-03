import java.util.Random;
public class Noppa implements Comparable<Noppa> {
	int value;
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
	public int compareTo(Noppa arg0) {
		return value-arg0.getValue();
	}
}
