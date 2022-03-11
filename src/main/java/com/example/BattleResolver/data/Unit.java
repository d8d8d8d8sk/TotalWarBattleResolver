package com.example.BattleResolver.data;

import lombok.Data;

@Data
public class Unit {
    private String unitType; // Hastati
    private Integer numOfTroops; // 120
    private Integer meleeBaseAtt; //how strong is their base melee attack
    private Integer rangeBaseAtt; //how strong range attack
    private Integer defBase; //base def level
    private Float attEquipModifier; //by what percent should we modify this units att bonuses
    private Float defEquipModifier;
    private Float experience; //the more experienced you are, the less likely youll rout
}
