package xyz.nesting.quick.domain;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import xyz.nesting.quick.util.ZcAbstractBaseModel;

/*
 */

@Document(collection = "gb_user")
public class MgUser extends ZcAbstractBaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8166410309486098574L;

	@Indexed
	@Field("user_uuid")
	private String userUuid;
	
	@Field("name")
	private String name;
	
	@Field("mobile")
	private String mobile;
	
	@Field("image")
	private String image;
	
	@Field("description")
	private String description;
	
	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
