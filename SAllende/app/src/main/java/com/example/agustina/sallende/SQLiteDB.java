package com.example.agustina.sallende;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

import Beans.BeanCobertura;
import Beans.BeanEspecialidad;
import Beans.BeanMedico;
import Beans.BeanSucursal;

/**
 * Created by Belen on 21/09/2015.
 */
public class SQLiteDB extends SQLiteOpenHelper {

    static final String dbName= "SAllende";

    static final String MedTable= "Medicos";
    static final String colMedID="id_med";
    static  final String colMedEspe= "Especialidades";
    static final String colMedName="nombre";
    static final String colMedSuc="Sucursal";

    static final String EspeTable="Especialidades";
    static final String colEspeID= "id_espe";
    static final String colEspeDescrip="descripcion";

    static final String CobTable="Cobertura";
    static final String colCobID="id_cob";
    static final String colCobName="nombre";

    static final String SucTable="Sucursal";
    static final String colSucID="id_suc";
    static final String colSucName="nombre";

    static final String viewMed= "ViewMedicos";
    static final String viewEspe="ViewEspecialidades";
    static final String viewCobertura="ViewCobertura";
    static final String viewSucursales="ViewSucursales";



    public SQLiteDB(Context context) {

        super(context, dbName, null, 2);
    }

    public void onCreate(SQLiteDatabase db){

        db.execSQL("CREATE TABLE "+ EspeTable + "(" + colEspeID +  " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + colEspeDescrip + " TEXT )");

        db.execSQL("CREATE TABLE "+ SucTable + "(" + colSucID +  " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + colSucName + " TEXT )");

        db.execSQL("CREATE TABLE " + MedTable + "(" + colMedID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + colMedName + " TEXT, " + colMedEspe + " INTEGER, "+ colMedSuc + " INTEGER, " + " FOREIGN KEY (" +
                colMedEspe + ") REFERENCES " + EspeTable + " (" + colEspeID + ")" + ", FOREIGN KEY (" +
                colMedSuc + ") REFERENCES " + SucTable + " (" + colSucID + "));");

        db.execSQL("CREATE TRIGGER fk_medEspe_espeid " + " BEFORE INSERT " + " ON " + MedTable +
                " FOR EACH ROW BEGIN" + " SELECT CASE WHEN ((SELECT " + colEspeID + " FROM " + EspeTable +
                " WHERE " + colEspeID + "=new." + colMedEspe + " ) IS NULL)" +
                " THEN RAISE (ABORT,'Foreign Key Violation') END;" + "  END;");

        db.execSQL("CREATE TRIGGER fk_medSuc_Sucid " + " BEFORE INSERT " + " ON " + MedTable +
                " FOR EACH ROW BEGIN" + " SELECT CASE WHEN ((SELECT " + colSucID + " FROM " + SucTable +
                " WHERE " + colSucID + "=new." + colMedSuc + " ) IS NULL)" +
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

        db.execSQL("CREATE VIEW " + viewSucursales + " AS SELECT " + SucTable + "." + colSucID +
                " AS _id," + " " + SucTable + "." + colSucName + " FROM " + SucTable);


        InsertSucursal(db, 2, "CERRO");
        InsertSucursal(db,1, "NUEVA CÓRDOBA");

        InsertEspecialidades(db, 1, "Alergia e inmunología");
        InsertEspecialidades(db, 2, "Anestesiología");
        InsertEspecialidades(db, 3, "Cardiología");
        InsertEspecialidades(db, 4, "Cirugía cardíaca");
        InsertEspecialidades(db, 5, "Dermatología");
        InsertEspecialidades(db, 6, "Fonoaudiología");
        InsertEspecialidades(db, 7, "Endocrinología");
        InsertEspecialidades(db, 8, "Gatroenterología");
        InsertEspecialidades(db, 9, "Nefrología");
        InsertEspecialidades(db, 10, "Neurología Infantil");
        InsertEspecialidades(db, 11, "Nutrición");
        InsertEspecialidades(db, 12, "Oftalmología");
        InsertEspecialidades(db, 13, "Otorrinolaringologia");
        InsertEspecialidades(db, 14, "Pediatría");
        InsertEspecialidades(db, 15, "Traumatología y Ortopedia");
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

        InsertMedico(db, 1, "Dr. Copioli Carlos", 1, 1);
        InsertMedico(db, 2, "Dra. Barrera Roxana", 1,1);
        InsertMedico(db, 3, "Dra. Cavallo Marta", 1,1);
        InsertMedico(db, 4, "Dra.Puentes Laura", 1,2);
        InsertMedico(db, 5, "Dr. Astore Fabian",2,1);
        InsertMedico(db, 6, "Dr. Demaria Javier", 2,1);
        InsertMedico(db, 7, "Dr. Escudero Juan", 2,1);
        InsertMedico(db, 8, "Dr. Gross Carlos", 2,2);
        InsertMedico(db, 9, "Dr. Pacheco Eduardo", 2,2);
        InsertMedico(db, 10, "Dr. Riveri Fancisco", 2,2);
        InsertMedico(db, 11, "Dr. Salas Marcos", 2,2);
        InsertMedico(db, 12, "Dra. Castro Maria Belen", 2,2);
        InsertMedico(db, 13, "Dr. Moreira Eduardo", 3,1);
        InsertMedico(db, 14, "Dr. Alday Luis", 3,1);
        InsertMedico(db, 15, "Dr. Allall Oscar", 3,1);
        InsertMedico(db, 16, "Dr. Allub Alejandro", 3,1);
        InsertMedico(db, 17, "Dra. Auad Luciana", 3,2);
        InsertMedico(db, 18, "Dr. Bass Gabriel", 3,2);
        InsertMedico(db, 19, "Dr. Bono Julio", 3,2);
        InsertMedico(db, 20, "Dr. Cordoba Roque", 4,1);
        InsertMedico(db, 21, "Dr. Figueroa Marcelo", 4,1);
        InsertMedico(db, 22, "Dr. Bronzi Jorge", 4,1);
        InsertMedico(db, 23, "Dr. Cordoba Ignacio", 4,2);
        InsertMedico(db, 24, "Dr. Liendo Rocardo", 4,2);
        InsertMedico(db, 25, "Dr. Bono Julio", 5,1);
        InsertMedico(db, 26, "Dra. Gonzales Eleonora", 5,1);
        InsertMedico(db, 27, "Dra. Baldrini Maria Pia", 5,1);
        InsertMedico(db, 28, "Dr. Centeno Alejandro", 5,1);
        InsertMedico(db, 29, "Dr. Perrotat Pedro", 5,2);
        InsertMedico(db, 30, "Dra. Ramona Griselda", 5,2);
        InsertMedico(db, 31, "Dra. Vidal Graciaela", 5,2);
        InsertMedico(db, 32, "Lic. Riera Monica", 6,1);
        InsertMedico(db, 33, "Lic. Fuentes Anabella", 6,1);
        InsertMedico(db, 34, "Lic. Leon Noelia", 6,2);
        InsertMedico(db, 35, "Lic. Maranzana Melisa", 6,2);
        InsertMedico(db, 36, "Dr. Ortiz Gustavo", 7,1);
        InsertMedico(db, 37, "Dra. Arja Ana", 7,1);
        InsertMedico(db, 38, "Dra. Bergoglio Marina", 7,1);
        InsertMedico(db, 39, "Dra. Griguol Sandra", 7,1);
        InsertMedico(db, 40, "Dra. Acuña Valeria", 7,2);
        InsertMedico(db, 41, "Dr. Carri Julio", 8,1);
        InsertMedico(db, 42, "Dra. Cordoba Claudia", 8,1);
        InsertMedico(db, 43, "Dr. Faule Sebastian", 8,1);
        InsertMedico(db, 44, "Dr. Higo Antonio", 8,2);
        InsertMedico(db, 45, "Dr. Fadul Miguel", 8,2);
        InsertMedico(db, 46, "Dra. Castillo Gabriela", 8,2);
        InsertMedico(db, 47, "Dr. Novoa Pablo", 9,1);
        InsertMedico(db, 48, "Dr. Orias Marcelo", 9,1);
        InsertMedico(db, 49, "Dra. Barron Belen", 9,1);
        InsertMedico(db, 50, "Dr. Rigo Diego", 9,1);
        InsertMedico(db, 51, "Dr. Palacios Claudio", 10,1);
        InsertMedico(db, 52, "Dr. Itati Zenon", 10,1);
        InsertMedico(db, 54, "Dra. Faustinelli Valeria", 10,2);
        InsertMedico(db, 55, "Dra. Pautaso Josefina", 10,2);
        InsertMedico(db, 53, "Lic. Duarte Carolina", 11,1);
        InsertMedico(db, 54, "Lic. Aragon Ana", 11,1);
        InsertMedico(db, 55, "Lic. Galiano Analia", 11,2);
        InsertMedico(db, 56, "Lic. Gonzalez Carolina", 11,2);
        InsertMedico(db, 57, "Lic. Gonzalez Maria Victoria", 11,2);
        InsertMedico(db, 58, "Dr. Vilarrodona Lucas", 12,1);
        InsertMedico(db, 59, "Dr. Laje Luis", 12,1);
        InsertMedico(db, 60, "Dr. Tacité Domingo", 12,2);
        InsertMedico(db, 61, "Dr. Laje Poviña Luis", 12,2);
        InsertMedico(db, 62, "Dr. Matach Gustavo", 12,2);
        InsertMedico(db, 63, "Dr. Reviglio Victor", 12,2);
        InsertMedico(db, 64, "Dr. Ale Omar", 12,2);
        InsertMedico(db, 65, "Dra. Castellano Ximena", 12,2);
        InsertMedico(db, 66, "Dra. Cáceres Beatriz", 12,2);
        InsertMedico(db, 67, "Dr. Zernotti Mario", 13,1);
        InsertMedico(db, 68, "Dra. Benitez Paula", 13,1);
        InsertMedico(db, 69, "Dr. Conci Rodolfo", 13,1);
        InsertMedico(db, 70, "Dr. Filiberti Gabriel", 13,1);
        InsertMedico(db, 71, "Dra. Mirilo Gabriela", 13,1);
        InsertMedico(db, 72, "Dr. Olmos Manuel", 13,1);
        InsertMedico(db, 73, "Dra. Castro Fernanda", 13,2);
        InsertMedico(db, 74, "Dr. Rey Gonzalo", 13,2);
        InsertMedico(db, 75, "Dr. Bergallo Roberto", 14,1);
        InsertMedico(db, 76, "Dra. Bergallo Soledad", 14,1);
        InsertMedico(db, 77, "Dra. Blanco Silvana", 14,1);
        InsertMedico(db, 78, "Dra. Bruno Paula", 14,2);
        InsertMedico(db, 79, "Dr. Buteler Lucas", 14,2);
        InsertMedico(db, 80, "Dr. Balacco Martin", 14,2);
        InsertMedico(db, 81, "Dra. Becerra Adriana", 14,2);
        InsertMedico(db, 82, "Dr. Allende Bartolomé Tomas", 15,1);
        InsertMedico(db, 83, "Dr. Allende Gillermo José", 15,1);
        InsertMedico(db, 84, "Dr. Allende Bartolomé", 15,1);
        InsertMedico(db, 85, "Dr. Allende Cristian", 15,1);
        InsertMedico(db, 86, "Dra. Allende Victoria", 15,2);
        InsertMedico(db, 87, "Dr. Bertoloti Roman", 15,2);
        InsertMedico(db, 88, "Dr. Vitar Ivan", 15,2);
        InsertMedico(db, 89, "Dr. Lopez Seoane Manuel", 16,1);
        InsertMedico(db, 90, "Prof. Dr. Juaneda Ricardo", 16,1);
        InsertMedico(db, 91, "Dr. Barros Nores Julio", 16,1);
        InsertMedico(db, 92, "Dr. Bechis Gustavo", 16,2);
        InsertMedico(db, 93, "Dr. Bertran Marcelo", 16,2);
        InsertMedico(db, 94, "Dr. Epelde Marcos", 16,2);
        InsertMedico(db, 95, "Dr. Gonzalez Tomás", 16,2);
        InsertMedico(db, 96, "Dr. Minusi Gustavo", 16,2);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion<newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + MedTable);
            db.execSQL("DROP TABLE IF EXISTS " + EspeTable);
            db.execSQL("DROP TABLE IF EXISTS " + CobTable);
            db.execSQL("DROP TABLE IF EXISTS "+ SucTable);

            db.execSQL("DROP VIEW IF EXISTS " + viewMed);
            db.execSQL("DROP VIEW IF EXISTS " + viewEspe);
            db.execSQL("DROP VIEW IF EXISTS " + viewCobertura);
            db.execSQL("DROP TRIGGER IF EXISTS  fk_medEspe_espeid");
            db.execSQL("DROP TRIGGER IF EXISTS  fk_medSuc_Sucid");

            onCreate(db);
        }
    }

    void InsertMedico(SQLiteDatabase db, int id, String medName, int espe, int suc)
    {
        ContentValues cv = new ContentValues();
        cv.put(colMedID, id);
        cv.put(colMedName, medName);
        cv.put(colMedEspe, espe);
        cv.put(colMedSuc, suc);
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
    void InsertSucursal(SQLiteDatabase db, int id, String sucName)
    {
        ContentValues cv = new ContentValues();
        cv.put(colSucID, id);
        cv.put(colSucName, sucName);
        db.insert(SucTable, colSucID, cv);
    }

    public ArrayList<BeanMedico> getMedicosFromEspe(int id) {
        ArrayList<BeanMedico> lista= new ArrayList<BeanMedico>();
        BeanMedico medico;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT mt." + colMedName + ", st." + colSucName + " FROM " + MedTable + " mt, " + SucTable + " st" +
                " WHERE mt." + colMedSuc + "= st." + colSucID + " AND mt." + colMedEspe + "=" + id + " ORDER BY mt." + colMedName, null);

        for(cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext())
        {
            lista.add(medico = new BeanMedico(cur.getString(0),cur.getString(1)));
        }
        return lista;
    }

    public ArrayList<BeanEspecialidad> getAllEspecialidades() {
        ArrayList<BeanEspecialidad> lista =new ArrayList<BeanEspecialidad>();
        BeanEspecialidad especialidad;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(" SELECT * FROM " + EspeTable + " ORDER BY " + colEspeDescrip , null);

        for(cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext())
        {
            lista.add(especialidad = new BeanEspecialidad(cur.getString(0),cur.getString(1)));
        }
        return lista;
    }

    public ArrayList<BeanCobertura> getAllCoberturas() {
        ArrayList<BeanCobertura> lista= new ArrayList<BeanCobertura>();
        BeanCobertura cob;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + CobTable + " ORDER BY " + colCobID, null);

        for(cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext())
        {
            lista.add(cob = new BeanCobertura(cur.getString(0),cur.getString(1)));
        }
        return lista;
    }

    public ArrayList<BeanSucursal> getAllSucursales(){
        ArrayList<BeanSucursal> lista = new ArrayList<BeanSucursal>();
        BeanSucursal suc;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery(" SELECT * FROM " + SucTable + " ORDER BY " + colSucName , null);

        for(cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext())
        {
            lista.add(suc = new BeanSucursal(cur.getString(0),cur.getString(1)));
        }
        return lista;
    }

    public ArrayList<BeanMedico> getMedicosXEspeXSuc(int id_suc, int id_espe) {
        ArrayList<BeanMedico> lista= new ArrayList<BeanMedico>();
        BeanMedico medico;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT mt." + colMedName + ", st." + colSucName + " FROM " + MedTable + " mt, " + SucTable + " st" +
                " WHERE mt." + colMedSuc + "= st." + colSucID + " AND mt." + colMedEspe + "=" + id_espe +
                " AND st." + colSucID + "=" + id_suc + " ORDER BY mt." + colMedName, null);

        for(cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext())
        {
            lista.add(medico = new BeanMedico(cur.getString(0),cur.getString(1)));
        }
        return lista;
    }

//faltan metodos update, delete, get con filtros


}
