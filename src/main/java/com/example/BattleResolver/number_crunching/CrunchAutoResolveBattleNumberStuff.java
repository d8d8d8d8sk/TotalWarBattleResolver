package com.example.BattleResolver.number_crunching;

import com.example.BattleResolver.data.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrunchAutoResolveBattleNumberStuff {
    public BattleResult battleResult(List<Faction> attackers, List<Faction> defenders){
        //ok so lets just convert all of the attacking units into one big score
        //likewise for defenders
        //and return whoever has the bigger score
        //could add some random numbers in here too but non-determinism?? y??
        Integer attackersScore = armiesToScore(factionsToArmies(attackers));
        Integer defendersScore = armiesToScore(factionsToArmies(defenders));
        if (attackersScore > defendersScore){
            return buildBattleResult(attackers, defenders);
        }
        //defenders win in a tie or etc
        return buildBattleResult(defenders, attackers);
    }

    public List<String> factionsToNames(List<Faction> factions){
        List<String> result = new ArrayList<>();
        for (Faction f : factions){
            result.add(f.getName());
        }
        return result;
    }

    public BattleResult buildBattleResult(List<Faction> winner, List<Faction> loser){
        BattleResult br = new BattleResult();
        br.setWinnerNames(factionsToNames(winner));
        br.setLoserNames(factionsToNames(loser));
        br.setBattleResultDescription("Heroic Victory");
        //TODO: lazy
        br.setHowManyPeopleDidTheAttackerKill(0);
        br.setHowManyPeopleDidTheAttackerLose(0);
        br.setHowManyPeopleDidTheDefenderKill(0);
        br.setHowManyPeopleDidTheDefenderLose(0);
        return br;
    }

    public List<Army> factionsToArmies(List<Faction> factions){
        List<Army> result = new ArrayList<>();
        for (Faction f : factions){
            result.addAll(f.getArmies());
        }
        return result;
    }

    public Integer armiesToScore(List<Army> armies){
        int sum = 0;
        for (Army a : armies){
            sum += armyToScore(a);
        }
        return sum;
    }

    public Integer armyToScore(Army a){
        int sum = 0;
        sum += unitsToScore(a.getUnits());
        for (Leader l : a.getLeaders()){
            sum *= l.getEloq();
            sum *= l.getMilitaryBonus();
        }
        return sum;
    }

    public Integer unitToScore(Unit u){
        var sum = 0;
        sum += u.getMeleeBaseAtt();
        sum += u.getRangeBaseAtt();
        sum += u.getDefBase();
        sum *= u.getAttEquipModifier();
        sum *= u.getDefEquipModifier();
        sum *= u.getExperience();
        sum *= u.getNumOfTroops();
        return sum;
    }

    public Integer unitsToScore(List<Unit> units){
        var sum = 0;
        for (Unit u : units){
            sum += unitToScore(u);
        }
        return sum;
    }
}
