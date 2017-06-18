package pesquisa_ordenacao;

public class TimeCounter {
	private long tstart;
	private double tdelta;
	public TimeCounter() {
		
	}
	
	public void start() {
		tstart = System.currentTimeMillis();
	}
	
	public void end() {
		tdelta = (System.currentTimeMillis() - tstart) / 1000.0;
	}
	
	
	public double getTdelta() {
		return tdelta;
	}

	public void setTdelta(double tdelta) {
		this.tdelta = tdelta;
	}

	public static TimeCounter startTime() {
		TimeCounter counter = new TimeCounter();
		counter.start();
		return counter;
	}
}
