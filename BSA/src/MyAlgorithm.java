import java.util.Vector;

public class MyAlgorithm {

	private Solution sol;
	private Configuration _setup;
	private double _upper_cost;
	private double _lower_cost;
	private int randomMutants;
	private int tempMut;
	private double globalMin;
	private Vector<Integer> mutT=new Vector<Integer>();
	private Vector<Double> globalMinimizer=new Vector<Double>();
	private Vector<Double> runTable=new Vector<Double>();
	
	double min;
	double max;
	double fitBest;
	int i, j;
	
	
	
	
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
		Vector<Double> fitT=new Vector<Double>();
		fitT.setSize(_setup.getPopsize());
		
		this.globalMinimizer.setSize(_setup.getDim());
		this.mutT.setSize(_setup.getDim());
		
		_lower_cost=sol.fitness(sol.TabLine);
		_upper_cost=_lower_cost;
		
		
		
	}
	
		public void Operation(){
			
			
			globalMin=Double.MAX_VALUE;
			
			for(int r=0;r<_setup.getNbRun();r++){
				
				System.out.println("Nb d'execution : "+r);
				
				for(i=0;i<_setup.getPopsize();i++){
					
					for(j=0;j<_setup.getPopsize();j++){
						
						/*P[i][j]=new double[_setup.getDim()][];
						T[i][j]=new double[_setup.getDim()][];
						oldP*/
						
						
					}
					
				}
				
				int flag = 0;
			}
		}
}
