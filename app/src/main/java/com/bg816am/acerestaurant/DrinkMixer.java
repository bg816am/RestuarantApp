package com.bg816am.acerestaurant;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkMixer extends MainActivity implements AdapterView.OnItemSelectedListener {


    private TextView mDisplayDrink;
    private Spinner mLiquorSelect;
    private Spinner mMixerSelect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drinkmixerscreen);

        //Variables to link xml items to code
        mDisplayDrink = findViewById(R.id.drinkView);
        mLiquorSelect = findViewById(R.id.liquorSpinner);
        mMixerSelect = findViewById(R.id.mixerSpinner);
        Button makeDrink = findViewById(R.id.createDrink);

        //I opted to not use the garnishes option at this time in the app, due to unexpected complexity with getting the liquors and mixers to work correctly. Will add in once
        //I am able to use the other spinners correctly
        //Spinner garnishArray = findViewById(R.id.garnishSpinner);

        makeDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // pulls the location in the array of liquors and mixers
                int liquorChoice = mLiquorSelect.getSelectedItemPosition();
                int mixerChoice = mMixerSelect.getSelectedItemPosition();

                //TODO: Set so item selected stays after hitting 'Make Drink'



               //This if else series takes the position (int) for each selection and associates with a drink.
                if (liquorChoice == 0 && mixerChoice == 1) {
                    mDisplayDrink.setText(R.string.vodkaTonic);
                } else if (liquorChoice == 0 && mixerChoice == 2) {
                    mDisplayDrink.setText(R.string.capeCod);
                } else if (liquorChoice == 0 && mixerChoice == 3) {
                    mDisplayDrink.setText(R.string.screwdriver);
                } else if (liquorChoice == 0 && mixerChoice == 4) {
                    mDisplayDrink.setText(R.string.vodkaCollins);
                } else if (liquorChoice == 1 && mixerChoice == 0) {
                    mDisplayDrink.setText(R.string.tequilaBatanga);
                } else if (liquorChoice == 1 && mixerChoice == 1) {
                    mDisplayDrink.setText(R.string.tequilaTonic);
                } else if (liquorChoice == 1 && mixerChoice == 2) {
                    mDisplayDrink.setText(R.string.cranberryMargarita);
                } else if (liquorChoice == 1 && mixerChoice == 3) {
                    mDisplayDrink.setText(R.string.sunrise);
                } else if (liquorChoice == 1 && mixerChoice == 4) {
                    mDisplayDrink.setText(R.string.margarita);
                } else if (liquorChoice == 2 && mixerChoice == 0) {
                    mDisplayDrink.setText(R.string.rumAndCoke);
                } else if (liquorChoice == 2 && mixerChoice == 2) {
                    mDisplayDrink.setText((R.string.cranberryZombie));
                } else if (liquorChoice == 2 && mixerChoice == 3) {
                    mDisplayDrink.setText(R.string.rumSunset);
                } else if (liquorChoice == 2 && mixerChoice == 4) {
                    mDisplayDrink.setText(R.string.rumSour);
                } else if (liquorChoice == 3 && mixerChoice == 1) {
                    mDisplayDrink.setText(R.string.ginTonic);
                } else if (liquorChoice == 3 && mixerChoice == 2) {
                    mDisplayDrink.setText(R.string.cranberryGin);
                }else if (liquorChoice == 3 && mixerChoice == 3) {
                    mDisplayDrink.setText(R.string.orangeBlossom);
                } else if (liquorChoice == 3 && mixerChoice == 4) {
                    mDisplayDrink.setText(R.string.ginSour);
                } else {
                    mDisplayDrink.setText(R.string.yourDrink);
                }

                Toast.makeText(DrinkMixer.this, "Making your drink", Toast.LENGTH_SHORT).show();

                // Create liquor adapter
                ArrayAdapter<CharSequence> liquorAdapter = ArrayAdapter.createFromResource(DrinkMixer.this, R.array.Liquors, android.R.layout.simple_spinner_item);
                liquorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mLiquorSelect.setAdapter(liquorAdapter);
                mLiquorSelect.setOnItemSelectedListener(DrinkMixer.this);

                // Create mixer adapter
                ArrayAdapter<CharSequence> mixerAdapter = ArrayAdapter.createFromResource(DrinkMixer.this, R.array.Mixers, android.R.layout.simple_spinner_item);
                mixerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mMixerSelect.setAdapter(mixerAdapter);
                mMixerSelect.setOnItemSelectedListener(DrinkMixer.this);



            }
        });
    }

        @Override
        public void onItemSelected (AdapterView < ? > adapterView, View view,int i, long l){

        }

        @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

        }

}















