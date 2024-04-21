package com.payment.service;

import java.util.List;

import com.payment.binding.TransactionDetailsBinding;

public interface TransactionDetailsService 
{
	public String doPayment(TransactionDetailsBinding tdb);
	public String updateTransaction(TransactionDetailsBinding tdb);
	public List<TransactionDetailsBinding> getAllTransaction();
	public String deleteTRansaction(int id);
}
