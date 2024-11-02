package org.cr;

import org.cr.result.*;

import javax.rmi.PortableRemoteObject;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.cr.result.Skills.*;

public class Main {
    public static void main(String[] args) {
        Person harryPotter = new Person("Harry", "Potter", new HashSet(Arrays.asList(LEVITATION)));
        Person hermioneGranger = new Person("Hermione", "Granger", new HashSet(Arrays.asList(LEVITATION, SEE_THE_FUTURE)));
        Person uncleBob = new Person("Robert", "C.Martin", new HashSet<>(Arrays.asList(PROGRAMMING)));
        Person dracoMalfoy = new Person("Draco", "Malfoy", new HashSet<>(Arrays.asList(LEVITATION)));

        List<Person> personList = Arrays.asList(harryPotter, hermioneGranger, uncleBob,dracoMalfoy);

        for (Person p: personList) {
            Result<HogwartsStudent> process = createHogwartStudent(p);
            System.out.println(process.hasError() ? process.getError() : process.getValue());
        }

    }

    private static Result<HogwartsStudent> createHogwartStudent(Person p) {

        StudentValidator studentValidator = new StudentValidator();
        SortingHat sortingHat = new SortingHat();

        Result<Boolean> isValidStudent = studentValidator.isValid(p);

        if (isValidStudent.hasError()) {
            return Result.error(isValidStudent.getError());
        }

        return sortingHat.assignHouse(p);

    }
}