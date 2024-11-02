package org.cr.result;


import java.util.function.Function;
import java.util.function.Supplier;

public class Result<T>{

    private final String error;
    private final T value;
    private final boolean hasError;

    private Result(T value, String error, boolean hasError){
        this.value = value;
        this.error = error;
        this.hasError = hasError;
    }

    public static <T> Result<T> success(T value){
        return new Result<>(value,null,false);
    }

    public static Result error(String error){
        return new Result(null,error,true);
    }

    public boolean hasError(){
        return  this.hasError;
    }

    public String getError(){
        return this.error;
    }

    public T getValue() {
        if(error != null){
            throw new RuntimeException("Error present");
        }
        return value;
    }

}
