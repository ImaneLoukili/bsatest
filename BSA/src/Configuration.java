
public class Configuration {
	
	private int nbRun; 
	private int nbItRun; 
	private int popsize; 
	private int dim; 
	private double mixrate;
	
	public Configuration(int nbRun, int nbItRun, int popsize, int dim, double mixrate) {
		super();
		this.nbRun = nbRun;
		this.nbItRun = nbItRun;
		this.popsize = popsize;
		this.dim = dim;
		this.mixrate = mixrate;
	}

	public int getNbRun() {
		return nbRun;
	}

	public void setNbRun(int nbRun) {
		this.nbRun = nbRun;
	}

	public int getNbItRun() {
		return nbItRun;
	}

	public void setNbItRun(int nbItRun) {
		this.nbItRun = nbItRun;
	}

	public int getPopsize() {
		return popsize;
	}

	public void setPopsize(int popsize) {
		this.popsize = popsize;
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}

	public double getMixrate() {
		return mixrate;
	}

	public void setMixrate(double mixrate) {
		this.mixrate = mixrate;
	} 
	
	
	
	
	
	
}

