package com.smojum.redirectpostservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RedirectController {

    @Autowired
    private PostDataMappingProperties postDataMappingProperties;

    @Value("${app.url}")
    private String url;

    @PostMapping(value = "/tc")
    public ModelAndView navigate() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        redirectView.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        redirectView.setHttp10Compatible(Boolean.TRUE);
        ModelAndView modelAndView = new ModelAndView(redirectView);
        return modelAndView;
    }

    @RequestMapping(value = "/redirect", method = {RequestMethod.GET, RequestMethod.POST})
    public String redirect(Model model) {
        model.addAllAttributes(postDataMappingProperties.getMap());
//        model.addAttribute("", "");
        return "redirect";
    }

    @RequestMapping(value = "/callback", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView callback() {
        String callbackurl = ""; // TODO: 4/2/2019
        // TODO: 4/2/2019  Here you can do any db update/ rest call etc.
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(callbackurl);
        ModelAndView modelAndView = new ModelAndView(redirectView);
        return modelAndView;
    }
}
