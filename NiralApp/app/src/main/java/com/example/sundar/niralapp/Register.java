package com.example.sundar.niralapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sundar on 8/15/2017.
 */
public class Register extends Activity {
    private Button btn_register, btn_login;
    private EditText inputName,inputEmail,inputPhone,inputPassword,inputRepass;
    private TextInputLayout inputLayoutName,inputLayoutPhone,inputLayoutEmail,inputLayoutRepass,inputLayoutPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        inputName   = (EditText) findViewById(R.id.reg_input_name);
        inputEmail = (EditText) findViewById(R.id.reg_input_email);
        inputPassword   = (EditText) findViewById(R.id.reg_input_password);
        inputPhone = (EditText) findViewById(R.id.reg_input_phone);
        inputRepass   = (EditText) findViewById(R.id.reg_input_repass);
        inputLayoutName = (TextInputLayout) findViewById(R.id.reg_input_layout_name);
        inputLayoutPhone = (TextInputLayout) findViewById(R.id.reg_input_layout_phone);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.reg_input_layout_email);
        inputLayoutRepass = (TextInputLayout) findViewById(R.id.reg_input_layout_repass);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.reg_input_layout_pass);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
            private void submitForm() {
                if(!validateName()){
                    return;
                }
                if (!validateEmail()) {
                    return;
                }
                if(!validatePhone()){
                    return;
                }
                if (!validatePassword()) {
                    return;
                }
                if(!validateRepassword()){
                    return;
                }
                if(!validatePass()){
                    return;
                }
                Toast.makeText(getApplicationContext(), "Register Successfull", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Register.this, Login.class);
                startActivity(i);
            }
        });
    }
    private boolean validateName(){
        if(inputName.getText().toString().trim().isEmpty()){
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validatePhone(){
        if(inputPhone.getText().toString().trim().isEmpty()){
            inputLayoutPhone.setError(getString(R.string.err_msg_phone));
            requestFocus(inputPhone);
            return false;
        } else {
            inputLayoutPhone.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validateRepassword(){
        if(inputRepass.getText().toString().trim().isEmpty()){
            inputLayoutRepass.setError(getString(R.string.err_msg_password));
            requestFocus(inputRepass);
            return false;
        } else {
            inputLayoutRepass.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }
        return true;
    }
    private boolean validatePass() {
        String pass = inputPassword.getText().toString().trim();
        String repass = inputRepass.getText().toString().trim();
        Toast.makeText(getApplicationContext(), pass, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), repass, Toast.LENGTH_SHORT).show();
        if (pass == repass) {
            Toast.makeText(getApplicationContext(), "Passwords are mismatching!!!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }
        return true;
    }
    private  boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
