public class Node{
  private int nodeData;
  private boolean nodeColor = false; //Black is False, Red is True
  private Node leftNode;
  private Node rightNode;



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
