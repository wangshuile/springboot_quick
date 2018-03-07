package xyz.nesting.quick.controller.pub;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.nesting.quick.controller.BaseController;
import xyz.nesting.quick.util.ZcApiResponse;


@RestController
@RequestMapping(PubController.ROUTER_PUBLIC)
public class PubController extends BaseController {

	public static final String ROUTER_PUBLIC = "/public";
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public ZcApiResponse test() {
	    	return ZcApiResponse.success();
    }
	
}
