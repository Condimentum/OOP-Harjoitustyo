import java.util.Random;
public class Noppa implements Comparable<Noppa> {
	private int value;
	private boolean lukitus;
	Random rnd = new Random();
	
	public Noppa(){
		value=1;
		lukitus = false;
	}
	public int getValue(){
		return value;
	}
	public boolean getLukitus(){
		return lukitus;
	}
	public void lock(){
		lukitus = !lukitus;
	}
	public void unlock(){
		lukitus=false;
	}
	public void heita(){
		if(!lukitus){
			value=rnd.nextInt(6)+1; //arpoo numeron 1-6
		}
	}
	public void print(){
		System.out.print(value);
	}
	public int compareTo(Noppa arg0) {
		return value-arg0.getValue();
	}
}
