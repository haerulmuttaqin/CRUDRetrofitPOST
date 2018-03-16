package com.haerul.crudretrofitpost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorActivity extends AppCompatActivity {

    private ApiInterface apiInterface;

    private EditText name, email;
    private Button bSimpan;

    String extr_id;
    String extr_name;
    String extr_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        Intent i = getIntent();
        extr_id = i.getStringExtra("id");
        extr_name = i.getStringExtra("name");
        extr_email = i.getStringExtra("email");

        name = findViewById(R.id.input_name);
        email = findViewById(R.id.input_email);
        bSimpan = findViewById(R.id.bSimpan);

        kondisi(extr_id);

    }

    private void insertUser() {

        String sname = name.getText().toString();
        String semail = email.getText().toString();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Contacts> call = apiInterface.insertUser(sname, semail);
        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                String value = response.body().getValue();
                String message = response.body().getMassage();
                if (value.equals("1")){
                    Toast.makeText(EditorActivity.this, message, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EditorActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                Toast.makeText(EditorActivity.this, "Jaringan Error! "+ t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void editUser() {

        String sid = extr_id;
        String sname = name.getText().toString();
        String semail = email.getText().toString();

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<Contacts> call = apiInterface.editUser(sid, sname, semail);
        call.enqueue(new Callback<Contacts>() {
            @Override
            public void onResponse(Call<Contacts> call, Response<Contacts> response) {
                String value = response.body().getValue();
                String message = response.body().getMassage();
                if (value.equals("1")){
                    Toast.makeText(EditorActivity.this, message, Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(EditorActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Contacts> call, Throwable t) {
                Toast.makeText(EditorActivity.this, "Jaringan Error! "+ t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void kondisi(String kond){

        if (kond == null){

            bSimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    insertUser();
                }
            });

        } else {

            name.setText(extr_name);
            email.setText(extr_email);

            bSimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editUser();
                }
            });
        }
    }
}
