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

      while(greaterOrLess != 0){
        int greaterOrLess = compare(inputNodeData, referenceNode.getNodeData());
        if(greaterOrLess < 0){
          if(referenceNode.getLeftNode() == null){
            referenceNode.setLeftNode(new Node(inputNodeData));
            adjustTreeAfterAdd(referenceNode.getLeftNode());
            return;
          }
          referenceNode = referenceNode.getLeftNode();
        } else {
          if(referenceNode.getRightNode() == null){
            referenceNode.setRightNode(new Node(inputNodeData));
            adjustTreeAfterAdd(referenceNode.getRightNode());
            return;
          }
          referenceNode = referenceNode.getRightNode();
        }	
      }
    }
  
  
  public void remove(int removeNodeData){
     Node node = (Node) nodeContaining(removeNodeData);
     if(node == null){
       return;
     } else if(node.getLeftNode() != null && node.getRightNode() != null){
       Node predecessor = predecessor(node);
       node.setData(predecessor = predecessor.getNodeData();
       node = predecessor;
     }
     Node pullUp = leftOf(node) == null ? rightof(node) : leftOf(node);
     if(pullUp != null){
       if(node == root){
         setRoot(pullUp);
       } else if(node.getParentNode().getLeftNode() == node){
         node.getParentNode().setLeft(pullUp);
       } else {
         node.getParent().setRight(pullUp);
       }

       if(!node.getColor()){
         adjustTreeAfterRemove(pullUp);
       }
     } else if(node == root){
       setRoot(null);
     } else{
       if(!node.getColor()){
         adjustTreeAfterRemove(node);
       }
       node.removeFromParent();
     }    
   }
  



  private void adjustTreeAfterAdd(Node n){
     n.setColor(true);
     if(n != null && n != root && n.getParentNode().getColor()){
       if(n.getParentNode().getSiblingNode().getColor()){
         n.getParentNode().setColor(false);
         n.getParentNode().getParentNode().setColor(true);
	 n.getParentNode().getSiblingNode().setColor(false);
         adjustTreeAfterAdd(n.getParentNode().getParentNode());
       } else if( n.getParentNode() == n.getParentNode().getParentNode().getLeftNode()){
         if(n == rightof(parentOf(n)){
	   rotateLeft(n =n.getParent());
	 }
	 n.getParent().setColor(false);
	 n.getParent().getParent().setColor(true);
	 rotateRight(n.getParent().getParent();
       }
       else if(n.getParentNode() == n.getParentNode().getParentNode().getRightNode()){
         if(n == n.getParentNode().getLeftNode()){
	   rotateRight(n = n.getParentNode());
	 }
         n.getParent().setColor(false);
         n.getParent().getParent().setColor(true);
         rotateLeft(n.getParent().getParent();
       }
     }
     root.setColor(false);
  }


  private void adjustTreeAfterRemove(Node n){
    while(n != root && !n.getColor()){
      if(n == n.getParentNode().getLeftNode()){
        Node sibling = n.getParentNode().
	  if(sibling.getColor())){
            sibling.setColor(false);
	    n.getParentNode().setColor(true);
	    rotateLeft(n.getParentNode());
	    sibling = n.getParentNode().getRightNode();
	  }
	  if(!sibling.getLeftNode().getColor() && !sibling.getRightNode().getColor()){
	    sibling.setColor(true);
	    n = n.getParentNode();
	  } else if (!sibling.getLeftNode().getColor()){
            sibling.setColor( n.getParentNode.getColor());
	    n.getParentNode().setColor(false);
	    sibling.setColor(true);
	    rotateRight(sibling);
	    sibling = n.getParentNode().getLeftNode();
	  }
	  sibling.setColor(n.getParentNode().getColor());
	  n.getParentNode().setColor(false);
	  sibling.getRightNode().setColor(false);
	  rotateLeft(n.getParentNode());
	  n = (Node) root;
      }
    } else {
      Node sibling = n.getParentNode().getLeftNode();
      if(sibling.getColor()){
        sibling.setColor(false);
	n.getParentNode().setColor(true);
	rotateRight(n.getParentNod());
	sibling = n.getParentNode().getLeftNode();
      }
      if(!sibling.getLeftNode().getColor() && !sibling.getRightNode().getColor()){
        sibling.setColor(true);
	n = n.getParentNode();
      } else if(!sibling.getRightNode().getColor()){
        sibling.getRightNode().setColor(false);
	sibling.setColor(true);
	rotateLeft(sibling);
	sibling = n.getParentNode().getLeftNode();
      }
      sibling.setColor(n.getParentNode().getColor())
      n.getParenNode().setColor()
    }
  }
}

