package Punto1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Crear EntityManagerFactory con la unidad de persistencia definida en persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Crear objetos
            Medico medico = new Medico();
            medico.setMatricula(12345);
            medico.setCelular(381456789);

            Especialidad especialidad = new Especialidad();
            especialidad.setDenominacion("Cardiología");

            Turno turno = new Turno();
            turno.setFecha(new Date(2025,9,8));
            turno.setHora(13);

            // Relacionar
            medico.addEspecialidad(especialidad);
            medico.addTurno(turno);


            em.persist(medico);

            em.getTransaction().commit();

            System.out.println("✅ Instancia persistida correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
