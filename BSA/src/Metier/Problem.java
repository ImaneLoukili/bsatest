package Metier;

public class Problem {
	private int dim;
	private int function_id;
	public double LowerLimit;
	public double UpperLimit;

	public Problem() {

		dim = 30;
		function_id = 1;
		LowerLimit = -2.048;
		UpperLimit = 2.048;
	}

	public Problem(int dim, int function_id) {
		super();
		this.dim = dim;
		this.function_id = function_id;
	}

	public void LimitFunction(int function_id) {
		switch (function_id) {
		case 1: // Rosenbrock
			LowerLimit = -2.048;
			UpperLimit = 2.048;
			break;
		case 2: // Rastrigin
			LowerLimit = -5.12;
			UpperLimit = 5.12;
			break;
		case 3: // Ackley
			LowerLimit = -32.768;
			UpperLimit = 32.768;
			break;
		
		case 4: // Weierstrass
			LowerLimit = -100; 
			UpperLimit = 100;
			break;
		case 5: // Griewank
			LowerLimit = -600;
			UpperLimit = 600;
			break;
		}
	}

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}

	public int getFunction_id() {
		return function_id;
	}

	public void setFunction_id(int function_id) {
		this.function_id = function_id;
	}
	
}