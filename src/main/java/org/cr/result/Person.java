package org.cr.result;

import java.util.Set;

public class Person {

    protected String name;
    protected String surname;
    protected Set<Skills> abilities;


    public Person(String name,String surname,Set<Skills> abilities){

        if(name == null || name.isEmpty()){
            throw new RuntimeException("Name must be present");
        }

        if(surname == null || surname.isEmpty()){
            throw new RuntimeException("Surname must be present");
        }


        this.name= name;
        this.surname = surname;
        this.abilities = abilities;
    }

    public String getName() {
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public Set<Skills> getAbilities() {
        return abilities;
    }

    @Override
    public String toString() {
        return String.format("%s %s",name,surname);
    }
}
