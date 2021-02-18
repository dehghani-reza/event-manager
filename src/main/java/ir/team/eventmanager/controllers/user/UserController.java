package ir.team.eventmanager.controllers.user;

import ir.team.eventmanager.controllers.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public abstract class UserController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

}
