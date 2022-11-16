import Model.CustomScanner;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Program 1");
        CustomScanner scannerP1 = new CustomScanner("src/Utils/P1.txt",
                "src/Utils/PIF1.txt",
                "src/Utils/ST1.txt");
        scannerP1.scan();

        System.out.println("------------------------");
        System.out.println("Program 2");
        CustomScanner scannerP2 = new CustomScanner("src/Utils/P2.txt",
                "src/Utils/PIF2.txt",
                "src/Utils/ST2.txt");
        scannerP2.scan();


        System.out.println("------------------------");
        System.out.println("Program 3");
        CustomScanner scannerP3 = new CustomScanner("src/Utils/P3.txt",
                "src/Utils/PIF3.txt",
                "src/Utils/ST3.txt");
        scannerP3.scan();

        System.out.println("------------------------");
        System.out.println("Program with lexical errors");
        CustomScanner scannerP1err = new CustomScanner("src/Utils/P1err.txt",
                "src/Utils/PIFerr.txt",
                "src/Utils/STerr.txt");
        scannerP1err.scan();
    }
}
