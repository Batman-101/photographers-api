package com.excel.studio.controller;

import com.excel.studio.model.ErrorModel;
import com.excel.studio.model.GenericResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;

@Controller
public class MyCustomErrorController implements ErrorController {

    @RequestMapping("/error")
    @ResponseBody
    public GenericResponse handleError() {
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setSuccess(false);
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMessage("Url Not Found");
        errorModel.setErrorCode(404);
        genericResponse.setError(errorModel);
        genericResponse.setTimestamp(Instant.now());
        return genericResponse;
    }

//    @Override
    public String getErrorPath() {
        return "/error";
    }
}