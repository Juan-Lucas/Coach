package com.example.coach.vue;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coach.R;
import com.example.coach.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controle = Controle.getInstance();
    }


    /**
     *initialisation des liens avec des objets graphiques
     */
    private void init()
    {
        txtPoids = findViewById(R.id.txtPoids);
        txtTaille = findViewById(R.id.txtTaille);
        txtAge = findViewById(R.id.txtAge);
        rdHomme = findViewById(R.id.rdHomme);
        lblIMG = findViewById(R.id.lblIMG);
        imgSmiley = findViewById(R.id.imgSmiley);
        ecouterCalcul();
    }

    /**
     * Ecoute l'evenement sur le bouton CALCULER
     */
    private void ecouterCalcul()
    {
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View view)
            {
                //Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe = 0;
                try
                {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                }catch (Exception e){}
                if (rdHomme.isChecked())
                {
                    sexe = 1;
                }
                if (poids == 0 || taille == 0 || age == 0)
                {
                    Toast.makeText(MainActivity.this,"Remplir tous les champs",Toast.LENGTH_LONG).show();
                }
                else
                {
                    afficherResultat(poids,taille,age,sexe);
                }
            }
        });
    }

    /**
     * Affichage du message et de l'image
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    @SuppressLint("SetTextI18n")
    private void afficherResultat(Integer poids,
                                  Integer taille,
                                  Integer age,
                                  Integer sexe
                                  )
    {
        //creation du profil et recuperation  des informations
        this.controle.creerProfil(poids,taille,age,sexe);
        float img = this.controle.getIMG();
        String message = this.controle.getMessage();
        //affichage
        if(message.equals("normal"))
        {
            imgSmiley.setImageResource(R.drawable.normal);
        }
        else
        {
            if (message.equals("trop faible"))
            {
                imgSmiley.setImageResource(R.drawable.maigre);
            }
            else
            {
                imgSmiley.setImageResource(R.drawable.graisse);
            }
        }
        lblIMG.setText(String.valueOf(img) + " : IMG " + message);
    }

    //proprietes
    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Controle controle;
}
