package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it 
		Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);

		// - connect to the broker
		boolean connected = client.connect();
		// - publish the temperature(s)
		if(connected) {
			
			for(int i = 0; i < COUNT; i++) {
				
				//client.publish(Common.TEMPTOPIC, sn.toString());
				client.publish(Common.TEMPTOPIC, Integer.toString(sn.read()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			// - disconnect from the broker
			client.disconnect();
		}
		
		

		// TODO - end

		System.out.println("Temperature device stopping ... ");

	}
}
