import java.util.Scanner;

public class scheduler{
	
	 public static void main(String[] args) {
		 
		 priority_scheduling p= new priority_scheduling();
		 SJF s=new SJF();
		 SRTF sr=new SRTF();
		   Scanner in = new Scanner(System.in);
	        int choise;
	       
	        boolean flag = true;
	        while (flag) {
	            System.out.println("Enter number of your choice: "+"\n");
	            System.out.println("1- Priority Scheduling");
	            System.out.println("2- SJF Scheduling");
	            System.out.println("3- SRTF Scheduling");
	            System.out.println("4- AGAT Scheduling");
	            System.out.println("0- Exit");
	            choise = in.nextInt();
	            switch (choise) {
	            
	            case 0: {
                    flag = false;
                    break;
                }
	            case 1:{
	            	System.out.println("priority scheduling is: "+"\n");
	            	 p.Display_menu();
	            	 break;
	            }
	            case 2: {
	            	System.out.println("SJF scheduling is: "+"\n");
	            	s.Display_menu();
                    break;
                }
                case 3: {
                	System.out.println("SRTF scheduling is: "+"\n");
	            	sr.Display_menu();
                    break;
                }
                case 4: {
                    break;

                }
	            	
	         }
	     }
	}
	 

}