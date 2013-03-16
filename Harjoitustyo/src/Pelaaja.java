/**
 * 
 * @author Axel, Jonne
 *
 */
import java.io.Serializable;
import java.util.EnumMap;
import java.util.ArrayList;
public class Pelaaja implements Serializable, Comparable<Pelaaja> {
	private String nimi;
	static ArrayList<Jatsiyhdistelma> jatsiyhdistelmat;
	private Pelivihko vihko;
	private Jatsikasi kasi;
	
	/**
	 * Oletuskonstruktori
	 * @param n pelaajan nimi
	 */
	public Pelaaja(String n){
		nimi = n;
		vihko = new Pelivihko();
		kasi = new Jatsikasi();
	}
	
	/**
	 * Heittää nopat
	 */
	public void heita(){
		kasi.heita();
	}
	
	/**
	 * Tulostaa nopista muodostettavat yhdistelmät ja niistä saatavat pisteet, joita pelaaja ei ole vielä käyttänyt
	 */
	public void printYhdistelmat(){
		ArrayList<Yhdistelma> yhdistelmat = mahdollisetYhdistelmat();
		for(int i=0; i<yhdistelmat.size(); i++){
			System.out.println(yhdistelmat.get(i).getNimi().name() + ": " + yhdistelmat.get(i).getPisteet());
		}
	}
	public ArrayList<Yhdistelma> mahdollisetYhdistelmat(){
		Yhdistelma y = new Yhdistelma(kasi);
		ArrayList<Yhdistelma> yhdistelmat = y.getYhdistelmat(); // Kaikki kädestä saatavat yhdistelmät
		ArrayList<Yhdistelma> toReturn = new ArrayList<Yhdistelma>(); // Palautettavat yhdistelmät
		for(int i=0; i<yhdistelmat.size(); i++){
			try{
				vihko.getPisteet(yhdistelmat.get(i).getNimi()); // Kokeillaan, onko vihkoon jo asetettu yhdistelmälle pisteet
			}
			catch(NoPointsException e){ // Yhdistelmälle ei ole vielä asetettu pisteitä, joten lisätään yhdistelmä palautettaviin
				toReturn.add(yhdistelmat.get(i));
			}
		}
		return toReturn;
	}
	public String getNimi(){
		return nimi;
	}
	public void setNimi(String n){
		nimi=n;
	}
	/**
	public EnumMap<Jatsiyhdistelma, Integer> getYhdistelmat(){
		return yhdistelmat;
	}
	*/
	/**
	 * 
	 * @param avain Jatsiyhdistelma, jonka kohdalta haetaan tallennettu yhdistelmä
	 * @return Yhdistelma
	 * @throws NoPointsException, jos pisteet==null
	 */
	public int getPisteet(Jatsiyhdistelma avain) throws NoPointsException{
		return vihko.getPisteet(avain);
	}
	
	public int getPisteet(){
		return vihko.getSum();
	}
	public Pelivihko getVihko(){
		return vihko;
	}
	/**
	public void setPisteet(Yhdistelma y){
		yhdistelmat.put(y.getNimi(), y.getPisteet());
	}
	*/
	public void printKasi(){
		kasi.print();
	}
	public Jatsikasi getKasi(){
		return kasi;
	}

	public int compareTo(Pelaaja arg0) {
		return vihko.compareTo(arg0.getVihko());
	}

}
