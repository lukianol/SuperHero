package com.superhero.superhero;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.amazonaws.http.HttpMethodName;
import com.amazonaws.mobileconnectors.apigateway.ApiClientFactory;
import com.amazonaws.mobileconnectors.apigateway.ApiRequest;
import com.superhero.clientsdk.HelpApiClient;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        final EditText titleEntered = findViewById(R.id.title_entered);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                            ApiClientFactory factory = new ApiClientFactory();
                            HelpApiClient client = factory.build(HelpApiClient.class);
                            ApiRequest request = new ApiRequest();
                            request.withHttpMethod(HttpMethodName.POST);
                            request.addHeader("Test", titleEntered.getText().toString());
                            request.withPath("/");
                            client.execute(request);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

                thread.start();

            }
        });
    }

}
