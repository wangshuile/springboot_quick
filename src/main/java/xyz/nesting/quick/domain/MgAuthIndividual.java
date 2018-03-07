package xyz.nesting.quick.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import xyz.nesting.quick.util.ZcAbstractBaseModel;


/*
 */

@Document(collection = "gb_auth_individual")
public class MgAuthIndividual extends ZcAbstractBaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6826015626955017247L;

	@Indexed
	@Field("user_uuid")
	private String userUuid;
	
	@Field("id_name")
	private String idName;
	
	@Indexed
	@Field("id_number")
	private String idNumber;
	
	@Field("card_number")
	private String cardNumber;
	
	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

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
