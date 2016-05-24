import java.util.Random;
import java.util.Vector;

public class Solution {

	public Vector<Double> TabLine = new Vector<Double>();
	private double currentFitness;
	private int dim;
	private Problem pbm;

	public Solution(double currentFitness, int dim, Problem pbm) {
		super();
		this.currentFitness = currentFitness;
		this.dim = dim;
		this.pbm = pbm;
	}

	public double getCurrentFitness() {
		return currentFitness;
	}

//	public void random(double upper, double lower) {
//		Random rnd = new Random();
//		Configuration conf;
//		dim = conf.getDim();
//		for (int j = 0; j < dim; j++) {
//			TabLine.push_back(lower + (upper - lower) *  (double)rnd.nextInt(1));
//		}
//	}

	public Vector<Double> getTabLine() {
		return TabLine;
	}

	public double fitness(Vector<Double> tabL) {
		double sum = 0.0;
		currentFitness = 0.0;

		int j; // limité à la dim

		switch (pbm.getFunction_id()) {
		case 1: // Rosenbrock

			for (j = 0; j < dim - 1; j++) {
				sum = 100 * (Math.pow((tabL.get(j + 1) - Math.pow(tabL.get(j), 2)), 2)) + Math.pow(tabL.get(j) - 1, 2);
			}

			currentFitness = sum;

			break;

		case 2: // Rastrigin

			for (j = 0; j < dim; j++) {
				sum = Math.pow(tabL.get(j), 2) - (10 * Math.cos(2 * Math.PI * tabL.get(j)));
			}

			currentFitness = (10 * dim) + sum;

			break;

		case 3: // Ackley

			double A = 0, B = 0;

			for (j = 0; j < dim; j++) {
				A = Math.pow(tabL.get(j), 2);
				B = Math.cos(2 * Math.PI * tabL.get(j));
			}
			sum = -20 * Math.exp(-0.2 * Math.sqrt((1 / dim) * A)) - Math.exp((1 / dim) * B) + 20 + Math.exp(1);

			currentFitness = sum;

			break;

		case 4: // Weierstrass

			int i = 0;
			double a, b;
			int k_max;
			a = 0.5;
			b = 3.0;
			k_max = 20;

			for (j = 0; j < dim; j++) {
				for (int t = 0; t <= k_max; t++) {
					sum += Math.pow(a, (double) t)
							* Math.cos(2.0 * Math.PI * Math.pow(b, (double) t) * (tabL.get(j) + 0.5));
				}
			}

			currentFitness = sum;

			break;
		}
		return currentFitness;
	}

}
