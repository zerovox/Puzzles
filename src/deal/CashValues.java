package deal;

public class CashValues {
	public static int toPence(int i){
		 switch (i) {
         case 0:  return 1;
         case 1:  return 10;
         case 2:  return 50; 
         case 3:  return 100;
         case 4:  return 500;  
         case 5:  return 1000;
         case 6:  return 5000;
         case 7:  return 10000; 
         case 8:  return 25000; 
         case 9:  return 50000; 
         case 10:  return 75000;
         case 11:  return 100000;  
         case 12:  return 300000;
         case 13:  return 500000;
         case 14:  return 1000000; 
         case 15:  return 1500000; 
         case 16:  return 2000000; 
         case 17:  return 3500000;
         case 18:  return 5000000;
         case 19:  return 7500000; 
         case 20:  return 10000000;  
         case 21:  return 25000000; 
         default: return 0;
     }
	}

}
