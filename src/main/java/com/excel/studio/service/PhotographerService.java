package com.excel.studio.service;

import com.excel.studio.exception.DataAccessException;
import com.excel.studio.model.Photographer;

import java.util.List;
import java.util.Optional;

/**
 * PhotographerService is responsible for making calls to dao and additional business logic.
 */
public interface PhotographerService {

    List<Photographer> getAllPhotographers() throws DataAccessException;

    Optional<Photographer> getPhotographerById(String id) throws DataAccessException;

    List<Photographer> getPhotographerByType(String type) throws DataAccessException;
}
