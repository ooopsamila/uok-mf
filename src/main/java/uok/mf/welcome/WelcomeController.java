package uok.mf.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by amila on 2/22/14.
 */
@Controller
@RequestMapping("welcome")
@SessionAttributes("WelcomeForm")
public class WelcomeController {
    public static final String view = "welcome";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm() {
        return new ModelAndView(view, "welcomeForm", new WelcomeForm());
    }
}
