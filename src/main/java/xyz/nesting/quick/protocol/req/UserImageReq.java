package xyz.nesting.quick.protocol.req;

import org.hibernate.validator.constraints.NotEmpty;

import xyz.nesting.quick.util.ZcAbstractToString;

public class UserImageReq extends ZcAbstractToString{

	@NotEmpty(message = "image is empty")
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
}
