/*package com.example.merek.tournamaker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TournamakerDatabaseHelper extends SQLiteOpenHelper {
    private static TournamakerDatabaseHelper tInstance;
    private static final String TAG = "TournamakerDBHelper";

    // Database Info
    private static final String DATABASE_NAME = "tournamaker.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    private static final String TABLE_TEAMS = "teams";
    private static final String TABLE_TOURNAMENTS = "tournaments";
    private static final String TABLE_TEAM_TOURNAMENT = "team_tournament";

    // Teams Table Columns
    private static final String KEY_TEAM_ID = "id";
    private static final String KEY_TEAM_NAME = "name";
    private static final String KEY_TEAM_ICON_NAME = "icon_name"; // Name of the icon
    private static final String KEY_TEAM_ICON_PATH = "icon_path"; // Check if icon is stored on drawables or in a SD card
    private static final String KEY_TEAM_ICON_IS_DRAWABLE = "icon_is_drawable";

    // Tournaments Table Columns
    private static final String KEY_TOURNAMENT_ID = "id";
    private static final String KEY_TOURNAMENT_NAME = "name";
    private static final String KEY_TOURNAMENT_TYPE = "type";
    private static final String KEY_TOURNAMENT_ACTIVE = "active";

    // Teams Tournament Stats Table Columns
    private static final String KEY_TEAM_REFERENCE_ID = "team_id";
    private static final String KEY_TOURNAMENT_REFERENCE_ID = "tournament_id";
    private static final String KEY_TEAM_TOURNAMENT_NUM_GOALS = "goals";
    private static final String KEY_TEAM_TOURNAMENT_NUM_WINS = "wins";
    private static final String KEY_TEAM_TOURNAMENT_NUM_LOSES = "loses";
    private static final String KEY_TEAM_TOURNAMENT_LEAGUE_POS = "pos";

    public static synchronized TournamakerDatabaseHelper getInstance(Context context){
        if (tInstance == null){
            tInstance = new TournamakerDatabaseHelper(context.getApplicationContext());
        }
        return tInstance;
    }

    private TournamakerDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when database connection is being configured
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }


    // Called when database is created for the first time
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create teams table
        String CREATE_TEAMS_TABLE = "CREATE TABLE " + TABLE_TEAMS +
                "(" +
                    KEY_TEAM_ID + " INTEGER PRIMARY KEY," + // Define primary key
                    KEY_TEAM_NAME + " TEXT UNIQUE," +
                    KEY_TEAM_ICON_NAME + " TEXT," +
                    KEY_TEAM_ICON_PATH + " TEXT UNIQUE," +
                    KEY_TEAM_ICON_IS_DRAWABLE + " BOOLEAN" +
                ")";

        // Create tournament table
        String CREATE_TOURNAMENTS_TABLE = "CREATE TABLE " + TABLE_TEAMS +
                "(" +
                KEY_TOURNAMENT_ID + " INTEGER PRIMARY KEY," + // Define primary key
                KEY_TOURNAMENT_NAME + " TEXT UNIQUE," +
                KEY_TOURNAMENT_TYPE + " TEXT," +
                KEY_TOURNAMENT_ACTIVE + " BOOLEAN" +
                ")";

        // Create team tournament stats table
        String CREATE_TEAM_TOURNAMENT_TABLE = "CREATE TABLE " + TABLE_TEAMS +
                "(" +
                KEY_TEAM_REFERENCE_ID + " INTEGER NOT NULL," + // Define primary key
                KEY_TOURNAMENT_REFERENCE_ID + " INTEGER NOT NULL," +
                KEY_TEAM_TOURNAMENT_NUM_GOALS + " INTEGER," +
                KEY_TEAM_TOURNAMENT_NUM_WINS + " INTEGER," +
                KEY_TEAM_TOURNAMENT_NUM_LOSES + " INTEGER," +
                KEY_TEAM_TOURNAMENT_LEAGUE_POS + " INTEGER," +
                " FOREIGN KEY (" + KEY_TEAM_REFERENCE_ID + ") REFERENCES " + TABLE_TEAMS + "(" + KEY_TEAM_ID + ")," +
                " FOREIGN KEY (" + KEY_TOURNAMENT_REFERENCE_ID + ") REFERENCES " + TABLE_TOURNAMENTS + "(" + KEY_TOURNAMENT_ID + ")," +
                " PRIMARY KEY (" + KEY_TEAM_REFERENCE_ID + ", " + KEY_TOURNAMENT_REFERENCE_ID + ")" +
                ")";

        // Execute SQL
        db.execSQL(CREATE_TEAMS_TABLE);
        db.execSQL(CREATE_TOURNAMENTS_TABLE);
        db.execSQL(CREATE_TEAM_TOURNAMENT_TABLE);
    }

    // Called when database is already created and will be upgraded.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop all old tables and recreate them
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEAMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOURNAMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEAM_TOURNAMENT);
        onCreate(db);
    }

    public void addTeam(Team team) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            //long teamId = addOrUpdateTeam(teamTournamentStats, teamIconName, iconPath, isDrawable);

            ContentValues values = new ContentValues();
            //values.put(KEY_TEAM_ID, teamId);
            values.put(KEY_TEAM_NAME, team.getName());
            values.put(KEY_TEAM_ICON_NAME, teamIconName);
            values.put(KEY_TEAM_ICON_PATH, iconPath);
            values.put(KEY_TEAM_ICON_IS_DRAWABLE, isDrawable);

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_TEAMS, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    public void addTournament(Tournament tournament) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            //long teamId = addOrUpdateTeam(teamTournamentStats, teamIconName, iconPath, isDrawable);

            ContentValues values = new ContentValues();
            values.put(KEY_TOURNAMENT_NAME, tournament.getName());
            values.put(KEY_TOURNAMENT_TYPE, tournament.getType());
            values.put(KEY_TOURNAMENT_ACTIVE, tournament.isActive());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_TOURNAMENTS, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    public void addTeam(Team team) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            //long teamId = addOrUpdateTeam(teamTournamentStats, teamIconName, iconPath, isDrawable);

            ContentValues values = new ContentValues();
            values.put(KEY_TEAM_REFERENCE_ID, getTeamID(team.getTeamName()));
            values.put(KEY_TOURNAMENT_REFERENCE_ID, getTournamentID(team.getTournamentName()));
            values.put(KEY_TEAM_TOURNAMENT_NUM_GOALS, team.getNumOfGoals());
            values.put(KEY_TEAM_TOURNAMENT_NUM_WINS, team.getNumGamesWon());
            values.put(KEY_TEAM_TOURNAMENT_NUM_LOSES, team.getNumGamesLost());
            values.put(KEY_TEAM_TOURNAMENT_LEAGUE_POS, team.getLeaguePosition());

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_TEAM_TOURNAMENT, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    private int getTeamID(String name){
        List<Integer> teamIDList = new ArrayList<>();

        // SELECT * FROM TEAMS
        String TEAM_ID_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE name=%s",
                        TABLE_TEAMS, name);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(TEAM_ID_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    int teamID = cursor.getInt(cursor.getColumnIndex(KEY_TEAM_ID));

                    teamIDList.add(teamID);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return teamIDList.get(0);
    }

    private int getTournamentID(String name){
        List<Integer> tournamentIDList = new ArrayList<>();

        // SELECT * FROM TEAMS
        String TEAM_ID_SELECT_QUERY =
                String.format("SELECT * FROM %s WHERE name=%s",
                        TABLE_TEAMS, name);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(TEAM_ID_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    int tournamentID = cursor.getInt(cursor.getColumnIndex(KEY_TOURNAMENT_ID));

                    tournamentIDList.add(tournamentID);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return tournamentIDList.get(0);
    }

//    public long addOrUpdateTeam(TeamTournamentStats team, String teamIconName, String iconPath, Boolean isDrawable) {
//        // The database connection is cached so it's not expensive to call getWriteableDatabase() multiple times.
//        SQLiteDatabase db = getWritableDatabase();
//        long teamId = -1;
//
//        db.beginTransaction();
//        try {
//            ContentValues values = new ContentValues();
//            values.put(KEY_TEAM_NAME, team.getName());
//            values.put(KEY_TEAM_NUM_GOALS, team.getNumOfGoals());
//            values.put(KEY_TEAM_NUM_WINS, team.getNumGamesWon());
//            values.put(KEY_TEAM_NUM_LOSES, team.getNumGamesLost());
//            values.put(KEY_TEAM_LEAGUE_POS, team.getLeaguePosition());
//            values.put(KEY_TEAM_ICON_NAME, teamIconName);
//            values.put(KEY_TEAM_ICON_PATH, iconPath);
//            values.put(KEY_TEAM_ICON_IS_DRAWABLE, isDrawable);
//
//            // First try to update the user in case the user already exists in the database
//            // This assumes userNames are unique
//            int rows = db.update(TABLE_TEAMS, values, KEY_TEAM_NAME + "= ?", new String[]{team.getName()});
//
//            // Check if update succeeded
//            if (rows == 1) {
//                // Get the primary key of the user we just updated
//                String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
//                        KEY_TEAM_ID, TABLE_TEAMS, KEY_TEAM_NAME);
//                Cursor cursor = db.rawQuery(usersSelectQuery, new String[]{String.valueOf(team.getName())});
//                try {
//                    if (cursor.moveToFirst()) {
//                        teamId = cursor.getInt(0);
//                        db.setTransactionSuccessful();
//                    }
//                } finally {
//                    if (cursor != null && !cursor.isClosed()) {
//                        cursor.close();
//                    }
//                }
//            } else {
//                // user with this userName did not already exist, so insert new user
//                teamId = db.insertOrThrow(TABLE_TEAMS, null, values);
//                db.setTransactionSuccessful();
//            }
//        } catch (Exception e) {
//            Log.d(TAG, "Error while trying to add or update user");
//        } finally {
//            db.endTransaction();
//        }
//        return teamId;
//    }

    public List<Team> getAllTeams() {
        List<Team> teams = new ArrayList<>();

        // SELECT * FROM TEAMS
        String POSTS_SELECT_QUERY =
                String.format("SELECT * FROM %s",
                        TABLE_TEAMS);

        // "getReadableDatabase()" and "getWriteableDatabase()" return the same object (except under low
        // disk space scenarios)
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(POSTS_SELECT_QUERY, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex(KEY_TEAM_NAME));
                    String path = cursor.getString(cursor.getColumnIndex(KEY_TEAM_ICON_PATH)) + cursor.getString(cursor.getColumnIndex(KEY_TEAM_ICON_NAME));
                    boolean isIconDrawable = cursor.getInt(cursor.getColumnIndex(KEY_TEAM_ICON_IS_DRAWABLE))>0;

                    // Instantiate team
                    Team team = new Team(name, path, isIconDrawable);

                    teams.add(team);
                } while(cursor.moveToNext());
            }
        } catch (Exception e) {
            Log.d(TAG, "Error while trying to get posts from database");
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }
        return teams;
    }

}*/
