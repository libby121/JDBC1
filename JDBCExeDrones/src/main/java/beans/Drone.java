package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class Drone {
	
	private int id;
	private String manufacturer;
	private String model;
	
	private int cameraPixel;
	private double flightRange;
	private double price;
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Drone(int id, String manufacturer, String model, int cameraPixel, double flightRange, double price) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.cameraPixel = cameraPixel;
		this.flightRange = flightRange;
		this.price = price;
	}
	public Drone(int id, String manufacturer, int cameraPixel, double flightRange, double price) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.cameraPixel = cameraPixel;
		this.flightRange = flightRange;
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getCameraPixel() {
		return cameraPixel;
	}
	public void setCameraPixel(int cameraPixel) {
		this.cameraPixel = cameraPixel;
	}
	public double getFlightRange() {
		return flightRange;
	}
	public void setFlightRange(double flightRange) {
		this.flightRange = flightRange;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Drone [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", cameraPixel="
				+ cameraPixel + ", flightRange=" + flightRange + ", price=" + price + "]";
	}
	
	
	

}
