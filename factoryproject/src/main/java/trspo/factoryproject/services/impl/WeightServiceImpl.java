package trspo.factoryproject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trspo.factoryproject.repo.VehicleRepository;
import trspo.factoryproject.repo.WeightRepository;
import trspo.factoryproject.services.WeightService;
import trspo.factoryproject.services.model.Vehicle;
import trspo.factoryproject.services.model.Weight;

import java.util.List;
import java.util.UUID;

@Service
public class WeightServiceImpl implements WeightService {
    @Autowired
    private WeightRepository WeightRepository;
    private VehicleRepository VehicleRepository;

    @Transactional
    public void addWeight(Weight weight) {
       WeightRepository.save(weight);
   }

    public Weight getById(UUID id) {
        return WeightRepository.getOne(id);
    }

    public void deleteById(UUID id) {
        WeightRepository.deleteById(id);
    }

    /*public void unpackWeight(Vehicle vehicle){
        vehicle.setStatusFree();
        Weight weight = WeightRepository.findById(vehicle.getWeight()).get();
        weight.setStatusReceived();
    }*/
    public void unpackWeight(UUID vehicle1){
        for (Vehicle vehicle: VehicleRepository.findAll()){
            if (vehicle.getId() == vehicle1){
                vehicle.setStatusFree();
                Weight weight = WeightRepository.findById(vehicle.getWeight()).get();
                weight.setStatusReceived();
            }
        }
    }

   public List<Weight> getAll() {
        return WeightRepository.findAll();
    }
}
