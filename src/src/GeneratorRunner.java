public class GeneratorRunner {
    public static void main(String[] args) {
        Kruskal k = new Kruskal(20,20);
        k.printMatrix();
        System.out.println();
        System.out.println(k.report());
        String[] split = k.report().split("\n");
        for(String s : split)
            System.out.println(s);
    }
}
