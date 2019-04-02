package com.smojum.redirectpostservice;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class RedirectController {
    @PostMapping(value = "/tc")
    public ModelAndView navigate() throws Exception {
        String url = "https://stagepremier.trustcommerce.com/trustcommerce_payment/index.php";
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        redirectView.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        redirectView.setHttp10Compatible(Boolean.TRUE);
//        redirectView.setExpandUriTemplateVariables(false);
//        Map<String, String> map = new HashMap<>();
//        map.put("trxcustid_licensekey", "ZNKa3om2r1IEYrihkgaySppVHYE5AUPO7gITsishehTqkSwTOig0qukwAFnxDkRA");
//        map.put("trxcustid", "822023");
//        map.put("billingids", "N7BKYH%2CN7BR6A");
//        map.put("checking_ach", "y");
//        redirectView.setAttributesMap(map);
        ModelAndView modelAndView = new ModelAndView(redirectView);
        return modelAndView;
    }
    @GetMapping(value = "/tc2")
    public ModelAndView navigate2(RedirectAttributes redirectAttributes) throws Exception {
        String url = "https://stagepremier.trustcommerce.com/trustcommerce_payment/index.php";
        redirectAttributes.addFlashAttribute("trxcustid_licensekey", "ZNKa3om2r1IEYrihkgaySppVHYE5AUPO7gITsishehTqkSwTOig0qukwAFnxDkRA");
        redirectAttributes.addFlashAttribute("trxcustid", "822023");
        redirectAttributes.addFlashAttribute("billingids", "N7BKYH%2CN7BR6A");
        redirectAttributes.addFlashAttribute("checking_ach", "y");

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);
        redirectView.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
        redirectView.setHttp10Compatible(Boolean.TRUE);

        return new ModelAndView(redirectView);
    }
}
