package com.liveguru;

public class CustomerLiveGuruData {

	public class NewCustomer {
		public static final String EMAIL = "giangpk";
		public static final String CUSTOMER_NAME = "Auto Test";
		public static final String GENDER = "male";
		public static final String DOB = "2000-01-02";
		public static final String ADDRESS = "1234 Hang Bai";
		public static final String CITY = "Ho Chi Minh";
		public static final String STATE = "Binh Thanh";
		public static final String PIN = "123467";
		public static final String MOBILE_NUMBER = "09827877154";
	}

	public class EditCustomer {
		public static final String EDIT_ADDRESS = "99899\nQuan 1";
		public static final String EDIT_CITY = "Sai Gon";
		public static final String EDIT_STATE = "Manila";
		public static final String EDIT_PIN = "738900";
		public static final String EDIT_MOBILE_NUMBER = "09673458934";
		public static final String EDIT_EMAIL = "gpk3";
	}

	public class CollumNameRegistered {
		public static final String CUSTOMER_NAME = "Customer Name";
		public static final String GENDER = "Gender";
		public static final String DOB = "Birthdate";
		public static final String ADDRESS = "Address";
		public static final String CITY = "City";
		public static final String STATE = "State";
		public static final String PIN = "Pin";
		public static final String MOBILE = "Mobile No.";
		public static final String EMAIL = "Email";
		public static final String CUSTOMER_ID = "Customer ID";
		public static final String CURRENT_BALANCE = "Current Balance";
		public static final String CURRENT_AMOUNT_WHEN_ADD = "Current Amount";
		public static final String ACCOUNT_TYPE = "Account Type";
		public static final String ACCOUNT_ID = "Account ID";
		public static final String TRANSACTION_ID = "Transaction ID";
		public static final String AMOUNT_FUNTRANSFER = "Amount";
		public static final String BALANCE_INQUIRY = "Balance";
	}
	
	public class TitleTextboxNewCustomer {
		public static final String CUSTOMER_NAME = "Customer Name";
		public static final String GENDER = "Gender";
		public static final String DOB = "Date of Birth";
		public static final String ADDRESS = "Address";
		public static final String CITY = "City";
		public static final String STATE = "State";
		public static final String PIN = "PIN";
		public static final String MOBILE = "Mobile Number";
		public static final String EMAIL = "E-mail";
		public static final String PASSWORD = "Password";
	}
	
	public class NCMessage {
		public static final String CUSTOMER_NAME_BLANK = "Customer name must not be blank";
		public static final String CUSTOMER_NAME_NUMBER = "Numbers are not allowed";
		public static final String CUSTOMER_NAME_SPECIAL_CHAR = "Special characters are not allowed";
		public static final String CUSTOMER_NAME_BLANK_FIRST = "First character can not have space";
		
		public static final String ADDRESS_BLANK = "Address Field must not be blank";
		public static final String ADDRESS_BLANK_FIRST = "First character can not have space";
		
		public static final String CITY_BLANK = "City Field must not be blank";
		public static final String CITY_NUMBER = "Numbers are not allowed";
		public static final String CITY_SPECIAL_CHAR = "Special characters are not allowed";
		public static final String CITY_BLANK_FIRST = "First character can not have space";
		
		public static final String STATE_BLANK = "State must not be blank";
		public static final String STATE_NUMBER = "Numbers are not allowed";
		public static final String STATE_SPECIAL_CHAR = "Special characters are not allowed";
		public static final String STATE_BLANK_FIRST = "First character can not have space";
		
		public static final String PIN_BLANK = "PIN Code must not be blank";
		public static final String PIN_CHARACTERS = "Characters are not allowed";
		public static final String PIN_SPECIAL_CHAR = "Special characters are not allowed";
		public static final String PIN_BLANK_FIRST = "First character can not have space";
		public static final String PIN_HAVE_BLANK = "Characters are not allowed";
		public static final String PIN_MUST_HAVE_6_DIGITS = "PIN Code must have 6 Digits";
		
		public static final String MOBILE_BLANK = "Mobile no must not be blank";
		public static final String MOBILE_SPECIAL_CHAR = "Special characters are not allowed";
		public static final String MOBILE_HAVE_BLANK = "Characters are not allowed";
		public static final String MOBILE_BLANK_FIRST = "First character can not have space";
		
		public static final String EMAIL_BLANK = "Email-ID must not be blank";
		public static final String EMAIL_INCORRECT_FORMAT = "Email-ID is not valid";
		public static final String EMAIL_HAVE_SPACE = "Email-ID is not valid";
		public static final String EMAIL_BLANK_FIRST = "First character can not have space";
	}
	
	public class InvalidNCRegister {
		public static final String NAME_NUMBERIC = "1234";
		public static final String NAME_SPECIAL_CHAR = "GIANG!@#";
		public static final String NAME_BLANK_FIRST = " GIANG";
		
		public static final String ADDRESS_BLANK_FIRST = " HaTinh";
		
		public static final String CITY_NUMBERIC = "HaTinh1234";
		public static final String CITY_SPECIAL_CHAR = "HaTinh!@#";
		public static final String CITY_BLANK_FIRST = " HaTinh";
		
		public static final String STATE_NUMBERIC = "ThachHa1234";
		public static final String STATE_SPECIAL_CHAR = "ThachHa!@#";
		public static final String STATE_BLANK_FIRST = " ThachHa";
		
		public static final String PIN_NOT_NUMBERIC = "PIN234";
		public static final String PIN_MORE_THAN_6_DIGITS = "1234567";
		public static final String PIN_LESS_THAN_6_DIGITS = "123";
		public static final String PIN_BLANK_FIRST = " 12345";
		public static final String PIN_HAVE_BLANK = "123 45";
		public static final String PIN_SPECIAL_CHAR = "123@#1";
		
		public static final String MOBILE_SPECIAL_CHAR = "886636!@12	";
		public static final String MOBILE_HAVE_BLANK = "123 123";
		public static final String MOBILE_BLANK_FIRST = " 123456";
		
		public static final String EMAIL_INCORRECT_FORMAT = "giangpk33@gmail.";
		public static final String EMAIL_HAVE_SPACE = "giang pk33@gmail.com";
		public static final String EMAIL_BLANK_FIRST = " giangpk33@gmail.com";
	}

	public class ClassNameAddTable {
		public static final String CUSTOMER_NAME = "name";
		public static final String DOB = "dob";
		public static final String ADDRESS = "addr";
		public static final String CITY = "city";
		public static final String STATE = "state";
		public static final String PIN = "pinno";
		public static final String TELEPHONE = "telephoneno";
		public static final String EMAIL = "emailid";
		public static final String PASSWORD = "password";
	}

	public class Message {
		public static final String REGISTERED_SUCCESS_MESSAGE = "Customer Registered Successfully!!!";
		public static final String UPDATED_SUCCESS_MESSAGE = "Customer details updated Successfully!!!";
		public static final String GENERATE_ACCOUNT_SUCCESS_MESSAGE = "Account Generated Successfully!!!";
		public static final String UPDATED_ACCOUNT_SUCCESS_MESSAGE = "Account details updated Successfully!!!";
		public static final String DEPOSIT_SUCCESS_MESSAGE = "Transaction details of Deposit for Account ";
		public static final String WITHDRAW_SUCCESS_MESSAGE = "Transaction details of Withdrawal for Account ";
		public static final String FUNDTRANSFER_SUCCESS_MESSAGE = "Fund Transfer Details";
		public static final String BALANCE_INQUIRY_MESSAGE = "Balance Details for Account ";
		public static final String ACCOUNT_NOT_EXIST_MESSAGE = "Account does not exist";
		public static final String CUSTOMER_NOT_EXIST_MESSAGE = "Customer does not exist!!";
		public static final String ACCOUNT_DELETED_SUCCESS_MESSAGE = "Account Deleted Sucessfully";
		public static final String CUSTOMER_DELETED_SUCCESS_MESSAGE = "Customer deleted Successfully";
	}

	public class DepositWithDrawalData {
		public static final String INIT_BALANCE = "50000";
		public static final String DEPOSIT_AMOUNT = "5000";
		public static final String BALANCE_AFTER_DEPOSIT = "55000";
		public static final String WITHDRAW_AMOUNT = "15000";
		public static final String BALANCE_AFTER_WITHDRAW = "40000";

		public static final String DEPOSIT_DESCRIPTION = "Deposit";
		public static final String WITHDRAW_DESCRIPTION = "Withdraw";
		
		public static final String AMOUNT_TRANSFER = "10000";
		public static final String PAYEES_ACC_NO = "86662";
		public static final String TRANSFER_DESCRIPTION = "Transfer";
		
		public static final String BALANCE_INQUIRY = "30000";
		
	}

	public class AccountType {
		public static final String SAVINGS = "Savings";
		public static final String CURRENT = "Current";
	}

	public class TitleForm {
		public static final String EDIT_ACCOUNT_FORM = "Edit Account Form";
		public static final String EDIT_ACCOUNT_ENTRY_FORM = "Edit Account Entry Form";
		public static final String ADD_NEW_ACCOUNT_FORM = "Add new account form";
		public static final String EDIT_CUSTOMER_FORM = "Edit Customer Form";
		public static final String EDIT_CUSTOMER_ENTRY_FORM = "Edit Customer";
		public static final String ADD_NEW_CUSTOMER_FORM = "Add New Customer";
		public static final String DEPOSIT_FORM = "Amount Deposit Form";
		public static final String WITHDRAW_FORM = "Amount Withdrawal Form";
		public static final String FUNTRANSFER_FORM = "Fund transfer";
		public static final String BALANCE_INQUIRY_FORM = "Balance Enquiry Form";
		public static final String DELETE_ACCOUNT_FORM = "Delete Account Form";
		public static final String DELETE_CUSTOMER_FORM = "Delete Customer Form";
	}

	public class PageName {
		public static final String NEW_CUSTOMER = "New Customer";
		public static final String EDIT_CUSTOMER = "Edit Customer";
		public static final String NEW_ACCOUNT = "New Account";
		public static final String EDIT_ACCOUNT = "Edit Account";
		public static final String DEPOST = "Deposit";
		public static final String WITHDRAWAL = "Withdrawal";
		public static final String FUNTRANSFER = "Fund Transfer";
		public static final String BALANCE_ENQUIRY = "Balance Enquiry";
		public static final String DELETE_ACCOUNT = "Delete Account";
		public static final String DELETE_CUSTOMER = "Delete Customer";
	}
}
