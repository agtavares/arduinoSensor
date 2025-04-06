
package com.puc.arduino;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Sensor> sensors;
	private static final SerialPortAccess managerPort = new SerialPortAccess();
	private static final String portName = "COM1";

	public static void main(String[] args)  {

		managerPort.connect(portName);
		// aqqui seriam lidos os valorem vindos da porte serial pelo arduino
		// String response = managerPort.readSerial();

		// dados simulados vindos do arduino (vide link de execução do tinkercad)
		String response = "temp:43;umid:1;lumi:6;temp:43;umid:1;lumi:6;temp:43;umid:1;lumi:6;temp:43;umid:1;lumi:6;";

		sensors = transformSerialToSensor(response);
		for(Sensor sensor : sensors) {
			System.out.println(sensor.getSensorName() + ", " + sensor.getPercentageValue());
		}
	}

	public static List<Sensor> transformSerialToSensor(String responseSerial) {

		String charDelimiterFromSensorData = ";";
		sensors = new ArrayList<Sensor>();

		int numberOfReceivedValues = StringUtils.countOccurrencesOf(responseSerial, charDelimiterFromSensorData);

		String[] serialSplit = responseSerial.split(charDelimiterFromSensorData);

		for(int i = 0; i < numberOfReceivedValues; i++) {

			String[] valueParsed = serialSplit[i].split(":");

			Sensor sensor = new Sensor();
			sensor.setSensorName(valueParsed[0]);
			sensor.setPercentageValue(valueParsed[1]);

			sensors.add(sensor);
		}

		return sensors;
	}
}