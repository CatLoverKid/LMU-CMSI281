public class Node{
  private int nodeData;
  private boolean nodeColor;
  private Node leftNode;
  private Node rightNode;
  private Node parentNode;



public void Node(Node parentInput,int dataInput){
  nodeData = dataInput;
  leftNode = null;
  rightNode = null;
  nodeColor = false;				//Black is False
  nodeParent = parentInput;
}

  public int getNodeData(){
    return nodeData;
  }

  public boolean getNodeColor(){
    return nodeColor;
  }
  
  public Node getLeftNode(){
    return leftNode;
  }

  public Node getRightNode(){
    return rightNode;
  }

  public Node getParentNode(){
    return parentNode;
  }

  public void setLeftNode(Node inputLeftNode){
    leftNode = inputLeftNode;
  }

  public void setRightNode (Node inputRightNode){
    rightNode = inputRightNode;
  }

  public void setColor(boolean inputColor){
    nodeColor = inputColor;
  }

  public void setData(int inputData){
    nodeData = inputData;
  }
}
