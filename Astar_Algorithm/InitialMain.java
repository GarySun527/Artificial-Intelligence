
public class InitialMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String easy = "134862705";
		String medium = "281043765";
		String hard = "281463075";
		String worst = "567408321";
		String goal = "123804765";
		
		Node en = new Node(easy);
		Node mn = new Node(medium);
		Node hn = new Node(hard);
		Node wn = new Node(worst);
		
		//if you want to use 'medium', 'hard', or 'worst', please change the 'en' to 'mn','hn',or 'wn'.

		System.out.println("A* search using the heuristic function f*(n) = g(n) + h*(n)");
		//to change 'en' to 'mn','hn',or 'wn' to show the result.
		HeuristicAstar has = new HeuristicAstar(en, goal);
		has.has();

		
		System.out.println("\n\nA* search using the Manhattan heuristic function.");
		//to change 'en' to 'mn','hn',or 'wn' to show the result.
		ManhattanHeuristicAstar mhas = new ManhattanHeuristicAstar(en,goal);
		mhas.mhas();

		
		System.out.println("\n\nIterative deepening A* with the Manhattan heuristic function.");	
		//to change 'en' to 'mn','hn',or 'wn' to show the result.
		IterativeDeepeningAstarManhattan ida = new IterativeDeepeningAstarManhattan(en,goal);
		//every time i will add one more level.
			int num = 1;
			while(ida.isSolution != true) {			
				ida.ida(num);;
				num++;
		}
			
		System.out.println("\n\nDepth-first Branch and Bound with the Manhattan heuristic function.");
		//to change 'en' to 'mn','hn',or 'wn' to show the result.
		DepthFirstBranchAndBound dfbb = new DepthFirstBranchAndBound(en,goal);
		dfbb.dfbb();;
	}
}
