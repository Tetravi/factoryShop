package trspo.factoryproject.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trspo.factoryproject.services.DeliveryService;
import trspo.factoryproject.services.impl.DeliveryServiceImpl;
import trspo.factoryproject.services.model.Order;
import trspo.factoryproject.services.model.Vehicle;
import trspo.factoryproject.services.model.Weight;
import trspo.factoryproject.services.model.dto.OrdersDTO;
import trspo.factoryproject.services.model.dto.createVehicleDTO;
import trspo.factoryproject.services.model.dto.setVehicleDTO;
import trspo.factoryproject.services.model.dto.setWeightDTO;

import java.util.UUID;

@RestController
@RequestMapping("/delivery")
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryController {
    @Autowired
    DeliveryServiceImpl deliveryService;

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return deliveryService.addVehicle(vehicle);
    }

    /*@PostMapping(path="/crVehicle")
    public ResponseEntity<Void> createVehicle(@RequestBody createVehicleDTO vehicleDto){
        Vehicle vehicle = new Vehicle(vehicleDto.getDriver(), vehicleDto.getNumber(),
                vehicleDto.getMaxWeight());
        vehicle.setId();
        deliveryService.addVehicle(vehicle);
        return ResponseEntity.ok().build();
    }*/

    /*@GetMapping(path="/getAll")
    public List<Vehicle> index() { return deliveryService.getAll(); }*/

    /*@GetMapping("{vehicleId}")
    public Vehicle getById(@PathVariable(value = "vehicleId") UUID id) {
        return deliveryService.getById(id);
    }*/

    @DeleteMapping("{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable(value = "vehicleId") UUID id) {
        deliveryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path="/setVehicle")
    public void setVehicle(@RequestBody setVehicleDTO setVehicleDTO) {
        Vehicle vehicle = setVehicleDTO.getVehicle();
        Order order = setVehicleDTO.getOrder();
        UUID order_id = order.getId();
        UUID vehicle_id = vehicle.getId();
        deliveryService.setVehicle(vehicle_id, order_id);
    }

    @PostMapping(path="/setWeight")
    public void setWeight(@RequestBody setWeightDTO setWeightDTO) {
        Weight weight = setWeightDTO.getWeight();
        Order order = setWeightDTO.getOrder();
        UUID weight_id = weight.getId();
        UUID order_id = order.getId();
        deliveryService.setWeight(weight_id, order_id);
        //System.out.println(weight_id);
        //System.out.println(order_id);
    }
}
