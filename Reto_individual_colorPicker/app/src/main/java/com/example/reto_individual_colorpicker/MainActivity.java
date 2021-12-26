package com.example.reto_individual_colorpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // color picker
    private ArrayList<String> colors = new ArrayList<>();
    private LinearLayout[] color_displays;
    private TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize both object arrays:
        textViews = new TextView[]{findViewById(R.id.tw_1),findViewById(R.id.tw_2),findViewById(R.id.tw_3),findViewById(R.id.tw_4),findViewById(R.id.tw_5)};
        color_displays = new LinearLayout[]{findViewById(R.id.layout1),findViewById(R.id.layout2),findViewById(R.id.layout3),findViewById(R.id.layout4),findViewById(R.id.layout5)};

        // listener for the color input (auto "#"):
        EditText et = findViewById(R.id.color_input);
        et.setText("#");
        et.setSelection(et.getText().toString().length());
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 0){
                    et.setText("#");
                    et.setSelection(et.getText().toString().length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                try{
                    int current_color = Color.parseColor(et.getText().toString());
                    hideKeyboardFrom(getApplicationContext(), findViewById(android.R.id.content).getRootView());
                    String color_ = et.getText().toString();
                    int[] rgb_colors_ = getRGB(color_.substring(1,color_.length()));
                    textViews[4].setText(color_+ " | rgb(" + rgb_colors_[0] + "," + rgb_colors_[1] + "," + rgb_colors_[2] + ")");

                    System.out.println("penis");
                    LinearLayout current_ = findViewById(R.id.layout5);
                    current_.setBackgroundColor(current_color);

                    for(int y = 0; y < 4 ; y++){
                        String rand_color = generate_random_color();
                        int[] rgb_colors = getRGB(rand_color.substring(1,rand_color.length()));

                        colors.add(rand_color);
                        color_displays[y].setBackgroundColor(Color.parseColor(rand_color));
                        textViews[y].setText(rand_color + " | rgb("+rgb_colors[0]+","+rgb_colors[1]+","+rgb_colors[2]+")");
                    }
                } catch (Exception e){
                    if(et.getText().toString().equals("# ")){
                        // generate single color for the color input field:
                        hideKeyboardFrom(getApplicationContext(), findViewById(android.R.id.content).getRootView());
                        String single_random_color = generate_random_color();
                        LinearLayout current_color = findViewById(R.id.layout5);
                        EditText tw = findViewById(R.id.color_input);
                        TextView tw_ = findViewById(R.id.tw_5);

                        int[] rgb_colors_ = getRGB(single_random_color.substring(1,single_random_color.length()));
                        tw_.setText(single_random_color + " | rgb(" + rgb_colors_[0] + "," + rgb_colors_[1] + "," + rgb_colors_[2] + ")");
                        tw.setText(single_random_color);
                        current_color.setBackgroundColor(Color.parseColor(single_random_color));

                        for(int y = 0; y < 4; y++) {
                            String rand_color = generate_random_color();
                            int[] rgb_colors = getRGB(rand_color.substring(1, rand_color.length()));

                            colors.add(rand_color);
                            color_displays[y].setBackgroundColor(Color.parseColor(rand_color));
                            textViews[y].setText(rand_color + " | rgb(" + rgb_colors[0] + "," + rgb_colors[1] + "," + rgb_colors[2] + ")");
                        }
                    } else {
                        et.setError("Color invalido.");
                    }
                }
            }
        });
    }

    private String generate_random_color(){
        // generate a random hex color # aa bb cc:
        String color_output = "#";
        Random rand = new Random();
        boolean valid_color = false;

        while(!valid_color){
            for(int y = 0; y<6; y++){
                switch(rand.nextInt(2)){
                    case 0:
                        // generate a random number from 0 - 9:
                        int rand_number = rand.nextInt(10);

                        color_output += String.valueOf(rand_number);
                        break;
                    case 1:
                        // generate a random letter from a - z:
                        String letters = "ABCDEF";
                        int rand_letter_index = rand.nextInt(letters.length());

                        color_output += String.valueOf(letters.toCharArray()[rand_letter_index]);
                        break;
                }
            }

            try{
                int color_check = Color.parseColor(color_output);
                valid_color = true;
            } catch (Exception e){
                valid_color = false;
            }
        }


        System.out.println(color_output);
        return color_output;
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static int[] getRGB(final String rgb)
    {
        // get the rgb code:
        final int[] ret = new int[3];
        for (int i = 0; i < 3; i++)
        {
            ret[i] = Integer.parseInt(rgb.substring(i * 2, i * 2 + 2), 16);
        }
        return ret;
    }

}