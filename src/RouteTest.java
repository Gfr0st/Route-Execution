
/**
 * Class that tests the behaviour of the robot with simple actions
 * @author Gabriel Iuriciuc
 *
 */
public class RouteTest{
	
	public static void main(String[] args) {
		LineFollower lineFollower = new LineFollower();
		// Constructed an route for the given map to test the robot
			lineFollower.moveAction(4);
			lineFollower.turnAction(90);
			lineFollower.moveAction(5);
			lineFollower.turnAction(-90);
			lineFollower.moveAction(1);
			lineFollower.turnAction(-90);
			lineFollower.moveAction(2);
			lineFollower.turnAction(-90);
	}
}

