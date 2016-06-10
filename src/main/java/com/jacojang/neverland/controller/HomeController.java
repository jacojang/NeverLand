package com.jacojang.neverland.controller;

import com.jacojang.neverland.domain.Home;
import com.jacojang.neverland.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jacojang on 16. 6. 8.
 */
@Controller
@RequestMapping(value = "/homes")
public class HomeController {
    private HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService){
        this.homeService = homeService;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String list(@RequestParam boolean rebuild, Model model){
        homeService.list(rebuild);
        Iterable<Home> homes = homeService.listByCheckDate();
        model.addAttribute("homes", homes);
        return "redirect:bydate";
    }

    @RequestMapping(value="/byprice", method = RequestMethod.GET)
    public String byprice(Model model){
        Iterable<Home> homes = homeService.listByPrice();
        model.addAttribute("homes", homes);
        model.addAttribute("title", "byPrice");
        return "/homes/index";
    }

    @RequestMapping(value="/bysize", method = RequestMethod.GET)
    public String bysize(Model model){
        Iterable<Home> homes = homeService.listBySize();
        model.addAttribute("homes", homes);
        model.addAttribute("title", "bySize");
        return "/homes/index";
    }

    @RequestMapping(value="/bydate", method = RequestMethod.GET)
    public String bydate(Model model){
        Iterable<Home> homes = homeService.listByCheckDate();
        model.addAttribute("homes", homes);
        model.addAttribute("title", "byDate");
        return "/homes/index";
    }

    @RequestMapping(value="/bytype", method = RequestMethod.GET)
    public String bytype(Model model){
        Iterable<Home> homes = homeService.listByType();
        model.addAttribute("homes", homes);
        model.addAttribute("title", "byType");
        return "/homes/index";
    }

    @RequestMapping(value="/byname", method = RequestMethod.GET)
    public String byname(Model model){
        Iterable<Home> homes = homeService.listByName();
        model.addAttribute("homes", homes);
        model.addAttribute("title", "byName");
        return "/homes/index";
    }
}
