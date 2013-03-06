/**
 * 
 * @author Axel, Jonne
 *
 */
import java.io.*;
import java.util.*;
public class Jatsipeli implements Serializable {
	private ArrayList<Pelaaja> pelaajat;
	private FileOutputStream f_out;
	private FileInputStream f_in;
	private ObjectOutputStream obj_out;
	private ObjectInputStream obj_in;
	private File saveFile;
	private String path;
	
	public Jatsipeli(){
		pelaajat = new ArrayList<Pelaaja>();
		path = "save.data";
		try{
			createSave();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		try{
			f_out = new FileOutputStream(saveFile);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			obj_out = new ObjectOutputStream(f_out);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		try {
			f_in = new FileInputStream(saveFile);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			obj_in = new ObjectInputStream (f_in);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void save(){
		try{
			obj_out.writeObject(this);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public Jatsipeli load(){
		Jatsipeli tmp = new Jatsipeli();
		try {
			tmp = (Jatsipeli)obj_in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tmp;
	}
	private void createSave() throws IOException{
		saveFile=new File(path);
		if(!saveFile.exists()){
			saveFile.createNewFile();
		}
	}
	public void addPelaaja(Pelaaja p){
		pelaajat.add(p);
	}
	public Pelaaja getPelaaja(int ind){
		return pelaajat.get(ind);
	}
	public int getPelaajatLkm(){
		return pelaajat.size();
	}
	public void Save() throws FileNotFoundException{
		
	}
	/** Main-metodi
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Jatsipeli game = new Jatsipeli();
		game.addPelaaja(new Pelaaja("Janne"));
		game.addPelaaja(new Pelaaja("Kuukupööpötin"));
		String lukitut="";
		int valinta;
		ArrayList<Yhdistelma> yhdistelmat;
		while(!game.vihkoTaynna()){ // Toistetaan, kunnes pelivihko on täynnä
			for(int player=0; player<game.getPelaajatLkm(); player++){
				for(int i=3; i>0; i--){
					System.out.println(i);
					lukitut="";
					game.getPelaaja(player).heita();
					game.getPelaaja(player).getKasi().unlock();
					System.out.println(game.getPelaaja(player).getNimi());
					game.getPelaaja(player).printKasi();
					if(i==1){
						game.getPelaaja(player).printYhdistelmat();
						yhdistelmat=game.getPelaaja(player).mahdollisetYhdistelmat();
						valinta=reader.nextInt();
						game.getPelaaja(player).setPisteet(yhdistelmat.get(valinta));
						System.out.println("Tallennettu Jatsiyhdistelmä "+yhdistelmat.get(valinta).getNimi().name()+": "+yhdistelmat.get(valinta).getPisteet());
						reader.nextLine(); //Tarvitaan jostain syystä
					}
					else{
						lukitut=reader.nextLine();
						for(int j=0; j<lukitut.length(); j++){
							game.getPelaaja(0).getKasi().lock(Character.getNumericValue(lukitut.charAt(j)));
						}
					}
				}
			}
		}
		

	}
	/** Tarkistaa, onko pelivihko täynnä
	 * tarkistaa kaikkien pelaajien kaikki yhdistelmät
	 * @return false, jos vielä jokin yhdistelmä on käyttämättä, ts. pisteet==null, true, jos vihko on täynnä
	 */
	public boolean vihkoTaynna(){
		for(int i=0; i<pelaajat.size(); i++){
			for(int j=0; j<15; j++){
				try{
					pelaajat.get(i).getPisteet(Pelaaja.jatsiyhdistelmat.get(j));
				}
				catch(NoPointsException e){
					return false;
				}
			}
		}
		return true;
	}

}
