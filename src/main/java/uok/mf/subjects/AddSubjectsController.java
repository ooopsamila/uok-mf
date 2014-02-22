package uok.mf.subjects;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by amila on 2/22/14.
 */
@Controller
@RequestMapping("add_subjects")
@SessionAttributes("addSubjectsForm")
public class AddSubjectsController {
    public static final String view = "add_subjects";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm() {
        return new ModelAndView(view, "addSubjectsForm", new AddSubjectsForm());
    }
}
