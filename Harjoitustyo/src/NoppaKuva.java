import java.awt.*;
import javax.swing.*;


public class NoppaKuva {

	Image s1;
	Image s2;
	Image s3;
	Image s4;
	Image s5;
	Image s6;
	
	Image o1;
	Image o2;
	Image o3;
	Image o4;
	Image o5;
	Image o6;
	
	public NoppaKuva(){
		ImageIcon i = new ImageIcon("noppa_1_lock.png");
		s1 = i.getImage();
		
		ImageIcon ii = new ImageIcon("noppa_2_lock.png");
		s2 = ii.getImage();
		
		ImageIcon iii = new ImageIcon("noppa_3_lock.png");
		s3 = iii.getImage();
		
		ImageIcon iiii = new ImageIcon("noppa_4_lock.png");
		s4 = iiii.getImage();
		
		ImageIcon iiiii = new ImageIcon("noppa_5_lock.png");
		s5 = iiiii.getImage();
		
		ImageIcon iiiiii = new ImageIcon("noppa_6_lock.png");
		s6 = iiiiii.getImage();
		
		
		
		ImageIcon e = new ImageIcon("noppa_1.png");
		o1 = e.getImage();
		
		ImageIcon ee = new ImageIcon("noppa_2.png");
		o2 = ee.getImage();
		
		ImageIcon eee = new ImageIcon("noppa_3.png");
		o3 = eee.getImage();
		
		ImageIcon eeee = new ImageIcon("noppa_4.png");
		o4 = eeee.getImage();
		
		ImageIcon eeeee = new ImageIcon("noppa_5.png");
		o5 = eeeee.getImage();
		
		ImageIcon eeeeee = new ImageIcon("noppa_6.png");
		o6 = eeeeee.getImage();
			}
	
	public Image annaSilma(int silmaluku, int lukitus){
		if(silmaluku==1){
			if(lukitus==0){
				return o1;
			}
			else{
			return s1;
			}
		}
		else if(silmaluku==2){
				if(lukitus==0){
					return o2;
				}
				else{
					return s2;
				}
		}
		else if(silmaluku==3){
				if(lukitus==0){
					return o3;
				}
				else{
					return s3;
				}
		}
		else if(silmaluku==4){
				if(lukitus==0){
					return o4;
				}
				else{
					return s4;
				}
		}
		else if(silmaluku==5){
				if(lukitus==0){
					return o5;
				}
				else{
					return s5;
				}
		}
		else{
			if(lukitus==0){
				return o6;
			}
			else{
				return s6;
			}
		}
	}
}