package maurotuzzolino.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import maurotuzzolino.entities.Evento;

public class EventoDAO {

    private EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(evento);
        transaction.commit();

        System.out.println("L'evento " + evento.getTitolo() + " è stato aggiunto correttamente.");
    }

    public Evento getById(long id) {
        return entityManager.find(Evento.class, id);
    }

    public void delete(Evento evento) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(evento);
        transaction.commit();

        System.out.println("L'evento " + evento.getTitolo() + " è stato eliminato correttamente.");
    }
}
