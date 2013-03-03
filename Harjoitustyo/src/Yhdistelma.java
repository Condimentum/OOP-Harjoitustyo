import java.util.Arrays;
import java.util.ArrayList;
public class Yhdistelma extends Jatsikasi implements Comparable<Yhdistelma> {
	private int pisteet;
	private Jatsiyhdistelma nimi;
	
	public enum Jatsiyhdistelma{
		YKKOSET, KAKKOSET, KOLMOSET, NELOSET, VIITOSET, KUUTOSET, PARI, KAKSI_PARIA, KOLME_SAMAA, NELJA_SAMAA, PIKKUSUORA, ISOSUORA, TAYSKASI, SATTUMA, YATZY
	}
	public Yhdistelma(Jatsikasi k){
		super(k);
		pisteet=0;
		nimi = null;
		Arrays.sort(nopat);
	}
	public boolean ykkoset(){
		if(nopat[0].getValue()==1){
			return true;
		}
		return false;
	}
	public boolean kakkoset(){
		if(nopat[0].getValue()==2){
			return true;
		}
		return false;
	}
	public boolean kolmoset(){
		if(nopat[0].getValue()==3){
			return true;
		}
		return false;
	}
	public boolean neloset(){
		if(nopat[0].getValue()==4){
			return true;
		}
		return false;
	}
	public boolean viitoset(){
		if(nopat[0].getValue()==5){
			return true;
		}
		return false;
	}
	public boolean kuutoset(){
		if(nopat[0].getValue()==6){
			return true;
		}
		return false;
	}
	public boolean kaksiSamaa(){
		if(kolmeSamaa()||neljaSamaa()){
			return false;
		}
		for(int i=0; i<4; i++){
			if(nopat[i].getValue()==nopat[i+1].getValue()){
				return true;
			}
		}
		return false;
	}
	public boolean kaksiParia(){
		int count = 0;
		for(int i=0; i<4; i++){
			if(nopat[i].getValue()==nopat[i+1].getValue()){
				count++;
				i++;
			}
		}
		if(count==2){
			return true;
		}
		return false; //else
	}
	public boolean kolmeSamaa(){
		if(neljaSamaa()){
			return false;
		}
		for(int i=0; i<3; i++){
			if(nopat[i].getValue()==nopat[i+1].getValue() && nopat[i].getValue()==nopat[i+2].getValue()){
				return true;
			}
		}
		return false;
	}
	public boolean neljaSamaa(){
		for(int i=0; i<2; i++){
			if(nopat[i].getValue()==nopat[i+1].getValue()&&nopat[i].getValue()==nopat[i+2].getValue()&&nopat[i].getValue()==nopat[i+3].getValue()){
				return true;
			}
		}
		return false;
	}
	public boolean pikkusuora(){
		for(int i=0; i<5; i++){
			if(nopat[i].getValue()!=i+1){
				return false;
			}
		}
		return true;
	}
	public boolean isosuora(){
		for(int i=0; i<5; i++){
			if(nopat[i].getValue()!=i+2){
				return false;
			}
		}
		return true;
	}
	public boolean tayskasi(){
		if(kaksiSamaa()&&kolmeSamaa()){
			return true;
		}
		return false;
	}
	public boolean yatzy(){
		for(int i=1; i<5; i++){
			if(nopat[0].getValue()!=nopat[i].getValue()){
				return false;
			}
		}
		return true;
	}
	public int getPisteet(){
		return pisteet;
	}
	public void setPisteet(int a){
		pisteet=a;
	}
	public Jatsiyhdistelma getNimi(){
		return nimi;
	}
	public void setNimi(Jatsiyhdistelma y){
		nimi = y;
	}
	@Override
	public int compareTo(Yhdistelma o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
