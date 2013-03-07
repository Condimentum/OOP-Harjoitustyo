import java.io.Serializable;

/**
 * Poikkeus, joka heitetään, jos yhdistelmän arvo == null
 * @author Axel, Jonne
 *
 */
public class NoPointsException extends Exception implements Serializable {
	public NoPointsException(String message){
		super(message);
	}
	public NoPointsException(){
		super();
	}
}
