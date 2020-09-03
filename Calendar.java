public class Calendar {

	private static Calendar instance = new Calendar();
	
	private Calendar() {
	}
	
	public static Calendar getInstance() {
		return instance;
	}
}