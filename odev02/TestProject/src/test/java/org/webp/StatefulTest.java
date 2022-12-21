package org.webp.intro.jee.ejb.stateful;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.ejb.EJB;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class StatefulTest {
    @Deployment
    public static JavaArchive createDeployment() {

        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(BlogText.class, Stateless.class, UserBean.class, UserDetails.class, User.class, Stateful.class);
    }


    @EJB
    private User user;

    @Test
    public void testStateful(){

        user.increment();
        user.increment();
        user.increment();
        int expected = 3;

        assertEquals(expected, user.getStateful());
    }
}