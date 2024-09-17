package com.slotmachine.slot_machine.service;
import com.slotmachine.slot_machine.controller.dtos.SlotMachineDTO;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SlotMachineService {

    public List<SlotMachineDTO> convertArrayToList(SlotMachineDTO[] slotMachineDTO) {
        return Arrays.asList(slotMachineDTO);
    }

    public List<SlotMachineDTO> sortValues(SlotMachineDTO[] slotMachine) {
        Random random = new Random();
        List<SlotMachineDTO> sortSlotMachineToList = IntStream.range(0, slotMachine.length)
                .mapToObj(index -> slotMachine[random.nextInt(slotMachine.length)])
                .peek(slot -> System.out.println(slot.getName()))
                .collect(Collectors.toList());
//        sortSlotMachineToList.forEach(slot -> System.out.println(slot.getName()));
        return sortSlotMachineToList;
    }
}



