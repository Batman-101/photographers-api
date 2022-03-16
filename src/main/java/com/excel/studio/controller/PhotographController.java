package com.excel.studio.controller;

import com.excel.studio.exception.DataAccessException;
import com.excel.studio.model.ErrorModel;
import com.excel.studio.model.GenericResponse;
import com.excel.studio.model.Photographer;
import com.excel.studio.service.PhotographerService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * PhotographController with all API endpoints to query Photographers
 */
@RestController
public class PhotographController {
    private static final Logger log = LoggerFactory.getLogger(PhotographController.class);

    @Autowired
    private final PhotographerService photographerService;

    @Autowired
    public PhotographController(PhotographerService locationService) {
        this.photographerService = locationService;
    }

    @GetMapping("/api/photographers")
    @ApiPageable
    @ApiResponses(value = { @ApiResponse(code = 204, message = "No Content Found"),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "URL Not Found")})
    ResponseEntity<GenericResponse> getAllPhotographers() {
        log.info("Getting all photographers");
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setTimestamp(Instant.now());
        genericResponse.setSuccess(false);

        try {
            List<Photographer> photographers = photographerService.getAllPhotographers();
            if (photographers != null && !photographers.isEmpty()) {
                genericResponse.setSuccess(true);
                genericResponse.setData(photographers);
                return new ResponseEntity<>(genericResponse, HttpStatus.OK);
            } else {
                genericResponse.setSuccess(true);
                return new ResponseEntity<>(genericResponse, HttpStatus.NO_CONTENT);
            }
        } catch(DataAccessException ex){
            genericResponse.setSuccess(false);
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(102);
            errorModel.setMessage(ex.getMessage());
            genericResponse.setError(errorModel);
            return new ResponseEntity<>(genericResponse, HttpStatus.OK);
        } catch(Exception ex){
            genericResponse.setSuccess(false);
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(102);
            errorModel.setMessage(ex.getMessage());
            genericResponse.setError(errorModel);
            return new ResponseEntity<>(genericResponse, HttpStatus.OK);
        }
    }

    @GetMapping("/api/photographer/id/{photographerId}")
    @ApiPageable
    @ApiResponses(value = { @ApiResponse(code = 204, message = "No Content Found"),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "URL Not Found")})
    ResponseEntity<GenericResponse> getPhotographerById(@PathVariable("photographerId") String id) {
        log.info("Getting photographer by id: {}", id);
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setTimestamp(Instant.now());
        genericResponse.setSuccess(false);

        try {
            Optional<Photographer> photographer = photographerService.getPhotographerById(id);
            if (photographer.isPresent()) {
                genericResponse.setSuccess(true);
                genericResponse.setData(photographer.get());
                return new ResponseEntity<>(genericResponse, HttpStatus.OK);
            } else {
                genericResponse.setSuccess(true);
                return new ResponseEntity<>(genericResponse, HttpStatus.NO_CONTENT);
            }
        } catch(DataAccessException ex){
            genericResponse.setSuccess(false);
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(102);
            errorModel.setMessage(ex.getMessage());
            genericResponse.setError(errorModel);
            return new ResponseEntity<>(genericResponse, HttpStatus.OK);
        } catch(Exception ex){
            genericResponse.setSuccess(false);
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(102);
            errorModel.setMessage(ex.getMessage());
            genericResponse.setError(errorModel);
            return new ResponseEntity<>(genericResponse, HttpStatus.OK);
        }
    }

    @GetMapping("/api/photographers/event/{eventType}")
    @ApiPageable
    @ApiResponses(value = { @ApiResponse(code = 204, message = "No Content Found"),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "URL Not Found")})
    ResponseEntity<GenericResponse> getPhotographersByType(@PathVariable("eventType") String eventType) {
        log.info("Getting all photographers by eventType:{}", eventType);
        GenericResponse genericResponse = new GenericResponse();
        genericResponse.setTimestamp(Instant.now());
        genericResponse.setSuccess(false);

        try {
            List<Photographer> photographers = photographerService.getPhotographerByType(eventType);
            if (photographers != null && !photographers.isEmpty()) {
                genericResponse.setSuccess(true);
                genericResponse.setData(photographers);
                return new ResponseEntity<>(genericResponse, HttpStatus.OK);
            } else {
                genericResponse.setSuccess(true);
                return new ResponseEntity<>(genericResponse, HttpStatus.NO_CONTENT);
            }
        } catch(DataAccessException ex){
            genericResponse.setSuccess(false);
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(102);
            errorModel.setMessage(ex.getMessage());
            genericResponse.setError(errorModel);
            return new ResponseEntity<>(genericResponse, HttpStatus.OK);
        } catch(Exception ex){
            genericResponse.setSuccess(false);
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(102);
            errorModel.setMessage(ex.getMessage());
            genericResponse.setError(errorModel);
            return new ResponseEntity<>(genericResponse, HttpStatus.OK);
        }
    }
}
