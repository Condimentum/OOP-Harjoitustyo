import java.util.ArrayList;
import java.util.HashMap;
public class Pelivihko {
	ArrayList<Pelaaja> pelaajat;
	HashMap<Pelaaja, HashMap<Jatsiyhdistelma, Integer>> yhdistelmat; // Yo dawg i heard you like HashMaps
	
	public Pelivihko(ArrayList<Pelaaja> p){
		pelaajat=p;
		yhdistelmat = new HashMap<Pelaaja, HashMap<Jatsiyhdistelma, Integer>>();
		for(int i=0; i<p.size(); i++){
			yhdistelmat.put(p.get(i), p.get(i).getYhdistelmat());
		}
	}
	

}
