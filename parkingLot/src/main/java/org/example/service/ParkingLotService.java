package org.example.service;

import org.example.model.Car;
import org.example.model.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParkingLotService {
    private ParkingLot parkingLot;

    public ParkingLotService(Integer size){
        ParkingLot newParkingLot = ParkingLot.getInstance(size);
        this.parkingLot = newParkingLot;
    }
    public void parkCar(String registrationNumber, String color){
        Car car = new Car(registrationNumber,color);
        Integer slot = parkingLot.putCar(car);
        if(slot == -1)
            System.out.println("no slot available in the parking lot");
        else
            System.out.println(registrationNumber+" is put in slot number "+slot);
    }
    public void findSlotsOfCarWithColor(String color){
        Map<Integer, Car> slotCarMap = parkingLot.getSlotCarMap();
        List<Integer> res = new ArrayList<>();
        for(Integer slot:slotCarMap.keySet())
        {
            Car currCar = slotCarMap.get(slot);
            if(currCar.getColor().equals(color))
                res.add(slot);
        }
        System.out.println(res);
    }
    public void findSlotNumberOfCarWithRegistrationNumber(String registrationNumber){
        Map<Integer, Car> slotCarMap = parkingLot.getSlotCarMap();

        for(Integer slot:slotCarMap.keySet())
        {
            Car currCar = slotCarMap.get(slot);
            if(currCar.getResgistrationNumber().equals(registrationNumber)) {
                System.out.println("car with registration number "+registrationNumber+" is present in slot "+slot);
                return;
            }
        }
        System.out.println("car with registrtion number "+registrationNumber+" is not present");
    }
    public void show(){
        Map<Integer, Car> slotCarMap = parkingLot.getSlotCarMap();
        for(Integer slot:slotCarMap.keySet()){
            System.out.println(slot+" "+slotCarMap.get(slot).getResgistrationNumber()+" "+slotCarMap.get(slot).getColor());
        }
    }
    public void free(Integer slot){
        Map<Integer, Car> slotCarMap = parkingLot.getSlotCarMap();
        Integer size = parkingLot.getSize();
        if(slot<=0 || slot>size)
            System.out.println("invalid slot number");
        else if(!slotCarMap.containsKey(slot))
            System.out.println("slot "+slot+" is already empty");
        else{
            Car car = slotCarMap.get(slot);
            slotCarMap.remove(slot);
            parkingLot.setSlotCarMap(slotCarMap);
            System.out.println("car "+car.getResgistrationNumber()+" removed from slot "+slot);
        }
    }
}
