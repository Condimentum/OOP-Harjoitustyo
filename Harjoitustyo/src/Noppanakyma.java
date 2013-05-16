import javax.swing.*;

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
	private JLabel otsikko;
	NoppaKuva a1;
	
    public Noppanakyma() {
    	NoppaKuva a1 = new NoppaKuva();
    	JLabel tausta =new JLabel(new ImageIcon("tausta.png"));
    	tausta.setLayout(null);
    	
    	
    	Random rnd = new Random();
    	final int a = rnd.nextInt(6)+1;
    	final int b = rnd.nextInt(6)+1;
    	final int c = rnd.nextInt(6)+1;
    	final int d = rnd.nextInt(6)+1;
    	final int e = rnd.nextInt(6)+1;
    	
    	vaihto = new JButton("Vaihda Noppia");
    	
    	
    	
    	vaihto.setBounds(435,405,150,40);
    	
    	
    	
    	nappi1 = new JButton(new ImageIcon(a1.annaSilma(a,0)));
    	nappi1.setBorder(BorderFactory.createEmptyBorder());
    	nappi1.setBounds(160,475,100,100);
    	nappi1.addMouseListener(
    			
 		       new MouseListener () {
 		    	   int p=0;
 		        public void actionPerformed(Action tapahtuma) {
 		        
 		        }

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// 0 = Vapaa : 1 = Lukittu
						NoppaKuva q = new NoppaKuva();
						if(p%2==0){
						nappi1.setIcon((Icon)(new ImageIcon(q.annaSilma(a,1))));
						p++;
					}
						else{
							p++;
							nappi1.setIcon((Icon)(new ImageIcon(q.annaSilma(a,0))));
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
    	
    	
    	
    	
    	nappi2 = new JButton(new ImageIcon(a1.annaSilma(b,0)));
    	nappi2.setBorder(BorderFactory.createEmptyBorder());
    	nappi2.setBounds(310,475,100,100);
    	nappi2.addMouseListener(
    			
  		       new MouseListener () {
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						// 0 = Vapaa : 1 = Lukittu
 						NoppaKuva q = new NoppaKuva();
 						if(p%2==0){
 						nappi2.setIcon((Icon)(new ImageIcon(q.annaSilma(b,1))));
 						p++;
 					}
 						else{
 							p++;
 							nappi2.setIcon((Icon)(new ImageIcon(q.annaSilma(b,0))));
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
    	
    	
    	nappi3 = new JButton(new ImageIcon(a1.annaSilma(c,0)));
    	nappi3.setBorder(BorderFactory.createEmptyBorder());
    	nappi3.setBounds(460,475,100,100);
    	nappi3.addMouseListener(
    			
  		       new MouseListener () {
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						// 0 = Vapaa : 1 = Lukittu
 						NoppaKuva q = new NoppaKuva();
 						if(p%2==0){
 						nappi3.setIcon((Icon)(new ImageIcon(q.annaSilma(c,1))));
 						p++;
 					}
 						else{
 							p++;
 							nappi3.setIcon((Icon)(new ImageIcon(q.annaSilma(c,0))));
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
    	
    	
    	
    	nappi4 = new JButton(new ImageIcon(a1.annaSilma(d,0)));
    	nappi4.setBorder(BorderFactory.createEmptyBorder());
    	nappi4.setBounds(610,475,100,100);
    	nappi4.addMouseListener(
    			
  		       new MouseListener () {
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						// 0 = Vapaa : 1 = Lukittu
 						NoppaKuva q = new NoppaKuva();
 						if(p%2==0){
 						nappi4.setIcon((Icon)(new ImageIcon(q.annaSilma(d,1))));
 						p++;
 					}
 						else{
 							p++;
 							nappi4.setIcon((Icon)(new ImageIcon(q.annaSilma(d,0))));
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
    	
    	
    	
    	nappi5 = new JButton(new ImageIcon(a1.annaSilma(e,0)));
    	nappi5.setBorder(BorderFactory.createEmptyBorder());
    	nappi5.setBounds(760,475,100,100);
    	nappi5.addMouseListener(
    			
  		       new MouseListener () {
  		    	   int p=0;
  		        public void actionPerformed(Action tapahtuma) {
  		        
  		        }

 					@Override
 					public void mouseClicked(MouseEvent arg0) {
 						// 0 = Vapaa : 1 = Lukittu
 						NoppaKuva q = new NoppaKuva();
 						if(p%2==0){
 						nappi5.setIcon((Icon)(new ImageIcon(q.annaSilma(e,1))));
 						p++;
 					}
 						else{
 							p++;
 							nappi5.setIcon((Icon)(new ImageIcon(q.annaSilma(e,0))));
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
    	tausta.add(otsikko);
    	
        setTitle("Yatzi!!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
    }
    public static void main(String[] args) {
        new Noppanakyma();
    }

}
