package com.example.BattleResolver.data;

import lombok.Data;

import java.util.List;

@Data
public class Faction {
    private String name; //"Carthage"
    private List<Army> armies;
}
