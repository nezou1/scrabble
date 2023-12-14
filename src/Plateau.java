public class Plateau {

    public static void plateau(){
        int lignes;
        int colonnes;
        String[][] tab = new String[16][16];
        for(lignes=0; lignes<tab.length; lignes++){
            for(colonnes=0; colonnes<(tab[lignes].length)-1; colonnes++) {
                tab[lignes][colonnes] = "|___";
                System.out.print(tab[lignes][colonnes]);

            }
            tab[lignes][15]="|___|";
            System.out.println(tab[lignes][15]);

        }

    }



    public static void main(String[] args){
        plateau();
    }
}
