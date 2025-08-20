package com.vwdigitalhub.tango.application.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class TangoIntegrationTest {

    @Test
    void testOneRobotExecution() {
        TangoService service = new TangoService(10, 10);
        service.addRobot(1, 2, 'N', "LMLMLMLMM");
        List<String> results = service.executeAllRobots();
        assertThat(results.size()).isEqualTo(1);
        assertThat(results.get(0)).isEqualTo("1 3 N");
    }

    @Test
    void testTwoRobotsExecution() {
        TangoService service = new TangoService(5, 5);
        service.addRobot(1, 2, 'N', "LMLMLMLMM");
        service.addRobot(3, 3, 'E', "MMRMMRMRRM");
        List<String> results = service.executeAllRobots();
        assertThat(results.size()).isEqualTo(2);
        assertThat(results.get(0)).isEqualTo("1 3 N");
        assertThat(results.get(1)).isEqualTo("5 1 E");
    }

    @Test
    void testThreeRobotsExecution() {
        TangoService service = new TangoService(50, 50);
        service.addRobot(1, 2, 'N', "LMLMLMLMM");
        service.addRobot(3, 3, 'E', "MMRMMRMRRM");
        service.addRobot(10, 10, 'E', "MMRRMMLLMMLRLRM");
        List<String> results = service.executeAllRobots();
        assertThat(results.size()).isEqualTo(3);
        assertThat(results.get(0)).isEqualTo("1 3 N");
        assertThat(results.get(1)).isEqualTo("5 1 E");
        assertThat(results.get(2)).isEqualTo("13 10 E");
    }
}
