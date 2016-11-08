public class CircularLinkedList{
  int size = 0;
  Node first = null;
  Node last = null;
  Node current = null;

  
  public CircularLinkedList(String[] stringArray){
    for(String s : stringArray){
      addNode(s);
    }
  }

  public boolean isEmpty(){
    return first == null;
  }

  public Node returnCurrent(){
    return current;
  }

  private void incrementCurrent(){
    current = current.next();
  }

  private void decrementCurrent(){
    for(int i = 1; i < size; i++){
      current = current.next();
    }
  }

  public void addNode(String string){
    Node newNode = new Node(string, first);
    if(isEmpty()){
      first = newNode;
      current = first;
    }else{
      current.next = newNode;
    }
    newNode.next = last;
  }
}




public class Node{
  private String value = null;
  public Node next = null;

  public Node (String value, Node next){
    this.value = value;
    this.next = next;
  }

  public String getValue(){
    return value;
  }
}
