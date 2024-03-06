package org.example;

import org.example.service.ParkingLotService;
import org.example.model.Commands;

import java.util.Scanner;

import static org.example.model.Commands.EXIT;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //System.out.println("Hello world!");
        ParkingLotService parkingLotService = null;
        String color,registrationNumber;
        while(true){
            String ip = sc.nextLine();
            String[] arr = ip.split(" ");
            String op = arr[0];
            Commands com = Commands.get(op);
            switch (com) {
                case EXIT:
                    return;
                case CREATE:
                    Integer size = Integer.parseInt(arr[1]);
                    if (parkingLotService != null) {
                        System.out.println("parking lot is already instantiated");
                    } else {
                        parkingLotService = new ParkingLotService(size);
                    }
                    break;
                case PARK:
                    registrationNumber = arr[1];
                    color = arr[2];
                    parkingLotService.parkCar(registrationNumber, color);
                    break;
                case FREE:
                    Integer slotToBeFreed = Integer.parseInt(arr[1]);
                    parkingLotService.free(slotToBeFreed);
                    break;
                case SHOW:
                    parkingLotService.show();
                    break;
                case FIND_CAR:
                    registrationNumber = arr[1];
                    parkingLotService.findSlotNumberOfCarWithRegistrationNumber(registrationNumber);
                    break;
                case FIND_CARS_OF_COLOR:
                    color = arr[1];
                    parkingLotService.findSlotsOfCarWithColor(color);
                    break;
                case INVALID:
                    System.out.println("please enter valid command");
                    break;
                }
            }
        }
    }
