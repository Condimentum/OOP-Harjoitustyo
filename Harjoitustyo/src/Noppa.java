/**
 * 
 * @author Axel, Jonne
 *
 */
import java.io.Serializable;
import java.util.Random;
public class Noppa implements Comparable<Noppa>, Serializable {
	private int value;
	private boolean lukitus;
	Random rnd = new Random();
	
	/**
	 * Oletuskonstruktori
	 */
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
	
	/**
	 * asettaa lukituksen: false->true, true->false
	 */
	public void lock(){
		lukitus = !lukitus;
	}
	
	/**
	 * poistaa lukituksen
	 */
	public void unlock(){
		lukitus=false;
	}
	
	/**
	 * Heittää nopan
	 */
	public void heita(){
		if(!lukitus){
			value=rnd.nextInt(6)+1; //arpoo numeron 1-6
		}
	}
	
	/**
	 * Tulostaa nopan arvon
	 */
	public void print(){
		System.out.print(value);
	}
	
	/**
	 * compareTo
	 */
	public int compareTo(Noppa arg0) {
		return value-arg0.getValue();
	}
}
