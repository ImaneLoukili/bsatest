package Metier;

import java.util.Random;
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
	int indexBest;
	int indexWorst;
	
	
	
	public MyAlgorithm(Solution sol,Configuration _setup) {
		
		this.sol=sol;
		this._setup = _setup;
		int t=_setup.getNbRun();
		this.runTable.setSize(_setup.getNbRun());//_setup.getNbRun();
		double[][]oldPop=new double[_setup.getDim()][_setup.getPopsize()];
		double[][]P=new double[_setup.getDim()][_setup.getPopsize()];
		double[][]Mutant=new double[_setup.getDim()][_setup.getPopsize()];
		double[][]Map=new double[_setup.getDim()][_setup.getPopsize()];
		double[][]T=new double[_setup.getDim()][_setup.getPopsize()];
		
		Vector<Double> fitP=new Vector<Double>();
		fitP.setSize(_setup.getPopsize());
		Vector<Double> fitT=new Vector<Double>();
		fitT.setSize(_setup.getPopsize());
		
		this.globalMinimizer.setSize(_setup.getDim());
		this.mutT.setSize(_setup.getDim());
		
		_lower_cost=sol.fitness(sol.TabLine);
		_upper_cost=_lower_cost;
		
		globalMin=Double.MAX_VALUE;
		
		for(int r=0;r<_setup.getNbRun();r++){
			
			System.out.println("Nb d'execution : "+r);
			int flag = 0;
			
			for(i=0;i<_setup.getPopsize();i++){
				
				sol.TabLine.clear();
				//sol.rand();
				
				for(j=0;j<_setup.getPopsize();j++){
					P[i][j]=sol.TabLine.elementAt(j);
					oldPop[i][j]=sol.TabLine.elementAt(j);
				}
				
				fitP.setElementAt(sol.fitness(sol.TabLine), i);
				
					
			}
			
			for(int k=0;k<_setup.getNbItRun();k++){
				min=fitP.elementAt(0);
				max=fitP.elementAt(0);
				
				int id = 0;
				
				for(i=0;i<_setup.getPopsize();i++){
					if(fitP.elementAt(i)==fitP.elementAt(0)){
						_lower_cost=fitP.elementAt(0);
						_upper_cost=fitP.elementAt(0);
						flag=1;
						id=i;
					}
					else if(fitP.elementAt(i)<min){
						_lower_cost=fitP.elementAt(i);
						min=best_cost();
						flag=2;
						id=i;
					}
					else if(fitP.elementAt(i)>max){
						_upper_cost=fitP.elementAt(i);
						max=worst_cost();
						flag=3;
						id=i;
					}
					else {}
					if (flag == 1)
					{
						indexBest=id+1;
						indexWorst=id+1;
						
					}
					else if (flag == 2)
					{
						indexBest = id + 1;
					}
					else if (flag == 3)
					{
						indexWorst = id + 1;
					}
					else{}
					
				}
				Random rnd=new Random();
				double a=rnd.nextDouble();
				double b=rnd.nextDouble();
				double c=rnd.nextDouble();
				double d=rnd.nextDouble();
				
	//SELECTION1			
				for (i = 0; i < _setup.getPopsize(); i++)
				{
					for (j = 0; j < _setup.getDim(); j++)
					{
						if (a < b)
						{
							oldPop[i][j] = P[i][j];
						}
					}
				}
	//PERMUTATION
				for (i = 0; i < _setup.getPopsize(); i++)
				{
					for (j = 0; j < _setup.getDim() / 2; j++)
					{
						
						int randA=rnd.nextInt(_setup.getPopsize()-1);
						int randB=rnd.nextInt(_setup.getPopsize()-1);

						double temp;
						
						temp=oldPop[randA][j];
						oldPop[randA][j]=oldPop[randB][j];
						oldPop[randB][j]=temp;
						
					}
				}
				
	//Mutation 
				
				double F;
				
				for (i = 0; i < _setup.getPopsize(); i++)
				{
					for (j = 0; j < _setup.getDim(); j++)
					{
						//F = 3 * distribution(generator);

						//Mutant[i][j] = P[i][j] + ((oldPop[i][j] - P[i][j]) * F);
					}
				}
				
	//Crossover
				
				for (i = 0; i < _setup.getPopsize(); i++)
				{
					for (j = 0; j < _setup.getDim(); j++)
					{
						Map[i][j] = 1;
					}
				}
				
				randomMutants = (int)Math.ceil(_setup.getMixrate() * _setup.getDim() * a);
				
				
				
				
				
				
			      
			    }
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			}
		
	public double best_cost(){
		return _lower_cost;
	}
	public double worst_cost(){
		return _upper_cost;
	}
}
