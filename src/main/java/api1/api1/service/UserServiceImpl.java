package api1.api1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import api1.api1.model.Api1Response;
import api1.api1.model.Api2Request;
import api1.api1.model.Api2Response;
import api1.api1.model.Users;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService{
	private String GET_USER_BY_ID_URI = "/users/{id}";

	private String POST_ADD_USER_URI = "/users";

	private String PUT_UPDATE_USER_URI = "/users/update";

	private String DELETE_USER_URI = "/{id}";

//@Autowired
	private final WebClient webClient;

	public UserServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://localhost:9091/api1").build();
	}

	@Override
	public Api1Response getSingleUser(Long id) {
		Api2Response api2Response = webClient.get().uri(GET_USER_BY_ID_URI, id).retrieve()
				.bodyToMono(Api2Response.class).block();

		return this.getResponse(api2Response);
	}

	@Override
	public Api1Response saveUser(Users user) {
		Api2Response api2Response = webClient.post().uri(POST_ADD_USER_URI).bodyValue(this.UserToUserRequest(user))
				.retrieve().bodyToMono(Api2Response.class).block();

		return this.getResponse(api2Response);
	}

	@Override
	public Api1Response updateUser(Users user) {
		Api2Response api2Response = webClient.put().uri(PUT_UPDATE_USER_URI).bodyValue(this.UserToUserRequest(user))
				.retrieve().bodyToMono(Api2Response.class).block();

		return this.getResponse(api2Response);
	}

	@Override
	public Api1Response deleteUser(Long id) {
		Api2Response api2Response = webClient.delete().uri(DELETE_USER_URI, id).retrieve()
				.bodyToMono(Api2Response.class).block();

		return this.getResponse(api2Response);
	}

	private Api1Response getResponse(Api2Response api2Response) {
// TODO Auto-generated method stub
		Api1Response api1Response = new Api1Response();
//User user = this.UserToUserRequest(user);
		Users user = api2Response.getUser();
		api1Response.setUser(user);
		api1Response.setMessage(api2Response.getMessage());
		return api1Response;
	}

	private Users UserRequestToUser(Api2Request api2Request) {
		Users user = new Users();
		user.setId(api2Request.getRid());
		user.setName(api2Request.getRname());
		user.setDob(api2Request.getRdob());
		user.setEmail(api2Request.getRemail());
		user.setMobno(api2Request.getRmobno());
		return user;
	}

	private Api2Request UserToUserRequest(Users user) {
		Api2Request api2Request = new Api2Request();
		api2Request.setRid(user.getId());
		api2Request.setRname(user.getName());
		api2Request.setRdob(user.getDob());
		api2Request.setRemail(user.getEmail());
		api2Request.setRmobno(user.getMobno());
		return api2Request;
	}
}
