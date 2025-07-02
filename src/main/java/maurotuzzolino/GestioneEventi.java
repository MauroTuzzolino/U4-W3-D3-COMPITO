package maurotuzzolino;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import maurotuzzolino.dao.EventoDAO;
import maurotuzzolino.entities.Evento;
import maurotuzzolino.entities.TipoEvento;

import java.time.LocalDate;

public class GestioneEventi {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(em);

        Evento evento = new Evento(
                "Festa di compleanno",
                LocalDate.of(2025, 7, 15),
                "Compleanno a sorpresa",
                TipoEvento.PUBBLICO,
                50
        );

        eventoDAO.save(evento);

        Evento eventoTrovato = eventoDAO.getById(evento.getId());
        System.out.println("Evento trovato: " + eventoTrovato.getTitolo());

        eventoDAO.delete(eventoTrovato);

        em.close();
        emf.close();
    }
}
