package com.example.BattleResolver.data;

import lombok.Data;

import java.util.List;

@Data
public class Army {
    private List<Leader> leaders; //armies can have many generals within
    private List<Unit> units; //well, obviously!
}
