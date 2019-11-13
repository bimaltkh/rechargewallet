package nirmal.developer.rechargewallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
EditText name,DOB,usrname,userid,pass,conpass;
Button button,but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        DOB=findViewById(R.id.dob);
        userid=findViewById(R.id.userID);
        usrname=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        conpass=findViewById(R.id.conpass);
        button=findViewById(R.id.reg);
        but=findViewById(R.id.skipbut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (!(name.getText().toString().isEmpty() || DOB.getText().toString().isEmpty() || userid.getText().toString().isEmpty() || usrname.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || conpass.getText().toString().isEmpty() && pass.getText().equals(conpass.getText().toString())) )
                    {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://mature-railroads.000webhostapp.com/RechargeWallet/mainactivity.php",
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
//If we are getting success from server

                                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();

Intent iso= new Intent(getApplicationContext(),login.class);
startActivity(iso);
                                        try {
                                            JSONArray jsonArray = new JSONArray(response);
                                            for (int i = 0; i < jsonArray.length(); i++) {
                                                JSONObject json_obj = jsonArray.getJSONObject(i);

                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                                    }

                                }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
//Adding parameters to request

                                params.put("name", name.getText().toString());
                                params.put("DOB", DOB.getText().toString());
                                params.put("ID", userid.getText().toString());
                                params.put("username", usrname.getText().toString());
                                params.put("pass", pass.getText().toString());


//returning parameter
                                return params;
                            }
                        };
//Adding the string request to the queue
                        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                        requestQueue.add(stringRequest);
                    } else {
                    Toast.makeText(MainActivity.this,"not matched",Toast.LENGTH_SHORT).show();
                }
            }
        });
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent isa=new Intent(getApplicationContext(),login.class);
                startActivity(isa);
            }
        });
    }
}
