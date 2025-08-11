package com.webage.dao;

import java.util.List;
import java.util.Date;

import com.webage.domain.Purchase;

public interface PurchaseDao { 
	public void savePurchase(Purchase purchase);
	public List<Purchase> getAllPurchases();
	public Purchase getPurchase(int id);
	public Purchase getPurchase(String name, Date Date);
}
