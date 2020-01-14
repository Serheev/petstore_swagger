package com.serheev.service;

import com.serheev.model.Order;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class StoreRequestServiceTest {
    private static Logger log = Logger.getLogger(StoreRequestServiceTest.class);
    private static StoreRequestService request;
    private static Order order;

    @Before
    public void setUp() {
        request = new StoreRequestService();
        order = new Order(10001, 1, 10, "placed", true);
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
    public void orderShouldBeReceived() {
        try {
            assertEquals(404, request.doGet(10001));
            assertEquals(200, request.doPost(order));
            assertEquals(200, request.doGet(10001));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void orderShouldBeAdd() {
        try {
            assertEquals(404, request.doGet(10001));
            assertEquals(200, request.doPost(order));
            assertEquals(200, request.doGet(10001));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void orderStatusShouldBeUpdate() {
        try {
            assertEquals(200, request.doPost(order));
            order.setStatus("received");
            order.setQuantity(12);
            assertEquals(200, request.doPost(order));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void petShouldBeDelete() {
        try {
            assertEquals(200, request.doPost(order));
            assertEquals(200, request.doDelete(10001));
            assertEquals(404, request.doGet(10001));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Test
    public void errorStatusCodeShouldBeReceived() {
        try {
            assertEquals(404, request.doGet(10001));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}