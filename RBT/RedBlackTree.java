import java.util.Comparator
public class RedBlackTree extends BinarySearchyTree{

    private Node root = null;
    private Comparator comparator = new Comparator;

    public void RedBlackTree(){
      root = new Node(null);
    }
 
 
   public void add(int inputNodeData){
      if(root == null){
        root = new Node(inputNodeData);
      }
      Node referenceNode = root;
      int greaterOrLess = compare(inputNodeData, referenceNode.getNodeData());

      while(greaterOrLess != 0){										//for as long as they are not the same (if they are, then no data needs to be added
        int greaterOrLess = compare(inputNodeData, referenceNode.getNodeData());				//compare the two sets of data
        if(greaterOrLess < 0){											//if input is less than reference, move to the left and check there
          if(referenceNode.getLeft() == null){									//if the left is a null, add the data there, then adjust the tree to ensure balance
            referenceNode.setLeftNode(new Node(data));
            adjustTree(referenceNode.getLeftNode());
            return;
          }
          referenceNode = referenceNode.getLeftNode();								//if it isn't null, set the reference Node to the left node, and try again
        } else {
          if(referenceNode.getRightNode() == null){								//if input is greater than reference, move to the right and check there
            referenceNode.setRightNode(new Node(inputNodeData));						//if the right is a null, add the data there, then adjust the tree to ensure balance
            adjustTree(referenceNode.getRightNode());
            return;
          }
	  referenceNode = referenceNode.getRightNode();								//if it isn't null, set the reference Node to the right node, and try again
        }	
      }
    }
}
