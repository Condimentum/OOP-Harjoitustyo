/**
 * 
 * @author Axel, Jonne
 *
 */
import java.io.Serializable;
import java.util.Arrays;
import java.util.ArrayList;
public class Yhdistelma extends Jatsikasi implements Comparable<Yhdistelma>, Serializable {
	private int pisteet;
	private Jatsiyhdistelma nimi;
	
	public Yhdistelma(Jatsikasi k){
		super(k);
		pisteet = 0;
		nimi = null;
		Arrays.sort(nopat); // Järjestetään nopat nousevaan järjestykseen
	}
	public Yhdistelma(Noppa[] n, int a, Jatsiyhdistelma b){
		super(n);
		pisteet = a;
		nimi = b;
		Arrays.sort(nopat); // Järjestetään nopat nousevaan järjestykseen
	}
	/**
	 * Etsii mahdolliset yhdistelmät ja niiden pisteet
	 * @return mahdolliset yhdistelmät
	 */
	public ArrayList<Yhdistelma> getYhdistelmat(){
		ArrayList<Yhdistelma> a = new ArrayList<Yhdistelma>();
		int points=0;
		if(ykkoset()){
			for(int i=0; i<5; i++){
				if (nopat[i].getValue()==1){
					points++;
				}
			}
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.YKKOSET));
			points=0;
		}
		if(kakkoset()){
			for(int i=0; i<5; i++){
				if (nopat[i].getValue()==2){
					points++;
				}
			}
			points = points*2;
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.KAKKOSET));
			points=0;
		}
		if(kolmoset()){
			for(int i=0; i<5; i++){
				if (nopat[i].getValue()==3){
					points++;
				}
			}
			points = points*3;
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.KOLMOSET));
			points=0;
		}
		if(neloset()){
			for(int i=0; i<5; i++){
				if (nopat[i].getValue()==4){
					points++;
				}
			}
			points = points*4;
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.NELOSET));
			points=0;
		}
		if(viitoset()){
			for(int i=0; i<5; i++){
				if (nopat[i].getValue()==5){
					points++;
				}
			}
			points = points*5;
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.VIITOSET));
			points=0;
		}
		if(kuutoset()){
			for(int i=0; i<5; i++){
				if (nopat[i].getValue()==6){
					points++;
				}
			}
			points = points*6;
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.KUUTOSET));
			points=0;
		}
		if(kaksiParia()){
			int ind=0;
			int tmpPoints;
			for(int i=0; i<2; i++){
				if(nopat[i].getValue()==nopat[i+1].getValue()){
					ind = i+2;
					points = nopat[i].getValue() + nopat[i+1].getValue();
					break;
				}
			}
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.PARI)); // add ensimmäinen pari
			tmpPoints=points;
			points=0;
			for(int i=ind; i<4; i++){
				if(nopat[i].getValue()==nopat[i+1].getValue()){
					ind = i+2;
					points = nopat[i].getValue() + nopat[i+1].getValue();
				}
			}
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.PARI)); // add toinen pari
			tmpPoints=tmpPoints+points;
			points=0;
			a.add(new Yhdistelma(nopat, tmpPoints, Jatsiyhdistelma.KAKSI_PARIA)); // add kaksi paria
		}
		else if(pari() || kolmeSamaa() || neljaSamaa()){ // Löytyy vain yksi pari
			for(int i=0; i<4; i++){
				if (nopat[i].getValue()==nopat[i+1].getValue()){
					points = nopat[i].getValue() + nopat[i+1].getValue();
				}
			}
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.PARI));
			points=0;
		}
		if(kolmeSamaa() || neljaSamaa()){
			for(int i=0; i<3; i++){
				if (nopat[i].getValue()==nopat[i+1].getValue() && nopat[i].getValue()==nopat[i+2].getValue()){
					points = nopat[i].getValue() + nopat[i+1].getValue() + nopat[i+2].getValue();
				}
			}
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.KOLME_SAMAA));
			points=0;
		}
		if(neljaSamaa()){
			for(int i=0; i<2; i++){
				if (nopat[i].getValue()==nopat[i+1].getValue() && nopat[i].getValue()==nopat[i+2].getValue() && nopat[i].getValue()==nopat[i+3].getValue()){
					points = nopat[i].getValue() + nopat[i+1].getValue() + nopat[i+2].getValue() + nopat[i+3].getValue();
				}
			}
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.NELJA_SAMAA));
			points=0;
		}
		if(pikkusuora()){
			a.add(new Yhdistelma(nopat, 15, Jatsiyhdistelma.PIKKUSUORA));
		}
		if(isosuora()){
			a.add(new Yhdistelma(nopat, 20, Jatsiyhdistelma.ISOSUORA));
		}
		if(tayskasi()){
			for(int i=0; i<5; i++){
				points=points+nopat[i].getValue();
			}
			a.add(new Yhdistelma(nopat, points, Jatsiyhdistelma.TAYSKASI));
			points=0;
		}
		if(yatzy()){
			a.add(new Yhdistelma(nopat, 50, Jatsiyhdistelma.YATZY));
		}
		return a;
	}
	/**
	 * Testataan, mitä yhdistelmiä löytyy
	 * HUOM! jos löytyy kolme samaa tai neljä samaa, kaksiSamaa() palauttaa false
	 * @return true=löytyi, false=ei löytynyt yhdistelmää
	 */
	public boolean ykkoset(){
		if(nopat[0].getValue()==1){
			return true;
		}
		return false;
	}
	public boolean kakkoset(){
		for(int i=0; i<5; i++){
			if(nopat[i].getValue()==2){
				return true;
			}
		}
		return false;
	}
	public boolean kolmoset(){
		for(int i=0; i<5; i++){
			if(nopat[i].getValue()==3){
				return true;
			}
		}
		return false;
	}
	public boolean neloset(){
		for(int i=0; i<5; i++){
			if(nopat[i].getValue()==4){
				return true;
			}
		}
		return false;
	}
	public boolean viitoset(){
		for(int i=0; i<5; i++){
			if(nopat[i].getValue()==5){
				return true;
			}
		}
		return false;
	}
	public boolean kuutoset(){
		for(int i=0; i<5; i++){
			if(nopat[i].getValue()==6){
				return true;
			}
		}
		return false;
	}
	public boolean pari(){
		for(int i=0; i<4; i++){
			if(nopat[i].getValue()==nopat[i+1].getValue()){
				return true;
			}
		}
		return false;
	}
	public boolean kaksiParia(){
		int count = 0;
		for(int i=0; i<4; i++){
			if(nopat[i].getValue()==nopat[i+1].getValue()){
				count++;
				i++;
			}
		}
		if(count==2){
			return true;
		}
		return false;
	}
	public boolean kolmeSamaa(){
		for(int i=0; i<3; i++){
			if(nopat[i].getValue()==nopat[i+2].getValue()){
				return true;
			}
		}
		return false;
	}
	public boolean neljaSamaa(){
		for(int i=0; i<2; i++){
			if(nopat[i].getValue()==nopat[i+3].getValue()){
				return true;
			}
		}
		return false;
	}
	public boolean pikkusuora(){
		for(int i=0; i<5; i++){
			if(nopat[i].getValue()!=i+1){
				return false;
			}
		}
		return true;
	}
	public boolean isosuora(){
		for(int i=0; i<5; i++){
			if(nopat[i].getValue()!=i+2){
				return false;
			}
		}
		return true;
	}
	public boolean tayskasi(){
		if(nopat[0].getValue()==nopat[1].getValue()&&nopat[2].getValue()==nopat[4].getValue()){
			return true;
		}
		if(nopat[0].getValue()==nopat[2].getValue()&&nopat[3].getValue()==nopat[4].getValue()){
			return true;
		}
		return false;
	}
	public boolean yatzy(){
		for(int i=1; i<5; i++){
			if(nopat[0].getValue()!=nopat[i].getValue()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Getterit ja setterit
	 */
	public int getPisteet(){
		return pisteet;
	}
	public void setPisteet(int a){
		pisteet=a;
	}
	public Jatsiyhdistelma getNimi(){
		return nimi;
	}
	public void setNimi(Jatsiyhdistelma y){
		nimi = y;
	}
	/**
	 * compareTo
	 */
	public int compareTo(Yhdistelma o) {
		return pisteet-o.getPisteet();
	}
}
