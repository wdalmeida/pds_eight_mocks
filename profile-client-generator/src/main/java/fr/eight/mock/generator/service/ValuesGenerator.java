package fr.eight.mock.generator.service;

import java.util.Random;


public class ValuesGenerator {


    /**
     *
     * @param min !< 0
     * @param max !< 0
     * @return random number between min & max inclusive
     */
    public static int randInt(int min, int max) {

        Random rn = new Random();

        return rn.nextInt((max - min) + 1) + min;

    }

    /**
     *
     * @return an age between 18 & 88 years old
     */
    public static int generateAge() {
        return randInt(18, 88);
    }

    /**
     *  1 : celibataire
     *  2 : marie
     *  3 : veuf
     *  4 : pacse
     * @return familial status
     */
    public static int generateFamilialStatus() {

        int familialStatus = 1;

        int ratio = randInt(0, 100);

        if(ratio < 100) {
            familialStatus = 4;
        }
        if(ratio < 86) {
            familialStatus = 3;
        }
        if(ratio < 79) {
            familialStatus = 2;
        }
        if (ratio < 33) {
            familialStatus = 1;
        }

        return familialStatus;
    }

    /**
     * RULE 1 : < 20 : 0 childrens else between 0 and 5
     * @return number of childs between 0 and 4
     */
    public static int generateChilds(int age) {

        if (age >= 20) {
            return randInt(0, 5);
        }
        else {
            return 0;
        }

    }

    /**
     *  Courant    1
     *  Livret Jeune    2
     *  PEA    3
     *  PEL    4
     *  RULE 1 : if age < 26: more probability to get an account type 2
     * @param age must be >= 18
     * @return type account
     */
    public static int generateTypeAccount(int age) {

        int typeAccount = 1;

        if (age <= 26) {
            int ratio = randInt(0, 10);

            if (ratio > 4) { typeAccount = 2; }

        }
        else {
            int ratio = randInt(0, 100);

            if (ratio < 100) { typeAccount = 1; }
            if (ratio < 56)  { typeAccount = 3; }
            if (ratio < 39)  { typeAccount = 4; }
        }

        return typeAccount;
    }


    /**
     * RULE 2 : more probability to not be owner than be owner
     * @return is owner 1 or not 2
     */
    public static int genereateIsOwner() {

        int isOwner = 1;

        int ratio = randInt(0, 100);

        if (ratio > 39) {
            isOwner = 0;
        }

        return isOwner;
    }

    /**
     *  1 : sans emploi  11%
     *  2 : etudiant  22%
     *  3 : employe  24%
     *  4 : ouvriers 17%
     *  5 : cadres 9%
     *  6 : retraite 16%
     *  @param age betwteen 18 and 88
     * @return a social category
     */
    public static int generateSocialCategory(int age) {
        int ratio = randInt(0, 100);

        int catSocial = 6;



        if (age <= 26) {

            if (ratio < 100) { catSocial = 2; }
            if (ratio < 33)  { catSocial = 3; }
            if (ratio < 7) { catSocial = 1; }

        }
        else if (age > 63) {
            catSocial = 6;
        }
        else {
            if (ratio < 100) {
                catSocial = 5; // cadre : 8%
            }
            if (ratio < 92) {
                catSocial = 4; // ouvriers : 33%
            }
            if (ratio < 59) {
                catSocial = 3; // employe : 47 %
            }
            if (ratio < 12) {
                catSocial = 1; // sans emploi : 12
            }

        }

        return catSocial;
    }

    /**
     *
     * @param socialCat [1,6]
     * @return a balance in function of the social category
     */
    public static int generateBalance(int socialCat) {
        int solde = 0;

        if (socialCat == 2) {
            solde = randInt(1000, 3000);
        }
        else if (socialCat == 1 || socialCat == 6) {
            int ratio = randInt(0, 10);

            if (ratio < 3) {
                solde = randInt(0, 2000);
                solde = -solde;
            }
            else {
                solde = randInt(0, 3000);
            }
        }
        else if(socialCat == 3 ||socialCat == 4) {
            int ratio = randInt(0, 10);

            if (ratio < 2) {
                solde = randInt(0, 2000);
                solde = -solde;
            }
            else {
                solde = randInt(0, 3500);
            }
        }
        else if(socialCat == 5) {
            solde = randInt(1500, 7000);
        }

        return solde;
    }

    public static int generateLoanHistory(int age) {

        int histoCredit;


        if (age < 26) {
            histoCredit = 0;
        } else {
            int ratio = randInt(0, 100);

            if (ratio > 97) {
                histoCredit = 0;
            }
            else {
                histoCredit = randInt(0, 500);
            }

        }

        return  histoCredit;
    }

    /**
     *
     * @param loanHistory !< 0
     * @return the current loan
     */
    public static int generateCurrentLoan(int loanHistory) {
        int credit;

        int ratio = randInt(0, 100);

        if (ratio > 88) {
            credit = 0;
        }
        else {
            credit = (loanHistory / 2) + 100;
        }

        return credit;
    }

    public static int generateRevenue(int socialCat) {

        int revenue = 0;

        if (socialCat == 2) {
            revenue = randInt(0, 2600);
            revenue = revenue - 100;
        }
        else if (socialCat == 3) {
            revenue = randInt(1200, 2000);
            revenue = revenue + 300;
        }
        else if (socialCat == 4) {
            revenue = randInt(1000, 1900);
            revenue = revenue - 150;
        }
        else if (socialCat == 5) {
            revenue = randInt(1800, 14400);
            revenue = revenue + 600;
        }
        else if (socialCat == 6) {
            revenue = randInt(700, 1200);
            revenue = revenue - 200;
        }

        return revenue;
    }

    /**
     *
     * @param historyLoan
     * @param currentLoan
     * @param socialCat
     * @param revenue
     * @param familyStatus
     * @param childs
     * @param isOwner
     * @return new credit or not
     */
    public static int generateFuturLoan(int historyLoan, int currentLoan, int socialCat, int revenue, int familyStatus, int childs, int isOwner) {

        int futurLoan = 0;

        //if 2 follow loans
        if (historyLoan > 0 && currentLoan > 0) {
            futurLoan = 0;
        }
        else {
            //sans emploi
            if (socialCat == 1) {
                futurLoan = 0;
            }
            //etudiant
            else if (socialCat == 2) {
                if (revenue > 2000) {
                    futurLoan = 1;
                }
                else if (revenue > 1500 && childs == 0 && (familyStatus == 2 || familyStatus == 4)) {
                    futurLoan = 1;
                }
                else {
                    futurLoan = 0;
                }
            }
            //employe
            else if (socialCat == 3) {
                if (revenue > 2000) {
                    futurLoan = 1;
                }
                else if (revenue > 1800 && isOwner == 1 && (familyStatus == 2 || familyStatus == 4)) {
                    futurLoan = 1;
                }
                else if (revenue > 1400 && isOwner == 1 && childs <= 3 && (familyStatus == 2 || familyStatus == 4)) {
                    futurLoan = 1;
                }
                else {
                    futurLoan = 0;
                }
            }
            //ouvrier
            else if (socialCat == 4) {
                if (revenue > 2000) {
                    futurLoan = 1;
                }
                else if (revenue > 1800 && isOwner == 1) {
                    futurLoan = 1;
                }
                else if (revenue > 1500 && isOwner == 1 && childs <= 2) {
                    futurLoan = 1;
                }
                else {
                    futurLoan = 0;
                }

            }
            //cadre
            else if (socialCat == 5) {
                if (revenue > 2000) {
                    futurLoan = 1;
                }
                else if(revenue > 1700 && childs <= 3) {
                    futurLoan = 1;
                }
                else {
                    futurLoan = 0;
                }
            }
            //retraite
            else if (socialCat == 6) {
                if (revenue > 2000) {
                    futurLoan = 1;
                }
                else if(revenue > 1500 && isOwner == 1) {
                    futurLoan = 1;
                }
                else {
                    futurLoan = 0;
                }
            }

        }



        return futurLoan;
    }

}
