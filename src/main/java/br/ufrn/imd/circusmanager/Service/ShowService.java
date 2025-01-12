package br.ufrn.imd.circusmanager.Service;

import br.ufrn.imd.circusmanager.Dao.ShowDAO;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Circus.Show;

import java.util.List;

/**
 * The type Show service.
 */
public class ShowService {
    /**
     * The Show dao.
     */
    ShowDAO showDAO;

    /**
     * Instantiates a new Show service.
     */
    public ShowService() {
        this.showDAO = new ShowDAO();
    }

    /**
     * Add show.
     *
     * @param circo the circo
     * @param show  the show
     */
    public void addShow(Circo circo, Show show) {
        show.setCirco(circo);
        showDAO.salvar(show);
    }

    /**
     * Listar show list.
     *
     * @param circo the circo
     * @return the list
     */
    public List<Show> listarShow(Circo circo) {
        return showDAO.buscarTodos(circo);
    }
}
