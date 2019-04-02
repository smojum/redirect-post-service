package com.smojum.redirectpostservice;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RedirectController {
    @PostMapping(value = "/tc")
    public ModelAndView navigate() {
        String url = "https://stagepremier.trustcommerce.com/trustcommerce_payment/index.php";
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        redirectView.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        redirectView.setHttp10Compatible(Boolean.TRUE);
        ModelAndView modelAndView = new ModelAndView(redirectView);
        return modelAndView;
    }

    @GetMapping(value = "/redirect")
    public String redirect(Model model) {
        // TODO: 4/2/2019 use property configurator to load map and set it directly here. 
        model.addAttribute("trxcustid_licensekey", "ZNKa3om2r1IEYrihkgaySppVHYE5AUPO7gITsishehTqkSwTOig0qukwAFnxDkRA");
        model.addAttribute("trxcustid", "822023");
        model.addAttribute("billingids", "N7BKYH%2CN7BR6A");
        model.addAttribute("checking_ach", "y");
        return "redirect";
    }
}
