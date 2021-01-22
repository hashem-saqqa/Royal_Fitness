package com.example.royalfitnessmhr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class createacount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createacount);
    }

    private void registerUser() {
         EditText firstname0 = findViewById(R.id.editText5);
        final String firstname = firstname0.getText().toString();
       EditText familyname0 = findViewById(R.id.editText6);
        final String familyname = familyname0.getText().toString();
        EditText phonenumber0 = findViewById(R.id.editText15);
        final String phonenumber =phonenumber0.getText().toString();
        EditText age0 = findViewById(R.id.editText12);
        final String age =age0.getText().toString();
        EditText email0 = findViewById(R.id.editText18);
        final String email = email0.getText().toString();
      EditText gender0 = findViewById(R.id.editText17);
        final String gender = gender0.getText().toString();
        EditText dateofbirth0 = findViewById(R.id.editText7);
        final String dateofbirth = dateofbirth0.getText().toString();
        EditText weight0 = findViewById(R.id.editText20);
        final String weight = weight0.getText().toString();
        EditText address0 = findViewById(R.id.editText22);
        final String address = address0.getText().toString();
        EditText height0 = findViewById(R.id.editText21);
        final String height = height0.getText().toString();
        EditText password0 = findViewById(R.id.editText23);
        final String password = password0.getText().toString();
        EditText passwordconfirmation = findViewById(R.id.editText24);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering user ...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://192.168.0.112:888/fetnees/creat_user.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(), jsonObject.getString("done"),
                                    Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("fname", firstname);
                params.put("lastName", familyname);
                params.put("age", age);
                params.put("birthday", dateofbirth);
                params.put("gender", gender);
                params.put("phone", phonenumber);
                params.put("wight", weight);
                params.put("lenght", height);
                params.put("email", email);
                params.put("addres", address);
                params.put("pass", password);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        stringRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }
        });
    }

    public void create(View view) {
        registerUser();
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);

    }


}
