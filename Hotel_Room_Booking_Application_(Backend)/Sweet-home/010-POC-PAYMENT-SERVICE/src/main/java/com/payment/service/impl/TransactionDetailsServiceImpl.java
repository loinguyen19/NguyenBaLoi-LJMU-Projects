package com.payment.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payment.binding.TransactionDetailsBinding;
import com.payment.entity.TransactionDetailsEntity;
import com.payment.repository.TransactionDetailsRepository;
import com.payment.service.TransactionDetailsService;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService
{
	
	@Autowired
	private TransactionDetailsRepository transactionRepository;

	@Override
	public String doPayment(TransactionDetailsBinding tdb) 
	{
		TransactionDetailsEntity entity = new TransactionDetailsEntity();
		BeanUtils.copyProperties(tdb, entity);
		
		if(tdb.getPaymentMode().contains("CARD"))
		{
			transactionRepository.save(entity);
		}
		else
		{
			return "Payment Mode is not match....!!!";
		}
		return "Record is save...!!!";
	}

	@Override
	public String updateTransaction(TransactionDetailsBinding tdb)
	{
		TransactionDetailsEntity entityData = transactionRepository.findById(tdb.getPaymentId()).orElse(null);
		
		if(entityData != null)
		{
			entityData.setCardNumber(tdb.getCardNumber());
			entityData.setBookingId(tdb.getBookingId());
			entityData.setPaymentMode(tdb.getPaymentMode());
			entityData.setUpiId(tdb.getUpiId());
			entityData.setUpdateDate(tdb.getUpdateDate());
		
			
			transactionRepository.save(entityData);
		}
		return "Record is updated...!!!";
	}

	@Override
	public List<TransactionDetailsBinding> getAllTransaction()
	{
		List<TransactionDetailsBinding> bindingList=new ArrayList<>();
		List<TransactionDetailsEntity> findAll = transactionRepository.findAll();
		
		for(TransactionDetailsEntity entity : findAll)
		{
			TransactionDetailsBinding binding=new TransactionDetailsBinding();
			BeanUtils.copyProperties(entity,binding);
			bindingList.add(binding);
			
		}
		return bindingList;
	}

	@Override
	public String deleteTRansaction(int id) 
	{
		transactionRepository.deleteById(id);
		return "Record is deleted...!!";
	}

}
