package com.serheev.service;

import com.serheev.model.Pet;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class PetRequestTest {
    private static org.apache.log4j.Logger log = Logger.getLogger(PetRequestTest.class);
    private static PetRequest request;
    private static Pet cat;

    @Before
    public void SetUp() {
        request = new PetRequest();
        cat = new Pet(10001, "Tom", 0, "Cats", "Available");
    }

    @After
    public void clearAfterTest() throws IOException {
        try {
            log.info("@After DELETE: Code=" + request.doDelete(10001));
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void petShouldBeReceived() throws IOException {
        try {
            assertEquals(404, request.doGet(10001));
            assertEquals(200, request.doPost(cat));
            assertEquals(200, request.doGet(10001));
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void petShouldBeAdd() throws IOException {
        try {
            assertEquals(404, request.doGet(10001));
            assertEquals(200, request.doPost(cat));
            assertEquals(200, request.doGet(10001));
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void petNameShouldBeUpdate() throws IOException {
        try {
            assertEquals(200, request.doPost(cat));
            cat.setName("Jerry");
            cat.setCategory_name("Mice");
            assertEquals(200, request.doPut(cat));
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void petShouldBeDelete() throws IOException {
        try {
            assertEquals(200, request.doPost(cat));
            assertEquals(200, request.doDelete(10001));
            assertEquals(404, request.doGet(10001));
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void errorStatusCodeShouldBeReceived() {
        try {
            assertEquals(404, request.doGet(10001));
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                request.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

}