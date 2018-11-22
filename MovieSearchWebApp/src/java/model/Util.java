/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Dejan
 */

// util potreban za upload fajlova i slika //

public class Util {
    
    private static SessionFactory sf = null;
    
    public static SessionFactory getSession(){
        if(sf==null){
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
            srb.applySettings(config.getProperties());
            ServiceRegistry servis = srb.build();
            sf= config.buildSessionFactory(servis);
        }
    return sf;
}
}
