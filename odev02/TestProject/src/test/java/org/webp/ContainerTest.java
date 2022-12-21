package org.webp.intro.jee.ejb.stateless;



import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import javax.ejb.EJBException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Arquillian.class)
public class ContainerTest {

    @Deployment
    public static JavaArchive createDeployment() {

        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(UserBean.class, User.class)
                .addAsResource("META-INF/persistence.xml");
    }


    @EJB
    private UserBean bean;

    @Test
    public void testWithEmbeddedContainer(){

        Long id = 3;

        assertFalse(bean.isRegistered(id));

        bean.registerNewUser(id,4,"x","y");

        assertTrue(bean.isRegistered(id));
    }

    @Test
    public void testQuery(){

        long k = bean.getNumberOfUsers();

        bean.registerNewUser(0,0,"a","b");
        bean.registerNewUser(1,1,"a","b");
        bean.registerNewUser(2,2,"a","b");

        long n = bean.getNumberOfUsers();
        assertEquals(k+3, n);
    }

    @Test
    public void testNullValue(){
        try{
            bean.registerNewUser(0,0, "a", null);
            fail();
        }catch (EJBException e){
        }

    }
}
