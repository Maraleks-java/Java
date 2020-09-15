package HeadFirstJava.chapter3.tesk1;

public class TestArrays {
    public static void main(String[] args) {
        String[] isLands = new String[4];
        int[] index = new int[4];
        int y = 0;

        isLands[0] = "Бермуды";
        isLands[1] = "Фиджи";
        isLands[2] = "Азорские острова";
        isLands[3] = "Косумел";

        index[0] = 1;
        index[1] = 3;
        index[2] = 0;
        index[3] = 2;

        while (y < 4){
            int ref = index[y];
            System.out.println(isLands[ref]);
            y = y + 1;
        }
        System.out.println("Острова = ");
    }
}
