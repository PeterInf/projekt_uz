package edu.projectuz;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Kacper Wolkowski
 *
 *
 *  Tutaj mozna sprawdzic czy wszystko sie dobrze laczy z baza.
 *  Username, password i nazwa bazy sa ustawiane jako wartosci w pliku src/main/java/resources/META-INF/Persistence.xml
 */
public class HibernateTest {
    public static void main(String[] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.close();
        entityManagerFactory.close();
    }

}
