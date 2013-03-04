import java.util.ArrayList;
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
	public Noppa[] heita(ArrayList<Integer> lukitut){
		for(int i=0; i<5; i++){
			if (lukitut.get(0)==i){ // Jos noppa on lukittu, ei heitetä
				lukitut.remove(0); // Poistetaan lukitus
				continue; // Siirrytään seuraavaan noppaan
			}
			else{
				nopat[i].heita();
			}
		}
		return nopat;
	}
	public Noppa[] getNopat(){
		return nopat;
	}
}
