package com.parkit.parkingsystem.service;

import java.time.Duration;
import java.util.Date;

import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;

public class FareCalculatorService {

	public void calculateFare(Ticket ticket) {
		if ((ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime()))) {
			throw new IllegalArgumentException("Out time provided is incorrect:" + ticket.getOutTime().toString());
		}
		Date inHour = ticket.getInTime();
		Date outHour = ticket.getOutTime();

		Duration duration = Duration.between(inHour.toInstant(), outHour.toInstant());
		if (duration.toMinutes() <= 30) {
			ticket.setPrice(0.0);
		} else {
			switch (ticket.getParkingSpot().getParkingType()) {

			case CAR: {
				ticket.setPrice((duration.getSeconds() / 3600.0) * Fare.CAR_RATE_PER_HOUR);
				break;
			}
			case BIKE: {
				ticket.setPrice((duration.getSeconds() / 3600.0) * Fare.BIKE_RATE_PER_HOUR);
				break;
			}
			default:
				throw new IllegalArgumentException("Unkown Parking Type");
			}
		}

	}
}