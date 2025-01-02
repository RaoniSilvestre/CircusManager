package br.ufrn.imd.circusmanager.Dao;

import java.util.ArrayList;

import br.ufrn.imd.circusmanager.Model.Circus.Show;

public class ShowDAO {
    private ArrayList<Show> shows;

    public ShowDAO() {
        shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
    }
    
    public ArrayList<Show> getShows() {
        return shows;
    }
}
