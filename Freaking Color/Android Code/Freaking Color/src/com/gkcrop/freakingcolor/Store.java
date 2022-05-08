package com.gkcrop.freakingcolor;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class Store
{

    public static final String FIRST = "first";
    public static final String LOCK = "lock";
    public static final String SCORE = "score";

    public Store()
    {
    }

    public static Boolean getReferenceBoolean(Context context, String s)
    {
        return Boolean.valueOf(context.getSharedPreferences("color", 0).getBoolean(s, false));
    }

    public static int getReferenceInt(Context context, String s)
    {
        return context.getSharedPreferences("color", 0).getInt(s, 0);
    }

    public static void setReferenceBoolean(Context context, String s, Boolean boolean1)
    {
        Editor editor = context.getSharedPreferences("color", 0).edit();
        editor.putBoolean(s, boolean1.booleanValue());
        editor.commit();
    }

    public static void setReferenceInt(Context context, String s, int i)
    {
        Editor editor = context.getSharedPreferences("color", 0).edit();
        editor.putInt(s, i);
        editor.commit();
    }
}
