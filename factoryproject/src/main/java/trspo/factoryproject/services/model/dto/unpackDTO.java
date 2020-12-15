package trspo.factoryproject.services.model.dto;

import trspo.factoryproject.services.model.Vehicle;

public class unpackDTO {
    private Vehicle vehicle;

    public unpackDTO(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
