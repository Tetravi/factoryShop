package trspo.factoryproject.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trspo.factoryproject.repo.VehicleRepository;
import trspo.factoryproject.services.impl.WeightServiceImpl;
import trspo.factoryproject.services.model.Vehicle;
import trspo.factoryproject.services.model.Weight;
import trspo.factoryproject.services.model.dto.createVehicleDTO;
import trspo.factoryproject.services.model.dto.createWeightDTO;
import trspo.factoryproject.services.model.dto.unpackDTO;

import java.util.UUID;

@RestController
@RequestMapping("/weight")
@AllArgsConstructor
@NoArgsConstructor
public class WeightController {
    @Autowired
    WeightServiceImpl weightService;
    @Autowired
    VehicleRepository vehicleRepository;

    @PostMapping
    public void createWeight(@RequestBody Weight weight) {
        weightService.addWeight(weight);
    }

    /*@GetMapping(path="/getAll")
    public List<Weight> index() { return weightService.getAll(); }

    @GetMapping("{weightId}")
    public Weight getById(@PathVariable(value = "weightId") UUID id) {
        return weightService.getById(id);
    }*/

    /*@PostMapping(path="/crWeight")
    public ResponseEntity<Void> createWeight(@RequestBody createWeightDTO weightDto){
        Weight weight = new Weight(weightDto.getWorker().getId());
        weight.setId();
        weightService.addWeight(weight);
        return ResponseEntity.ok().build();
    }*/

    @DeleteMapping("{weightId}")
    public ResponseEntity<Void> deleteWeight(@PathVariable(value = "weightId") UUID id) {
        weightService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path="/unpack")
    public void unpack(@RequestBody unpackDTO vehicleDTO) {

        Vehicle vehicle = vehicleDTO.getVehicle();
        UUID vehicle_id = vehicle.getId();
        //System.out.println(vehicle_id);
        weightService.unpackWeight(vehicle_id);
    }
}
