package com.excel.studio.controller;

import com.excel.studio.model.Photographer;
import com.excel.studio.service.PhotographerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(PhotographController.class)
public class PhotographerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhotographerService photographerService;

    @Test
    public void testGetAllPhotographers() throws Exception {
        List<Photographer> photographers = new ArrayList<>();
        Photographer p1 = new Photographer();
        p1.setId("1");
        photographers.add(p1);
        when(photographerService.getAllPhotographers()).thenReturn(photographers);
        this.mockMvc.perform(get("/photographers").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk()) ;
    }

    @Test
    public void testGetPhotographerById() throws Exception {
        Photographer p1 = new Photographer();
        p1.setId("1");
        when(photographerService.getPhotographerById("1")).thenReturn(Optional.of(p1));
        this.mockMvc.perform(get("/photographer/1").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk()) ;
    }

    @Test
    public void testGetPhotographerByEvent() throws Exception {
        List<Photographer> photographers = new ArrayList<>();
        Photographer p1 = new Photographer();
        p1.setId("1");
        photographers.add(p1);
        when(photographerService.getPhotographerByType("wedding")).thenReturn(photographers);
        this.mockMvc.perform(get("/photographers/event/wedding").contentType(MediaType.APPLICATION_JSON)).andDo(print())
                .andExpect(status().isOk()) ;
    }
}
