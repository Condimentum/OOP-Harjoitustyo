/**
 * 
 * @author Axel, Jonne
 *
 */
import java.io.*;
import java.util.*;
public class Jatsipeli implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pelaaja> pelaajat;
	private FileOutputStream f_out;
	private FileInputStream f_in;
	private ObjectOutputStream obj_out;
	private ObjectInputStream obj_in;
	
	public Jatsipeli(){
		pelaajat = new ArrayList<Pelaaja>();
		try{
			createSave();
		}
		catch(IOException e){
			System.out.println("Penis0");
		}
		try{
			f_out = new FileOutputStream("save.data");
		}
		catch(FileNotFoundException e){
			System.out.println("Penis");
		}
		try{
			obj_out = new ObjectOutputStream(f_out);
		}
		catch(IOException e){
			System.out.println("Penis1");
		}
		try {
			f_in = new FileInputStream("save.data");
		} 
		catch (FileNotFoundException e) {
			System.out.println("Penis2");
		}
		try {
			obj_in = new ObjectInputStream (f_in);
		} 
		catch (IOException e) {
			System.out.println("Penis3");
		}
	}
	public void save(){
		try{
			obj_out.writeObject(this);
		}
		catch(IOException e){
			System.out.println("Penis4");
		}
	}
	public Jatsipeli load() throws IOException, ClassNotFoundException{
		Object obj = obj_in.readObject();
		Jatsipeli tmp = new Jatsipeli();
		if (obj instanceof Jatsipeli)
		{
			// Cast object to a Vector
			tmp=(Jatsipeli)obj;

			// Do something with vector....
		}
		return tmp;
	}
	private void createSave() throws IOException{
		File saveFile=new File("save.data");
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
						game.getPelaaja(player).printPelivihko();
						System.out.println("------------------------");
						System.out.println("Mahdolliset yhdistelmät:");
						game.getPelaaja(player).printYhdistelmat();
						yhdistelmat=game.getPelaaja(player).mahdollisetYhdistelmat();
						valinta=reader.nextInt();
						game.getPelaaja(player).setPisteet(yhdistelmat.get(valinta));
						System.out.println("Tallennettu Jatsiyhdistelmä "+yhdistelmat.get(valinta).getNimi().name()+": "+yhdistelmat.get(valinta).getPisteet());
						reader.nextLine(); //Tarvitaan jostain syystä
						game.save();
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
