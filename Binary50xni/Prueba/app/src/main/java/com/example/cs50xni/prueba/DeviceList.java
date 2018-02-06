package com.example.cs50xni.prueba;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class DeviceList extends AppCompatActivity {

    Button btnVin;
    ListView listaDispositivos;
    TextView txt;
    int num;
    CheckBox box;
    TextInputEditText txtnumero;
    boolean check = false;

    private BluetoothAdapter myBluetooth = null;

    public static String EXTRA_ADDRESS = "device_address";
    public  static String numeros ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);


        listaDispositivos = findViewById(R.id.listview);
        txt = findViewById(R.id.text);
        txtnumero = findViewById(R.id.num_text);
        box = findViewById(R.id.check);


        myBluetooth = BluetoothAdapter.getDefaultAdapter();

        if (myBluetooth == null) {
            //Mostramos un mensaje, indicando al usuario que no tiene conexión bluetooth disponible
            Toast.makeText(getApplicationContext(), "Bluetooth no disponible", Toast.LENGTH_LONG).show();

            //finalizamos la aplicación
            finish();
        } else if (!myBluetooth.isEnabled()) {
            //Preguntamos al usuario si desea encender el bluetooth
            Intent turnBTon = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(turnBTon, 1);


        }

     btnVin = findViewById(R.id.comenzar);


        btnVin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boton();
            }
        });

    }



    public void boton()
    {

        String nu="";

        if (txtnumero.getText().toString().trim().length()>0)
        {
            nu = txtnumero.getText().toString();


            num = Integer.parseInt(nu);
            txtnumero.setEnabled(false);


            if(box.isChecked())
            {
                check = true;
            }



            String texto = txt.getText().toString();
            if (texto.equals(""))
            {
                txt.setText("Dispositivos Vinculados");
            }
            listaDispositivosvinculados();
        }

        else
            {
            Toast.makeText(getApplicationContext(), "Ingrese el numero", Toast.LENGTH_SHORT).show();
        }


        }



    private void listaDispositivosvinculados()
    {
        Set<BluetoothDevice> dispVinculados;
        dispVinculados = myBluetooth.getBondedDevices();
        ArrayList list = new ArrayList();

        if (dispVinculados.size()>0)
        {
            for(BluetoothDevice bt : dispVinculados)
            {
                list.add(bt.getName() + "\n" + bt.getAddress()); //Obtenemos los nombres y direcciones MAC de los disp. vinculados
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No se han encontrado dispositivos vinculados", Toast.LENGTH_LONG).show();
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        listaDispositivos.setAdapter(adapter);
        listaDispositivos.setOnItemClickListener(myListClickListener);

    }

    private AdapterView.OnItemClickListener myListClickListener = new AdapterView.OnItemClickListener()
    {
        public void onItemClick (AdapterView<?> av, View v, int arg2, long arg3)
        {
            // Get the device MAC address, the last 17 chars in the View
            String info = ((TextView) v).getText().toString();
            String address = info.substring(info.length() - 17);


            if (check == true)
            {
                Intent intent = new Intent(DeviceList.this,Sin_etiquetas.class);
                intent.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
                intent.putExtra(numeros,num);
                startActivity(intent);
                finish();
            }
            else
            {
                // Make an intent to start next activity.
                Intent i = new Intent(DeviceList.this, MainActivity.class);

                //Change the activity.
                i.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
                i.putExtra(numeros,num);
                startActivity(i);
                finish();
            }


        }
    };

    @Override
    public void onBackPressed()
    {
        finish();
    }


}
