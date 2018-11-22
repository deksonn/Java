
package model;

import entiteti.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.QuerySyntaxException;

/**
 *
 * @author Dejan
 */

// metode za kreiranje sesije, cuvanje, vracanje i brisanje korisnika //

public class Model {
    
    static Session session = Model.kreirajSesiju();
    private static Session kreirajSesiju(){
        
        Configuration c = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
.applySettings(c.getProperties());
      SessionFactory f = c.buildSessionFactory(builder.build());
      return f.openSession();
    }
    
    public static User vratiUsera(String name, String password){
        Query q = session.createQuery("from User where name =  :u and password = :p");
        q.setParameter("u", name);
        q.setParameter("p", password);
        if(q.list().isEmpty()) return null;
        return (User)(q.list().get(0));

    }
    public static List<User> vratiSveUsere(){
        Query q=session.createQuery("from User");
        return q.list();
    }
    
    public static void saveUser(User novi){
        Session sesija = Util.getSession().openSession();
        sesija.beginTransaction();
        sesija.save(novi);
        sesija.getTransaction().commit();
        if(sesija.isOpen()){
            sesija.close();
        }
    }
    
    public static User getUserByName(String name){
        
         Query q = session.createQuery("from User where name =  :u");
         q.setParameter("u", name);
        if(q.list().isEmpty()) return null;
        return (User)(q.list().get(0));
        
    }
    
    
    public static void obrisiKorisnika(User u){
        Transaction tr = null;
        try{
            tr = session.beginTransaction();
            session.delete(u);
            tr.commit();
        } catch(HibernateException e){
            tr.rollback();
        }
    }
}
