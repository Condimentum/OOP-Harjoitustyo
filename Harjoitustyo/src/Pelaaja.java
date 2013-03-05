import java.util.EnumMap;
import java.util.ArrayList;
public class Pelaaja {
	private String nimi;
	private EnumMap<Jatsiyhdistelma, Integer> yhdistelmat;
	private ArrayList<Jatsiyhdistelma> jatsiyhdistelmat;
	private Jatsikasi kasi;
	
	public Pelaaja(String n){
		nimi = n;
		yhdistelmat = new EnumMap<Jatsiyhdistelma, Integer>(Jatsiyhdistelma.class);
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
	 */
	public int getPisteet(Jatsiyhdistelma avain) throws NoPointsException{
		if(yhdistelmat.get(avain)!=null){
			return (Integer)yhdistelmat.get(avain);
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
	/**
	 * 
	 * @param avain 
	 * @param arvo
	 */
	public void setPisteet(Yhdistelma y){
		yhdistelmat.put(y.getNimi(), y.getPisteet());
	}
	public void printKasi(){
		kasi.print();
	}
	public void unlock(){
		kasi.unlock();
	}
	public void lock(int i){
		kasi.lock(i);
	}

}
