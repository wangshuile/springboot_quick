package xyz.nesting.quick.service;

import xyz.nesting.quick.domain.MgAuthIndividual;

public interface AuthService {

	void auth(String userUuid, String idName, String idNumber, String cardNumber);

	MgAuthIndividual get(String userUuid);

}
