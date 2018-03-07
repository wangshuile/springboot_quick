package xyz.nesting.quick.service;

import xyz.nesting.quick.domain.MgUser;

public interface UserService {

	MgUser getUserByUserUuid(String userUuid);

	MgUser add(String userUuid, String mobile);

	void updateProfile(String userUuid, String name, String description);

	void updateImage(String userUuid, String image);

}
