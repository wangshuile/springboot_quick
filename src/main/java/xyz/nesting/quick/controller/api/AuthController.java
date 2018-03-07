package xyz.nesting.quick.controller.api;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.nesting.quick.domain.MgAuthIndividual;
import xyz.nesting.quick.protocol.req.AuthIndividualReq;
import xyz.nesting.quick.util.ZcApiResponse;

@RequestMapping(BaseApiController.ROUTER_API_V1 + "/auth")
@RestController
@Validated
public class AuthController extends BaseApiController{
	
	@RequestMapping(value="/individual", method = RequestMethod.POST)
    public ZcApiResponse auth(@Valid @RequestBody AuthIndividualReq req) {
    		log.debug("auth useruuid:{},req:{}", getUserUuid(), req);
    		authService.auth(getUserUuid(), req.getIdName(), req.getIdNumber(), req.getCardNumber());
	    	return ZcApiResponse.success();
    }
	
	@RequestMapping(value="/individual", method = RequestMethod.GET)
    public ZcApiResponse get() {
    		log.debug("auth get useruuid:{}", getUserUuid());
    		MgAuthIndividual mgAuthIndividual = authService.get(getUserUuid());
	    	return ZcApiResponse.success(mgAuthIndividual);
    }
	
	
}
