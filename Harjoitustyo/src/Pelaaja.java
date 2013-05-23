/**
 * 
 * @author Axel, Jonne
 *
 */
import java.io.Serializable;
import java.util.Collections;
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
	/**
	public void printYhdistelmat(){
		ArrayList<Yhdistelma> yhdistelmat = mahdollisetYhdistelmat();
		for(int i=0; i<yhdistelmat.size(); i++){
			System.out.println(yhdistelmat.get(i).getNimi().name() + ":	" + yhdistelmat.get(i).getPisteet());
		}
		
	}
	*/
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
		Collections.sort(toReturn, Collections.reverseOrder()); // Järjestää yhdistelmät pisteiden mukaan laskevaan järjestykseen
		return toReturn;
	}
	
	public String mahdollisetYhdistelmatToString(){
		String s="";
		ArrayList<Yhdistelma> y = mahdollisetYhdistelmat();
		for(int i=0; i<y.size(); i++){
			s=s+(i+1)+" - "+y.get(i).getNimi()+": "+y.get(i).getPisteet()+"p"+"\n";
			if(i==y.size()-1){
				s=s+(i+2)+" - "+"yliviivaa";
			}
		}
		return s;
		
	}
	
	public ArrayList<String> mahdollisetYhdistelmatTest(){
		ArrayList<String> s = new ArrayList<String>();
		ArrayList<Yhdistelma> y = mahdollisetYhdistelmat();
		for(int i=0; i<y.size(); i++){
			s.add(y.get(i).getNimi()+": "+y.get(i).getPisteet()+"p");
			if(i==y.size()-1){
				s.add("yliviivaa");
			}
		}
		return s;
	}
	
	public void printYliviivattavat(){
		ArrayList<Yhdistelma> yhdistelmat = yliviivattavat();
		for(int i=0; i<yhdistelmat.size(); i++){
			System.out.println(yhdistelmat.get(i).getNimi().name() + ":	" + yhdistelmat.get(i).getPisteet());
		}
	}
	public ArrayList<Yhdistelma> yliviivattavat(){
		Yhdistelma y = new Yhdistelma(kasi);
		ArrayList<Yhdistelma> yhdistelmat = y.getYhdistelmat(); // Kaikki kädestä saatavat yhdistelmät
		ArrayList<Yhdistelma> toReturn = new ArrayList<Yhdistelma>(); // Palautettavat yhdistelmät
		for(int i=0; i<jatsiyhdistelmat.size(); i++){ // Käydään kaikki jatsiyhdistelmät läpi
			for(int j=0; j<yhdistelmat.size(); j++){ // Käydään kaikki kädestä saatavat yhdistelmät läpi
				if(jatsiyhdistelmat.get(i)==yhdistelmat.get(j).getNimi()){ // Jos kädestä on mahdollista saada ko. yhdistelmä, ei lisätä palautettaviin
					continue;
				}
				if(j==yhdistelmat.size()-1){ // Ollaan päästy loppuun, eli kädestä ei ole mahdollista saada ko. yhdistelmää. Lisätään palautettaviin
					toReturn.add(new Yhdistelma(kasi.getNopat(), 0, jatsiyhdistelmat.get(i)));
				}
				
			}
		}
		for(int i=0; i<toReturn.size(); i++){
			try{
				vihko.getPisteet(toReturn.get(i).getNimi()); // Kokeillaan, onko vihkoon jo asetettu yhdistelmälle pisteet
				toReturn.remove(i); // On asetettu, joten poistetaan palautettavista
				i--;
			}
			catch(NoPointsException e){ // Yhdistelmälle ei ole vielä asetettu pisteitä, joten ei tehdä mitään
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
