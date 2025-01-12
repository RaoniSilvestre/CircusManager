package br.ufrn.imd.circusmanager.Service;

import br.ufrn.imd.circusmanager.Dao.ShowDAO;
import br.ufrn.imd.circusmanager.Model.Circus.Circo;
import br.ufrn.imd.circusmanager.Model.Circus.Show;

import java.util.List;

public class ShowService {
    ShowDAO showDAO;

    public ShowService() {
        this.showDAO = new ShowDAO();
    }

    public void addShow(Circo circo, Show show) {
        show.setCirco(circo);
        showDAO.salvar(show);
    }

    public List<Show> listarShow(Circo circo) {
        return showDAO.buscarTodos(circo);
    }
}
