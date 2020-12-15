package trspo.factoryproject.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trspo.factoryproject.repo.VehicleRepository;
import trspo.factoryproject.services.FirmService;
import trspo.factoryproject.services.impl.FirmServiceImpl;
import trspo.factoryproject.services.model.Vehicle;
import trspo.factoryproject.services.model.Worker;
import trspo.factoryproject.services.model.dto.createVehicleDTO;
import trspo.factoryproject.services.model.dto.createWorkerDTO;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/firm")
@AllArgsConstructor
@NoArgsConstructor
public class FirmController {
    @Autowired
    FirmServiceImpl firmService;
    @Autowired
    VehicleRepository vehicleRepository;

    @PostMapping
    public void createWorker(@RequestBody Worker worker) {
        firmService.addWorker(worker);
    }

    /*@GetMapping(path="/getAll")
    public List<Worker> index() { return firmService.getAll(); }

    @GetMapping("{workerId}")
    public Worker getById(@PathVariable(value = "workerId") UUID id) {
        return firmService.getById(id);
    }*/

    /*@PostMapping(path="/crWorker")
    public ResponseEntity<Void> createWorker(@RequestBody createWorkerDTO workerDto){
        Worker worker = new Worker(workerDto.getName(), workerDto.getJob(), workerDto.getSalary());
        worker.setId();
        firmService.addWorker(worker);
        return ResponseEntity.ok().build();
    }*/

    @DeleteMapping("{workerId}")
    public ResponseEntity<Void> deleteWorker(@PathVariable(value = "workerId") UUID id) {
        firmService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(path="/giveCash")
    public void giveCash(@RequestBody createVehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.getOne(vehicleDTO.getId());
        firmService.cashOperations(vehicle);
    }
}
