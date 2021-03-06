import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;

/**
 * 
 */

/**
 * @author Axel, Jonne
 *
 */
public class Pelivihko implements Comparable<Pelivihko>, Serializable {
	EnumMap<Jatsiyhdistelma, Integer> yhdistelmat;
	static ArrayList<Jatsiyhdistelma> jatsiyhdistelmat;
	private int valisumma;
	private int bonus;
	private int summa;
	private boolean full;
	
	public Pelivihko(){
		yhdistelmat = new EnumMap<Jatsiyhdistelma, Integer>(Jatsiyhdistelma.class);
		jatsiyhdistelmat = new ArrayList<Jatsiyhdistelma>();
		jatsiyhdistelmat.add(Jatsiyhdistelma.YKKOSET);
		jatsiyhdistelmat.add(Jatsiyhdistelma.KAKKOSET);
		jatsiyhdistelmat.add(Jatsiyhdistelma.KOLMOSET);
		jatsiyhdistelmat.add(Jatsiyhdistelma.NELOSET);
		jatsiyhdistelmat.add(Jatsiyhdistelma.VIITOSET);
		jatsiyhdistelmat.add(Jatsiyhdistelma.KUUTOSET);
		jatsiyhdistelmat.add(Jatsiyhdistelma.PARI);
		jatsiyhdistelmat.add(Jatsiyhdistelma.KAKSI_PARIA);
		jatsiyhdistelmat.add(Jatsiyhdistelma.KOLME_SAMAA);
		jatsiyhdistelmat.add(Jatsiyhdistelma.NELJA_SAMAA);
		jatsiyhdistelmat.add(Jatsiyhdistelma.PIKKUSUORA);
		jatsiyhdistelmat.add(Jatsiyhdistelma.ISOSUORA);
		jatsiyhdistelmat.add(Jatsiyhdistelma.TAYSKASI);
		jatsiyhdistelmat.add(Jatsiyhdistelma.SATTUMA);
		jatsiyhdistelmat.add(Jatsiyhdistelma.YATZY);
		for(int i=0; i<jatsiyhdistelmat.size(); i++){
			yhdistelmat.put(jatsiyhdistelmat.get(i), null);
		}
		valisumma=0;
		bonus=0;
		summa=0;
		full=false;
	}
	
	/**
	 * run.java:n käyttöön, mahdollistaa pelin tilan latauksen
	 * @param j jatsiyhdistelmän nimi
	 * @param a pisteet
	 */
	public void load(Jatsiyhdistelma j, int a){
		yhdistelmat.put(j, a);
		// Jos yhdistelmä on jokin silmälukuyhdistelmistä, lisätään saadut pisteet välisummaan
				if(j==Jatsiyhdistelma.YKKOSET||j==Jatsiyhdistelma.KAKKOSET||j==Jatsiyhdistelma.KOLMOSET||j==Jatsiyhdistelma.NELOSET||j==Jatsiyhdistelma.VIITOSET||j==Jatsiyhdistelma.KUUTOSET){
					valisumma=valisumma+a;
					if((bonus==0)){ // Jos bonusta ei ole vielä annettu
						if(valisumma>=63){
							bonus=50; // Annetaan bonus
							summa=summa+50;
						}
					}
				}
				summa = summa + a;
				for(int i=0; i<15; i++){ // Tarkistaa, onko pelivihko täynnä
					if(yhdistelmat.get(jatsiyhdistelmat.get(i))==null){ // Ei ole täynnä
						break;
					}
					if(i==14){ // On täynnä
						full=true;
					}
				}
	}
	
	public void setPisteet(Yhdistelma y){
		yhdistelmat.put(y.getNimi(), y.getPisteet());
		// Jos yhdistelmä on jokin silmälukuyhdistelmistä, lisätään saadut pisteet välisummaan
		if(y.getNimi()==Jatsiyhdistelma.YKKOSET||y.getNimi()==Jatsiyhdistelma.KAKKOSET||y.getNimi()==Jatsiyhdistelma.KOLMOSET||y.getNimi()==Jatsiyhdistelma.NELOSET||y.getNimi()==Jatsiyhdistelma.VIITOSET||y.getNimi()==Jatsiyhdistelma.KUUTOSET){
			valisumma=valisumma+y.getPisteet();
			if((bonus==0)){ // Jos bonusta ei ole vielä annettu
				if(valisumma>=63){
					bonus=50; // Annetaan bonus
					summa=summa+50;
				}
			}
		}
		summa = summa + y.getPisteet();
		for(int i=0; i<15; i++){ // Tarkistaa, onko pelivihko täynnä
			if(yhdistelmat.get(jatsiyhdistelmat.get(i))==null){ // Ei ole täynnä
				break;
			}
			if(i==14){ // On täynnä
				full=true;
			}
		}
	}
	
	/**
	 * Palauttaa pelivihon String-tyyppisenä
	 * @return pelivihko
	 */
	public String toString(){
		String s ="";
		for(int i=0; i<6; i++){
			s=s+(jatsiyhdistelmat.get(i).name() + ":		" + yhdistelmat.get(jatsiyhdistelmat.get(i))) + "\n";
		}
		s=s+"-------------------------------------------------"+ "\n";
		s=s+("VALISUMMA: " + valisumma)+ "\n";
		s=s+("BONUS: " + bonus)+ "\n";
		s=s+"-------------------------------------------------"+ "\n";
		for(int i=6; i<8; i++){
			s=s+(jatsiyhdistelmat.get(i).name() + ":		" + yhdistelmat.get(jatsiyhdistelmat.get(i)))+ "\n";
		}
		s=s+(jatsiyhdistelmat.get(8).name() + ":	" + yhdistelmat.get(jatsiyhdistelmat.get(8)))+ "\n";
		for(int i=9; i<15; i++){
			s=s+(jatsiyhdistelmat.get(i).name() + ":		" + yhdistelmat.get(jatsiyhdistelmat.get(i)))+ "\n";
		}
		s=s+"-------------------------------------------------"+ "\n";
		s=s+("SUMMA: " + summa)+ "\n";
		return s;
	}
	
	public int getSum(){
		return summa;
	}
	
	public int getPisteet(Jatsiyhdistelma avain) throws NoPointsException{
		if(yhdistelmat.get(avain)!=null){
			return yhdistelmat.get(avain);
		}
		else{
			throw new NoPointsException("value==null");
		}
	}
	
	public boolean full(){
		return full;
	}
	
	public int compareTo(Pelivihko arg0) {
		return summa-arg0.getSum();
	}
}
