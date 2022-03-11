package com.example.BattleResolver.data;

import lombok.Data;

import java.util.List;

@Data
public class BattleRequest {
    private List<Faction> attackers;
    private List<Faction> defenders;
}
