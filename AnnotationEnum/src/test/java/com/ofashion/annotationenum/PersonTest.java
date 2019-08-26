package com.ofashion.annotationenum;

import com.google.common.truth.Truth;

import org.junit.Test;

public class PersonTest {

    @Test
    public void test() {
        Person person = new Person();
//        person.setGender("ab");

        person.setGender(Person.Gender.MALE);
        Truth.assertThat(person.getGender()).isEqualTo("male");
    }

}