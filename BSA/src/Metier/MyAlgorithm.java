package Metier;
import java.util.Vector;

public class MyAlgorithm {

	private Solution sol;
	private Configuration _setup;
	private double _upper_cost;
	private double _lower_cost;
	private int randomMutants;
	private int tempMut;
	private double globalMin;
	private int mutT;
	private double globalMinimizer;
	private Vector<Double> runTable=new Vector<Double>();
	
	
	
	
	public MyAlgorithm(Solution sol,Configuration _setup) {
		
		this.sol=sol;
		this._setup = _setup;
		int t=_setup.getNbRun();
		this.runTable.setSize(_setup.getNbRun());//_setup.getNbRun();
		double[][]oldPop=new double[_setup.getPopsize()][];
		double[][]P=new double[_setup.getPopsize()][];
		double[][]Mutant=new double[_setup.getPopsize()][];
		double[][]Map=new double[_setup.getPopsize()][];
		double[][]T=new double[_setup.getPopsize()][];
		
		Vector<Double> fitP=new Vector<Double>();
		fitP.setSize(_setup.getPopsize());
		
		
		
		/*, double _upper_cost, double _lower_cost, int randomMutants,
			int tempMut, double globalMin, int mutT, double globalMinimizer, double runTable
		this._upper_cost = _upper_cost;
		this._lower_cost = _lower_cost;
		this.randomMutants = randomMutants;
		this.tempMut = tempMut;
		this.globalMin = globalMin;
		this.mutT = mutT;
		this.globalMinimizer = globalMinimizer;*/
		
	}
	
	
	
	
	
	
	
}
