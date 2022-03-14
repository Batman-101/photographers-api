package com.excel.studio.dao;

import com.excel.studio.exception.DataAccessException;
import com.excel.studio.model.Photographer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class PhotographersDaoTests {

    @MockBean
    private PhotographerDao photographerDao;

    @Test
    public void testGetAllPhotographers() throws DataAccessException {
        List<Photographer> locations = new ArrayList<>();
        Photographer photographer = new Photographer();
        photographer.setId("1");
        locations.add(photographer);
        when(photographerDao.getAllPhotographers()).thenReturn(locations);
        List<Photographer> returnedList = photographerDao.getAllPhotographers();
        assert(returnedList.get(0).getId().equalsIgnoreCase("1"));
    }

    @Test
    public void testGetPhotographersById() throws DataAccessException {
        Photographer photographer = new Photographer();
        photographer.setId("1");
        when(photographerDao.getPhotographerById("1")).thenReturn(Optional.of(photographer));
        Optional<Photographer> returnedList = photographerDao.getPhotographerById("1");
        assert(returnedList.get().getId().equalsIgnoreCase("1"));
    }

    @Test
    public void testGetAllPhotographersByEvent() throws DataAccessException {
        List<Photographer> locations = new ArrayList<>();
        Photographer photographer = new Photographer();
        photographer.setId("1");
        locations.add(photographer);
        when(photographerDao.getPhotographerByType("wedding")).thenReturn(locations);
        List<Photographer> returnedList = photographerDao.getPhotographerByType("wedding");
        assert(returnedList.get(0).getId().equalsIgnoreCase("1"));
    }
}
