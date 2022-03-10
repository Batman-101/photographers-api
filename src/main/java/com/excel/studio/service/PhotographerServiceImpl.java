package com.excel.studio.service;

import com.excel.studio.dao.PhotographerDao;
import com.excel.studio.exception.DataAccessException;
import com.excel.studio.model.Photographer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * PhotographerServiceImpl is responsible for making calls to dao and additional business logic.
 */
@Service
public class PhotographerServiceImpl implements PhotographerService {
    private final PhotographerDao locationDao;
    private static final Logger log = LoggerFactory.getLogger(PhotographerServiceImpl.class);


    @Autowired
    public PhotographerServiceImpl(PhotographerDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public List<Photographer> getAllPhotographers() throws DataAccessException {
        try {
            return locationDao.getAllPhotographers();
        } catch (Exception ex) {
            log.info(ex.getMessage());
            throw new DataAccessException("Failed the fetch data!!");

        }
    }

    @Override
    public Optional<Photographer> getPhotographerById(String id) throws DataAccessException {

        try{
            return locationDao.getPhotographerById(id);
        }catch(Exception ex){
            log.info(ex.getMessage());
            throw new DataAccessException("Failed the fetch data!!");
        }
    }

    @Override
    public List<Photographer> getPhotographerByType(String type) throws DataAccessException {
        try{
            return locationDao.getPhotographerByType(type);
        }catch(Exception ex){
            log.info(ex.getMessage());
            throw new DataAccessException("Failed the fetch data!!");
        }
    }
}
