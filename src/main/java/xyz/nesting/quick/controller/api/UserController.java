package xyz.nesting.quick.controller.api;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.nesting.quick.domain.MgUser;
import xyz.nesting.quick.protocol.req.UserImageReq;
import xyz.nesting.quick.protocol.req.UserProfileReq;
import xyz.nesting.quick.protocol.req.UserReq;
import xyz.nesting.quick.util.ZcApiResponse;

@RequestMapping(BaseApiController.ROUTER_API_V1 + "/user")
@RestController
@Validated
public class UserController extends BaseApiController{
	
	@RequestMapping(value="/test", method = RequestMethod.POST)
    public ZcApiResponse test() {
    		log.debug("user test: {}", getUserUuid());
    		userService.add(getUserUuid(),"test"+new Random().nextInt(102));
	    	return ZcApiResponse.success(getUser());
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public ZcApiResponse add(@Valid @RequestBody UserReq userReq) {
    		log.debug("user add useruuid:{},mobile:{}", getUserUuid(), userReq.getMobile());
    		userService.add(getUserUuid(), userReq.getMobile());
	    	return ZcApiResponse.success(getUser());
    }
	
	@RequestMapping(method = RequestMethod.GET)
    public ZcApiResponse get() {
		long start = System.currentTimeMillis();
    		log.debug("get useruuid:{}", getUserUuid());
    		MgUser user = getUser();
    		System.out.println(System.currentTimeMillis() - start);
	    	return ZcApiResponse.success(user);
    }
	
	@RequestMapping(value = "/profile", method = RequestMethod.PUT)
    public ZcApiResponse updateProfile(@Valid @RequestBody UserProfileReq userReq) {
    		log.debug("user updateProfile useruuid:{},name:{},description:{}", getUserUuid(), userReq.getName(), userReq.getDescription());
    		userService.updateProfile(getUserUuid(), userReq.getName(), userReq.getDescription());
	    	return ZcApiResponse.success(getUser());
    }
	
	@RequestMapping(value = "/image", method = RequestMethod.PUT)
    public ZcApiResponse updateImage(@Valid @RequestBody UserImageReq userReq) {
    		log.debug("user updateImage useruuid:{},image:{}", getUserUuid(), userReq.getImage());
    		userService.updateImage(getUserUuid(), userReq.getImage());
	    	return ZcApiResponse.success(getUser());
    }
	
}
