/**
 * Poikkeus, joka heitetään, jos yhdistelmän arvo == null
 * @author Axel, Jonne
 *
 */
public class NoPointsException extends Exception {
	public NoPointsException(String message){
		super(message);
	}
	public NoPointsException(){
		super();
	}
}
