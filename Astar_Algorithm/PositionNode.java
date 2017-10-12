import java.util.*;

public class PositionNode {

public static List<String> getChildNode(String state) {
	List<String> children = new ArrayList<String>();
	switch (state.indexOf("0")) {
		case 0: {
		    children.add(state.replace(state.charAt(0), '-').replace(state.charAt(1),
		    		state.charAt(0)).replace('-', state.charAt(1)));
		    children.add(state.replace(state.charAt(0), '-').replace(state.charAt(3), 
		    		state.charAt(0)).replace('-', state.charAt(3)));
		    break;
		}
		case 1: {
		    children.add(state.replace(state.charAt(1), '-').replace(state.charAt(0),
		    		state.charAt(1)).replace('-', state.charAt(0)));
		    children.add(state.replace(state.charAt(1), '-').replace(state.charAt(2), 
		    		state.charAt(1)).replace('-', state.charAt(2)));
		    children.add(state.replace(state.charAt(1), '-').replace(state.charAt(4), 
		    		state.charAt(1)).replace('-', state.charAt(4)));
		    break;
		}
		case 2: {
		
		    children.add(state.replace(state.charAt(2), '-').replace(state.charAt(1),
		    		state.charAt(2)).replace('-', state.charAt(1)));
		    children.add(state.replace(state.charAt(2), '-').replace(state.charAt(5), 
		    		state.charAt(2)).replace('-', state.charAt(5)));
		    break;
		}
		case 3: {
		    children.add(state.replace(state.charAt(3), '-').replace(state.charAt(0), 
		    		state.charAt(3)).replace('-', state.charAt(0)));
		    children.add(state.replace(state.charAt(3), '-').replace(state.charAt(4), 
		    		state.charAt(3)).replace('-', state.charAt(4)));
		    children.add(state.replace(state.charAt(3), '-').replace(state.charAt(6), 
		    		state.charAt(3)).replace('-', state.charAt(6)));
		    break;
		}
		case 4: {
		    children.add(state.replace(state.charAt(4), '-').replace(state.charAt(1), 
		    		state.charAt(4)).replace('-', state.charAt(1)));
		    children.add(state.replace(state.charAt(4), '-').replace(state.charAt(3), 
		    		state.charAt(4)).replace('-', state.charAt(3)));
		    children.add(state.replace(state.charAt(4), '-').replace(state.charAt(5), 
		    		state.charAt(4)).replace('-', state.charAt(5)));
		    children.add(state.replace(state.charAt(4), '-').replace(state.charAt(7), 
		    		state.charAt(4)).replace('-', state.charAt(7)));
		    break;
		}
		case 5: {
		    children.add(state.replace(state.charAt(5), '-').replace(state.charAt(2), 
		    		state.charAt(5)).replace('-', state.charAt(2)));
		    children.add(state.replace(state.charAt(5), '-').replace(state.charAt(4), 
		    		state.charAt(5)).replace('-', state.charAt(4)));
		    children.add(state.replace(state.charAt(5), '-').replace(state.charAt(8), 
		    		state.charAt(5)).replace('-', state.charAt(8)));
		    break;
		}
		case 6: {
		    children.add(state.replace(state.charAt(6), '-').replace(state.charAt(3), 
		    		state.charAt(6)).replace('-', state.charAt(3)));
		    children.add(state.replace(state.charAt(6), '-').replace(state.charAt(7), 
		    		state.charAt(6)).replace('-', state.charAt(7)));
		    break;
		
		}
		case 7: {
		    children.add(state.replace(state.charAt(7), '-').replace(state.charAt(4), 
		    		state.charAt(7)).replace('-', state.charAt(4)));
		    children.add(state.replace(state.charAt(7), '-').replace(state.charAt(6), 
		    		state.charAt(7)).replace('-', state.charAt(6)));
		    children.add(state.replace(state.charAt(7), '-').replace(state.charAt(8), 
		    		state.charAt(7)).replace('-', state.charAt(8)));
		    break;
		}
		case 8: {
		    children.add(state.replace(state.charAt(8), '-').replace(state.charAt(5), 
		    		state.charAt(8)).replace('-', state.charAt(5)));
		    children.add(state.replace(state.charAt(8), '-').replace(state.charAt(7), 
		    		state.charAt(8)).replace('-', state.charAt(7)));
		        break;
		    }
		}

	    return children;
	
	}

public static void print(Node goalNode, Set<String> visitedNodes, Node root, int time, long totalTime) {

    Stack<Node> stateStack = new Stack<Node>();
    stateStack.push(goalNode);
    while (!goalNode.getState().equals(root.getState())) {
        stateStack.push(goalNode.getParent());
        goalNode = goalNode.getParent();
    }
    String sourceState = root.getState();
    String destinationState;

    for (int i = stateStack.size() - 1; i >= 0; i--) {
        System.out.println("-----------------------------------------------------------");
        destinationState = stateStack.get(i).getState();
        if (!sourceState.equals(destinationState)) {
            System.out.println("Move " + destinationState.charAt(sourceState.indexOf('0')) + " " 
            		+ findTransition(sourceState, destinationState));
        }

        sourceState = destinationState;
        System.out.println(stateStack.get(i).getState());
        System.out.println(" " + stateStack.get(i).getState().substring(0, 3)+" ");
        System.out.println(" " + stateStack.get(i).getState().substring(3, 6)+" ");
        System.out.println(" " + stateStack.get(i).getState().substring(6, 9)+" ");


    }
    System.out.println(" Number of transitions to get to the goal state from the initial state:  " + (stateStack.size() - 1));
    System.out.println(" Number of visited states:  " + (visitedNodes.size()));
    System.out.println(" Total Time for this solution: " + totalTime);
    System.out.println(" Number of Nodes poped out of the queue: " + time);

}

public static String findTransition(String sc, String dest) {
    int zeroDiff = dest.indexOf('0') - sc.indexOf('0');
    switch (zeroDiff ) {
        case -3:
            return "DOWN";
        case 3:
            return "UP";
        case 1:
            return "LEFT";
        case -1:
            return "RIGHT";
    }
    return null;
}
	
}
