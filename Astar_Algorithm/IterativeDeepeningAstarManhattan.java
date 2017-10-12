import java.util.*;

public class IterativeDeepeningAstarManhattan {
	public boolean isSolution;
    public Node root;
    public String goalState;
    
    IterativeDeepeningAstarManhattan(Node rt, String gs){
    	root = rt;
    	goalState = gs;
    	isSolution = false;
    }
    
    public void ida(int limitedH) {
   	 long startTime = System.currentTimeMillis();

       Set<String> openSet = new HashSet<String>();
       int time = 0;
       Node node = new Node(root.getState());
       node.setTotalCost(0);

       ComparatorNode nodePriorityComparator = new ComparatorNode();
       PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<Node>(5, nodePriorityComparator);
       Node currentNode = node;
       
       while(currentNode.getDepth() < limitedH) {
           openSet.add(currentNode.getState());
           List<String> closeList = PositionNode.getChildNode(currentNode.getState());
           
			if(currentNode.getState().equals(goalState)) {	
				isSolution = true;
				break;
			}
           
           for (String n : closeList) {
               if (openSet.contains(n))
                   continue;
               openSet.add(n);
               Node child = new Node(n);
               currentNode.addChild(child);
               child.setParent(currentNode);
               child.setDepth(currentNode.getDepth()+1);
               
               int tempCost = currentNode.getTotalCost() + Character.getNumericValue(child.getState().charAt(child.getParent().getState().indexOf('0')));
               int  estimatedCost = estimatedFunction(child.getState(), goalState);
               child.setTotalCost(tempCost, estimatedCost);

				nodePriorityQueue.add(child);
           }
           currentNode = nodePriorityQueue.poll();
           time += 1;
       }
       long finishTime = System.currentTimeMillis();
       long totalTime = finishTime - startTime;
      
		if(isSolution) {
			System.out.println(" There is a solution!\n");
		    PositionNode.print(currentNode, openSet, root, time, totalTime);
		}
 
   }
    
    private int estimatedFunction(String currentState, String goalSate) {
        int difference = 0;
        for (int i = 0; i < currentState.length(); i += 1)
            for (int j = 0; j < goalSate.length(); j += 1)
                if (currentState.charAt(i) == goalSate.charAt(j))
                    difference = difference + ((Math.abs(i % 3 - j % 3)) + Math.abs(i / 3 - j / 3));
        return difference;
    }
	
}
