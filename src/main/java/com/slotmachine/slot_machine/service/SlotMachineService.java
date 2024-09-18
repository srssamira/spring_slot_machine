package com.slotmachine.slot_machine.service;

import com.slotmachine.slot_machine.controller.dtos.SlotMachineDTO;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SlotMachineService {

    public List<SlotMachineDTO> sortValues(SlotMachineDTO[] slotMachine) {
        Random random = new Random();
        List<SlotMachineDTO> sortSlotMachineToList = IntStream.range(0, slotMachine.length)
                .mapToObj(index -> slotMachine[random.nextInt(slotMachine.length)])
                .collect(Collectors.toList());

//        sortSlotMachineToList.forEach(slot -> System.out.println(slot.getName()));
        return sortSlotMachineToList;
    }

    public boolean addBonus(List<SlotMachineDTO> slotMachineList) {
        if (slotMachineList.get(0).getName().equalsIgnoreCase(slotMachineList.get(1).getName())
        && slotMachineList.get(1).getName().equalsIgnoreCase(slotMachineList.get(2).getName())) {
            return true;
        }
        else return false;
    }

    public int sumScore(List<SlotMachineDTO> slotMachineList) {
        return slotMachineList.stream().mapToInt(slot -> slot.getScore()).sum();
    }

    public Map<String, String> displaySlotMachine(SlotMachineDTO[] slotMachine) {
        List<SlotMachineDTO> slotMachineList = sortValues(slotMachine);
        Map<String, String> slotMachineMap = new HashMap<>();

        int totalPoints = 0;
        if (addBonus(slotMachineList))
            totalPoints = sumScore(slotMachineList) * 100;
        else totalPoints = sumScore(slotMachineList);

        String totalPointsToString = Integer.toString(totalPoints);
        slotMachineMap.put("firstSymbol ", slotMachineList.get(0).getName());
        slotMachineMap.put("secondSymbol ", slotMachineList.get(1).getName());
        slotMachineMap.put("thirdSymbol ", slotMachineList.get(2).getName());
        slotMachineMap.put("totalPoints", totalPointsToString);

        return slotMachineMap;
    }
}



