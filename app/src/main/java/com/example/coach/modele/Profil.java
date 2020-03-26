package com.example.coach.modele;

public class Profil {

    private static final Integer minFemme = 15;//maigre si en dessous
    private static final Integer maxFemme = 30;//gros si au dessus
    private static final Integer minHomme = 10;//maigre si en dessous
    private static final Integer maxHomme = 25;//gros si au dessus

    /**
     * Constructeur
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMG();
        this.resultatIMG();
    }

    /**
     * Calcule de l'IMG
     */
    private void calculIMG()
    {
        float taille_en_mettre = ((float)taille)/100;
        this.img = (float)((1.2*poids / (taille_en_mettre * taille_en_mettre) + (0.23*age) - (10.83*sexe) - 5.4));
    }

    /**
     * Recuperation du resultat du calcul de l'IMG
     */
    private void resultatIMG()
    {
        Integer min;
        Integer max;
        if (sexe == 0)
        {
            //femme
            min = minFemme;
            max = maxFemme;
        }
        else
        {
            //homme
            min = minHomme;
            max = maxHomme;
        }
        //message correspondant
        message  = "normal";
        if (img < min)
        {
            message = "trop faible";
        }
        else
        {
            if (img > max)
            {
                message = "trop eleve";
            }
        }
    }

    /**
     * recuperation du poids
     * @return poids
     */
    public Integer getPoids() {
        return poids;
    }

    /**
     * recuperation de la taille
     * @return taille
     */
    public Integer getTaille() {
        return taille;
    }

    /**
     * recuperation de l'age
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * recuperation du sexe
     * @return sexe
     */
    public Integer getSexe() {
        return sexe;
    }

    /**
     * recuperation de l'IMG
     * @return img
     */
    public float getImg() {
        return img;
    }

    /**
     * recuperation du message
     * @return message
     */
    public String getMessage() {
        return message;
    }


    private  Integer poids;
    private  Integer taille;
    private  Integer age;
    private  Integer sexe;
    private  float img;
    private String message;
}
