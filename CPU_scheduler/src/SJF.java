import java.util.Scanner;

public class SJF {
	
	String name;
	int arrival_time;
	int burst_time;	
	
	//this function displays all about sjf scheduling
	public void Display_menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of processes: ");
        int n=sc.nextInt();
        process processlist[] = new process[n];
        for(int i=0; i<n; i++) {
        	 
        	   System.out.println("Enter name of process " + (i+1));
               name = sc.next();
               System.out.println("Enter arival time of process" + (i+1));
               arrival_time = sc.nextInt();
               System.out.println("Enter brust time of process" + (i+1));
               burst_time = sc.nextInt();
               processlist[i] = new process(name, arrival_time, burst_time);
        }
        /*
        process processlist[] = new process[4];  //(Name,arrive,burst)
        processlist[0] = new process("p1", 0, 7);
        processlist[1] = new process("p2", 2, 4);
        processlist[2] = new process("p3", 4, 5);
        processlist[3] = new process("p4", 5, 9);
        
        */
        int index = 0;
        double Avgwaiting_time = 0;
        double Avgternarround_time = 0;
        int cur_time=0;
        for (int i = 0; i < 4; i++) {
            index = get_shortest(processlist, cur_time); //get shortest burst time
            processlist[index].setStart(cur_time);
            processlist[index].setEnd(processlist[index].getBurst_time()  + processlist[index].getStart());
            processlist[index].setWait(processlist[index].getStart() - processlist[index].getArrival_time());
            processlist[index].setTernarround(processlist[index].getWait() + processlist[index].getBurst_time() );
            Avgwaiting_time += processlist[index].getWait();
            Avgternarround_time += processlist[index].getTernarround();
            System.out.println(processlist[index].print());
            processlist[index].setState(false);
            cur_time = cur_time + processlist[index].getBurst_time() ;
           
        }
        System.out.println("Average Waiting Time = " + Avgwaiting_time / processlist.length);

        System.out.println("Average Turnaround Time =" + Avgternarround_time / processlist.length+"\n");
  }
	
	//return shortest burst time
	  public int get_shortest(process processlist[],int cur_time) {
		  int shortest = 1000;
	       int index = 0 ;
	       
	       for(int i=0; i<processlist.length;i++) {
	    	   if(processlist[i].getArrival_time()<=cur_time && processlist[i].isState()==true) {
	    		   if(processlist[i].getBurst_time()<shortest) {
	    			   index=i;
	    			   shortest = processlist[i].getBurst_time();
	    		   }
	    		   else if(processlist[i].getBurst_time()==shortest) {
	    			   if(processlist[i].getArrival_time()<processlist[index].getArrival_time()) {
	    				   index=i;
	    				   shortest = processlist[i].getBurst_time();
	    			   }
	    		   }
	    	   }
	       }
	       
	       //solve starvation
	       int max_burst=0;
	       int max_index=0;
	      
	        for (int i = 0; i < processlist.length; i++) { //get max burst time
	        		if (processlist[i].getBurst_time()>max_burst && processlist[i].isState()==true) {
	        			
	        			max_burst = processlist[i].getBurst_time();
	        			max_index =i;
	                    
	                }
	        	
	        }
	        if (processlist[max_index].getBurst_time()>20 && processlist[max_index].isState()==true) {
	       processlist[max_index].setBurst_time(processlist[max_index].getBurst_time() - 1);//burst-1
	        }
		  return index;
	  }  
}
