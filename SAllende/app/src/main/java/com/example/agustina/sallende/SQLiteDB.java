package com.example.agustina.sallende;

import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Belen on 21/09/2015.
 */
public class SQLiteDB extends SQLiteOpenHelper {

    static final String dbName= "SAllende";

    static final String MedTable= "Medicos";
    static final String colMedID="id_med";
    static  final String colMedEspe= "Espe";
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
                    + colMedName + " TEXT" + colMedEspe + "INTEGER NOT NULL, FOREIGN KEY (" +
                colMedEspe + ") REFERENCES " + EspeTable + " (" + colEspeID + ")");

        db.execSQL("CREATE TABLE "+ EspeTable + "(" + colEspeID +  " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + colEspeDescrip + " TEXT )");

        db.execSQL("CREATE TABLE " + CobTable + "(" + colCobID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + colCobName + " TEXT )");

        db.execSQL("CREATE VIEW " + viewMed + "AS SELECT " + MedTable + "." + colMedID +
                    " AS _id," + " " + MedTable + "." + colMedName + "," + " " + EspeTable + "."
                + colEspeDescrip + "" + " FROM " + MedTable + " JOIN " + EspeTable + " ON " + MedTable
                + "." + colMedEspe + " =" + EspeTable + "." + colEspeID);

        db.execSQL("CREATE VIEW " + viewEspe + "AS SELECT " + EspeTable + "." + colEspeID +
                " AS _id," + " " + EspeTable + "." + colEspeDescrip + "FROM " +  EspeTable);

        db.execSQL("CREATE VIEW " + viewCobertura + "AS SELECT " + CobTable + "." + colCobID +
                " AS _id," + " " + CobTable + "." + colCobName + "FROM " + CobTable);

        db.execSQL("CREATE TRIGGER fk_medEspe_espeid " + " BEFORE INSERT " + " ON " + MedTable +
                " FOR EACH ROW BEGIN" + " SELECT CASE WHEN ((SELECT " + colEspeID + " FROM " + EspeTable +
                " WHERE " + colEspeID + "=new." + colMedEspe + " ) IS NULL)" +
                " THEN RAISE (ABORT,'Foreign Key Violation') END;" + "  END;");
    //HACER
        InsertMedico(db, 1, "Dr. Copioli Carlos", 1);
        InsertEspecialidades(db, 1, "Alergia e inmunología");
        InsertCobertura(db,1,"Osde");


//HACER EL INSERT
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

    void InsertMedico(SQLiteDatabase db, int id, String medName, int espe)
    {
        ContentValues cv = new ContentValues();
        cv.put(colMedID, id);
        cv.put(colMedName, medName);
        cv.put(colMedEspe, espe);
        db.insert(MedTable, colMedID, cv);

    }
    void InsertEspecialidades(SQLiteDatabase db, int id, String descrip)
    {
        ContentValues cv = new ContentValues();
        cv.put(colEspeID, id);
        cv.put(colEspeDescrip, descrip);
        db.insert(EspeTable, colEspeID, cv);
    }
    void InsertCobertura(SQLiteDatabase db, int id, String cobName)
    {
        ContentValues cv = new ContentValues();
        cv.put(colCobID, id);
        cv.put(colCobName, cobName);
        db.insert(CobTable, colCobID, cv);
    }


    Cursor getAllMedicos() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + viewMed, null);
        return cur;
    }

    Cursor getAllEspecialidades() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + viewEspe, null);
        return cur;
    }

    Cursor getAllCoberturas() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + viewCobertura, null);
        return cur;
    }

//faltan metodos update, delete, get con filtros


}
