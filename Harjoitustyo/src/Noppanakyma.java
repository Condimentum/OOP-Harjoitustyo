import javax.swing.*;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color.*;
import java.awt.Graphics;
import java.util.Random;
import javax.imageio.*;

public class Noppanakyma extends JFrame{
	private JButton nappi1;
	private JButton nappi2;
	private JButton nappi3;
	private JButton nappi4;
	private JButton nappi5;
	private JButton vaihto;
	private JTextField kentta;
	private JTextField pelaaja1;
	private JTextField pelaaja2;
	private JTextField yhdistelm‰Rivi;
	private JLabel otsikko;
	NoppaKuva a1;
	private Jatsikasi nopat;
	
    public Noppanakyma() {
    	nopat = new Jatsikasi();
    	nopat.heita();
    	NoppaKuva a1 = new NoppaKuva();
    	JLabel tausta =new JLabel(new ImageIcon("tausta.png"));
    	tausta.setLayout(null);
    	
    	
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
 						nopat.heita();
 						nappi1.setIcon((Icon)(new ImageIcon(nopat.getNopat()[0].getImage())));
 						nappi2.setIcon((Icon)(new ImageIcon(nopat.getNopat()[1].getImage())));
 						nappi3.setIcon((Icon)(new ImageIcon(nopat.getNopat()[2].getImage())));
 						nappi4.setIcon((Icon)(new ImageIcon(nopat.getNopat()[3].getImage())));
 						nappi5.setIcon((Icon)(new ImageIcon(nopat.getNopat()[4].getImage())));
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
    	
    	
    	
    	nappi1 = new JButton(new ImageIcon(nopat.getNopat()[0].getImage()));
    	nappi1.setBorder(BorderFactory.createEmptyBorder());
    	nappi1.setBounds(160,475,100,100);
    	nappi1.addMouseListener(
    			
 		       new MouseListener () {
 		    	   int p=0;
 		        public void actionPerformed(Action tapahtuma) {
 		        
 		        }

					@Override
					public void mouseClicked(MouseEvent arg0) {
						nopat.getNopat()[0].lock();
						nappi1.setIcon((Icon)(new ImageIcon(nopat.getNopat()[0].getImage())));
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
    	
    	
    	
    	
    	nappi2 = new JButton(new ImageIcon(nopat.getNopat()[1].getImage()));
    	nappi2.setBorder(BorderFactory.createEmptyBorder());
    	nappi2.setBounds(310,475,100,100);
    	nappi2.addMouseListener(
    			
  		       new MouseListener () {
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						nopat.getNopat()[1].lock();
						nappi2.setIcon((Icon)(new ImageIcon(nopat.getNopat()[1].getImage())));
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
    	
    	
    	nappi3 = new JButton(new ImageIcon(nopat.getNopat()[2].getImage()));
    	nappi3.setBorder(BorderFactory.createEmptyBorder());
    	nappi3.setBounds(460,475,100,100);
    	nappi3.addMouseListener(
    			
  		       new MouseListener () {
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						nopat.getNopat()[2].lock();
						nappi3.setIcon((Icon)(new ImageIcon(nopat.getNopat()[2].getImage())));
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
    	
    	
    	
    	nappi4 = new JButton(new ImageIcon(nopat.getNopat()[3].getImage()));
    	nappi4.setBorder(BorderFactory.createEmptyBorder());
    	nappi4.setBounds(610,475,100,100);
    	nappi4.addMouseListener(
    			
  		       new MouseListener () {
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						nopat.getNopat()[3].lock();
						nappi4.setIcon((Icon)(new ImageIcon(nopat.getNopat()[3].getImage())));
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
    	
    	
    	
    	nappi5 = new JButton(new ImageIcon(nopat.getNopat()[4].getImage()));
    	nappi5.setBorder(BorderFactory.createEmptyBorder());
    	nappi5.setBounds(760,475,100,100);
    	nappi5.addMouseListener(
    			
  		       new MouseListener () {
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						nopat.getNopat()[4].lock();
						nappi5.setIcon((Icon)(new ImageIcon(nopat.getNopat()[4].getImage())));
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
    	kentta.setBounds(700,410,120,30);
    	
    	pelaaja1 = new JTextField("T‰h‰n pelaaja 1 tiedot");
    	pelaaja1.setBounds(150,10,200,380);
    	
    	pelaaja2 = new JTextField("T‰h‰n pelaaja 2 tiedot");
    	pelaaja2.setBounds(380,10,200,380);
    	
    	yhdistelm‰Rivi = new JTextField("T‰h‰n yhdistelm‰t ja niiden komennot");
    	yhdistelm‰Rivi.setBounds(680,10,220,380);
    	
    	otsikko = new JLabel("Pelaaja1");
    	otsikko.setBounds(600,415,50,20);
    	
    	add(tausta);
    	setLayout(new FlowLayout());
    	tausta.add(nappi1);
    	tausta.add(nappi2);
    	tausta.add(nappi3);
    	tausta.add(nappi4);
    	tausta.add(nappi5);
    	tausta.add(vaihto);
    	tausta.add(kentta);
    	tausta.add(pelaaja1);
    	tausta.add(pelaaja2);
    	tausta.add(yhdistelm‰Rivi);
    	tausta.add(otsikko);
    	
        setTitle("Yatzi!!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        music();
    }
    public static void main(String[] args) {
        new Noppanakyma();
    }
    
    private void music(){
    	try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("music.wav")));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

}
