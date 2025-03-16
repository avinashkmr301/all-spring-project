package org.avi.plurahsight;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.avi.plurahsight.airport.Passenger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Passenger john = new Passenger(1, "John Smith", "A-17, Block-A, Noida-sector-92");
        em.persist(john);

        em.getTransaction().commit();
        emf.close();
    }
}
