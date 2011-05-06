
public class BTNode {
	private BTNode left = null;
	private BTNode right = null;
	private Object data = null;
	public BTNode() {
	}
	public BTNode(Object o) {
		data = o;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object o)
	{
		data = o;
	}
	public void setLeft(BTNode n) {
		left = n;
	}
	public BTNode getLeft() {
		return left;
	}
	public void setRight(BTNode n) {
		right = n;
	}
	public BTNode getRight() {
		return right;
	}
	public Object getRightMostData() {
        if (right == null)
            return data;
        else
            return right.getRightMostData();
    }
	public BTNode removeRightMost() {
        if (right == null)
            return left;
        else {
            setRight(right.removeRightMost());
            return this;
        }
    }
	public void display()
	{
		System.out.println(data.toString());
		if(left != null)
			left.display();
		if(right != null)
			right.display();
	}
}
