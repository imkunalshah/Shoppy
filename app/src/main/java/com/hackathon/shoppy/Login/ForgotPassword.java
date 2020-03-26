package com.hackathon.shoppy.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.hackathon.shoppy.R;
import com.shashank.sony.fancytoastlib.FancyToast;

public class ForgotPassword extends AppCompatActivity {
EditText email;
Button resetpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        email = findViewById(R.id.email);
        resetpass = findViewById(R.id.resetpass);
        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().trim().isEmpty()){
                    email.requestFocus();
                    email.setError("Please Enter Email");
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches()){
                    email.setError("Please Enter A Valid Email.");
                    email.requestFocus();
                    return;
                }

                try {
                    FirebaseAuth.getInstance().sendPasswordResetEmail(email.getText().toString().trim())
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        FancyToast.makeText(getApplicationContext(),"Reset Email Sent",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                                        Intent intent = new Intent(ForgotPassword.this,Login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else {
                                        FancyToast.makeText(getApplicationContext(),"User Does Not Exist",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                                    }
                                }
                            });
                }catch (Exception e){
                    FancyToast.makeText(getApplicationContext(),e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }


            }
        });
    }
}
