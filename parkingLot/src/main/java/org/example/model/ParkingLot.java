package org.example.model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static Integer size;
    private static Map<Integer, Car> slotCarMap;

    private static ParkingLot INSTANCE = null;

    public static Map<Integer, Car> getSlotCarMap() {
        return slotCarMap;
    }

    public static void setSlotCarMap(Map<Integer, Car> slotCarMap) {
        ParkingLot.slotCarMap = slotCarMap;
    }

    public static Integer getSize() {
        return size;
    }

    public static ParkingLot getInstance(Integer capacity){
        size = capacity;
        slotCarMap = new HashMap<>();
        if(INSTANCE==null)
            INSTANCE = new ParkingLot();
        return INSTANCE;
    }
    public Integer putCar(Car car){
        Integer freeSpace = getFreeSpace();
        if(freeSpace==0)
            return -1;
        slotCarMap.put(freeSpace,car);
        return freeSpace;
    }
    private Integer getFreeSpace(){
        for(int i=1;i<=size;i++){
            if(!slotCarMap.containsKey(i))
                return i;
        }
        return -1;
    }
}
