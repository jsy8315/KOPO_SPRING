package DAODTO;

public class BankAccountInfo {
    private String accountNum;
    private String bankCode;
    private String accCode;
    private String accBalance;

    public BankAccountInfo(String accountNum, String bankCode, String accCode, String accBalance) {
        this.setAccountNum(accountNum);
        this.setBankCode(bankCode);
        this.setAccCode(accCode);
        this.setAccBalance(accBalance);
    }

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		this.accCode = accCode;
	}

	public String getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(String accBalance) {
		this.accBalance = accBalance;
	}

    // Getters and setters
}

