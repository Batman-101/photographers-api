package com.excel.studio.dao;

import com.excel.studio.exception.DataAccessException;
import com.excel.studio.model.Photographer;

import java.util.List;
import java.util.Optional;

/**
 * PhotographerDao contains contracts for all data access logic.
 */
public interface PhotographerDao {
    List<Photographer> getAllPhotographers() throws DataAccessException;
    Optional<Photographer> getPhotographerById(String id) throws DataAccessException;
    List<Photographer> getPhotographerByType(String type) throws DataAccessException;
}
