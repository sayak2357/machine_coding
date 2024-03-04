package org.example.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Commands {
    CREATE("create_parking_lot_of_size"),
    PARK("park"),
    SHOW("show"),
    EXIT("exit"),
    FIND_CAR("slot_number_for_registration_number"),
    FIND_CARS_OF_COLOR("slot_numbers_of_cars_with_color"),

    FREE("free");

    private static final Map<String,Commands> ENUM_MAP;

    public final String value;
    Commands(String val){
        this.value = val;
    }
    public String getValue(){
        return this.value;
    }
    static {
        Map<String,Commands> map = new HashMap<String, Commands>();
        for (Commands instance : Commands.values()) {
            map.put(instance.getValue().toLowerCase(),instance);
        }
        ENUM_MAP = map;
    }

    public static Commands get (String value) {
        return ENUM_MAP.get(value.toLowerCase());
    }

}
