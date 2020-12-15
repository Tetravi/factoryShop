package trspo.factoryproject.services;

import trspo.factoryproject.services.model.Order;
import trspo.factoryproject.services.model.Vehicle;
import trspo.factoryproject.services.model.Weight;

import java.util.List;
import java.util.UUID;

public interface DeliveryService {
    /*void addVehicle(Worker driver, String number,
                           double maxWeight);*/
    Vehicle addVehicle(Vehicle vehicle);

    public List<Vehicle> getAll();

    public Vehicle getById(UUID id);

    public void deleteById(UUID id);

    void setVehicle(UUID vehicle1, UUID order);

    public void setWeight(UUID weight, UUID order);
}
