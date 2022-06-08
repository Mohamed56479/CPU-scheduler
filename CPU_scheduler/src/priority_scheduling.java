import java.util.Scanner;

public class priority_scheduling {
	String name;
	int priority;
	int arrival_time;
	int burst_time;	
	int context_switching;
	
//this function displays all about priority scheduling
	public void Display_menu() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("enter number of processes: ");
	        int n=sc.nextInt();
	        process processlist[] = new process[n];
	        for(int i=0; i<n; i++) {
	        	 
	        	   System.out.println("Enter name of process " + (i+1));
                   name = sc.next();
                   System.out.println("Enter priority of process" + (i+1));
                   priority = sc.nextInt();
                   System.out.println("Enter arival time of process" + (i+1));
                   arrival_time = sc.nextInt();
                   System.out.println("Enter brust time of process" + (i+1));
                   burst_time = sc.nextInt();
                   processlist[i] = new process(name, priority, arrival_time, burst_time);
	        }
	        
	        System.out.println("enter number of context_switching: ");
	        context_switching= sc.nextInt();
	        /*
	        process processlist[] = new process[5];  //(Name ,priority,arrive,burst)
	        processlist[0] = new process("p1", 3, 3, 3);
	        processlist[1] = new process("p2", 1, 0, 3);
	        processlist[2] = new process("p3", 25,3, 1);
	        processlist[3] = new process("p4", 6, 2, 2);
	        processlist[4] = new process("p5", 2, 4, 4);
            */
	      
	        
	        int index = 0;
	        double Avgwaiting_time = 0;
	        double Avgternarround_time = 0;
	        int cur_time=0;
	        for (int i = 0; i < 5; i++) {
                index = get_maxpriority(processlist, cur_time); //get index of max priority
                processlist[index].setStart(cur_time);
                processlist[index].setEnd(processlist[index].getBurst_time() + context_switching + processlist[index].getStart());
                processlist[index].setWait(processlist[index].getStart() - processlist[index].getArrival_time());
                processlist[index].setTernarround(processlist[index].getWait() + processlist[index].getBurst_time() + context_switching);
                Avgwaiting_time += processlist[index].getWait();
                Avgternarround_time += processlist[index].getTernarround();
                System.out.println(processlist[index].toString());
                processlist[index].setState(false);
                cur_time = cur_time + processlist[index].getBurst_time() + context_switching;
               
            }
            System.out.println("Average Waiting Time = " + Avgwaiting_time / processlist.length);

            System.out.println("Average Turnaround Time =" + Avgternarround_time / processlist.length+"\n");
	  }
	 
	//function that return index of max priority
	  public int get_maxpriority(process processlist[],int cur_time) {
		  int max_priority = 1000;
	       int index = 0 ;
	       
	       for(int i=0; i<processlist.length;i++) {
	    	   if(processlist[i].getArrival_time()<=cur_time && processlist[i].isState()==true) {
	    		   if(processlist[i].getPriority()<max_priority) {
	    			   index=i;
	    			   max_priority = processlist[i].getPriority();
	    		   }
	    		   else if(processlist[i].getPriority()==max_priority) { //if equal compare with arrival
	    			   if(processlist[i].getArrival_time()<processlist[index].getArrival_time()) {
	    				   index=i;
	    				   max_priority = processlist[i].getPriority();
	    			   }
	    		   }
	    	   }
	       }
	        //solve starvation

	       int min_priority=0;
	       int max_index=0;
	        for (int i = 0; i < processlist.length; i++) { //get min priority
	        		if (processlist[i].getPriority()>min_priority && processlist[i].isState()==true) {
	        			
	        			min_priority = processlist[i].getPriority();
	        			max_index =i;
	                    
	                }
	        	
	        }
    		if (processlist[max_index].getPriority()>20 && processlist[max_index].isState()==true) {

	       processlist[max_index].setPriority(processlist[max_index].getPriority() - 1);//priority-1
    		}
		  return index;
	  }
	  
	  
}
