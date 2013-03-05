
public class Jatsikasi {
	protected Noppa[] nopat;
	
	public Jatsikasi(){
		nopat = new Noppa[5];
	}
	protected Jatsikasi(Jatsikasi k){
		nopat = k.getNopat();
	}
	protected Jatsikasi(Noppa[] n){
		nopat=n;
	}
	/**
	 * heittää lukitsemattomat nopat
	 * @param lukitut lukittujen noppien indeksit nousevassa järjestyksessä
	 */
	public void heita(){
		for(int i=0; i<5; i++){
			if (!nopat[i].getLukitus()){ // Jos noppaa ei ole lukittu, heitetään
				nopat[i].heita();
			}
		}
	}
	public void print(){
		for(int i=0; i<5; i++){
			nopat[i].print();
		}
	}
	public Noppa[] getNopat(){
		return nopat;
	}
	public void lock(int ind){
		nopat[ind].lock();
	}
	public void unlock(){
		for(int i=0; i<5; i++){
			nopat[i].unlock();
		}
	}
}
