package com.test.djackatron2.service;

import static org.junit.Assert.*;

import org.joda.time.LocalTime;
import org.junit.Test;

public class TestTimeService {
	
	TimeService timeService = new TimeService();

	@Test
	public void testTimeWhenTransferInOpenTime() {
		
//		LocalTime openServiceTime = ;
		
		LocalTime currentTransferTime = new LocalTime();
		currentTransferTime.toDateTimeToday();
		assertTrue(timeService.openService(currentTransferTime));
	}

}
