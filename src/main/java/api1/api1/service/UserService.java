package api1.api1.service;

import api1.api1.model.Api1Response;
import api1.api1.model.Users;

public interface UserService {
Api1Response saveUser(Users user);
	
	Api1Response getSingleUser (Long id);
	
	//List<Users> getSingleUser (Long id);
	
	Api1Response deleteUser(Long id);
	
	Api1Response updateUser(Users user);
}
