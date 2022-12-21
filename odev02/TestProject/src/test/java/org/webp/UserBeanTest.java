package org.webp.intro.jee.ejb.stateless;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class UserBeanTest {


    @Test
    public void testBeanAsRegularJava(){

        UserBean bean = new UserBean();
        assertThrows(NullPointerException.class, () -> bean.registerNewUser("x","y","z"));
    }

}