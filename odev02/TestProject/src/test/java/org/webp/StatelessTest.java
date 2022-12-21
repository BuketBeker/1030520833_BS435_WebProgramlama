package org.webp.intro.jee.ejb.stateless;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StatelessTest {

    @Test
    public void testItWrong(){

        Stateless stateless = new Stateless();
        assertNotNull(stateless.getValue());
    }
}