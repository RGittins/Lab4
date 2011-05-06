public class BT {
	BTNode root = null;
	
	
	public void add(Object d) { //Used the example from online
        if (root == null) 
            root = new BTNode(d);
        else {
            BTNode ptr = root, parent = null;
            while (ptr != null) {
                parent = ptr;
                // current data  <= d
                if (d.toString().compareToIgnoreCase(ptr.getData().toString()) <= 0) 
                    ptr = ptr.getLeft();
                else
                    ptr = ptr.getRight();
            }
            ptr = new BTNode(d);
            if (d.toString().compareToIgnoreCase(parent.getData().toString()) <= 0) 
                parent.setLeft(ptr);
            else
                parent.setRight(ptr);
        }
    }
	
	public boolean remove(Object d) {
	        BTNode ptr = root;
	        BTNode parent = null;

	        while (ptr != null && 
	               d.toString().compareTo(ptr.getData().toString()) != 0) {
	            parent = ptr;
	            if (d.toString().compareTo(ptr.getData().toString()) < 0)
	                ptr = ptr.getLeft();
	            else
	                ptr = ptr.getRight();
	        }

	        if (ptr == null)           // CASE 1: not found, tree unchanged
	            return false;
	        else if (ptr.getLeft() == null) {  // no left branch
	            if (ptr == root)       // CASE 2: found at root
	                root = root.getRight();
	            else {                 // CASE 3: found but not at root
	                if (ptr == parent.getLeft())
	                    parent.setLeft(ptr.getRight());
	                else
	                    parent.setRight(ptr.getRight());
	            }
	        }
	        else {                     // CASE 4: found, and left branch exists
	            ptr.setData(ptr.getLeft().getRightMostData());
	            ptr.setLeft(ptr.getLeft().removeRightMost());
	        }

	        return true;
	    }
	
	public boolean lookup(Object o)
	{
		if(root == null)
			return false;
		BTNode ptr = root;
		while(ptr != null)
			if(ptr.getData().toString() == o.toString())
				return true;
			else if(o.toString().compareToIgnoreCase(ptr.getData().toString()) <= 0)
				ptr = ptr.getLeft();
			else
				ptr = ptr.getRight();
		
		return false;
	}
	
	public void display()
	{
		if(root != null)
			root.display();
	}
}
