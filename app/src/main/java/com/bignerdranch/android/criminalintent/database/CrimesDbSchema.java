package com.bignerdranch.android.criminalintent.database;

/**
 * Created by romananchugov on 11.08.17.
 */

public class CrimesDbSchema {

    public static final class CrimeTable{
        public static final String NAME = "crimes";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
