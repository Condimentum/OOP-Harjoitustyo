import java.io.Serializable;

/**
 * 
 * @author Axel, Jonne
 *
 */
public class Jatsikasi implements Serializable {
	protected Noppa[] nopat;
	
	public Jatsikasi(){
		nopat = new Noppa[5];
		for(int i=0; i<5; i++){
			nopat[i]=new Noppa();
		}
	}
	/**
	 * Seuraavat konstruktorit vain aliluokan Yhdistelma käyttöön
	 */
	protected Jatsikasi(Jatsikasi k){
		nopat = k.getNopat();
	}
	protected Jatsikasi(Noppa[] n){
		nopat=n;
	}
	/**
	 * heittää lukitsemattomat nopat
	 */
	public void heita(){
		for(int i=0; i<nopat.length; i++){
			if (nopat[i].getLukitus()==false){ // Jos noppaa ei ole lukittu, heitetään
				nopat[i].heita();
			}
		}
	}
	public void print(){
		for(int i=0; i<5; i++){
			nopat[i].print();
		}
		System.out.println();
	}
	public Noppa[] getNopat(){
		return nopat;
	}
	/** Nopan lukitus 
	 * false->true, true->false
	 * @param ind nopan indeksi
	 */
	public void lock(int ind){
		nopat[ind].lock();
	}
	/**
	 * poistaa lukituksen kaikista nopista
	 */
	public void unlock(){
		for(int i=0; i<5; i++){
			nopat[i].unlock();
		}
	}
}
