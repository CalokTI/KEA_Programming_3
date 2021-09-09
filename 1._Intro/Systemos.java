import java.util.List;

public class Systemos {
    //Overload
    public static class out {
        public static void println(String str) {
            System.out.println(str);
        }

        public static void println(int str) {
            System.out.println(str);
        }

        public static void println(double str) {
            System.out.println(str);
        }

        public static void println(char str) {
            System.out.println(str);
            System.out.println("char");
        }

        public static void println(float str) {
            System.out.println(str);
        }

        public static void println(long str) {
            System.out.println(str);
        }

        public static void println(short str) {
            System.out.println(str);
        }

        public static void println(byte str) {
            System.out.println(str);
        }

        public static void println(Object content){
            System.out.println(content);
        }

        public static void println(Word[] content){
            for (int i = 0; i < content.length; i++) {
                System.out.println(content[i]);
            }
        }

        /*public static void println(List content){
            for (int i = 0; i < content.size(); i++) {
                System.out.println(content.get(i));
            }
        }*/

        public static void println(List content){
            content.forEach(object -> println(object));

        }

    }

}
