package app.comprovincias;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements Button.OnClickListener{

    public static final int SELECCIONA_PROVINCIA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=(Button)findViewById(R.id.btnSelect);
        b.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Selecciona.class);
        startActivityForResult(intent,SELECCIONA_PROVINCIA);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        TextView t=(TextView)findViewById(R.id.txtTitulo);

        if (requestCode == SELECCIONA_PROVINCIA) {
            if (resultCode == RESULT_OK) {
                // se seleccionó correctamente la provincia
                t.setText("Se ha seleccionado:\n"+data.getStringExtra("PROVINCIA"));
            }
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/


}