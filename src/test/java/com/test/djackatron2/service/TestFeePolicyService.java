package com.test.djackatron2.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFeePolicyService {

	double feeActual = 5.00d;
	
	@Test
	public void TestTransferAmountIsOneThoundsandBaht() {
		
		CalculateFee calculateFee = new CalculateFee();
		assertEquals(feeActual, calculateFee.fee(1000.00d));

	}
	
	@Test
	public void TestTransferAmountIsTenBaht() {
		
		CalculateFee calculateFee = new CalculateFee();
		assertEquals(feeActual, calculateFee.fee(10.00));

	}
	
	@Test
	public void TestTransferAmountIsOneBaht() {
		
		CalculateFee calculateFee = new CalculateFee();
		assertEquals(feeActual, calculateFee.fee(1.00));

	}

	
}
