package com.slotmachine.slot_machine.controller;

import com.slotmachine.slot_machine.controller.dtos.SlotMachineDTO;
import com.slotmachine.slot_machine.service.SlotMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sortittion")
public class SlotMachineController {

    @Autowired
    private SlotMachineService slotMachineService;
    private final SlotMachineDTO[] slotMachine = SlotMachineDTO.values();

    @GetMapping
    public ResponseEntity<?> displaySlotMachine() {
        return ResponseEntity.ok(slotMachineService.displaySlotMachine(slotMachine));
    }
}
