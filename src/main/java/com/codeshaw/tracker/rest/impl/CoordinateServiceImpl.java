package com.codeshaw.tracker.rest.impl;

import com.codeshaw.tracker.rest.CoordinateService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST-ful implementation of {@link CoordinateService}
 */
@Service
@RestController
@RequestMapping("/coordinates")
public class CoordinateServiceImpl implements CoordinateService {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
