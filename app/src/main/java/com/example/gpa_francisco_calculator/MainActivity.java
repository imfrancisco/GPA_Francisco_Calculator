package com.example.gpa_francisco_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView myTextView;
    private EditText Credit, Grade;
    private Button addCourse, calculateGPA, erase;
    private Double totalCredit = 0.0, count = 0.0, grade =0.0, credit =0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Credit = findViewById(R.id.EditText1_courseCredit);
        Grade = findViewById(R.id.EditText1_courseGrade);
        addCourse = findViewById(R.id.Button_class1);

        calculateGPA = findViewById(R.id.Button_computeGPA);
        erase = findViewById(R.id.Button_Erase);

        myTextView = findViewById(R.id.textView_resultGPA);

        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credit = Double.parseDouble(Credit.getText().toString());
                grade = Double.parseDouble(Grade.getText().toString());

                if(Credit.length() == 0){
                    Credit.setError("Enter Course Credit Please");
                }
                else if(Grade.length() == 0){
                        Grade.setError("Enter Course Grade Please");
                }
                else {
                    count += (grade * credit);
                    totalCredit += credit;
                    Toast.makeText(getApplicationContext(), "Credit: " + credit + " " + "Grade: " + grade, Toast.LENGTH_LONG).show();

                    Credit.setText("");
                    Grade.setText("");
                }
            }
        });
        
        myTextView.setBackgroundColor(Color.WHITE);
        calculateGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result = count/totalCredit;
                myTextView.setText("GPA Results: " + result);
                if(result < 60){
                    myTextView.setBackgroundColor(Color.RED);
                }
                else if(result >= 60 && result < 80){
                    myTextView.setBackgroundColor(Color.YELLOW);
                }
                else if (result >= 80 && result <= 100){
                    myTextView.setBackgroundColor(Color.GREEN);
                }
            }
        });

        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalCredit = 0.0;
                count = 0.0;
                grade =0.0;
                credit =0.0;
                Credit.setText("");
                Grade.setText("");
                myTextView.setText("");
            }
        });
    }
}
