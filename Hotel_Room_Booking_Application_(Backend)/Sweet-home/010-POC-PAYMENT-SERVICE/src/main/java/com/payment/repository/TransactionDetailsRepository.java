package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.entity.TransactionDetailsEntity;

@Repository
public interface TransactionDetailsRepository extends JpaRepository<TransactionDetailsEntity, Integer>{

}
