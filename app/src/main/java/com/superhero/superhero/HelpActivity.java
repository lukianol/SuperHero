package com.superhero.superhero;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.amazonaws.mobileconnectors.apigateway.ApiClientFactory;
import com.superhero.api_client.SuperHeroClient;
import com.superhero.api_client.model.NewRequest;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        final EditText titleEntered = findViewById(R.id.title_entered);
        final EditText descriptionEntered = findViewById(R.id.description_entered);
        final HelpActivity this_ = this;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {



                            ApiClientFactory factory = new ApiClientFactory();
                            SuperHeroClient client = factory.build(SuperHeroClient.class);
                            NewRequest request = new NewRequest();
                            request.setTitle(titleEntered.getText().toString());
                            request.setDescription(descriptionEntered.getText().toString());
                            request.setRequestorId(new IdentityManager().getIdentityId());
                            client.requestPost(request);
                        } catch (Throwable e) {
                            e.printStackTrace();

                            this_.runOnUiThread(new Runnable() {
                                public void run() {
                                    Toast.makeText(this_.getBaseContext(), "Your request couldn't be submitted", Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                    }
                });

                thread.start();

            }
        });
    }

}
