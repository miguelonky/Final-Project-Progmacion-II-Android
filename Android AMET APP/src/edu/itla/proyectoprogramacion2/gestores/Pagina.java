package edu.itla.proyectoprogramacion2.gestores;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import edu.itla.proyectoprogramacion2.ActividadPrincipal;
import edu.itla.proyectoprogramacion2.R;
import edu.itla.proyectoprogramacion2.bd.DataBaseManager;
import edu.itla.proyectoprogramacion2.gestionardatos.Insercion;

public class Pagina extends Activity {


	SectionsPagerAdapter adaptadorPagina;
	ViewPager vistaPagina;
	private static final String ARG_SECTION_NUMBER = "section_number";
	Button multar;


	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pagina);

		adaptadorPagina = new SectionsPagerAdapter(getFragmentManager());
		vistaPagina = (ViewPager) findViewById(R.id.pager);
		vistaPagina.setAdapter(adaptadorPagina);
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int posicion) {
			if(posicion == 0){
				return PrimerFragmento.newInstance(posicion);
			} else if (posicion == 1) {
				return SegundoFragmento.newInstance(posicion);
			} else {
				return TercerFragmento.newInstance(posicion);
			}
		}

		@Override
		public int getCount() {
			return 3;
		}

	}

	public static class PrimerFragmento extends Fragment {

		public static PrimerFragmento newInstance(int numeroSeccion) {
			PrimerFragmento primerFragmento = new PrimerFragmento();
			Bundle instancia = new Bundle();
			instancia.putInt(ARG_SECTION_NUMBER, numeroSeccion);
			primerFragmento.setArguments(instancia);
			return primerFragmento;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.actividad_registro,
					container, false);

			Switch nacionalidad = (Switch)rootView.findViewById(R.id.switchNacionalidad);
			final EditText txtNacionalidad = (EditText)rootView.findViewById(R.id.txtNacionalidad);
			final Switch licencia = (Switch)rootView.findViewById(R.id.switchLicencia);
			final TextView documento = (TextView) rootView.findViewById(R.id.documento);
			licencia.setEnabled(false);
			documento.setText("No. Cédula:");

			nacionalidad.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked){
						txtNacionalidad.setEnabled(false);
						txtNacionalidad.setText("Dominicano");
						licencia.setEnabled(true);
					} else {
						txtNacionalidad.setEnabled(true);
						txtNacionalidad.setText("");
						licencia.setEnabled(false);
						documento.setText("Doc. Identidad:");
					}

				}
			});

			licencia.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if(isChecked){
						documento.setText("No. Licencia:");
					} else {
						documento.setText("No. Cédula:");
					}
				}
			});
			return rootView;
		}
	}

	public static class SegundoFragmento extends Fragment {


		public static SegundoFragmento newInstance(int numeroSeccion) {
			SegundoFragmento segundoFragmento = new SegundoFragmento();
			Bundle isntancia = new Bundle();
			isntancia.putInt(ARG_SECTION_NUMBER, numeroSeccion);
			segundoFragmento.setArguments(isntancia);
			return segundoFragmento;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_regisrto2,
					container, false);

			final Switch grua = (Switch) rootView.findViewById(R.id.grua);
			final EditText txtGrua = (EditText) rootView.findViewById(R.id.txtGrua);
			txtGrua.setEnabled(false);

			grua.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked){
						txtGrua.setEnabled(true);
					} else {
						txtGrua.setEnabled(false);
					}
				}
			});

			return rootView;
		}
	}

	public static class TercerFragmento extends Fragment {

		public static TercerFragmento newInstance(int numeroSeccion) {
			TercerFragmento tercerFragmento = new TercerFragmento();
			Bundle isntancia = new Bundle();
			isntancia.putInt(ARG_SECTION_NUMBER, numeroSeccion);
			tercerFragmento.setArguments(isntancia);
			return tercerFragmento;
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_registro3,
					container, false);

			Button botonMultar = (Button) rootView.findViewById(R.id.multar);
			botonMultar.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					Toast mensaje = Toast.makeText(getActivity().getApplicationContext(),"Multa guardada correctamente." , Toast.LENGTH_SHORT);
					Intent cambioActivity = new Intent(getActivity().getApplicationContext(), ActividadPrincipal.class);
					mensaje.show();
					DataBaseManager dbmanager = new DataBaseManager(getActivity().getApplicationContext());

					Insercion insercion = new Insercion();
					insercion.insertar();

					startActivity(cambioActivity);
				}
			});
			return rootView;
		}
	}
}
