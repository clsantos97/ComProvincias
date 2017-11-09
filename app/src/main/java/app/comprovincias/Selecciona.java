package app.comprovincias;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import android.view.View;



public class Selecciona extends AppCompatActivity implements EditText.OnKeyListener{
//public class Selecciona extends ListActivity implements ListView.OnItemClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecciona);


        EditText et = (EditText)findViewById(R.id.etProvincia);
        et.setOnKeyListener(this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        InputMethodManager im = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        im.showSoftInput(et, 0);
/*        InputMethodManager inputmethodmgr= (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputmethodmgr.hideSoftInputFromWindow(et.getWindowToken(), 0);*/

    }

    @Override
    public boolean onKey(View view, int in, KeyEvent keyEvent) {
        if(in == KeyEvent.KEYCODE_ENTER) {
            Intent i = new Intent();
            EditText et = (EditText) findViewById(R.id.etProvincia);
            if(!et.getText().equals("") && et.getText()!=null ){
                i.putExtra("PROVINCIA", et.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }

        }
        return false;
    }
}

