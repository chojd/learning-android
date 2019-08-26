package com.ofashion.annotationenum;

import android.support.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Action {

    public Action(@ActionType int type) {
        this.type = type;
    }

    @IntDef({
            NONE,
            SMART})
    @Target({
            ElementType.FIELD,
            ElementType.METHOD,
            ElementType.PARAMETER
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface ActionType {
    }

    public static final int NONE = 0;
    public static final int SMART = 1;

    private @ActionType int type;

}
