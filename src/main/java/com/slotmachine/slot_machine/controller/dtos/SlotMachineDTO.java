package com.slotmachine.slot_machine.controller.dtos;

public enum SlotMachineDTO {
    BANANA("BANANA", 10),
    STRAWBERRY("STRAWBERRY", 20),
    STAR("STAR", 40);

    private String name;
    private int score;

    SlotMachineDTO(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "SlotMachineDTO {" +
                "name = '" + name + '\'' +
                ", score = " + score +
                '}';
    }
}
