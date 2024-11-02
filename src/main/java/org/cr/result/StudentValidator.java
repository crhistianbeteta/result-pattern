package org.cr.result;

import java.util.HashSet;
import java.util.Set;

public class StudentValidator {

    Set<String> forbiddenSurnames = new HashSet<String>(){{
        add("Malfoy");
        add("Riddle");
        add("Lestrange");
    }};

    public Result<Boolean> isValid(Person student){
        if(forbiddenSurnames.contains(student.getSurname())){
            return Result.error(student +" has forbidden surname");
        }

        return Result.success(true);
    }
}
