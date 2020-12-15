package trspo.factoryproject.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trspo.factoryproject.repo.OrderRepository;
import trspo.factoryproject.repo.WeightRepository;
import trspo.factoryproject.repo.WorkerRepository;
import trspo.factoryproject.services.FirmService;
import trspo.factoryproject.services.model.Order;
import trspo.factoryproject.services.model.Vehicle;
import trspo.factoryproject.services.model.Weight;
import trspo.factoryproject.services.model.Worker;

import java.util.List;
import java.util.UUID;

@Service
public class FirmServiceImpl implements FirmService {
    @Autowired
    private WorkerRepository WorkerRepository;
    private OrderRepository OrderRepository;
    private WeightRepository WeightRepository;

    @Transactional
    public void addWorker(Worker worker) {
        WorkerRepository.save(worker);
    }

    public List<Worker> getAll() {
        return WorkerRepository.findAll();
    }

    public Worker getById(UUID id) {
        return WorkerRepository.getOne(id);
    }

    public void deleteById(UUID id) {
        WorkerRepository.deleteById(id);
    }

    public void cashOperations(Vehicle vehicle){
        Weight weight = WeightRepository.findById(vehicle.getWeight()).get();
        Worker worker = WorkerRepository.findById(weight.getWorker()).get();
        Worker driver = WorkerRepository.findById(vehicle.getDriver()).get();
        Order order = OrderRepository.findById(vehicle.getOrder()).get();
        worker.giveSalary(order.getPrice() * 0.1);
        driver.giveSalary(order.getPrice() * 0.1);
    }
}
