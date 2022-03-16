package com.excel.studio.dao;

import com.excel.studio.config.YmlConfig;
import com.excel.studio.exception.DataAccessException;
import com.excel.studio.model.Photographer;
import com.excel.studio.model.Photographers;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * PhotographersDaoImpl contains all data access logic.
 */
@Repository
@Data
public class PhotographersDaoImpl implements PhotographerDao {
    private static final Logger log = LoggerFactory.getLogger(PhotographersDaoImpl.class);

    @Autowired
    private YmlConfig config;

    @Override
    public List<Photographer> getAllPhotographers() throws DataAccessException {
        try {
               return getPhotographersAtOnce().getPhotographers();
        } catch (Exception ex) {
            log.error("Exception occured while fetching photographer data : {}", ex.getMessage());
            throw new DataAccessException("Failed the fetch data!!");
        }
    }

    @Override
    public Optional<Photographer> getPhotographerById(String id) throws DataAccessException {
        try {
                return getPhotographersAtOnce().getPhotographers()
                        .stream()
                        .filter(p -> p.getId().equalsIgnoreCase(id))
                        .findFirst();

        } catch (Exception ex) {
            log.error("Exception occured while fetching photographer data : {}", ex.getMessage());
            throw new DataAccessException("Failed the fetch data!!");
        }
    }

    @Override
    public List<Photographer> getPhotographerByType(String type) throws DataAccessException {
        try {
            return getPhotographersAtOnce().getPhotographers()
                    .stream()
                    .filter(p -> p.getEventType().contains(type))
                    .collect(Collectors.toList());

        } catch (Exception ex) {
            log.error("Exception occurred while fetching photographer data : {}", ex.getMessage());
            throw new DataAccessException("Failed the fetch data!!");
        }
    }

    public Photographers getPhotographersAtOnce() throws DataAccessException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            // Convert JSON File to Java Object
            return mapper.readValue(new File(config.getDataPath()), Photographers.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new DataAccessException("Failed the fetch data!!");
        }
    }
}

