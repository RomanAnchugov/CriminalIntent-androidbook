package com.bignerdranch.android.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.criminalintent.Crime;

import java.util.Date;
import java.util.UUID;

/**
 * Created by romananchugov on 11.08.17.
 */

public class CrimeCursorWrapper extends CursorWrapper {


    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime(){
        String uuidString = getString(getColumnIndex(CrimesDbSchema.CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimesDbSchema.CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimesDbSchema.CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimesDbSchema.CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimesDbSchema.CrimeTable.Cols.SUSPECT));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setSuspect(suspect);
        return crime;
    }
}
