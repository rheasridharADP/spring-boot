package com.webage.dao;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.webage.domain.Purchase;

@Repository
public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired 
	JdbcClient jdbcClient;

	//	PART 3a:
	//	Modify the getAllPurchases() method below.
	//	Use the jdbcClient to retrieve purchases from the DB:
	//  - The provided SQL retrieves all rows from the PURCHASE table.
	//  - Utilize the ".sql" method to specify the SQL statement.
	//  - Utilize the ".query" method to specify a RowMapper.
	//	  - Use a new BeanPropertyRowMapper<Purchase>(Purchase.class) to easily map columns to Purchase properties.
	//	- Utilize the ".list" method to return a List of Purchase objects.

	@Override
	public List<Purchase> getAllPurchases() {
		String sql = "SELECT * FROM PURCHASE";
		// Replace this statement with the call to jdbcClient.
		return jdbcClient
				.sql(sql)
				.query(new BeanPropertyRowMapper<Purchase>(Purchase.class))
				.list();
	}

	//	PART 5a (Optional):
	//	Modify the getPurchase() method below.
	//	Use the jdbcClient to retrieve purchases from the DB:
	//  - The provided SQL retrieves all rows from the PURCHASE table.
	//  - Utilize the ".sql" method to specify the SQL statement.
	//  - Utilize the ".param" method to specify the id parameter.
	//  - Utilize the ".query" method to specify a RowMapper.
	//	  - Use a new BeanPropertyRowMapper<Purchase>(Purchase.class) to easily map columns to Purchase properties.
	//	- Utilize the ".single" method to return the Purchase object.

	@Override
	public Purchase getPurchase(int id) {
		String sql = "SELECT * FROM PURCHASE WHERE ID = ?";
		// Add code here
		return null;
	}

	//	PART 6a (Optional):
	//	Modify the savePurchase() method below.
	//	Use the jdbcClient to insert a purchase into the DB:
	//  - The provided SQL inserts a new row into the PURCHASE table.
	//  - Utilize the ".sql" method to specify the SQL statement.
	//  - Utilize the ".param" method to specify the name, product, and date parameters, in order.
	//  - Utilize the ".update" method to execute the insert.

	@Override
	public void savePurchase(Purchase purchase) {
		String sql = "insert into PURCHASE (CUSTOMERNAME, PRODUCT, PURCHASEDATE) values(?,?,?)";
		// Add code here
	}


	@Override
	public Purchase getPurchase(String name, Date date) {
		String sql = "SELECT * FROM PURCHASE WHERE CUSTOMERNAME = ? and PURCHASEDATE = ?";
		return jdbcClient
			.sql(sql)
			.param(name)
			.param(date)
			.query(new BeanPropertyRowMapper<Purchase>(Purchase.class))
			.single();
	}


}
