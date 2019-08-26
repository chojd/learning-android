package com.ofashion.annotationenum;

import android.support.annotation.StringDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Person {

    @StringDef({Gender.MALE, Gender.FEMALE})
    @Target({ElementType.FIELD,
            ElementType.METHOD,
            ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Gender {
        String MALE = "male";
        String FEMALE = "female";
    }

    private @Gender String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(@Gender String gender) {
        this.gender = gender;
    }
}
