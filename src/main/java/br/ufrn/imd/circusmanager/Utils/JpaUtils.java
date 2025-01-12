package br.ufrn.imd.circusmanager.Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The type Jpa utils.
 */
public class JpaUtils {

    private static final EntityManagerFactory emf;

    // Inicializa o EntityManagerFactory apenas uma vez
    static {
        try {
            emf = Persistence.createEntityManagerFactory("circus-manager-pu");
        } catch (Throwable ex) {
            System.err.println("Falha ao inicializar o EntityManagerFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Gets entity manager.
     *
     * @return the entity manager
     */
// Retorna um novo EntityManager
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Close.
     */
// Fecha o EntityManagerFactory ao encerrar a aplicação
    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}