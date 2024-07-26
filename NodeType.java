public class NodeType<T extends Comparable<T>> {
public T info;
public NodeType<T> left;
public NodeType<T> right;

public NodeType(T info){
  Info = info;
}

public bool isLeafNode(){
  if(left != null && right != null){
  return true;
  }
  return false;
}

public bool isSingleParent(){
  if(left != null && right == null || left == null && right != null ){
  return true;
  }
  return false;
}


} // NodeType
