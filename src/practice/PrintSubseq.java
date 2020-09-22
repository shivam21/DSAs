package practice;

public class PrintSubseq {
    public static void main(String[] args) {
        printSubSeq("abc", "");
    }

    private static void printSubSeq(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        printSubSeq(input.substring(1), output);
        printSubSeq(input.substring(1), output + input.charAt(0));

    }
}
