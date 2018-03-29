 package com.example.mahsa_pc.form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.StringBufferInputStream;
import java.util.concurrent.ExecutionException;
import java.util.logging.ErrorManager;


 public class MainActivity extends AppCompatActivity {

     private TextView ErrorMessage;
     private Button Submit;
     private EditText NameInput;
     private EditText StudentNumberInput;
     private EditText EnteranceYearInput;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ErrorMessage = (TextView) findViewById(R.id.errorMessage);
        Submit =(Button)findViewById(R.id.submitButton);

        NameInput = (EditText)findViewById(R.id.nameInput);
        StudentNumberInput = (EditText)findViewById(R.id.studentNumberInput);
        EnteranceYearInput = (EditText)findViewById(R.id.entranceYearInput);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ErrorMessage.setText("");
                CheckName();
                CheckStudentNumberInput();
                ChekentranceYearInput();


            }
        });

    }

    boolean CheckName(){
        char first = NameInput.getText().charAt(0);
        Log.d("first",Character.toString(first));
        if(first != Character.toUpperCase(first) ) {
            Log.d("Error", "name is invalid\n");
            ErrorMessage.setText("name is invalid\n");
            return false;
//        }else
//            if ( CheckStudentNumberInput() && ChekentranceYearInput())
//                ErrorMessage.setText("You submit successfully\n");
//        else
//            return false;
        }else
         return true;
    }

    boolean CheckStudentNumberInput(){
        if((StudentNumberInput.getText().length() > 8) && (!CheckName()))
        {
            Log.d("Error",ErrorMessage.getText() + "1student number is invalid\n");
            ErrorMessage.setText(ErrorMessage.getText() + "student number is invalid\n");
            return false;
        }
            else if(StudentNumberInput.getText().length() > 8){
            Log.d("Error",ErrorMessage.getText() + "2student number is invalid\n");
                    ErrorMessage.setText(ErrorMessage.getText()+ "student number is invalid\n");
            return false;

        }else
            return true;
    }

    boolean ChekentranceYearInput(){

        char first_number = EnteranceYearInput.getText().charAt(0);
        char second_number = EnteranceYearInput.getText().charAt(1);

        if ((EnteranceYearInput.getText().length() > 2) && (!CheckName()) && (!CheckStudentNumberInput()))
            {
                Log.d("Error",ErrorMessage.getText() + "1entrance year is invalid\n");

                        ErrorMessage.setText(ErrorMessage.getText() + "entrance year is invalid\n");
            return false;
            }
//            else if
//            (EnteranceYearInput.getText().length() > 2){
//            Log.d("Error",ErrorMessage.getText() + "2entrance year is invalid\n");
//
//                    ErrorMessage.setText(ErrorMessage.getText() + "entrance year is invalid\n");
//                return false;}
            else if((first_number != StudentNumberInput.getText().charAt(0)) &&
                    (second_number != StudentNumberInput.getText().charAt(1)))  {
            Log.d("Error",ErrorMessage.getText() + "3entrance year is invalid\n");

                    ErrorMessage.setText(ErrorMessage.getText() + "entrance year is invalid\n");
                return false;
        }else
            return true;
    }

}
