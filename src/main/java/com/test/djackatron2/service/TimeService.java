package com.test.djackatron2.service;

import org.joda.time.LocalTime;

public class TimeService {

	public LocalTime openServiceTime;
	public LocalTime closeServiceTime;
	
	
	public void setOpenServiceTime(LocalTime openServiceTime) {
		this.openServiceTime = openServiceTime;
	}


	public void setCloseServiceTime(LocalTime closeServiceTime) {
		this.closeServiceTime = closeServiceTime;
	}


	public boolean openService(LocalTime currentTransferTime) {
		return false;
	}

}
