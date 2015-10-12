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
    static  final String colMedEspe= "Especialidades";
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

        db.execSQL("CREATE TABLE "+ EspeTable + "(" + colEspeID +  " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + colEspeDescrip + " TEXT )");

        db.execSQL("CREATE TABLE " + MedTable + "(" + colMedID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + colMedName + " TEXT, " + colMedEspe + " INTEGER, "+ " FOREIGN KEY (" +
                colMedEspe + ") REFERENCES " + EspeTable + " (" + colEspeID + "));");

        db.execSQL("CREATE TRIGGER fk_medEspe_espeid " + " BEFORE INSERT " + " ON " + MedTable +
                " FOR EACH ROW BEGIN" + " SELECT CASE WHEN ((SELECT " + colEspeID + " FROM " + EspeTable +
                " WHERE " + colEspeID + "=new." + colMedEspe + " ) IS NULL)" +
                " THEN RAISE (ABORT,'Foreign Key Violation') END;" + "  END;");


        db.execSQL("CREATE TABLE " + CobTable + "(" + colCobID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                    + colCobName + " TEXT )");

        db.execSQL("CREATE VIEW " + viewMed + " AS SELECT " + MedTable + "." + colMedID +
                    " AS _id," + " " + MedTable + "." + colMedName + "," + " " + EspeTable + "."
                + colEspeDescrip + "" + " FROM " + MedTable + " JOIN " + EspeTable + " ON " + MedTable
                + "." + colMedEspe + " =" + EspeTable + "." + colEspeID);

        db.execSQL("CREATE VIEW " + viewEspe + " AS SELECT " + EspeTable + "." + colEspeID +
                " AS _id," + " " + EspeTable + "." + colEspeDescrip + " FROM " + EspeTable);

        db.execSQL("CREATE VIEW " + viewCobertura + " AS SELECT " + CobTable + "." + colCobID +
                " AS _id," + " " + CobTable + "." + colCobName + " FROM " + CobTable);

       db = this.getWritableDatabase();
        //HACER
        InsertMedico(db, 1, "Dr. Copioli Carlos", 1);

        InsertEspecialidades(db, 1, "Alergia e inmunología");
        InsertEspecialidades(db, 2, "Anestesiología");
        InsertEspecialidades(db, 3, "Cardiología");
        InsertEspecialidades(db, 4, "Cirugía cardíaca");
        InsertEspecialidades(db, 5, "Dermatología");
        InsertEspecialidades(db, 6, "Fonoaudiología");
        InsertEspecialidades(db, 7, "Endocrinología");
        InsertEspecialidades(db, 8, "Gatroenterología");
        InsertEspecialidades(db, 9, "Nefrología");
        InsertEspecialidades(db, 10, "Neurología");
        InsertEspecialidades(db, 11, "Nutrición");
        InsertEspecialidades(db, 12, "Oftalmología");
        InsertEspecialidades(db, 13, "Otorrinolaringologia");
        InsertEspecialidades(db, 14, "Pediatría");
        InsertEspecialidades(db, 15, "Traumatología");
        InsertEspecialidades(db, 16, "Urología");

        InsertCobertura(db, 1, "A.M.U.R");
        InsertCobertura(db,2,"A.P.O.S");
        InsertCobertura(db,3,"A.P.S.O.T");
        InsertCobertura(db,4,"A.S.E");
        InsertCobertura(db,5,"ACA");
        InsertCobertura(db,6,"Agua y Energía");
        InsertCobertura(db,7,"AMICOS");
        InsertCobertura(db,8,"BERKLEY INTERNATIONAL ART");
        InsertCobertura(db,9,"C.N.A ART");
        InsertCobertura(db,10,"Caja de Abogados");
        InsertCobertura(db,11,"Caja Notarial");
        InsertCobertura(db,12,"CONSALUD");
        InsertCobertura(db,13,"D.A.S.U.T.E.N");
        InsertCobertura(db,14,"E.P.E.C");
        InsertCobertura(db,15,"Futbolistas Argentinos Agremiados");
        InsertCobertura(db,16,"Galeno");
        InsertCobertura(db,17,"I.O.S.E.P");
        InsertCobertura(db,18,"Liberty ART S.A.");
        InsertCobertura(db,19,"MEDIFE");
        InsertCobertura(db,20,"MET");
        InsertCobertura(db,21,"OSDE");
        InsertCobertura(db,22,"OMINT");
        InsertCobertura(db,23,"Premedica S.A.");
        InsertCobertura(db,24,"Prevención ART");
        InsertCobertura(db,25,"Provincia ART");
        InsertCobertura(db,26,"R.A.S.C.C.");
        InsertCobertura(db,27,"Responsabilidad Patronal ART");
        InsertCobertura(db,28,"Sanarte");
        InsertCobertura(db,29,"SANCOR");
        InsertCobertura(db,30,"SIPSSA");
        InsertCobertura(db,31,"SWISS MEDICAL S.A.");
        InsertCobertura(db,32,"UNIMED");
        InsertCobertura(db,33,"UPCN");


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
