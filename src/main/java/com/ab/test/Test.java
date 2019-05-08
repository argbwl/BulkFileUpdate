package com.ab.test;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import com.ab.dao.BankDAOImpl;
import com.ab.model.Bank;
import com.ab.util.FileUtil;

public class Test {

	public static void main(String[] args) throws IOException, SQLException {
		File file = FileUtil.getFileFromClassPath("bank.txt");
		BankDAOImpl dao = new BankDAOImpl();

//		FileUtil.writeToFile(100000, 163300, file);

		// Bank bank = new Bank(1, "SBI", "SBIN000244", 1945);
		// dao.saveBankRecord(bank);

		long start = System.currentTimeMillis();
		int[] value = dao.updateBankBatchData(FileUtil.getBankListFromFile(file));
		System.out.println("Total Row :" +value.length);
		System.out.println(System.currentTimeMillis() - start);
	}

}
