package com.parkit.parkingsystem.model;

import java.util.Date;

public class Ticket {
	private int id;
	private ParkingSpot parkingSpot;
	private String vehicleRegNumber;
	private double price;
	private Date inTime;
	private Date outTime;

	public Ticket() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ParkingSpot getParkingSpot() {
		if (this.parkingSpot != null) {
			return new ParkingSpot(parkingSpot.getId(), parkingSpot.getParkingType(), parkingSpot.isAvailable());
		}
		return null;
	}

	public void setParkingSpot(ParkingSpot pParkingSpot) {
		if (pParkingSpot != null) {
			this.parkingSpot = new ParkingSpot(pParkingSpot.getId(), pParkingSpot.getParkingType(),
					pParkingSpot.isAvailable());
		}
	}

	public String getVehicleRegNumber() {
		return this.vehicleRegNumber;
	}

	public void setVehicleRegNumber(String pVehicleRegNumber) {
		this.vehicleRegNumber = pVehicleRegNumber;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double pPrice) {
		this.price = pPrice;
	}

	public Date getInTime() {
		if (this.inTime != null) {
			return new Date(this.inTime.getTime());
		}
		return null;
	}

	public void setInTime(Date pInTime) {
		if (pInTime != null) {
			this.inTime = new Date(pInTime.getTime());
		}
	}

	public Date getOutTime() {
		if (this.outTime != null) {
			return new Date(this.outTime.getTime());
		}
		return null;
	}

	public void setOutTime(Date pOutTime) {
		if (pOutTime != null) {
			this.outTime = new Date(pOutTime.getTime());
		}
	}
}
