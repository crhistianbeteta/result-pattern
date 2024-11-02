package org.cr.result;

import java.util.*;

import static org.cr.result.Skills.LEVITATION;
import static org.cr.result.Skills.SEE_THE_FUTURE;

public class SortingHat {

    Set<Skills> validSkills = new HashSet<Skills>(Arrays.asList(LEVITATION,SEE_THE_FUTURE));

    public Result<HogwartsStudent> assignHouse(Person person){

        if(!person.getAbilities().stream().anyMatch(validSkills::contains)){
            return Result.error(person + " doesn't have magic skills");
        }

        HogwartsStudent hogwartsStudent = HogwartsStudent.fromPerson(person);
        hogwartsStudent.setHouse(getRandomHouse());
        return Result.success(hogwartsStudent);
    }

    private  House getRandomHouse() {
        House[] houses = House.values();
        int randomIndex = new Random().nextInt(houses.length);
        return houses[randomIndex];
    }


}
