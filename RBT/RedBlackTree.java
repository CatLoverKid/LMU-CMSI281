import java.util.Comparator;
public class RedBlackTree{

    private Node root = null;
	private Comparator comparator;

    public void RedBlackTree(){
      root = new Node();
    }
 
 
   public void add(int inputNodeData){
      if(root == null){
        root = new Node();
      }
      Node referenceNode = root;
      int GreaterOrLess = comparator.compare(inputNodeData, referenceNode.getNodeData());

      while(GreaterOrLess != 0){
        GreaterOrLess = comparator.compare(inputNodeData, referenceNode.getNodeData());
        if(GreaterOrLess < 0){
          if(referenceNode.getLeftNode() == null){
            referenceNode.setLeftNode(new Node());
            adjustTreeAfterAdd(referenceNode.getLeftNode());
            return;
          }
          referenceNode = referenceNode.getLeftNode();
        } else {
          if(referenceNode.getRightNode() == null){
            referenceNode.setRightNode(new Node());
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
       node.setNodeData(predecessor.getNodeData());
       node = predecessor;
     }
     Node pullUp = node.getLeftNode() == null ? node.getRightNode() : node.getLeftNode();
     if(pullUp != null){
       if(node == root){
         root = pullUp;
       } else if(node.getParentNode().getLeftNode() == node){
         node.getParentNode().setLeftNode(pullUp);
       } else {
         node.getParentNode().setRightNode(pullUp);
       }

       if(!node.getNodeColor()){
         adjustTreeAfterRemove(pullUp);
       }
     } else if(node == root){
       root = null;
     } else{
       if(!node.getNodeColor()){
         adjustTreeAfterRemove(node);
       }
       remove(node.getNodeData());
     }    
   }

  private void adjustTreeAfterAdd(Node n){
     n.setNodeColor(true);
     if(n != null && n != root && n.getParentNode().getNodeColor()){
       if(n.getParentNode().getSiblingNode().getNodeColor()){
         n.getParentNode().setNodeColor(false);
         n.getParentNode().getParentNode().setNodeColor(true);
	 n.getParentNode().getSiblingNode().setNodeColor(false);
         adjustTreeAfterAdd(n.getParentNode().getParentNode());
       } else if( n.getParentNode() == n.getParentNode().getParentNode().getLeftNode()){
         if(n == n.getParentNode().getLeftNode()){
	   rotateLeft(n = n.getParentNode());
	 }
	 n.getParentNode().setNodeColor(false);
	 n.getParentNode().getParentNode().setNodeColor(true);
	 rotateRight(n.getParentNode().getParentNode());
       }
       else if(n.getParentNode() == n.getParentNode().getParentNode().getRightNode()){
         if(n == n.getParentNode().getLeftNode()){
	   rotateRight(n = n.getParentNode());
	 }
         n.getParentNode().setNodeColor(false);
         n.getParentNode().getParentNode().setNodeColor(true);
         rotateLeft(n.getParentNode().getParentNode());
       }
     }
     root.setNodeColor(false);
  }

  private void adjustTreeAfterRemove(Node n){
    while(n != root && !n.getNodeColor()){
      if(n == n.getParentNode().getLeftNode()){
        Node sibling = n.getParentNode();
	  if(sibling.getNodeColor()){
            sibling.setNodeColor(false);
	    n.getParentNode().setNodeColor(true);
	    rotateLeft(n.getParentNode());
	    sibling = n.getParentNode().getRightNode();
	  }
	  if(!sibling.getLeftNode().getNodeColor() && !sibling.getRightNode().getNodeColor()){
	    sibling.setNodeColor(true);
	    n = n.getParentNode();
	  } else if (!sibling.getLeftNode().getNodeColor()){
            sibling.setNodeColor( n.getParentNode().getNodeColor());
	    n.getParentNode().setNodeColor(false);
	    sibling.setNodeColor(true);
	    rotateRight(sibling);
	    sibling = n.getParentNode().getLeftNode();
	  }
	  sibling.setNodeColor(n.getParentNode().getNodeColor());
	  n.getParentNode().setNodeColor(false);
	  sibling.getRightNode().setNodeColor(false);
	  rotateLeft(n.getParentNode());
	  n = (Node) root;
      } else {
      Node sibling = n.getParentNode().getLeftNode();
      if(sibling.getNodeColor()){
        sibling.setNodeColor(false);
	    n.getParentNode().setNodeColor(true);
	    rotateRight(n.getParentNode());
	    sibling = n.getParentNode().getLeftNode();
      }
      if(!sibling.getLeftNode().getNodeColor() && !sibling.getRightNode().getNodeColor()){
        sibling.setNodeColor(true);
	    n = n.getParentNode();
      } else if(!sibling.getRightNode().getNodeColor()){
        sibling.getRightNode().setNodeColor(false);
	    sibling.setNodeColor(true);
	    rotateLeft(sibling);
	    sibling = n.getParentNode().getLeftNode();
      }
      sibling.setNodeColor(n.getParentNode().getNodeColor());
      n.getParentNode().setNodeColor(false);
	  sibling.getLeftNode().setNodeColor(false);
	  rotateRight(n.getParentNode());
	  n = root;
    }
  }
  n.setNodeColor(false);
 }
  
  private void rotateRight(Node n){
	  if(n.getLeftNode() == null){
	    return;
	  }
	  Node priorLeftNode = n.getLeftNode();
	  n.setLeftNode(priorLeftNode.getRightNode());
	  if(n.getParentNode() == null){
		  root = priorLeftNode;
	  }else if(n.getParentNode().getLeftNode() == n){
		  n.getParentNode().setLeftNode(priorLeftNode);
	  }else{
		  n.getParentNode().setRightNode(priorLeftNode);
	  }
	  priorLeftNode.setRightNode(n);
  }
  
  private void rotateLeft(Node n){
	  if(n.getRightNode() == null){
		  return;
	  }
	  Node priorRightNode = n.getRightNode();
	  n.setRightNode(priorRightNode.getLeftNode());
	  if(n.getParentNode() == null){
		root = priorRightNode;
	  } else if( n.getParentNode().getLeftNode() == n){
		n.getParentNode().setLeftNode(priorRightNode);
	  } else{
		n.getParentNode().setRightNode(priorRightNode);
	  }
	  priorRightNode.setLeftNode(n);
  }
  
  private Node predecessor(Node inputNode){
	  Node n = inputNode.getLeftNode();
	  if(n != null){
	    while(n.getRightNode() != null){
		  n = n.getRightNode();
		}
	  }
	  return n;
  }
  
  private Node nodeContaining(int data){
	for(Node n = root; n != null;){
		int comparisonResult = comparator.compare(data, n.getNodeData());
		if(comparisonResult == 0){
			return n;
		}else if(comparisonResult < 0){
			n = n.getLeftNode();
		}else{
			n = n.getRightNode();
		}
	}
	return null;
  }
  
}

