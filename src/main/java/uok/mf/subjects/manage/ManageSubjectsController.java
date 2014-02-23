package uok.mf.subjects.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by amila on 2/22/14.
 */
@Controller
@RequestMapping("manage_subjects")
@SessionAttributes("manageSubjectsForm")
public class ManageSubjectsController {
    public static final String view = "manage_subjects";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm() {
        return new ModelAndView(view, "manageSubjectsForm", new ManageSubjectsForm());
    }
}
