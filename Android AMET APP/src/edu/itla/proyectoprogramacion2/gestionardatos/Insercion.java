package edu.itla.proyectoprogramacion2.gestionardatos;

import edu.itla.proyectoprogramacion2.R;
import edu.itla.proyectoprogramacion2.bd.DataBaseManager;
import android.app.Activity;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;

public class Insercion extends Activity {
	public Insercion(){
		
	}
	EditText fechaCita = (EditText) findViewById(R.id.fechaCitaCharla);
	EditText lugarCita= (EditText) findViewById(R.id.txtLugarCita);
	EditText direccionCita = (EditText) findViewById(R.id.txtDireccion);
	EditText nombreConductor = (EditText) findViewById(R.id.txtNombreMultado);
	EditText documentacion = (EditText) findViewById(R.id.txtDocumento);
	EditText nacionalidad = (EditText) findViewById(R.id.txtNacionalidad);
	EditText placa = (EditText) findViewById(R.id.txtPlaca);
	EditText tipoVehiculo = (EditText) findViewById(R.id.txtTipo);
	EditText lugarHecho = (EditText) findViewById(R.id.txtLugarDelHecho);
	EditText noAgente = (EditText) findViewById(R.id.txtAgente);
	EditText zona = (EditText) findViewById(R.id.txtZona);
	EditText noGrua = (EditText) findViewById(R.id.txtGrua);
	EditText infraccion = (EditText) findViewById(R.id.txtInfraccion);
	Switch bebida = (Switch) findViewById(R.id.switchAlcohol);
	RadioGroup alcohoemia = (RadioGroup) findViewById(R.id.radioOpcion);
    
    public void insertar(){
    	String alcohol = "";
    	String estado= "";
    	if (bebida.isChecked()){
    		alcohol = (String) bebida.getTextOn();
    	} else {
    		alcohol = (String) bebida.getTextOff();
    	}
    	if (alcohoemia.getCheckedRadioButtonId() == R.id.radioNaranjaRojo){
    		estado = "Parpadea en naranja y rojo.";
    	} else if (alcohoemia.getCheckedRadioButtonId() == R.id.radioNaranjaVerde){
    		estado = "Colores naranja y verde.";
    	}else if (alcohoemia.getCheckedRadioButtonId() == R.id.radioRojoVerde){
    		estado = "Parpadea en rojo y verde";
    	} else {
    		estado = "Color verde.";
    	}
    	
    	DataBaseManager manager = new DataBaseManager(getApplicationContext());
    	manager.insertar(fechaCita.getText().toString(), lugarCita.getText().toString(), direccionCita.getText().toString(), nombreConductor.getText().toString(), documentacion.getText().toString(),
    			nacionalidad.getText().toString(), placa.getText().toString(), tipoVehiculo.getText().toString(), lugarHecho.getText().toString(), noAgente.getText().toString(), zona.getText().toString(), 
    			noGrua.getText().toString(), infraccion.getText().toString(), alcohol , estado);
    }
}
