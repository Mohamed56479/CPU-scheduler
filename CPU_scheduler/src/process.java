
public class process {
	private String name;
	private int priority;
	private int burst_time;
	private int arrival_time;
	 private boolean state;
	 private int start;
	 private int wait;
     private int end;
     private int ternarround;
     
	public process(String name, int priority,int arrival_time, int burst_time) {
		
		this.name = name;
		this.priority = priority;	
		this.arrival_time = arrival_time;
		this.burst_time = burst_time;
		this.state=true;
	}
	
    public process(String name,int arrival_time, int burst_time) {
		
		this.name = name;	
		this.arrival_time = arrival_time;
		this.burst_time = burst_time;
		this.state=true;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getBurst_time() {
		return burst_time;
	}
	
	public void setBurst_time(int burst_time) {
		this.burst_time = burst_time;
	}
	
	public int getArrival_time() {
		return arrival_time;
	}
	
	public void setArrival_time(int arrival_time) {
		this.arrival_time = arrival_time;
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	public int getStart() {
		return start;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getWait() {
		return wait;
	}
	
	public void setWait(int wait) {
		this.wait = wait;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}
	
	public int getTernarround() {
		return ternarround;
	}
	
	public void setTernarround(int ternarround) {
		this.ternarround = ternarround;
	}

	  @Override
	    public String toString() {
	        return "{" + "Name=" + name + ", priority=" + priority + ", arrival=" + arrival_time + ", brust=" + burst_time +  ", start=" + start + ", wait=" + wait + ", end=" + end + ", ternarround=" + ternarround + '}';
	    }
	  public String print() {
		  return "{" + "Name=" + name  + ", arrival=" + arrival_time + ", brust=" + burst_time +  ", start=" + start + ", wait=" + wait + ", end=" + end + ", ternarround=" + ternarround + '}';
	  }
	  public String view() {
		  return "{" + "Name=" + name  + ", arrival=" + arrival_time + ", brust=" + burst_time +  ", start=" + start + ", end=" + end  + '}';
	  }
	

}
