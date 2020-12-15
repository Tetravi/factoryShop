package trspo.factoryproject.services;

import trspo.factoryproject.services.model.Vehicle;
import trspo.factoryproject.services.model.Worker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface FirmService {

    //void addWorker(String name, String job, int salary);
    public void addWorker(Worker worker);

    public List<Worker> getAll();

    public Worker getById(UUID id);

    public void deleteById(UUID id);

    void cashOperations(Vehicle vehicle);
}
;