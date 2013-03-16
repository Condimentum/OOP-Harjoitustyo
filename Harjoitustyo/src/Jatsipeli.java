/**
 * 
 * @author Axel, Jonne
 *
 */
import java.io.*;
import java.util.*;
public class Jatsipeli implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Pelaaja> pelaajat;
	private FileOutputStream f_out;
	private FileInputStream f_in;
	private ObjectOutputStream obj_out;
	private ObjectInputStream obj_in;
	
	/**
	 * Oletuskonstruktori
	 */
	public Jatsipeli(){
		pelaajat = new ArrayList<Pelaaja>();
		try{
			createSave(); // Luo tallennustiedoston
		}
		catch(IOException e){
			System.out.println("Penis0");
		}
		try{
			f_out = new FileOutputStream("save.data"); // Tekee jotain maagista
		}
		catch(FileNotFoundException e){
			System.out.println("Penis");
		}
		try{
			obj_out = new ObjectOutputStream(f_out); // I have no idea what I'm doing
		}
		catch(IOException e){
			System.out.println("Penis1");
		}
		try {
			f_in = new FileInputStream("save.data"); // Jotain vitun mystistä
		} 
		catch (FileNotFoundException e) {
			System.out.println("Penis2");
		}
		try {
			obj_in = new ObjectInputStream (f_in); // Aivopieru
		} 
		catch (IOException e) {
			System.out.println("Penis3");
		}
	}
	
	/**
	 * Tallentaa pelin tilan
	 */
	public void save(){
		try{
			obj_out.writeObject(this);
		}
		catch(IOException e){
			System.out.println("Penis4");
		}
	}
	
	/**
	 * Lataa pelin tilan (toteutus vielä kesken)
	 * @return Jatsipeli
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Jatsipeli load() throws IOException, ClassNotFoundException{
		Object obj = obj_in.readObject();
		Jatsipeli tmp = new Jatsipeli();
		if (obj instanceof Jatsipeli){
			tmp=(Jatsipeli)obj;
		}
		return tmp;
	}
	
	/**
	 * Luo tallennustiedoston
	 * @throws IOException
	 */
	private void createSave() throws IOException{
		File saveFile=new File("save.data");
		if(!saveFile.exists()){ // Jos tiedosto ei ole vielä olemassa
			saveFile.createNewFile();
		}
	}
	
	/**
	 * Lisää pelaajan peliin
	 * @param p pelaaja
	 */
	public void addPelaaja(Pelaaja p){
		pelaajat.add(p);
	}
	
	public void Save() throws FileNotFoundException{
		
	}
	/** Main-metodi
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
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
						System.out.println("Pelivihko:");
						game.getPelaaja(player).getVihko().print();
						System.out.println("------------------------");
						System.out.println("Mahdolliset yhdistelmät:");
						game.getPelaaja(player).printYhdistelmat();
						yhdistelmat=game.getPelaaja(player).mahdollisetYhdistelmat();
						valinta=reader.nextInt();
						game.getPelaaja(player).getVihko().setPisteet(yhdistelmat.get(valinta));
						System.out.println("Tallennettu Jatsiyhdistelmä "+yhdistelmat.get(valinta).getNimi().name()+": "+yhdistelmat.get(valinta).getPisteet());
						reader.nextLine(); //Tarvitaan jostain syystä
						game.save();
					}
					else{
						lukitut=reader.nextLine();
						for(int j=0; j<lukitut.length(); j++){
							game.getPelaaja(player).getKasi().lock(Character.getNumericValue(lukitut.charAt(j)));
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
			if(!pelaajat.get(i).getVihko().full()){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Getterit ja setterit
	 */
	public Pelaaja getPelaaja(int ind){
		return pelaajat.get(ind);
	}
	public int getPelaajatLkm(){
		return pelaajat.size();
	}
}
