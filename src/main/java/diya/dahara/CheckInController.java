/*
*  (C) Copyright 2010-2013 hSenid Mobile Solutions (Pvt) Limited.
*  All Rights Reserved.
*
*  These materials are unpublished, proprietary, confidential source code of
*  hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
*  of hSenid Mobile Solutions (Pvt) Limited.
*
*  hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
*  property rights in these materials.
*/
package diya.dahara;

import diya.dahara.form.CheckInForm;
import diya.dahara.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("checkIn")
@SessionAttributes("checkInForm")
public class CheckInController {

    private static String view = "checkIn";
    @Autowired
    private CheckInService checkInService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initForm() {
        return new ModelAndView(view, "checkInForm", new CheckInForm());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView checkIn(@ModelAttribute("checkInForm") CheckInForm checkInForm) throws Exception {
        checkInService.checkIn(checkInForm);
        return new ModelAndView("room");
    }


}
