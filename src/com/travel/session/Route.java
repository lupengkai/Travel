package com.travel.session;

import com.travel.model.Scenery;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by tage on 8/31/16.
 */
public class Route {
    private List<Scenery> sceneries = new LinkedList<>();

    public List<Scenery> getSceneries() {
        return sceneries;
    }

    public void add(Scenery scenery) {
        sceneries.add(scenery);
    }

}
