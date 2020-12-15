package trspo.factoryproject.services.model.dto;

import trspo.factoryproject.services.model.Status;
import trspo.factoryproject.services.model.Worker;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class createWeightDTO {
    @Id
    @GeneratedValue
    private UUID id;
    private Worker worker;
    private Status status;

    public createWeightDTO(Worker worker) {
        this.worker = worker;
        this.status = Status.DELIVERING;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
