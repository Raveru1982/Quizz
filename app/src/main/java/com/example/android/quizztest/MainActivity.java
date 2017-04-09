package com.example.android.quizztest;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

//used for q1 Checkbox
    static int q1score =0;
    TextView questionchk1;
    CheckBox r7;
    CheckBox r8;
    CheckBox r9;
    CheckBox r10;
    CheckBox r11;
    //radio buttons Q 2to7
    TextView question1;
    RadioButton answer1a;
    RadioButton answer1b;
    RadioButton answer1c;
    RadioButton answer1d;
    TextView question2;
    RadioButton answer2a;
    RadioButton answer2b;
    RadioButton answer2c;
    RadioButton answer2d;
    TextView question3;
    RadioButton answer3a;
    RadioButton answer3b;
    RadioButton answer3c;
    RadioButton answer3d;
    TextView question4;
    RadioButton answer4a;
    RadioButton answer4b;
    RadioButton answer4c;
    RadioButton answer4d;
    TextView question5;
    RadioButton answer5a;
    RadioButton answer5b;
    RadioButton answer5c;
    RadioButton answer5d;
    TextView question6;
    RadioButton answer6a;
    RadioButton answer6b;
    RadioButton answer6c;
    RadioButton answer6d;
    Button submit;
    RadioGroup r1;
    RadioGroup r2;
    RadioGroup r3;
    RadioGroup r4;
    RadioGroup r5;
    RadioGroup r6;
    int count;
//verify if the checkboxes are selected for adding the result later to count/score
    CheckBox chMedias = (CheckBox) findViewById(R.id.chkMedias);
    boolean hasMedias = chMedias.isChecked();
    CheckBox chAgnita = (CheckBox) findViewById(R.id.chkAgnita);
    boolean hasAgnita = chAgnita.isChecked();
    CheckBox chLugoj = (CheckBox) findViewById(R.id.chkLugoj);
    boolean hasLugoj = chLugoj.isChecked();
    CheckBox chSebes = (CheckBox) findViewById(R.id.chkSebes);
    boolean hasSebes = chSebes.isChecked();
    CheckBox chSaliste = (CheckBox) findViewById(R.id.chkSaliste);
    boolean hasSaliste = chSaliste.isChecked();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.count = 0;
        findElements();
        final TextView textCities=(TextView)findViewById(R.id.result);

        // getting reference of check boxes for the first display
        final CheckBox medias=(CheckBox)findViewById(R.id.chkMedias);
        final CheckBox agnita=(CheckBox)findViewById(R.id.chkAgnita);
        final CheckBox lugoj=(CheckBox)findViewById(R.id.chkLugoj);
        final CheckBox sebes=(CheckBox)findViewById(R.id.chkSebes);
        final CheckBox saliste=(CheckBox)findViewById(R.id.chkSaliste);
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        final String name = nameEditable.toString();
        // get reference of Button og question1
        Button button=(Button)findViewById(R.id.btnDisplay);
            button.setOnClickListener(new View.OnClickListener() {
                //display the chosen answer and verify if its correct
                @Override
                public void onClick(View v) {
                    if(medias.isChecked())
                    q1score++;
                    if(agnita.isChecked())
                        q1score++;
                    if(lugoj.isChecked())
                        q1score = q1score -1;
                    if(sebes.isChecked())
                        q1score = q1score -1;
                    if(saliste.isChecked())
                        q1score++;
                }
            });
                String cities = "";
                if (medias.isChecked())
                    cities += "Medias";
                if (agnita.isChecked())
                    cities += "  Agnita";
                if (lugoj.isChecked())
                    cities += "  Lugoj";
                if (sebes.isChecked())
                    cities += "  Sebes";
                if (saliste.isChecked())
                    cities += "  Saliste";
        if(q1score >3 || q1score <3)
            //wrong answer
            textCities.setText("Sorry, " +name + ", please, try again");
        else
        // correct answer - I know I could use strings, but I've done a lot of changes here and had to keep it close
                textCities.setText("Correct, " +name + ", correct answer is: " + cities);
            }
//calculate the correct answer score and show it to the user
    public void submitAnswers(View view) {
        calculateScore();
        if (count > 3) {
            view.setBackgroundColor(Color.YELLOW);
        } else {
            view.setBackgroundColor(Color.RED);
        }
        Toast.makeText(this, "You got " + this.count + " answers correct out of 7!", Toast.LENGTH_LONG).show();
        this.count = 0;
        resetRadios();
    }
//resets the checked buttons, radio or checkboxes
    public void resetRadios() {
        r1.clearCheck();
        r2.clearCheck();
        r3.clearCheck();
        r4.clearCheck();
        r5.clearCheck();
        r6.clearCheck();
        r7.setChecked(false);
        r8.setChecked(false);
        r9.setChecked(false);
        r10.setChecked(false);
        r11.setChecked(false);
    }
    public void calculateScore() {
        if (answer1a.isChecked())
            count++;
        if (answer2c.isChecked())
            count++;
        if (answer3b.isChecked())
            count++;
        if (answer4b.isChecked())
            count++;
        if (answer5c.isChecked())
            count++;
        if (answer6b.isChecked())
            count++;
        if ((hasSaliste)&& (hasAgnita) && (hasMedias))
            count++;
        }
    public void findElements() {
        this.question1 = (TextView) findViewById(R.id.question1_textView);
        this.answer1a = (RadioButton) findViewById(R.id.answer1_a);
        this.answer1b = (RadioButton) findViewById(R.id.answer1_b);
        this.answer1c = (RadioButton) findViewById(R.id.answer1_c);
        this.answer1d = (RadioButton) findViewById(R.id.answer1_d);
        this.question2 = (TextView) findViewById(R.id.question2_textView);
        this.answer2a = (RadioButton) findViewById(R.id.answer2_a);
        this.answer2b = (RadioButton) findViewById(R.id.answer2_b);
        this.answer2c = (RadioButton) findViewById(R.id.answer2_c);
        this.answer2d = (RadioButton) findViewById(R.id.answer2_d);
        this.question3 = (TextView) findViewById(R.id.question3_textView);
        this.answer3a = (RadioButton) findViewById(R.id.answer3_a);
        this.answer3b = (RadioButton) findViewById(R.id.answer3_b);
        this.answer3c = (RadioButton) findViewById(R.id.answer3_c);
        this.answer3d = (RadioButton) findViewById(R.id.answer3_d);
        this.question4 = (TextView) findViewById(R.id.question4_textView);
        this.answer4a = (RadioButton) findViewById(R.id.answer4_a);
        this.answer4b = (RadioButton) findViewById(R.id.answer4_b);
        this.answer4c = (RadioButton) findViewById(R.id.answer4_c);
        this.answer4d = (RadioButton) findViewById(R.id.answer4_d);
        this.question5 = (TextView) findViewById(R.id.question5_textView);
        this.answer5a = (RadioButton) findViewById(R.id.answer5_a);
        this.answer5b = (RadioButton) findViewById(R.id.answer5_b);
        this.answer5c = (RadioButton) findViewById(R.id.answer5_c);
        this.answer5d = (RadioButton) findViewById(R.id.answer5_d);
        this.question6 = (TextView) findViewById(R.id.question6_textView);
        this.answer6a = (RadioButton) findViewById(R.id.answer6_a);
        this.answer6b = (RadioButton) findViewById(R.id.answer6_b);
        this.answer6c = (RadioButton) findViewById(R.id.answer6_c);
        this.answer6d = (RadioButton) findViewById(R.id.answer6_d);
        this.questionchk1 = (TextView) findViewById(R.id.chk1);
        this.submit = (Button) findViewById(R.id.submit_button);
        r1 = (RadioGroup) findViewById(R.id.rg1);
        r2 = (RadioGroup) findViewById(R.id.rg2);
        r3 = (RadioGroup) findViewById(R.id.rg3);
        r4 = (RadioGroup) findViewById(R.id.rg4);
        r5 = (RadioGroup) findViewById(R.id.rg5);
        r6 = (RadioGroup) findViewById(R.id.rg6);
        r7 = (CheckBox) findViewById(R.id.chkMedias);
        r8 = (CheckBox) findViewById(R.id.chkAgnita);
        r9 = (CheckBox) findViewById(R.id.chkLugoj);
        r10 = (CheckBox) findViewById(R.id.chkSebes);
        r11 = (CheckBox) findViewById(R.id.chkSaliste);
    }
}

