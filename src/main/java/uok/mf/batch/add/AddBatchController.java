package uok.mf.batch.add;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import uok.mf.service.BatchService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amila on 3/8/14.
 */
@Controller
@RequestMapping("add_batch")
@SessionAttributes("addBatchForm")
public class AddBatchController {
    @Autowired
    private AddBatchValidator addBatchValidator;
    @Autowired
    private BatchService batchService;
    public static final String view = "add_batch";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm() {
        return new ModelAndView(view, "addBatchForm", new AddBatchForm());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView submitForm(@ModelAttribute("addBatchForm") AddBatchForm addBatchForm, BindingResult result) {
        addBatchValidator.validate(addBatchForm, result);
        if (!result.hasErrors()) {
            Map<String, String> model = new HashMap();
            batchService.createBatch(addBatchForm);
            model.put("successMessage", "uok.mf.add.batch.success");
            model.put("redirectUrl", "/manage_batch.html");
            return new ModelAndView("success", "model", model);
        }
        return new ModelAndView(view, "addBatchForm", addBatchForm);
    }
}
