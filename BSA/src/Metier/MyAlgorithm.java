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
	int id;
	

	public MyAlgorithm(Configuration setup,Problem pbm) {
		
		this.sol=new Solution(pbm);
		this._setup = setup;
		this.runTable.setSize(_setup.getNbRun());
		double[][]oldPop=new double[_setup.getPopsize()][_setup.getDim()];
		double[][]P=new double[_setup.getPopsize()][_setup.getDim()];
		double[][]Mutant=new double[_setup.getPopsize()][_setup.getDim()];
		double[][]Map=new double[_setup.getPopsize()][_setup.getDim()];
		double[][]T=new double[_setup.getPopsize()][_setup.getDim()];
		
		Vector<Double> fitP=new Vector<Double>();
		fitP.setSize(_setup.getPopsize());
		Vector<Double> fitT=new Vector<Double>();
		fitT.setSize(_setup.getPopsize());
		
		globalMinimizer.setSize(_setup.getDim());
		mutT.setSize(_setup.getDim());
		sol.random(pbm.UpperLimit, pbm.LowerLimit);
		_lower_cost=sol.fitness(sol.TabLine);
		_upper_cost=_lower_cost;
		
		globalMin=Double.MAX_VALUE;
		
		for(int r=0;r<_setup.getNbRun();r++){
			
			System.out.println("Nb d'execution : "+r);
			int flag = 0;
			
			for(i=0;i<_setup.getPopsize();i++){
				
				sol.TabLine.clear();
				sol.random(pbm.UpperLimit, pbm.LowerLimit);
				
				for(j=0;j<_setup.getDim();j++){
					P[i][j]=sol.TabLine.elementAt(j);
					oldPop[i][j]=sol.TabLine.elementAt(j);
				}
				
				fitP.setElementAt(sol.fitness(sol.TabLine), i);
				
					
			}
			
			for(int k=0;k<_setup.getNbItRun();k++){
				min=fitP.elementAt(0);
				max=fitP.elementAt(0);
			
				
				
				for(i=0;i<_setup.getPopsize();i++){
					//int id=0;
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
				//&PERMUTATION
				for (i = 0; i < _setup.getPopsize(); i++)
				{
					for (j = 0; j < _setup.getDim(); j++)
					{
						if (a < b)
						{
							oldPop[i][j] = P[i][j];
						}

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
						F = 3 * rnd.nextDouble();
						Mutant[i][j] = P[i][j] + ((oldPop[i][j] - P[i][j]) * F);
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
				
				if (c < d)
				{
					for (i = 0; i < _setup.getPopsize(); i++)
					{
						
						tempMut =rnd.nextInt(_setup.getDim()-1);
						for (j = 1; j <= randomMutants; j++)
						{
							while (Exists(tempMut)&&mutT!=null)
							{
								tempMut =rnd.nextInt(_setup.getDim()-1);
							}
							mutT.setElementAt(tempMut, j);
							int m=mutT.get(j);
							Map[i][m]=0;
						}
					}
				}
				////////////////////////////
				
			else{
					int randi;
					for(i=0;i<_setup.getPopsize();i++){
						randi=rnd.nextInt(_setup.getDim()-1);  // else petite (Pseudo-code)
						Map[i][randi]=0;
						
					}	
				}
				/////////  
				for (i = 0; i < _setup.getPopsize(); i++)
				{
					for (j = 0; j < _setup.getDim(); j++)
					{
						T[i][j] = Mutant[i][j];
					}
				}
				
				for (i = 0; i < _setup.getPopsize(); i++)
				{
					for (j = 0; j < _setup.getDim(); j++)
					{
						if (Map[i][j] == 1)
						{
							T[i][j] = P[i][j];
						}
					}
				}
				
	//Boundary Control
				for (i = 0; i < _setup.getPopsize(); i++)
				{
					sol.TabLine.clear();

					for (j = 0; j < _setup.getDim(); j++)
					{
						if (T[i][j] < pbm.LowerLimit || T[i][j] > pbm.UpperLimit)
						{
							T[i][j] = pbm.LowerLimit + (pbm.UpperLimit - pbm.LowerLimit) * rnd.nextDouble();
						}
						sol.TabLine.add(T[i][j]);
					}
					fitT.setElementAt(sol.fitness(sol.TabLine), i);
				}
	//Selection 2
				for (i = 0; i < _setup.getPopsize(); i++)
				{
					for (j = 0; j < _setup.getDim(); j++)
					{

						if (fitT.elementAt(i) < fitP.elementAt(i))
						{
							P[i][j] = T[i][j];
							fitP.setElementAt(fitT.elementAt(i), i);
						}
					}

				}
				
				fitBest = best_cost();
				
				if (fitBest <= globalMin)
				{
					globalMin = fitBest;
					for (i = 0; i < _setup.getPopsize(); i++)
					{
						for (j = 0; j < _setup.getDim(); j++)
						{
							if (i == indexBest)
							{
								globalMinimizer.setElementAt(P[i][j], j);
							}
						}
					}
				}
				
				
			   }//fin k
			
			//cout << "Meilleur individu : " << indexBest << endl;
			for (j = 0; j < _setup.getDim(); j++)
			{
				//cout << globalMinimizer[j] << " ";
			}
			//cout << endl;

			runTable.setElementAt(globalMin, r);;

			//
			//file.open("result.txt", ios::app);
			//file << "IndexBest:" << indexBest << endl;
			//file << "BestFitness:" << fitBest << endl << endl;
			//file.close();

		} // fin r 
		
		double sum = 0.0;
		double mean = 0.0;
		double temp = 0.0;
		double variance = 0.0;
		double deviation = 0.0;
				
		
		for (i = 0; i < _setup.getNbRun(); i++)
		{
			sum += runTable.elementAt(i);
		}
		
		mean = sum / _setup.getNbRun();
		System.out.println("Moyenne"+mean);
		
		for (i = 0; i < _setup.getNbRun(); i++)
		{
			temp += Math.pow((runTable.elementAt(i) - mean), 2);
		}
		variance = temp / _setup.getNbRun();
		System.out.println("Variance"+variance);
		
		deviation = Math.sqrt(variance);
		System.out.println("Ecart-type "+deviation);
						
			
			}
		
	public double best_cost(){
		return _lower_cost;
	}
	public double worst_cost(){
		return _upper_cost;
	}
	
	public boolean Exists(int tempM)
	{
		int j;
		for (j = 1; j <= randomMutants; j++)
		{
			if (mutT.elementAt(j).equals(tempM))
				return true;
		}
		return false;
	}
	
}
