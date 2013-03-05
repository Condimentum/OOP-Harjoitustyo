import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
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
	public void Save() throws FileNotFoundException{
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Jatsipeli p = new Jatsipeli();
		

	}

}
