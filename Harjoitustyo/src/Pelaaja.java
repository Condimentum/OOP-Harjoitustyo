/**
 * 
 * @author Axel, Jonne
 *
 */
import java.io.Serializable;
import java.util.EnumMap;
import java.util.ArrayList;
public class Pelaaja implements Serializable {
	private String nimi;
	private EnumMap<Jatsiyhdistelma, Integer> yhdistelmat;
	static ArrayList<Jatsiyhdistelma> jatsiyhdistelmat;
	private Jatsikasi kasi;
	
	public Pelaaja(String n){
		nimi = n;
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
		kasi = new Jatsikasi();
	}
	
	public void heita(){
		kasi.heita();
	}
	public void printYhdistelmat(){
		Yhdistelma y = new Yhdistelma(kasi);
		ArrayList<Yhdistelma> yhdistelmat = y.getYhdistelmat();
		for(int i=0; i<yhdistelmat.size(); i++){
			if(this.yhdistelmat.get(yhdistelmat.get(i).getNimi())==null){
				System.out.println(yhdistelmat.get(i).getNimi().name()+": "+yhdistelmat.get(i).getPisteet());
			}
		}
	}
	public ArrayList<Yhdistelma> mahdollisetYhdistelmat(){
		Yhdistelma y = new Yhdistelma(kasi);
		ArrayList<Yhdistelma> yhdistelmat = y.getYhdistelmat();
		ArrayList<Yhdistelma> toReturn = new ArrayList<Yhdistelma>();
		for(int i=0; i<yhdistelmat.size(); i++){
			if(this.yhdistelmat.get(yhdistelmat.get(i).getNimi())==null){
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
	public EnumMap<Jatsiyhdistelma, Integer> getYhdistelmat(){
		return yhdistelmat;
	}
	/**
	 * 
	 * @param avain Jatsiyhdistelma, jonka kohdalta haetaan tallennettu yhdistelmä
	 * @return Yhdistelma
	 * @throws NoPointsException, jos pisteet==null
	 */
	public int getPisteet(Jatsiyhdistelma avain) throws NoPointsException{
		if(yhdistelmat.get(avain)!=null){
			return yhdistelmat.get(avain);
		}
		else{
			throw new NoPointsException("value==null");
		}
	}
	public int getPisteet(){
		int sum=0;
		for(int i=0; i<jatsiyhdistelmat.size(); i++){
			try{
				sum=sum+getPisteet(jatsiyhdistelmat.get(i));
			}
			catch(NoPointsException e){
				continue;
			}
		}
		return sum;
	}
	
	public void setPisteet(Yhdistelma y){
		yhdistelmat.put(y.getNimi(), y.getPisteet());
	}
	public void printKasi(){
		kasi.print();
	}
	public Jatsikasi getKasi(){
		return kasi;
	}

}
