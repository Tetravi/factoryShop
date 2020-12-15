package trspo.factoryproject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trspo.factoryproject.repo.VehicleRepository;
import trspo.factoryproject.services.DeliveryService;
import trspo.factoryproject.services.model.Order;
import trspo.factoryproject.services.model.Status;
import trspo.factoryproject.services.model.Vehicle;
import trspo.factoryproject.services.model.Weight;

import java.util.List;
import java.util.UUID;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private VehicleRepository VehicleRepository;

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        Vehicle savedVehicle = VehicleRepository.save(vehicle);
        return savedVehicle;
    }

    public List<Vehicle> getAll() {
        return VehicleRepository.findAll();
    }

    public Vehicle getById(UUID id) {
        return VehicleRepository.getOne(id);
    }

    public void deleteById(UUID id) {
        VehicleRepository.deleteById(id);
    }

    public void setVehicle(UUID vehicle1, UUID order){
        /*for (Vehicle vehicle : VehicleRepository.findAll()) {
            if (vehicle.getStatus() == Status.BUSY)
                System.out.println("Транспорт уже занят");
            else {
                System.out.println("Транспорт {" + vehicle.toString() + "} будет отправлен за заказом");
                vehicle.setStatusBusy();
                vehicle.setOrder(order);
                break;
            }
        }*/
        for (Vehicle vehicle: VehicleRepository.findAll()){
            if (vehicle.getId() == vehicle1){
                    vehicle.setOrder(order);
                    vehicle.setStatusBusy();}
        }
    }

    public void setWeight(UUID weight, UUID order){
        for (Vehicle vehicle: VehicleRepository.findAll()){
            if (vehicle.getStatus() == Status.BUSY
                    && vehicle.getOrder() == order)
                vehicle.setWeight(weight);
            }
    }

}
