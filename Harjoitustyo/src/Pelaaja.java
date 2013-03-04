import java.util.HashMap;
import java.util.ArrayList;
public class Pelaaja {
	String nimi;
	HashMap<Jatsiyhdistelma, Yhdistelma> yhdistelmat;
	Jatsikasi kasi;
	
	public Pelaaja(String n){
		nimi = n;
		yhdistelmat.put(Jatsiyhdistelma.YKKOSET, null);
		yhdistelmat.put(Jatsiyhdistelma.KAKKOSET, null);
		yhdistelmat.put(Jatsiyhdistelma.KOLMOSET, null);
		yhdistelmat.put(Jatsiyhdistelma.NELOSET, null);
		yhdistelmat.put(Jatsiyhdistelma.VIITOSET, null);
		yhdistelmat.put(Jatsiyhdistelma.KUUTOSET, null);
		yhdistelmat.put(Jatsiyhdistelma.PARI, null);
		yhdistelmat.put(Jatsiyhdistelma.KAKSI_PARIA, null);
		yhdistelmat.put(Jatsiyhdistelma.KOLME_SAMAA, null);
		yhdistelmat.put(Jatsiyhdistelma.NELJA_SAMAA, null);
		yhdistelmat.put(Jatsiyhdistelma.PIKKUSUORA, null);
		yhdistelmat.put(Jatsiyhdistelma.ISOSUORA, null);
		yhdistelmat.put(Jatsiyhdistelma.TAYSKASI, null);
		yhdistelmat.put(Jatsiyhdistelma.SATTUMA, null);
		yhdistelmat.put(Jatsiyhdistelma.YATZY, null);
		kasi = new Jatsikasi();
	}
	
	public Noppa[] heita(ArrayList<Integer> lukitut){
		return kasi.heita(lukitut);
	}
	public String getNimi(){
		return nimi;
	}
	public void setNimi(String n){
		nimi=n;
	}
	/**
	 * 
	 * @param avain Jatsiyhdistelma, jonka kohdalta haetaan tallennettu yhdistelmä
	 * @return Yhdistelma
	 */
	public Yhdistelma getYhdistelma(Jatsiyhdistelma avain){
		return yhdistelmat.get(avain);
	}
	/**
	 * 
	 * @param avain 
	 * @param arvo
	 */
	public void setYhdistelma(Yhdistelma y){
		yhdistelmat.put(y.getNimi(), y.getPisteet());
	}

}
