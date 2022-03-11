package com.example.BattleResolver.data;

import lombok.Data;

import java.util.List;

@Data
public class BattleResult {
    private String battleResultDescription; //"CLEAR DEFEAT" etc
    private List<String> winnerNames;
    private List<String> loserNames;
    //should probably do like, list of generals killed in action too, or generals promoted
    private Integer howManyPeopleDidTheAttackerKill;
    private Integer howManyPeopleDidTheAttackerLose;
    private Integer howManyPeopleDidTheDefenderKill;
    private Integer howManyPeopleDidTheDefenderLose;
}
