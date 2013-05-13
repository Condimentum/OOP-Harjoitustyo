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
		ImageIcon i = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_1_lock.png");
		s1 = i.getImage();
		
		ImageIcon ii = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_2_lock.png");
		s2 = ii.getImage();
		
		ImageIcon iii = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_3_lock.png");
		s3 = iii.getImage();
		
		ImageIcon iiii = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_4_lock.png");
		s4 = iiii.getImage();
		
		ImageIcon iiiii = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_5_lock.png");
		s5 = iiiii.getImage();
		
		ImageIcon iiiiii = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_6_lock.png");
		s6 = iiiiii.getImage();
		
		
		
		ImageIcon e = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_1.png");
		o1 = e.getImage();
		
		ImageIcon ee = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_2.png");
		o2 = ee.getImage();
		
		ImageIcon eee = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_3.png");
		o3 = eee.getImage();
		
		ImageIcon eeee = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_4.png");
		o4 = eeee.getImage();
		
		ImageIcon eeeee = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_5.png");
		o5 = eeeee.getImage();
		
		ImageIcon eeeeee = new ImageIcon("C:\\Users\\Jonne\\Yliopisto\\noppa_6.png");
		o6 = eeeeee.getImage();
			}
	
	public Image annaSilmä(int silmäluku, int lukitus){
		if(silmäluku==1){
			if(lukitus==0){
				return o1;
			}
			else{
			return s1;
			}
		}
		else if(silmäluku==2){
				if(lukitus==0){
					return o2;
				}
				else{
					return s2;
				}
		}
		else if(silmäluku==3){
				if(lukitus==0){
					return o3;
				}
				else{
					return s3;
				}
		}
		else if(silmäluku==4){
				if(lukitus==0){
					return o4;
				}
				else{
					return s4;
				}
		}
		else if(silmäluku==5){
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