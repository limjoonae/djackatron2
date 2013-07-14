package com.test.djackatron2.service;

public class CalculateFee {

	double feeRate = 0.00d;

	public double feeRate(double transferAmount) {
		double tfa = transferAmount;
		if ((tfa > 0.00d) && (tfa <= 1000.00d)) {
			feeRate = 0.00d;
		} else if ((tfa > 1000.00d)
				&& (tfa <= 1000000.00d)) {
			feeRate = tfa*0.01d;
		} else if ((tfa > 1000000.00d)) {
			feeRate = 20000.00d;
		} else
			feeRate = 5.00d;
		return feeRate;
	}

}
