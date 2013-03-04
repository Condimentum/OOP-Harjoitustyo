import java.util.Random;
public class Noppa implements Comparable<Noppa> {
	int value;
	boolean lukitus;
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
	public void setLukitus(boolean b){
		lukitus = b;
	}
	public void heita(){
		if(!getLukitus()){
			value=rnd.nextInt(6)+1; //arpoo numeron 1-6
		}
	}
	public int compareTo(Noppa arg0) {
		return value-arg0.getValue();
	}
}
