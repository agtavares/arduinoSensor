package com.puc.arduino;

import com.fazecast.jSerialComm.SerialPort;

public class SerialPortAccess {

    private SerialPort port;
    private boolean isConnected = false;;

    public SerialPortAccess() {}

    public void connect(String portName) {
        port = SerialPort.getCommPort(portName);

        if(port.openPort()) {
            isConnected = true;
        }
        else {
            isConnected = false;
        }
    }

}