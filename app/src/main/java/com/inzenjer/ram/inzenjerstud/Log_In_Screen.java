package com.inzenjer.ram.inzenjerstud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Log_In_Screen extends AppCompatActivity {
    EditText name,email,password;
    String php,android,java,embedded,marketting,net,sName,sEmail,sPassword,HR;
    CheckBox Cphp,Candroid,Cjava,Cembedded,Cmarketting,Cnet,Chr;
    Button Register ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in__screen);
        name = findViewById(R.id.Register_name);
        email = findViewById(R.id.Register_email);
        password = findViewById(R.id.Register_password);
        Candroid = findViewById(R.id.department_selection_android);
        Cjava = findViewById(R.id.department_selection_java);
        Cphp = findViewById(R.id.department_selection_php);
        Cembedded = findViewById(R.id.department_selection_embedded);
        Cmarketting = findViewById(R.id.department_selection_marketing);
        Cnet = findViewById(R.id.department_selection_net);
        Chr = findViewById(R.id.department_selection_HR);
        Register = findViewById(R.id.register_register_button);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sName = name.getText().toString();
                sEmail = email.getText().toString();
                sPassword = password.getText().toString();
                if (Cjava.isChecked()) {
                    java = "1";
                }
                if (Cphp.isChecked()) {
                    php = "1";
                }
                if (Cembedded.isChecked())
                {
                    embedded ="1";
                }
                if (Cmarketting.isChecked())
                {
                    marketting ="1";
                }
                if (Cnet.isChecked())
                {
                    net ="1";
                }
                if (Chr.isChecked())
                {
                    HR ="1";
                }
                if (Candroid.isChecked())
                {
                    android ="1";
                }
                register();
            }
        });
    }

    private void register() {
        String uurl = " ";
        RequestQueue v1 = Volley.newRequestQueue(this);

        StringRequest st = new StringRequest(Request.Method.POST, uurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Log_In_Screen.this, response, Toast.LENGTH_SHORT).show();
                try {
                    JSONObject js = new JSONObject(response);
                    JSONObject mj = js.getJSONObject("mn");
                    String status = mj.getString("status");
                    Toast.makeText(Log_In_Screen.this, status, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    Toast.makeText(Log_In_Screen.this, e.toString(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


            }
        },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Log_In_Screen.this, error.toString(), Toast.LENGTH_SHORT).show();
                }

            }){
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("name", sName);
                params.put("password", sPassword);
                params.put("email", sEmail);
                params.put("php", php);
                params.put("android", android);
                params.put("java", java);
                params.put("embedded", embedded);
                params.put("marketting",marketting);
                params.put("net",net);
                params.put("hr",HR);

                return params;
            }
        };
        v1.add(st);
    }
}
