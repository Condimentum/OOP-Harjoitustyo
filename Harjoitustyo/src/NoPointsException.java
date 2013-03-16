import java.io.Serializable;

/**
 * Poikkeus, joka heitetään, jos yhdistelmän arvo == null
 * Toisinsanoen yhdistelmä on vielä käyttämättä
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
