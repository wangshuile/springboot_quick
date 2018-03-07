package xyz.nesting.quick.protocol.req;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import xyz.nesting.quick.util.ZcAbstractToString;

public class AuthIndividualReq extends ZcAbstractToString{

	
	@Size(min=1,max=32,message="身份证姓名(1~16位)")
	@NotEmpty(message="idName is empty")
	private String idName;
	
	@Size(min=15,max=18,message="身份证号码(15位或18位)")
	@NotEmpty(message="idNumber is empty")
	private String idNumber;
	
	@Size(min=12,max=19,message="银行卡号(12～19位)")
	@NotEmpty(message="cardNumber is empty")
	private String cardNumber;
	
	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
}
