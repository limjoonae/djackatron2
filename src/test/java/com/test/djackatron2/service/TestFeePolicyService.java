package com.test.djackatron2.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFeePolicyService {

	CalculateFee calculateFee = new CalculateFee();
	
	@Test
	public void testFeeRateWhenTransferAmountEqualOneThoundsandBaht() {	
		assertEquals(0.00d, calculateFee.feeRate(1000), 0);
	}

	@Test
	public void testFeeRateWhenTransferAmountEqualOneThoundsandAndOneBaht() {
		assertEquals(10.01d, calculateFee.feeRate(1001), 0);
	}
	
	@Test
	public void testFeeRateWhenTransferAmountEqualOneThoundsandAndTwoBaht() {
		assertEquals(11.01d, calculateFee.feeRate(1002), 0);
	}
	
	@Test
	public void testFeeRateWhenTransferAmountEqualOneMillionBaht() {
		assertEquals(10000.00d, calculateFee.feeRate(1000000), 0);
	}
	
	@Test
	public void testFeeRateWhenTransferAmountEqualOneMillionAndOneBahtFail() {
		assertEquals(10000.00d, calculateFee.feeRate(1000001), 0);
	}
	
	@Test
	public void testFeeRateWhenTransferAmountEqualOneMillionAndOneBahtPass() {
		assertEquals(20000.00d, calculateFee.feeRate(1000001), 0);
	}
}
