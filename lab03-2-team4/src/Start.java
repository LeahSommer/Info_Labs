public class Start {
    public static void main(String[] args){
        System.out.println("Prozess startet..");
        FileAnalyzer fa = new FileAnalyzer("data/test.txt", "data/results.txt");
        fa.countChars();
        fa.printResults();
        fa.printMostPopular();
    }
}
