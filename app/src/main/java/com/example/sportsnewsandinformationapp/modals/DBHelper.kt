package com.example.sportsnewsandinformationapp.modals

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    // below is the method for creating a database by a sqlite query
    override fun onCreate(db: SQLiteDatabase) {
        // below is a sqlite query, where column names
        // along with their data types is given
        val sportsQuery = ("CREATE TABLE " + TABLE_SPORTS + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                SPORTSTYPE_COL + " TEXT," +
                SPORTSNAME_COL + " TEXT," +
                INSTRUCTION_COL + " TEXT" +")")

        val newsQuery = ("CREATE TABLE " + TABLE_NEWS + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NEWS_IMAGE_URL_COL + " TEXT," +
                NEWS_TITLE_COL + " TEXT," +
                NEWS_DESCRIPTION_COL + " TEXT" +")")

        val athletesQuery = ("CREATE TABLE " + TABLE_ATHLETES + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                ATHLETES_NAME_COL + " TEXT," +
                ATHLETES_SPORT_NAME_COL + " TEXT," +
                ATHLETES_COUNTRY_COL + " TEXT," +
                ATHLETES_BEST_PERFORMANCE_COL + " TEXT," +
                ATHLETES_MEDALS_COL + " TEXT," +
                ATHLETES_FACTS_COL + " TEXT" +")")

        // we are calling sqlite
        // method for executing our query
        db.execSQL(sportsQuery)
        db.execSQL(newsQuery)
        db.execSQL(athletesQuery)
    }
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        // this method is to check if table already exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SPORTS)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NEWS)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATHLETES)
        onCreate(db)
    }

    // This method is for adding data in our database
    fun addSports(sportsType: String, sportsName: String, instruction: String ){

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values
        // in the form of key-value pair
        values.put(SPORTSTYPE_COL, sportsType)
        values.put(SPORTSNAME_COL, sportsName)
        values.put(INSTRUCTION_COL, instruction)

        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in our database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_SPORTS, null, values)

        // at last we are
        // closing our database
        db.close()
    }

    // This method is for adding data in our database
    fun addNews(imageUrl: String, title: String, description: String ){

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values
        // in the form of key-value pair
        values.put(NEWS_IMAGE_URL_COL, imageUrl)
        values.put(NEWS_TITLE_COL, title)
        values.put(NEWS_DESCRIPTION_COL, description)

        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in our database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_NEWS, null, values)

        // at last we are
        // closing our database
        db.close()
    }

    // This method is for adding data in our database
    fun addAthletes(athleteName: String, sportName: String, country: String, bestPerformance: String, medals: String, facts: String){

        // below we are creating
        // a content values variable
        val values = ContentValues()

        // we are inserting our values
        // in the form of key-value pair
        values.put(ATHLETES_NAME_COL, athleteName)
        values.put(ATHLETES_SPORT_NAME_COL, sportName)
        values.put(ATHLETES_COUNTRY_COL, country)
        values.put(ATHLETES_BEST_PERFORMANCE_COL, bestPerformance)
        values.put(ATHLETES_MEDALS_COL, medals)
        values.put(ATHLETES_FACTS_COL, facts)

        // here we are creating a
        // writable variable of
        // our database as we want to
        // insert value in our database
        val db = this.writableDatabase

        // all values are inserted into database
        db.insert(TABLE_ATHLETES, null, values)

        // at last we are
        // closing our database
        db.close()
    }

    // below method is to get
    // all data from our database
    fun getSports(): Cursor? {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + TABLE_SPORTS, null)
    }

    fun getNews(): Cursor? {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + TABLE_NEWS, null)
    }

    // below method is to get
    // all data from our database
    fun getAthletes(): Cursor? {

        // here we are creating a readable
        // variable of our database
        // as we want to read value from it
        val db = this.readableDatabase

        // below code returns a cursor to
        // read data from the database
        return db.rawQuery("SELECT * FROM " + TABLE_ATHLETES, null)
    }

    companion object{
        // here we have defined variables for our database

        // below is variable for database name
        private val DATABASE_NAME = "SportsNewsAndInformationApp"

        // below is the variable for database version
        private val DATABASE_VERSION = 1

        // below is the variable for table name
        val TABLE_SPORTS = "sports_table"

        // below is the variable for id column
        val ID_COL = "id"
        // below is the variable for name column
        val SPORTSTYPE_COL = "sportsType"

        // below is the variable for age column
        val SPORTSNAME_COL = "sportsName"

        // below is the variable for age column
        val INSTRUCTION_COL = "instruction"


        // below is the variable for table name
        val TABLE_NEWS = "news_table"

        // below is the variable for name column
        val NEWS_IMAGE_URL_COL = "imageUrl"

        // below is the variable for age column
        val NEWS_TITLE_COL = "title"

        // below is the variable for age column
        val NEWS_DESCRIPTION_COL = "description"


        // below is the variable for table name
        val TABLE_ATHLETES = "athletes_table"

        // below is the variable for name column
        val ATHLETES_NAME_COL = "athleteName"

        // below is the variable for age column
        val ATHLETES_SPORT_NAME_COL = "sportName"

        // below is the variable for age column
        val ATHLETES_COUNTRY_COL = "country"

        // below is the variable for age column
        val ATHLETES_BEST_PERFORMANCE_COL = "bestPerformance"

        // below is the variable for age column
        val ATHLETES_MEDALS_COL = "medals"

        // below is the variable for age column
        val ATHLETES_FACTS_COL = "facts"
    }
}