package edu.itla.proyectoprogramacion2;

import edu.itla.proyectoprogramacion2.gestores.Consulta;
import edu.itla.proyectoprogramacion2.gestores.Pagina;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActividadPrincipal extends ActionBarActivity {
	ImageButton registrar;
	ImageButton consultar;
	Intent cambiarActividad = new Intent();
	Toast mensaje;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pagina_principal);

		consultar = (ImageButton)findViewById(R.id.btn_consultar);
		consultar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mensaje = Toast.makeText(ActividadPrincipal.this, "Consultor de multas.", Toast.LENGTH_SHORT);
				mensaje.show();
				cambiarActividad.setClass(getApplicationContext(), Consulta.class);
				startActivity(cambiarActividad);
			}
		});	

		registrar = (ImageButton)findViewById(R.id.btn_registrar);
		registrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mensaje = Toast.makeText(ActividadPrincipal.this, "Bienvenido al registro de multas.", Toast.LENGTH_SHORT);
				mensaje.show();
				cambiarActividad.setClass(getApplicationContext(), Pagina.class);
				startActivity(cambiarActividad);
			}
		});
	}
}
