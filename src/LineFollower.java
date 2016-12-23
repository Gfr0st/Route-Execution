

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

/**
 * Class used for moving the robot on the map.
 * 
 * @author Gabriel Iuriciuc
 *
 */
public class LineFollower {

	private DifferentialPilot pilot;
	public int leftSensorValue;
	public int rightSensorValue;
	private final Float travelSpeed = 0.18f;

	private int delay=50;
	
	public LineFollower(){
		pilot = new DifferentialPilot(0.056, 0.12, Motor.B, Motor.C);
		delay = 50;
		pilot.setTravelSpeed(travelSpeed);
		LightSensor right = new LightSensor(SensorPort.S2);
		LightSensor left = new LightSensor(SensorPort.S3);
		right.setFloodlight(true);
		left.setFloodlight(true);
		int high = 44;
		int low = 20;
		
		left.setHigh(high);
		right.setHigh(high);
		left.setLow(low);
		right.setLow(low);
		
		LSlListener ls1Listener = new LSlListener(this , right ,left); // setting up the listener for the 2 sensors
		ls1Listener.start();
	}
	
	public void moveAction(int distance){ // method for moving the robot 
		while (distance > 0) {
			System.out.println("left"+ leftSensorValue); // debugging
			System.out.println("right" +rightSensorValue); // debugging
			if(leftSensorValue < 1500 && rightSensorValue < 1500){
				System.out.println("Junction"); // debugging part for testing that the robot correctly identifies junctions on the map
				distance--;
				pilot.stop();
			}else{
				pilot.steer((leftSensorValue - rightSensorValue)/4);
				Delay.msDelay(delay);
			}
			Delay.msDelay(delay);
		}
	}
	
	public void turnAction(double angle){ // method for turning the robot
		pilot.travel(0.03);
		pilot.stop();
		pilot.rotate(angle);
	}

}

