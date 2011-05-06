public class Database {
	private BT list;
	public Database() {
		list = new BT();
	}
	public void enter(Object o){
		list.add(o);
	}
	public void display()
	{
		list.display();
	}
	public boolean lookup(Object o){
		return list.lookup(o);
	}	
	
	public static void main(String[] args)
	{
		Database b = new Database();
		b.enter(new MovieEntry("avatar",2009,"Cameron"));
		b.enter(new MovieEntry("Jiggy",2009,"Cameron"));
		b.enter(new MovieEntry("Avatar",2009,"Cameron"));
		b.enter(new MovieEntry("Hodown",2009,"Cameron"));
		b.display();
	}
}
