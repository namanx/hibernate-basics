package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    
	public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project has started ..." );
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        
        
        // creating Student
       Student st = new Student();
       st.setId(109);
       st.setName("Divya");
       st.setCity("Indore");
       System.out.println(st);
       
       
       // creating object of Address Class
       Address add = new Address();
       add.setStreet("Airport Road");
       add.setCity("Pune");
       add.setOpen(true);
       add.setAddedDate(new Date());
       add.setX(10.0);
       
       
       // Reading Image
      
       FileInputStream fis = new FileInputStream("src/main/java/download.jpeg");
       byte[] data = new byte[fis.available()];
       fis.read(data);
       add.setImage(data);
       fis.close();
       org.hibernate.Session session =factory.openSession();
       org.hibernate.Transaction tx =session.beginTransaction();
       session.persist(st);
       session.persist(add);
       tx.commit();
       session.close();
       System.out.println("Transaction is Complete !");
}
}
