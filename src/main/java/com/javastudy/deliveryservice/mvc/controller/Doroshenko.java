/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javastudy.deliveryservice.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Tanya
 */
@Controller
public class Doroshenko {

    @RequestMapping(method = RequestMethod.GET, value = "/doroshenko.htm")
        public String getPage(Model model, HttpServletRequest req) {
        String name = req.getParameter("name");
        model.addAttribute("name", name);

        List<String> names = new ArrayList<String>();
        names.add("tanya");
        names.add("misha");
        names.add("gosha");
        names.add("vika");
        names.add("zhenya");
        
        model.addAttribute("list", names);
        return "doroshenko";
    }

}

    

