package trspo.factoryproject.services;

import trspo.factoryproject.services.model.Vehicle;
import trspo.factoryproject.services.model.Weight;

import java.util.List;
import java.util.UUID;

public interface WeightService {
    //void addWeight(Worker loader, Worker worker);
    public void addWeight(Weight weight);

    public List<Weight> getAll();

    public Weight getById(UUID id);

    public void deleteById(UUID id);

    public void unpackWeight(UUID vehicle);
}
