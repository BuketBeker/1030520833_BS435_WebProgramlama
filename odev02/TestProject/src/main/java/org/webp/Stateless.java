package org.webp.intro.jee.ejb.stateless;


import javax.ejb.Stateless;

@Stateless
public class Stateless {

    public String getValue(){
        return "Stateless";
    }
}
