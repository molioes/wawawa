public class GeneratorRunner {
    public static void main(String[] args) {
        Kruskal k = new Kruskal(20,20);
        k.printMatrix();
        System.out.println();
        System.out.println(k.report());
        String[] split = k.report().split("\n");
        for(String s : split)
            System.out.println(s);
        System.out.println();
        Factory.run(20,20);
        char[][] maze = Factory.getMaze();
        for(char[] arr:maze){
            for(char c : arr){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
