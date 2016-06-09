package com.jacojang.neverland.controller;

import com.jacojang.neverland.domain.Home;
import com.jacojang.neverland.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jacojang on 16. 6. 8.
 */
@RestController
@RequestMapping(value = "/homes")
public class HomeController {
    private HomeService homeService;

    @Autowired
    public HomeController(HomeService homeService){
        this.homeService = homeService;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public Iterable<Home> list(@RequestParam boolean rebuild){
        return homeService.list(rebuild);
    }
}
