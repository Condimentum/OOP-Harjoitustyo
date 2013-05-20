/**
 * 
 * @author Axel, Jonne
 *
 */
import java.awt.Image;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;
public class Noppa implements Comparable<Noppa>, Serializable {
	private int value;
	private boolean lukitus;
	Image img;
	final Image open1 = new ImageIcon("noppa_1.png").getImage();
	final Image open2 = new ImageIcon("noppa_2.png").getImage();
	final Image open3 = new ImageIcon("noppa_3.png").getImage();
	final Image open4 = new ImageIcon("noppa_4.png").getImage();
	final Image open5 = new ImageIcon("noppa_5.png").getImage();
	final Image open6 = new ImageIcon("noppa_6.png").getImage();
	final Image locked1 = new ImageIcon("noppa_1_lock.png").getImage();
	final Image locked2 = new ImageIcon("noppa_2_lock.png").getImage();
	final Image locked3 = new ImageIcon("noppa_3_lock.png").getImage();
	final Image locked4 = new ImageIcon("noppa_4_lock.png").getImage();
	final Image locked5 = new ImageIcon("noppa_5_lock.png").getImage();
	final Image locked6 = new ImageIcon("noppa_6_lock.png").getImage();
	
	Random rnd = new Random();
	
	/**
	 * Oletuskonstruktori
	 */
	public Noppa(){
		value=1;
		lukitus = false;
		setImage();
	}
	
	protected Image getImage(){
		return img;
	}
	
	private void setImage() {
		if (lukitus==false){
			if(value==1){
				img=open1;
			}
			else if(value==2){
				img=open2;
			}
			else if(value==3){
				img=open3;
			}
			else if(value==4){
				img=open4;
			}
			else if(value==5){
				img=open5;
			}
			else if(value==6){
				img=open6;
			}
		}
		else if (lukitus==true){
			if(value==1){
				img=locked1;
			}
			else if(value==2){
				img=locked2;
			}
			else if(value==3){
				img=locked3;
			}
			else if(value==4){
				img=locked4;
			}
			else if(value==5){
				img=locked5;
			}
			else if(value==6){
				img=locked6;
			}
		}
	}

	public int getValue(){
		return value;
	}
	public boolean getLukitus(){
		return lukitus;
	}
	
	/**
	 * asettaa lukituksen: false->true, true->false
	 */
	public void lock(){
		lukitus = !lukitus;
		setImage();
	}
	
	/**
	 * poistaa lukituksen
	 */
	public void unlock(){
		lukitus=false;
		setImage();
	}
	
	/**
	 * Heittää nopan
	 */
	public void heita(){
		if(!lukitus){
			value=rnd.nextInt(6)+1; //arpoo numeron 1-6
		}
		setImage();
	}
	
	/**
	 * Tulostaa nopan arvon
	 */
	public void print(){
		System.out.print(value);
	}
	
	/**
	 * compareTo
	 */
	public int compareTo(Noppa arg0) {
		return value-arg0.getValue();
	}
}
