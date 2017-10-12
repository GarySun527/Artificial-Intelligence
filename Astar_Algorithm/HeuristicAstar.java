import java.util.*;

public class HeuristicAstar {
    public Node root;
    public String goalState;
    
    HeuristicAstar(Node rt, String gs){
    	root = rt;
    	goalState = gs;
    }
    
    public void has() {
   	 long startTime = System.currentTimeMillis();
       // stateSet is a set that contains node that are already visited
       Set<String> openSet = new HashSet<String>();
       int time = 0;
       Node node = new Node(root.getState());
       node.setTotalCost(0);

       ComparatorNode nodePriorityComparator = new ComparatorNode();
       PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<Node>(5, nodePriorityComparator);
       Node currentNode = node;
       
       while (!currentNode.getState().equals(goalState)) {
           openSet.add(currentNode.getState());
           List<String> closedList = PositionNode.getChildNode(currentNode.getState());
           for (String n : closedList) {
               if (openSet.contains(n))
                   continue;
               openSet.add(n);
               Node child = new Node(n);
               currentNode.addChild(child);
               child.setParent(currentNode);

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
      
       PositionNode.print(currentNode, openSet, root, time, totalTime);
   }
    
    private int estimatedFunction(String currentState, String goalSate) {
        int difference = 0;
        for (int i = 0; i < currentState.length(); i += 1)
            if (currentState.charAt(i) != goalSate.charAt(i))
                difference += 1;
        return difference;
    }
}
