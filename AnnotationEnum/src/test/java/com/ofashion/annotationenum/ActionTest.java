package com.ofashion.annotationenum;

import org.junit.Test;

public class ActionTest {

    @Test
    public void constractorTest() {
        Action action = new Action(Action.NONE);

        Action action1 = new Action(5);
    }
}