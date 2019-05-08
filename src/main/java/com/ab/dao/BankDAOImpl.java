package com.ab.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ab.model.Bank;
import com.ab.util.ConnectionUtil;

public class BankDAOImpl {

	private static final String INSERT_QUERY = "INSERT INTO BANK (bank_id,bank_name,bank_ifsc,established_year) VALUES (?,?,?,?)";

	static JdbcTemplate jt;

	static {
		if (jt == null) {
			jt = ConnectionUtil.getJdbcTemplate();
		}
	}

	public void saveBankRecord(Bank bank) {
		// define query arguments
		Object[] params = new Object[] { bank.getBankId(), bank.getBankName(), bank.getIfsCode(),
				bank.getEstablishedYear() };
		// define SQL types of the arguments
		int[] types = new int[] { Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER };

		// execute insert query to insert the data
		// return number of row / rows processed by the executed query
		int row = jt.update(INSERT_QUERY, params, types);
		System.out.println("row : " + row);

	}

	public int[] updateBankBatchData(List<Bank> bankList) throws SQLException {
		try (PreparedStatement ps = ConnectionUtil.getConnection().prepareStatement(INSERT_QUERY)) {
			for (Bank bank : bankList) {
				ps.setInt(1, bank.getBankId());
				ps.setString(2, bank.getBankName());
				ps.setString(3, bank.getIfsCode());
				ps.setInt(4, bank.getEstablishedYear());
				ps.addBatch();
			}
			return ps.executeBatch();
		}
	}
	
	public int[] insertBatchUsingJT(final List<Bank> bankList){
				
		List<Object[]> parameters = new ArrayList<Object[]>();
	       
		for (Bank bank : bankList) {
	        parameters.add(new Object[] {bank.getBankId(), 
	            bank.getBankName(), bank.getIfsCode(),bank.getEstablishedYear()}
	        );
	    }
		return ConnectionUtil.getJdbcTemplate().batchUpdate(INSERT_QUERY, parameters);        
	}

}
