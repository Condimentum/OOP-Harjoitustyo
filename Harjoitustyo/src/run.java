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
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import javax.imageio.*;

public class run extends JFrame{
	
	private int heitot;
	private ArrayList<Pelaaja> pelaajat;
	private int currentPelaaja;
	private Clip clip;
	
	private JButton nappi1;
	private JButton nappi2;
	private JButton nappi3;
	private JButton nappi4;
	private JButton nappi5;
	private JButton vaihto;
	private JTextField kentta;
	private JTextArea pelaaja1;
	private JTextArea pelaaja2;
	private JTextArea yhdistelmaRivi;
	private JLabel otsikko;
	NoppaKuva a1;
	
	private ArrayList<Yhdistelma> yhdistelmat;
	private int valinta;
	
    public run() {
    	pelaajat = new ArrayList<Pelaaja>();
    	pelaajat.add(new Pelaaja("Pelaaja 1"));
    	pelaajat.add(new Pelaaja("Pelaaja 2"));
    	currentPelaaja=0;
    	heitot=0;
    	NoppaKuva a1 = new NoppaKuva();
    	JLabel tausta =new JLabel(new ImageIcon("tausta.png"));
    	tausta.setLayout(null);
    	
    	
    	Random rnd = new Random();
    	/**
    	final int a = rnd.nextInt(6)+1;
    	final int b = rnd.nextInt(6)+1;
    	final int c = rnd.nextInt(6)+1;
    	final int d = rnd.nextInt(6)+1;
    	final int e = rnd.nextInt(6)+1;
    	*/
    	
    	vaihto = new JButton("Heita");
    	
    	
    	
    	vaihto.setBounds(435,405,150,40);
    	vaihto.addMouseListener(
    			
    			
    			new MouseListener () {
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot<3){
 							heitot++;
 							otsikko.setText(pelaajat.get(currentPelaaja).getNimi()+"   heitot: " + (3-heitot));
 							pelaajat.get(currentPelaaja).heita();
 							nappi1.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[0].getImage())));
 							nappi2.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[1].getImage())));
 							nappi3.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[2].getImage())));
 							nappi4.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[3].getImage())));
 							nappi5.setIcon((Icon)(new ImageIcon(pelaajat.get(currentPelaaja).getKasi().getNopat()[4].getImage())));
 						}
 						if(heitot==3){
 							vaihto.setText("Vaihda Pelaajaa");
 							otsikko.setText(pelaajat.get(currentPelaaja).getNimi()+"   heitot: " + 0);
 							yhdistelmat=pelaajat.get(currentPelaaja).mahdollisetYhdistelmat(); // Pisteitä tuottavat yhdistelmät
 							yhdistelmat.addAll(pelaajat.get(currentPelaaja).yliviivattavat());	// Yliviivattavat
 							yhdistelmaRivi.setText("Valitse:"+"\n"+"\n"+pelaajat.get(currentPelaaja).mahdollisetYhdistelmatToString());
 							valinta=Integer.parseInt(kentta.getText())-1;
 							pelaajat.get(currentPelaaja).getVihko().setPisteet(yhdistelmat.get(valinta));
 							if(currentPelaaja==0){
 								pelaaja1.setText("PELAAJA 1" + "\n" + "\n" + pelaajat.get(0).getVihko().toString());
 							}
 							else{
 								pelaaja2.setText("PELAAJA 2" + "\n" + "\n" + pelaajat.get(1).getVihko().toString());
 							}
 							pelaajat.get(currentPelaaja).getKasi().unlock();
 							if(currentPelaaja==1){
 								currentPelaaja=0;
 							}
 							else{
 								currentPelaaja=1;
 							}
 							kentta.setText("");
 							yhdistelmaRivi.setText("Valitse:");
 							otsikko.setText(pelaajat.get(currentPelaaja).getNimi());
 							vaihto.setText("Heita");
 							heitot=0;
 							if(vihkoTaynna()){
 								// lentävä penis tai jotain
 								clip.stop();
 								clip.close();
 								music("Victory.wav");
 								System.out.println("peli loppu");
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
 		    	   int p=0;
 		        public void actionPerformed(Action tapahtuma) {
 		        
 		        }

					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(heitot!=0){
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
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot!=0){
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
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot!=0){
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
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot!=0){
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
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						if(heitot!=0){
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
    	
    	kentta = new JTextField("Kentta");
    	kentta.setBounds(250,10,500,300);
    	
    	kentta = new JTextField("Komennot");
    	kentta.setBounds(700,410,120,30);
    	kentta.addKeyListener(new KeyListener() {
    		public void keyPressed(KeyEvent e) {

    		if(e.getKeyChar() == KeyEvent.VK_ENTER && kentta.getText().length() != 0) {
    		System.out.println("ENTER PRESSED");
    		yhdistelmaRivi.setText(kentta.getText());
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
    	otsikko.setBounds(250,415,200,20);
    	
    	add(tausta);
    	setLayout(new FlowLayout());
    	tausta.add(nappi1);
    	tausta.add(nappi2);
    	tausta.add(nappi3);
    	tausta.add(nappi4);
    	tausta.add(nappi5);
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
    
	public void music(String file){
		try
        {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(file)));
            clip.loop(0);
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
  }
	public boolean vihkoTaynna(){
		for(int i=0; i<pelaajat.size(); i++){
			if(!pelaajat.get(i).getVihko().full()){
				return false;
			}
		}
		return true;
	}


}