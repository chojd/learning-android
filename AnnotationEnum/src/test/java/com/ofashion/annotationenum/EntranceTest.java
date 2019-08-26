package com.ofashion.annotationenum;

import com.google.common.truth.Truth;

import org.junit.Test;

import static org.junit.Assert.*;

public class EntranceTest {

    @Test
    public void getPerson() {
        Entrance entrance = new Entrance();
        Person person = entrance.getPerson();
        String gender = person.getGender();
        Truth.assertThat(gender).isEqualTo("male");
    }
}