/*
 Hierarchical Device Management System
Problem Statement:
Design a Device Management System using inheritance, abstract classes, and interfaces. Implement the following hierarchy:

Abstract Class: Device

Fields: String deviceId, String deviceName.
Abstract Method: void start().
Concrete Method: void showDeviceInfo() to display the device's details.
Concrete Classes: Laptop, Smartphone (Extend Device)

Both classes must implement the start() method with specific behavior for starting a laptop or smartphone.
Interface: Connectable

Methods:
void connectToNetwork(String networkName).
void disconnectFromNetwork().
Both Laptop and Smartphone must implement this interface.
Child Class of Laptop: GamingLaptop

Additional Fields: int gpuCores.
Overridden start() method with additional behavior specific to gaming laptops.
Write a program that:

Creates a list of devices (ArrayList<Device>).
Demonstrates polymorphism by invoking start() and connectToNetwork() on different objects.
Uses runtime type checking to handle devices differently (e.g., print GPU cores if the device is a GamingLaptop).
Input Example:

Create devices:

{Laptop, "L123", "Office Laptop"}
{Smartphone, "S456", "Android Phone"}
{GamingLaptop, "G789", "Gaming Beast", 8}
Actions:

Start all devices.
Connect all devices to "Home Network".
Display GPU cores if the device is a GamingLaptop.
Expected Output:

"Office Laptop is starting."
"Android Phone is starting."
"Gaming Beast with 8 GPU cores is starting."
"Office Laptop connected to Home Network."
"Android Phone connected to Home Network."
 */
import java.util.*;

abstract class Device
{
	private String deviceID;
	private String deviceName;
	
	public Device(String deviceID, String deviceName)
	{
		this.deviceID = deviceID;
		this.deviceName = deviceName;
	}
	
	public String getDeviceID() {
		return deviceID;
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	
	abstract void start();
	
	void showDeviceInfo()
	{
		System.out.println("Device ID: "+this.getDeviceID()+"\nDevice Name: "+this.getDeviceName());
	}
}

interface Connectable
{
	void connectToNetwork(String networkName);
	
	void disconnectFromNetwork();
}

class Laptop extends Device implements Connectable
{
	public Laptop(String deviceID, String deviceName)
	{
		super(deviceID, deviceName);
	}

	@Override
	public void connectToNetwork(String networkName) {
		System.out.println("Laptop is connected to network named: "+networkName); 
		
	}

	@Override
	public void disconnectFromNetwork() {
		System.out.println("Laptop is disconnected from the network");
		
	}

	@Override
	void start() {
		System.out.println("Laptop has started booting up.");
		
	}	
}

class GamingLaptop extends Laptop
{
	private int gpuCores;
	
	public GamingLaptop(String deviceID, String deviceName, int gpuCores) {
		super(deviceID, deviceName);
		this.gpuCores = gpuCores;
	}
	
	public int getGpuCores() {
		return gpuCores;
	}
	
	@Override
	public void start()
	{
		System.out.println(this.getDeviceName()+" is starting with "+this.getGpuCores()+" GPU cores.");
	}
	
}

class Smartphone extends Device implements Connectable
{

	public Smartphone(String deviceID, String deviceName) {
		super(deviceID, deviceName);
		
	}

	@Override
	public void connectToNetwork(String networkName) {
		System.out.println("Smartphone is connected to network named: "+networkName); 
		
	}

	@Override
	public void disconnectFromNetwork() {
		System.out.println("Smartphone is disconnected from the network");
		
	}

	@Override
	void start() {
		System.out.println("Smartphone has started up.");
		
	}
	
}

public class InteritanceAbstractInterface1 {

	public static void main(String[] args) {
		ArrayList<Device> devices = new ArrayList<>();
		System.out.println("Adding 3 objects: Laptop, Gaming Laptop and Smartphone\n");
		devices.add(new Laptop("L12", "HP Laptop"));
		devices.add(new GamingLaptop("G24TX", "Omen 15 3521", 4));
		devices.add(new Smartphone("OP8PRO", "Oneplus 8 Pro"));
		
		for(Device device : devices)
		{
			device.start();
			device.showDeviceInfo();
			((Connectable) device).connectToNetwork("Home Network");
			((Connectable) device).disconnectFromNetwork();
			
			System.out.println();
		}
	}
}
