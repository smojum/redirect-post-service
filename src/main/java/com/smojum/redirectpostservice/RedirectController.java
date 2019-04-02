package com.smojum.redirectpostservice;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RedirectController {
    @GetMapping(value = "/tc")
    public ModelAndView navigate() throws Exception {
        String redirectUrl = "https://stagepremier.trustcommerce.com/trustcommerce_payment/index.php";
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(redirectUrl);
        redirectView.setStatusCode(HttpStatus.PERMANENT_REDIRECT);
        redirectView.setHttp10Compatible(Boolean.TRUE);
        redirectView.setExpandUriTemplateVariables(false);
        ModelAndView modelAndView = new ModelAndView(redirectView);
        modelAndView.addObject("trxcustid_licensekey", "ZNKa3om2r1IEYrihkgaySppVHYE5AUPO7gITsishehTqkSwTOig0qukwAFnxDkRA");
        modelAndView.addObject("trxcustid", "822023");
        modelAndView.addObject("billingids", "N7BKYH%2CN7BR6A");
        modelAndView.addObject("checking_ach", "y");

        return modelAndView;
    }
}
