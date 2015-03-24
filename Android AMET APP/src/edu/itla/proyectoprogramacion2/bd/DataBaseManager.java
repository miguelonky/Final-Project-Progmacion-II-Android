package edu.itla.proyectoprogramacion2.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {
	public static final String TABLE_NAME = "multa";

	public static final String cn_cid = "_id";
	public static final String cn_id = "id";
	public static final String cn_fecha = "fecha";
	public static final String cn_lugar = "lugar";
	public static final String cn_direccion = "direccion";
	public static final String cn_nombre = "nombre";
	public static final String cn_documentoid = "documentoid";
	public static final String cn_nacionalidad = "nacionalidad";
	public static final String cn_noplaca = "noplaca";
	public static final String cn_tipo = "tipo";
	public static final String cn_lugarhecho = "lugarhecho";
	public static final String cn_noagente = "noagente";
	public static final String cn_zona = "zona";
	public static final String cn_noficha = "noficha";
	public static final String cn_infraccion = "infraccion";
	public static final String cn_bebida = "bebida";
	public static final String cn_alcholimetro = "alcholimetro";
	String [] columnas = new String []{cn_cid, cn_id , cn_fecha,cn_lugar,cn_direccion,cn_nombre ,cn_documentoid , cn_nacionalidad, cn_noplaca,cn_tipo, 
            cn_lugarhecho, cn_noagente, cn_zona, cn_noficha, cn_infraccion, cn_bebida, cn_alcholimetro};

	public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
			+ cn_cid + " integer,"
			+ cn_id + " integer primary key autoincrement,"
			+ cn_fecha+ " text ,"  
			+ cn_lugar+ " text ,"  
			+ cn_direccion+ " text,"  
			+ cn_nombre+ " text ,"  
			+ cn_documentoid+ " text ,"  
			+ cn_nacionalidad+ " text ,"  
			+ cn_noplaca+ " text ,"  
			+ cn_tipo+ " text ,"  
			+ cn_lugarhecho+ " text ,"  
			+ cn_noagente+ " text ," 
			+ cn_zona+ " text ,"
			+ cn_noficha+ " text ,"  
			+ cn_infraccion+ " text ,"  
			+ cn_bebida+ " text ,"
			+ cn_alcholimetro + " text);";
	private  DbHelper helper ;
	private SQLiteDatabase db ;

	public DataBaseManager( Context context ){

		helper = new DbHelper(context);
		db = helper.getWritableDatabase();
	}

	public ContentValues contenedor(String fecha , String lugar,String direccion , String nombre ,String documentoid ,String nacionalidad , String noplaca ,
			String tipo , String lugarhecho , String noagente , String zona ,String noficha , String infraccion , String bebida , String alcholimetro){
		ContentValues valores = new ContentValues();
		valores.put(cn_fecha, fecha);
		valores.put(cn_lugar, lugar);
		valores.put(cn_direccion,direccion);
		valores.put(cn_nombre, nombre);
		valores.put(cn_documentoid, documentoid);
		valores.put(cn_nacionalidad,nacionalidad);
		valores.put(cn_noplaca,noplaca);
		valores.put(cn_tipo,tipo);
		valores.put(cn_lugarhecho,lugarhecho);
		valores.put(cn_noagente,noagente);
		valores.put(cn_zona,zona);
		valores.put(cn_noficha,noficha);
		valores.put(cn_infraccion, infraccion);
		valores.put(cn_bebida,bebida);
		valores.put(cn_alcholimetro,alcholimetro);
		return valores;

	}


	public void insertar(  String fecha , String lugar,String direccion , String nombre ,String documentoid ,String nacionalidad , String noplaca ,
			String tipo , String lugarhecho , String noagente , String zona ,String noficha , String infraccion , String bebida , String alcholimetro ){

		db.insert(TABLE_NAME,null,contenedor( fecha , lugar, direccion ,  nombre , documentoid , nacionalidad ,  noplaca ,
				tipo ,  lugarhecho ,  noagente ,  zona , noficha ,  infraccion ,  bebida , alcholimetro));
	}
	public Cursor cursorregistros(){
		return db.query(TABLE_NAME, columnas, null, null, null, null, null);
	}
	
	public Cursor buscarRegistro(String nombre, String estado){
		
		if(estado == "codigo"){
			return db.query(TABLE_NAME, columnas, cn_id +"=?",new String [] {nombre}, null, null, null);
		} else if (estado == "agente"){
			return db.query(TABLE_NAME, columnas, cn_noagente +"=?",new String [] {nombre}, null, null, null);
		} else if (estado == "nombre"){
			return db.query(TABLE_NAME, columnas, cn_nombre +"=?",new String [] {nombre}, null, null, null);
		} else {
			return db.query(TABLE_NAME, columnas, cn_nombre +"=?",new String [] {nombre}, null, null, null);
		}
	}
}
