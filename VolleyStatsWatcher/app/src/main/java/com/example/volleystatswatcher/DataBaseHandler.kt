package com.example.volleystatswatcher

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHandler(context:Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private val DATABASE_VERSION = 5
        private val DATABASE_NAME = "MatchDatabase"

        private val TABLE_MATCHS = "MatchTable"

        private val KEY_ID = "_id"
        private val KEY_MATCH_ID = "match_id"
        private val KEY_SCORE = "total_score"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        //creating table with fields
        val CREATE_MATCH_TABLE = ("CREATE TABLE " + TABLE_MATCHS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MATCH_ID + " TEXT," +
                KEY_SCORE + " INTEGER" + ")")
        db?.execSQL(CREATE_MATCH_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_MATCHS")
        onCreate(db)
    }

    fun addMatch(emp: MatchClass): Long {
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(KEY_MATCH_ID, emp.match_id)
        contentValues.put(KEY_SCORE, emp.total_score)


        // Inserting match details using insert query.
        val success = db.insert(TABLE_MATCHS, null, contentValues)

        db.close()
        return success
    }

    fun updateMatch(emp: MatchClass): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(KEY_SCORE, emp.total_score+1) // EmpModelClass Email

        // Updating Row
        val success = db.update(TABLE_MATCHS, contentValues, KEY_ID + "=" + emp.id, null)
        //2nd argument is String containing nullColumnHack

        // Closing database connection
        db.close()
        return success

    }
    fun getScore(): Cursor? {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + TABLE_MATCHS, null)

    }

    }