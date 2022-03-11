package com.example.BattleResolver.controller;

import com.example.BattleResolver.data.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @PostMapping(value="/getNullBattleRequest")
    public BattleRequest getNullBattleRequest(){
        BattleRequest br = new BattleRequest();
        Faction f = new Faction();
        Army a = new Army();
        Unit u = new Unit();
        Leader l = new Leader();
        a.setLeaders(List.of(l));
        a.setUnits(List.of(u));
        f.setArmies(List.of(a));
        br.setAttackers(List.of(f));
        br.setDefenders(List.of(f));
        return br;
    }

    @PostMapping(value="/getSampleBattle")
    public BattleRequest getSampleBattle() throws JsonProcessingException {
        var battle = "{\n" +
                "    \"attackers\": [\n" +
                "        {\n" +
                "            \"name\": \"SPQR\",\n" +
                "            \"armies\": [\n" +
                "                {\n" +
                "                    \"leaders\": [\n" +
                "                        {\n" +
                "                            \"name\": \"Smackimus Maximus\",\n" +
                "                            \"eloq\": 1.1,\n" +
                "                            \"militaryBonus\": 1.1\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"units\": [\n" +
                "                        {\n" +
                "                            \"unitType\": \"Hastati\",\n" +
                "                            \"numOfTroops\": 120,\n" +
                "                            \"meleeBaseAtt\": 10,\n" +
                "                            \"rangeBaseAtt\": 7,\n" +
                "                            \"defBase\": 10,\n" +
                "                            \"attEquipModifier\": 1.1,\n" +
                "                            \"defEquipModifier\": 1.1,\n" +
                "                            \"experience\": 1.1\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ],\n" +
                "    \"defenders\": [\n" +
                "        {\n" +
                "            \"name\": \"Carthage\",\n" +
                "            \"armies\": [\n" +
                "                {\n" +
                "                    \"leaders\": [\n" +
                "                        {\n" +
                "                            \"name\": \"Hannibal\",\n" +
                "                            \"eloq\": 1.1,\n" +
                "                            \"militaryBonus\": 1.1\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"units\": [\n" +
                "                        {\n" +
                "                            \"unitType\": \"Elephants\",\n" +
                "                            \"numOfTroops\": 100,\n" +
                "                            \"meleeBaseAtt\": 15,\n" +
                "                            \"rangeBaseAtt\": 7,\n" +
                "                            \"defBase\": 6,\n" +
                "                            \"attEquipModifier\": 1.1,\n" +
                "                            \"defEquipModifier\": 1.1,\n" +
                "                            \"experience\": 1.1\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        return new ObjectMapper().readValue(battle, BattleRequest.class);
    }
}
