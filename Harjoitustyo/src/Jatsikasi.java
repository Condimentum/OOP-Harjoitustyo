import java.util.ArrayList;
public class Jatsikasi {
	protected Noppa[] nopat;
	
	public Jatsikasi(){
		nopat = new Noppa[5];
	}
	public Jatsikasi(Jatsikasi k){
		nopat = k.getNopat();
	}
	/**
	 * heittää lukitsemattomat nopat
	 * @param lukitut lukittujen noppien indeksit nousevassa järjestyksessä
	 */
	public void heita(ArrayList<Integer> lukitut){
		for(int i=0; i<5; i++){
			if (lukitut.get(0)==i){ // Jos noppa on lukittu, ei heitetä
				lukitut.remove(0); // Poistetaan lukitus
				continue; // Siirrytään seuraavaan noppaan
			}
			else{
				nopat[i].heita();
			}
		}
	}
	public Noppa[] getNopat(){
		return nopat;
	}
}
