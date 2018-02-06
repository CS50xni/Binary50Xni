package com.example.cs50xni.prueba;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;


import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {

    String address = null;
    int num=0;
    private ProgressDialog progress;
    BluetoothAdapter myBluetooth = null;
    BluetoothSocket btSocket = null;
    private boolean isBtConnected = false;
    static final UUID myUUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");


    TextView tex;
    ImageView lamp1, lamp2, lamp3, lamp4, lamp5, lamp6, lamp7, lamp8;
    boolean var = false, var1 = false;
    boolean var2 = false, var3 = false, var4 =false, var5 =false, var6 =false, var7 =false, var8 =false  ;

    int total=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent newint = getIntent();
        address = newint.getStringExtra(DeviceList.EXTRA_ADDRESS); //recivimos la mac address obtenida en la actividad anterior

        Bundle bundle = getIntent().getExtras();
        num = bundle.getInt(DeviceList.numeros);
        //textos = bundle.getBoolean(DeviceList.textos);

        lamp1=  findViewById(R.id.lampara1);
        lamp2=  findViewById(R.id.lampara2);
        lamp3=  findViewById(R.id.lampara3);
        lamp4=  findViewById(R.id.lampara4);
        lamp5=  findViewById(R.id.lampara5);
        lamp6=  findViewById(R.id.lampara6);
        lamp7=  findViewById(R.id.lampara7);
        lamp8=  findViewById(R.id.lampara8);



        new ConnectBT().execute(); //Call the class to connect


    }

    public void OnclickButtonListener(View view)
    {
        if(!var )
                {
                    lamp1.setImageResource(R.drawable.led);
                    turnOnLed1();
                    total = total + 1;

                    if (total == num)
                    {
                        Ganastes();
                        Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
                    }
                    var = true;
                }
            else
                {
                    lamp1.setImageResource(R.drawable.led_a);
                    turnOffLed1();
                    total = total - 1;
                    if (total == num)
                    {
                        Ganastes();
                        Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
                    }
                    var = false;
                }
    }//Funcion para encerder la led 1

    public void OnclickButtonListener1(View view)
    {

        if(!var1 )
        {
            lamp2.setImageResource(R.drawable.led);
            turnOnLed2();
            total = total + 2;


            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var1 = true;
        }
        else
        {
            lamp2.setImageResource(R.drawable.led_a);
            turnOffLed2();
            total = total - 2;

            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var1 = false;
        }
    }//Funcion para encerder la led 2

    public void OnclickButtonListener2(View view)
    {

        if(!var2 )
        {
            lamp3.setImageResource(R.drawable.led);
            turnOnLed3();
            total = total + 4;

            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var2 = true;
        }
        else
        {
            lamp3.setImageResource(R.drawable.led_a);
            turnOffLed3();
            total = total - 4 ;

            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var2 = false;
        }
    }//Funcion para encerder la led 3

    public void OnclickButtonListener3(View view)
    {

        if(!var3 )
        {
            lamp4.setImageResource(R.drawable.led);
            turnOnLed4();
            total = total + 8;


            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var3 = true;
        }
        else
        {
            lamp4.setImageResource(R.drawable.led_a);
            turnOffLed4();
            total = total - 8;


            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var3 = false;

        }

    }//Funcion para encerder la led 4


    public void OnclickButtonListener4(View view)
    {
        if(!var4 )
        {
            lamp5.setImageResource(R.drawable.led);
            turnOnLed5();
            total = total + 16;


            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var4 = true;
        }
        else
        {
            lamp5.setImageResource(R.drawable.led_a);
            turnOffLed5();
            total = total - 16;


            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var4 = false;
        }
    }//Funcion para encerder la led 5

    public void OnclickButtonListener5(View view)
    {
        if(!var5 )
        {
            lamp6.setImageResource(R.drawable.led);
            turnOnLed6();
            total = total + 32;


            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var5 = true;
        }
        else
        {
            lamp6.setImageResource(R.drawable.led_a);
            turnOffLed6();
            total = total - 32;


            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var5 = false;
        }
    }//Funcion para encerder la led 6


    public void OnclickButtonListener6(View view)
    {
        if(!var6 )
        {
            lamp7.setImageResource(R.drawable.led);
            turnOnLed7();
            total = total + 64;
            var6 = true;

            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
        }
        else
        {
            lamp7.setImageResource(R.drawable.led_a);
            turnOffLed7();
            total = total - 64;
            var6 = false;

            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
        }
    }//Funcion para encerder la led 7


    public void OnclickButtonListener7(View view)
    {
        if(!var7 )
        {
            lamp8.setImageResource(R.drawable.led);
            turnOnLed8();
            total = total + 128;


            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var7 = true;
        }
        else
        {
            lamp8.setImageResource(R.drawable.led_a);
            turnOffLed8();
            total = total - 128;


            if (total == num)
            {
                Ganastes();
                Toast.makeText(MainActivity.this, "Felicidades Ganastes", Toast.LENGTH_SHORT).show();//impriminos el resultado
            }
            var7 = false;
        }
    }//Funcion para encerder la led 8



    private void Disconnect()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.close();
            }
            catch (IOException e)
            { msg("Error");}
        }
        finish();

    }

    private void turnOffLed1()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("2l".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOnLed1()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("2h".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOffLed2()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("3l".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOnLed2()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("3h".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOffLed3()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("4l".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOnLed3()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("4h".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }


    private void turnOffLed4()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("5l".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOnLed4()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("5h".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOffLed5()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("6l".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOnLed5()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("6h".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOffLed6()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("7l".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOnLed6()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("7h".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOffLed7()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("8l".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOnLed7()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("8h".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOffLed8()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("9l".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void turnOnLed8()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("9h".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }


    private void Ganastes()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("1".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }

    private void ResetLed()
    {
        if (btSocket!=null)
        {
            try
            {
                btSocket.getOutputStream().write("0".toString().getBytes());
            }
            catch (IOException e)
            {
                msg("Error");
            }
        }
    }


    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
    }

    private class ConnectBT extends AsyncTask<Void, Void, Void>  // UI thread
    {
        private boolean ConnectSuccess = true;

        @Override
        protected void onPreExecute()
        {
            progress = ProgressDialog.show(MainActivity.this, "Connectando...", "Espere por favor!!!");
        }

        @Override
        protected Void doInBackground(Void... devices)
        {
            try
            {
                if (btSocket == null || !isBtConnected)
                {
                    myBluetooth = BluetoothAdapter.getDefaultAdapter();
                    BluetoothDevice dispositivo = myBluetooth.getRemoteDevice(address);//conectamos al dispositivo y chequeamos si esta disponible
                    btSocket = dispositivo.createInsecureRfcommSocketToServiceRecord(myUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    btSocket.connect();
                }
            }
            catch (IOException e)
            {
                ConnectSuccess = false;
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);

            if (!ConnectSuccess)
            {
                msg("Conexión Fallida");
                finish();
            }
            else
            {
                msg("Conectado");
                isBtConnected = true;
            }
            progress.dismiss();
        }
    }


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        ResetLed();
        Disconnect();
        Intent intent = new Intent(MainActivity.this, DeviceList.class);
        startActivity(intent);
        finish();
    }




}//Fin clase
