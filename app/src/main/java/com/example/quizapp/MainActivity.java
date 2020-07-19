package com.example.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();
    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    String s;
    SharedPreferences sp;
    SharedPreferences.Editor rs;

    private String mAnswer;
    private  int mScore = 0;
    private int mQuestionNumber = 0;
    private int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);
        sp = getSharedPreferences("pqr",MODE_PRIVATE);
        rs = sp.edit();
        updateQuestion();

        //button listener
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;

                if(count <= 5){
                if(mButtonChoice1.getText() == mAnswer){

                     mScore = mScore+1;
                    updateScore(mScore);
                    if(mQuestionNumber!=5){

                    updateQuestion();}
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    if(mQuestionNumber!=5){

                        updateQuestion();}

                }
            }
            else{ s = mScoreView.getText().toString();
                rs.putString("poo",s);
                rs.commit();
                Intent ob = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(ob);}

            }
        });
        //end

        //button listener
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count <= 5){

                    if(mButtonChoice2.getText() == mAnswer){

                     mScore = mScore+1;
                    updateScore(mScore);
                    if(mQuestionNumber!=5){

                        updateQuestion();}

                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    if(mQuestionNumber!=5){

                        updateQuestion();}

                }
            } else{ s = mScoreView.getText().toString();
                    rs.putString("poo",s);
                    rs.commit();
                    Intent ob = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(ob);}

            }
        });
        //end

        //button listener
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
               if(count <= 5){

                    if(mButtonChoice3.getText() == mAnswer){

                    mScore = mScore+1;
                    updateScore(mScore);
                    if(mQuestionNumber!=5){

                        updateQuestion();}

                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    if(mQuestionNumber!=5){

                        updateQuestion();}

                }
            }
               else{ s = mScoreView.getText().toString();
                   rs.putString("poo",s);
                   rs.commit();
                   Intent ob = new Intent(MainActivity.this,MainActivity2.class);
                   startActivity(ob);}


            }
        });
        //end

    }
    private  void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
    }

    private void updateScore(int point) {
       // if (mScore <= 5)
            mScoreView.setText("" + mScore);
        //else {

           // s = mScoreView.getText().toString();
            //rs.putString("poo",s);
           // rs.commit();
            //Intent ob = new Intent(MainActivity.this,MainActivity2.class);
             //startActivity(ob);
         //}
    }
    public void Exit(View view) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setTitle("Final Alert");
        builder1.setMessage("Do you want to exit");
        builder1.setIcon(R.drawable.eclaim);
        builder1.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Intent ob = new Intent(MainActivity.this,MainActivity.class);
                            // startActivity(ob);
                finish();
                System.exit(0);

            }
        });
        builder1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                s = mScoreView.getText().toString();
                rs.putString("poo",s);
                rs.commit();
                Intent ob = new Intent(MainActivity.this,MainActivity2.class);
                 startActivity(ob);
            }
        });
        builder1.setNeutralButton("cancel",null);
        builder1.show();


    }
}