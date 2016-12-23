
import lejos.nxt.LightSensor;

/**Class that given a robot reads the light values from the 2 light sensors
 * @author Gabriel Iuriciuc
 *
 */
public class LSlListener extends Thread {

	private LineFollower robotUnit;
	private LightSensor right;
	private LightSensor left;
	public static boolean stop = false;

	public LSlListener(LineFollower robotUnit, LightSensor right, LightSensor left) {
		this.robotUnit = robotUnit;
		this.right = right;
		this.left = left;
	}

	@Override
	public void run() {
		int rightlightValue;
		int leftlightValue;
		while(!stop) {
			rightlightValue = right.getLightValue();
			leftlightValue = left.getLightValue();
			robotUnit.leftSensorValue = leftlightValue;
			robotUnit.rightSensorValue = rightlightValue;
		}
	}
}
