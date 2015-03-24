package edu.itla.proyectoprogramacion2.gestores;

import edu.itla.proyectoprogramacion2.R;
import edu.itla.proyectoprogramacion2.bd.DataBaseManager;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

public class Consulta extends Activity implements View.OnClickListener {

	private DataBaseManager  manager;
	private EditText buscar;
	private ListView lista;
	private SimpleCursorAdapter adapter ;
	private Cursor cursor;
	private  ImageButton btnbuscar;
	private RadioGroup radioGrupo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad_consuta);

		manager = new DataBaseManager(this);
		lista = (ListView) findViewById(R.id.lista);
		buscar = (EditText) findViewById(R.id.txtBusqueda);
		btnbuscar = (ImageButton) findViewById(R.id.btn_buscar);

		btnbuscar.setOnClickListener(this);

		@SuppressWarnings("static-access")
		String[] from = new String[]{manager.cn_id,manager.cn_fecha, manager.cn_lugar, manager.cn_direccion, manager.cn_nombre,	manager.cn_documentoid,
			manager.cn_nacionalidad, manager.cn_noplaca, manager.cn_tipo, manager.cn_lugarhecho, manager.cn_noagente, manager.cn_zona,	manager.cn_noficha,  
			manager.cn_infraccion,  manager.cn_bebida, 	manager.cn_alcholimetro  };

		int[] to = new int[]{R.id.texto1,R.id.texto2 ,R.id.texto3,R.id.texto4,R.id.texto5,R.id.texto6,R.id.texto7,R.id.texto8,R.id.texto9,R.id.texto10,R.id.texto11,R.id.texto12,R.id.texto13,R.id.texto14,R.id.texto15,R.id.texto16};

		cursor = manager.cursorregistros();
		adapter = new SimpleCursorAdapter(this, R.layout.modelodedatos, cursor, from, to, 0);
		lista.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String estado="";
		radioGrupo = (RadioGroup) findViewById(R.id.radioOpcion);


		if(v.getId()== R.id.btn_buscar){
			if(radioGrupo.getCheckedRadioButtonId() == R.id.radioCodigo){
				estado = "codigo";
			} else if (radioGrupo.getCheckedRadioButtonId() == R.id.radioNombre){
				estado = "nombre";
			} else if (radioGrupo.getCheckedRadioButtonId() == R.id.radioAgente){
				estado = "agente";
			}
			
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		Cursor cursor2 = manager.buscarRegistro(buscar.getText().toString(), estado);
		adapter.changeCursor(cursor2);
				}
			}
		}
