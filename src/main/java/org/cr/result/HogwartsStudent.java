package org.cr.result;

import java.util.Set;

public class HogwartsStudent extends Person{

    private House house;

    public HogwartsStudent(String name, String surname, Set<Skills> skills){
        super(name,surname,skills);
    }

    public static HogwartsStudent fromPerson(Person p){
        return new HogwartsStudent(p.getName(),p.getSurname(),p.getAbilities());
    }
    public House getHouse() {
        return house;
    }

    public void setHouse(House house){
        this.house = house;
    }

    @Override
    public String toString() {
        return String.format("%s House: %s",super.toString(),house);
    }
}
