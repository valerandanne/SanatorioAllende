package com.example.agustina.sallende;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Belen on 21/09/2015.
 */
public class SQLiteDB extends SQLiteOpenHelper {

    static final String dbName= "SAllende";

    static final String MedTable= "Medicos";
    static final String colMedID="id_med";
    static final String colMedName="nombre";

    static final String EspeTable="Especialidades";
    static final String colEspeID= "id_espe";
    static final String colEspeDescrip="descripcion";

    static final String CobTable="Cobertura";
    static final String colCobID="id_cob";
    static final String colCobName="nombre";

    static final String viewMed= "ViewMedicos";
    static final String viewEspe="ViewEspecialidades";
    static final String viewCobertura="ViewCobertura";

    public SQLiteDB(Context context) {
        super(context, dbName, null, 1);
    }

    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE " + MedTable + "(" + colMedID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + colMedName + " TEXT)");

        db.execSQL("CREATE TABLE "+ EspeTable + "(" + colEspeID +  " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + colEspeDescrip + " TEXT )");

        db.execSQL("CREATE TABLE " + CobTable + "(" + colCobID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + colCobName + "TEXT )");

        db.execSQL("CREATE VIEW " + viewMed + "AS SELECT " + MedTable + "." + colMedID +
                    " AS _id," + " " + MedTable + "." + colMedName + "FROM " +  MedTable);

        db.execSQL("CREATE VIEW " + viewEspe + "AS SELECT " + EspeTable + "." + colEspeID +
                " AS _id," + " " + EspeTable + "." + colEspeDescrip + "FROM " +  EspeTable);

        db.execSQL("CREATE VIEW " + viewCobertura + "AS SELECT " + CobTable + "." + colCobID +
                " AS _id," + " " + CobTable + "." + colCobName + "FROM " + CobTable);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        db.execSQL("DROP TABLE IF EXISTS " + MedTable);
        db.execSQL("DROP TABLE IF EXISTS " + EspeTable);
        db.execSQL("DROP TABLE IF EXISTS " + CobTable);

        db.execSQL("DROP VIEW IF EXISTS " + viewMed);
        db.execSQL("DROP VIEW IF EXISTS " + viewEspe);
        db.execSQL("DROP VIEW IF EXISTS " + viewCobertura);

        onCreate(db);
    }


}
