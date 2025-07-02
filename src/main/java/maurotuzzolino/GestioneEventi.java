package maurotuzzolino;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import maurotuzzolino.dao.EventoDAO;

public class GestioneEventi {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);
        System.out.println("HEllo");

        em.close();
        emf.close();
    }
}
