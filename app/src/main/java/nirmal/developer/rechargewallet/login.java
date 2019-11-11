package nirmal.developer.rechargewallet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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

public class login extends AppCompatActivity {
    EditText usrname2, pass2;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usrname2=findViewById(R.id.usrnamelogin);
        pass2=findViewById(R.id.passlogin);
        login=findViewById(R.id.log);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usrname2.getText().toString().isEmpty() || pass2.getText().toString().isEmpty()) {
                    Toast.makeText(login.this, "field is empty", Toast.LENGTH_SHORT).show();
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "intown-film.000webhostapp.com/msg.php",
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
//If we are getting success from server

                                    Toast.makeText(login.this, response, Toast.LENGTH_LONG).show();
//Intent iso= new Intent(getApplicationContext(),HOME_page.class);
//startActivity(iso);
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


                            params.put("username2", usrname2.getText().toString());
                            params.put("pass2", pass2.getText().toString());


//returning parameter
                            return params;
                        }
                    };
//Adding the string request to the queue
                    RequestQueue requestQueue = Volley.newRequestQueue(login.this);
                    requestQueue.add(stringRequest);
                } else {
                    Toast.makeText(login.this, "EMPTY VALUES ...", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}