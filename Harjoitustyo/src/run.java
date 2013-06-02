import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.Border;

import java.io.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.imageio.*;

public class run extends JFrame{
	
	private int heitot;
	private ArrayList<Pelaaja> pelaajat;
	private int currentPelaaja;
	private Clip clip;
	private ArrayList<Yhdistelma> yhdistelmat;
	private int valinta;
	private boolean lock;
	
	private JButton nappi1; // Noppa 1
	private JButton nappi2; // Noppa 2
	private JButton nappi3; // Noppa 3
	private JButton nappi4; // Noppa 4
	private JButton nappi5; // Noppa 5
	private JButton nappiNollaa; // Nollaa pelin
	private JButton vaihto; // Heitä noppia / vaihda pelaajaa
	private JTextField kentta; // Käyttäjän komennot tähän
	private JTextArea pelaaja1; // Pelivihko
	private JTextArea pelaaja2;	 // Pelivihko
	private JTextArea yhdistelmaRivi; // Tähän mahdolliset komennot
	private JLabel otsikko; // Vuorossa olevan pelaajan nimi ja jäljellä olevat heitot
	
	
    public run() {
    	lock=true;
    	pelaajat = new ArrayList<Pelaaja>();
    	pelaajat.add(new Pelaaja("Pelaaja 1"));
    	pelaajat.add(new Pelaaja("Pelaaja 2"));
    	currentPelaaja=0;
    	heitot=0;
    	load();
    	JLabel tausta =new JLabel(new ImageIcon("tausta.png"));
    	tausta.setLayout(null);
    	
    	vaihto = new JButton("Heita");
    	vaihto.setBounds(435,405,150,40);
    	vaihto.addMouseListener(
    			
    			
    			new MouseListener () {
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }
  		        
 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot<2){ // Heittoja jäljellä
 							heitot++;
 							otsikko.setText(pelaajat.get(currentPelaaja).getNimi()+"   heitot: " + (3-heitot));
 							pelaajat.get(currentPelaaja).heita();
 							nappi1.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[0].getImage())));
 							nappi2.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[1].getImage())));
 							nappi3.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[2].getImage())));
 							nappi4.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[3].getImage())));
 							nappi5.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[4].getImage())));
 						}
 						else if(heitot==2){ // Viimeinen heitto
 							heitot++;
 							otsikko.setText(pelaajat.get(currentPelaaja).getNimi()+"   heitot: " + (3-heitot));
 							pelaajat.get(currentPelaaja).heita();
 							pelaajat.get(currentPelaaja).getKasi().unlock(); // Avataan lukitus nopista
 							nappi1.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[0].getImage())));
 							nappi2.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[1].getImage())));
 							nappi3.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[2].getImage())));
 							nappi4.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[3].getImage())));
 							nappi5.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[4].getImage())));
 							vaihto.setText("Vaihda pelaajaa");
 							yhdistelmat=pelaajat.get(currentPelaaja).mahdollisetYhdistelmat(); // Pisteitä tuottavat yhdistelmät
 							yhdistelmat.addAll(pelaajat.get(currentPelaaja).yliviivattavat());	// Yliviivattavat
 							yhdistelmaRivi.setText("Valitse:"+"\n"+"\n"+pelaajat.get(currentPelaaja).mahdollisetYhdistelmatToString());
 							otsikko.setText("Syota Komento ja paina enter");
 						}
 						else { // Heitot käytetty
 							if(!lock){
 								if(currentPelaaja==1){
 	 								currentPelaaja=0;
 	 							}
 	 							else{
 	 								currentPelaaja=1;
 	 							}
 	 							kentta.setText(""); // Tyhjennetään kenttä
 	 							yhdistelmaRivi.setText("Valitse:");
 	 							heitot=0;
 	 							otsikko.setText(pelaajat.get(currentPelaaja).getNimi()+"   heitot: " + (3-heitot));
 	 							vaihto.setText("Heita");
 	 							if(vihkoTaynna()){ // Peli loppu
 	 								clip.stop();
 	 								clip.close();
 	 								music("Victory.wav");
 	 								System.out.println("Peli loppu");
 	 								Collections.sort(pelaajat, Collections.reverseOrder());
 	 								JOptionPane.showMessageDialog(null, "Voittaja on " + pelaajat.get(0).getNimi());
 	 							}
 	 							lock=true;
 							}
 							
 						}
 					}
 					public void mouseEntered(MouseEvent arg0) {	
 					}
 					public void mouseExited(MouseEvent arg0) {	
 					}
 					public void mousePressed(MouseEvent arg0) {	
 					}
 					public void mouseReleased(MouseEvent arg0) {
 					}
  		      }
  		    );
    	
    	
    	
    	nappi1 = new JButton(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[0].getImage()));
    	nappi1.setOpaque(false);
    	nappi1.setContentAreaFilled(false);
    	nappi1.setBorderPainted(false);
    	nappi1.setBounds(160,475,100,100);
    	nappi1.addMouseListener(
    			
 		       new MouseListener () {
 		        public void actionPerformed(Action tapahtuma) {
 		        
 		        }

					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(heitot!=0 && heitot!=3){
							pelaajat.get(currentPelaaja).getKasi().getNopat()[0].lock();
							nappi1.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[0].getImage())));
						}
					}
					public void mouseEntered(MouseEvent arg0) {	
					}
					public void mouseExited(MouseEvent arg0) {	
					}
					public void mousePressed(MouseEvent arg0) {	
					}
					public void mouseReleased(MouseEvent arg0) {
					}
 		      }
 		    );
    	
    	
    	
    	
    	nappi2 = new JButton(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[1].getImage()));
    	nappi2.setOpaque(false);
    	nappi2.setContentAreaFilled(false);
    	nappi2.setBorderPainted(false);
    	nappi2.setBounds(310,475,100,100);
    	nappi2.addMouseListener(
    			
  		       new MouseListener () {
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot!=0 && heitot!=3){
							pelaajat.get(currentPelaaja).getKasi().getNopat()[1].lock();
							nappi2.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[1].getImage())));
						}
 					}
 					public void mouseEntered(MouseEvent arg0) {	
 					}
 					public void mouseExited(MouseEvent arg0) {	
 					}
 					public void mousePressed(MouseEvent arg0) {	
 					}
 					public void mouseReleased(MouseEvent arg0) {
 					}
  		      }
  		    );
    	
    	
    	nappi3 = new JButton(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[2].getImage()));
    	nappi3.setOpaque(false);
    	nappi3.setContentAreaFilled(false);
    	nappi3.setBorderPainted(false);
    	nappi3.setBounds(460,475,100,100);
    	nappi3.addMouseListener(
    			
  		       new MouseListener () {
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot!=0 && heitot!=3){
 							pelaajat.get(currentPelaaja).getKasi().getNopat()[2].lock();
 							nappi3.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[2].getImage())));
 						}
 					}
 					public void mouseEntered(MouseEvent arg0) {	
 					}
 					public void mouseExited(MouseEvent arg0) {	
 					}
 					public void mousePressed(MouseEvent arg0) {	
 					}
 					public void mouseReleased(MouseEvent arg0) {
 					}
  		      }
  		    );
    	
    	
    	
    	nappi4 = new JButton(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[3].getImage()));
    	nappi4.setOpaque(false);
    	nappi4.setContentAreaFilled(false);
    	nappi4.setBorderPainted(false);
    	nappi4.setBounds(610,475,100,100);
    	nappi4.addMouseListener(
    			
  		       new MouseListener () {
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot!=0 && heitot!=3){
 							pelaajat.get(currentPelaaja).getKasi().getNopat()[3].lock();
 							nappi4.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[3].getImage())));
 						}
 					}
 					public void mouseEntered(MouseEvent arg0) {	
 					}
 					public void mouseExited(MouseEvent arg0) {	
 					}
 					public void mousePressed(MouseEvent arg0) {	
 					}
 					public void mouseReleased(MouseEvent arg0) {
 					}
  		      }
  		    );
    	
    	
    	
    	nappi5 = new JButton(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[4].getImage()));
    	nappi5.setOpaque(false);
    	nappi5.setContentAreaFilled(false);
    	nappi5.setBorderPainted(false);
    	nappi5.setBounds(760,475,100,100);
    	nappi5.addMouseListener(
    			
  		       new MouseListener () {
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot!=0 && heitot!=3){
 						pelaajat.get(currentPelaaja).getKasi().getNopat()[4].lock();
						nappi5.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[4].getImage())));
 						}
 					}
 					public void mouseEntered(MouseEvent arg0) {	
 					}
 					public void mouseExited(MouseEvent arg0) {	
 					}
 					public void mousePressed(MouseEvent arg0) {	
 					}
 					public void mouseReleased(MouseEvent arg0) {
 					}
  		      }
  		    );
    	
    	nappiNollaa = new JButton("Uusi peli");
    	nappiNollaa.setBounds(920,500,90,40);
    	nappiNollaa.addMouseListener(
    			
   			 new MouseListener () {
   	  		        public void actionPerformed(Action tapahtuma) {
   	  		        
   	  		        }

   	 					@Override
   	 					public void mouseClicked(MouseEvent arg0) {
   	 						pelaajat = new ArrayList<Pelaaja>();
   	 						pelaajat.add(new Pelaaja("pelaaja1"));
   	 						pelaajat.add(new Pelaaja("pelaaja2"));
   	 						pelaaja1.setText("PELAAJA 1" + "\n" + "\n" + pelaajat.get(0).getVihko().toString()); // Päivitetään pelivihko
   	 						pelaaja2.setText("PELAAJA 2" + "\n" + "\n" + pelaajat.get(1).getVihko().toString()); // Päivitetään pelivihko
   	 						nappi1.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[0].getImage())));
							nappi2.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[1].getImage())));
							nappi3.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[2].getImage())));
							nappi4.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[3].getImage())));
							nappi5.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[4].getImage())));
   	 					}
   	 					public void mouseEntered(MouseEvent arg0) {	
   	 					}
   	 					public void mouseExited(MouseEvent arg0) {	
   	 					}
   	 					public void mousePressed(MouseEvent arg0) {	
   	 					}
   	 					public void mouseReleased(MouseEvent arg0) {
   	 					}
   	  		      }
   	  		    );

    	
    	kentta = new JTextField("Kentta");
    	kentta.setBounds(250,10,500,300);
    	
    	kentta = new JTextField("Komennot");
    	kentta.setBounds(700,410,120,30);
    	kentta.addKeyListener(new KeyListener() {
    		public void keyPressed(KeyEvent e) {

    		if(e.getKeyChar() == KeyEvent.VK_ENTER && kentta.getText().length() != 0) {
    		if(heitot==3){
    			try{
    				valinta=Integer.parseInt(kentta.getText())-1;
    				if(valinta>=0 && valinta<yhdistelmat.size()){
    					pelaajat.get(currentPelaaja).getVihko().setPisteet(yhdistelmat.get(valinta));
    					pelaaja1.setText("PELAAJA 1" + "\n" + "\n" + pelaajat.get(0).getVihko().toString()); // Päivitetään pelivihko
    					pelaaja2.setText("PELAAJA 2" + "\n" + "\n" + pelaajat.get(1).getVihko().toString()); // Päivitetään pelivihko
    					lock=false;
    					System.out.println("ENTER PRESSED");
    		    		yhdistelmaRivi.setText(kentta.getText());
    		    		save();
    				}
    			}
    			catch(NumberFormatException ex){
    				yhdistelmaRivi.setText("Annettu komento ei ollut numero:"+"\n"+"\n"+pelaajat.get(currentPelaaja).mahdollisetYhdistelmatToString());
    			}
    		}
    		}
    		}
    		public void keyTyped(KeyEvent e) {}
    		public void keyReleased(KeyEvent e) {}
    		});
    	
    	pelaaja1 = new JTextArea();
    	pelaaja1.setBounds(150,10,200,380);
    	pelaaja1.setEditable(false);
    	pelaaja1.setText(pelaajat.get(0).getNimi() + "\n" + "\n" + pelaajat.get(0).getVihko().toString());
    	
    	pelaaja2 = new JTextArea();
    	pelaaja2.setBounds(380,10,200,380);
    	pelaaja2.setEditable(false);
    	pelaaja2.setText(pelaajat.get(1).getNimi() + "\n" + "\n" + pelaajat.get(1).getVihko().toString());
    	
    	yhdistelmaRivi = new JTextArea();
    	yhdistelmaRivi.setBounds(680,10,220,380);
    	yhdistelmaRivi.setEditable(false);
    	yhdistelmaRivi.setText("Valitse:");

    	otsikko = new JLabel(pelaajat.get(currentPelaaja).getNimi()+"   heitot: " + (3-heitot));
    	otsikko.setBounds(200,415,250,20);
    	
    	add(tausta);
    	setLayout(new FlowLayout());
    	tausta.add(nappi1);
    	tausta.add(nappi2);
    	tausta.add(nappi3);
    	tausta.add(nappi4);
    	tausta.add(nappi5);
    	tausta.add(nappiNollaa);
    	tausta.add(vaihto);
    	tausta.add(pelaaja1);
    	tausta.add(pelaaja2);
    	tausta.add(yhdistelmaRivi);
    	tausta.add(kentta);
    	tausta.add(otsikko);
    	
        setTitle("Yatzi!!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 635);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        music("music.wav");
    }
	public static void main(String[] args) {
        new run();
    }
    
	/**
	 * Soittaa musiikkia
	 * @param file soitettavan tiedoston polku
	 */
	public void music(String file){
		try
        {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(file)));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
  }
	
	/**
	 * Tarkistaa onko pelaajien vihot täynnä ts. peli loppu
	 * @return true: peli loppu false: peli jatkuu
	 */
	public boolean vihkoTaynna(){
		for(int i=0; i<pelaajat.size(); i++){
			if(!pelaajat.get(i).getVihko().full()){
				return false;
			}
		}
		return true;
	}
	public void save(){
		try{
			// Create file 
			FileWriter fstream = new FileWriter("save.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(
					pelaajat.get(0).getNimi() + "\n"
					+ pelaajat.get(1).getNimi() + "\n");
			if(currentPelaaja==0){
				out.write(1+"\n");
			}
			else{
				out.write(0+"\n");
			}
			out.write("\n");
			for(int i=0; i<15; i++){
				try{
				out.write(Jatsiyhdistelma.values()[i].toString() + " " + pelaajat.get(0).getVihko().getPisteet(Jatsiyhdistelma.values()[i])+"\n");
				}
				catch(NoPointsException e){
				}
			}
			out.write("stop");
			out.write("\n");
			for(int i=0; i<15; i++){
				try{
				out.write(Jatsiyhdistelma.values()[i].toString() + " " + pelaajat.get(1).getVihko().getPisteet(Jatsiyhdistelma.values()[i])+"\n");
				}
				catch(NoPointsException e){
				}
			}
			//Close the output stream
			out.close();
		}
		catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void load(){
		Scanner sc;
		try {
			sc = new Scanner(new File("save.txt")).useDelimiter("\\s"); // Luetaan tiedostosta save.txt, käytetään erottimena " "
			pelaajat.removeAll(pelaajat); 
			pelaajat.add(new Pelaaja(sc.nextLine()));
			pelaajat.add(new Pelaaja(sc.nextLine()));
			currentPelaaja=sc.nextInt();
			sc.nextLine();
			sc.nextLine();
			while(true){
				try{
					pelaajat.get(0).getVihko().load(Jatsiyhdistelma.valueOf(sc.next()), sc.nextInt());
				}
					catch(IllegalArgumentException e){ // Rivillä lukee "stop"
						break;
					}
				sc.nextLine();
			}
			while(sc.hasNext()){
				pelaajat.get(1).getVihko().load(Jatsiyhdistelma.valueOf(sc.next()), sc.nextInt());
				sc.nextLine();
			}
			sc.close();
		} 
		catch (FileNotFoundException e) {
		}
		
	}


}
