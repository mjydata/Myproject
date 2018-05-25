package binaryTree;

public class BinaryTree {
    private Node root=null;
    public BinaryTree(int value) {
		root=new Node(value);
		root.LeftChild=null;
		root.RightChild=null;
		
	}
    public Node findKey(int value){
    	Node current=root;
    	while(true){
    		if(value<current.value){
        		current=current.LeftChild;
        	}else if(value>current.value){
        		current=current.RightChild;
        	}else if (value==current.value){
        		return current;
        	}
            if (current==null) {
    			return null;
    		}
         	
    	}
    }
    public String insertValue(int value){
    	String error=null;
    	Node insertNode=new Node(value);
    	
    	if(root==null){
    		root=insertNode;
    		root.LeftChild  = null;  
    	    root.RightChild = null; 
    	}else {
//    		Node current=root;
//			Node parent=null;
//    		while(true){
//    			
//        		if(value<root.value){
//        	       parent=current;
//        	       current=current.LeftChild;
//            		if(current==null){
//            			parent.LeftChild=insertNode;
//            			break;
//            		}
//            	}else if(value>root.value){
//            		parent=current;
//					current=root.RightChild;
//					if(current==null){
//						parent.RightChild=insertNode;
//            			break;
//            		}   
//				}else {  
//                    error = "having same value in binary tree";  
//                    break;
//                }  
//            		
//        	}
    		Node current = root;  
    	    Node parent = null;  
    	    while (true) {  
    	        if (value < current.value) {  
    	            parent = current;  
    	            current = current.LeftChild;  
    	            if (current == null) {  
    	                parent.LeftChild = insertNode;  
    	                break;  
    	            }  
    	        } else if (value > current.value) {  
    	            parent = current;  
    	            current = current.RightChild;  
    	            if (current == null) {  
    	                parent.RightChild = insertNode;  
    	                break;  
    	            }  
    	        } else {  
    	            error = "having same value in binary tree";  
    	            
    	        }   
    	        if(error!=null){
    	        	break;
    	        }
    	    } // end of while  

		}
    
    	
    	return error;
    }
    //中序遍历
    public void inOrderTraverse(Node node){
    	if(node==null)
    		return ;
    	inOrderTraverse(node.LeftChild);
    	node.display();
    	inOrderTraverse(node.RightChild);
    }
    public void inOrderTraverse1(){
    	inOrderTraverse(root);
    }
    
}
