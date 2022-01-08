package alro.hook.tests;

import alro.ALRO;

public class SampleProgram {

    public static void main(String a) {

        ALRO alro = ALRO.register(".ALRO");

        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (String aa : a.split("")) {
            sb1.append(aa);
            sb.append(convertStringToBinary(sb1.toString()));
        }


        alro.unregister();

    }

    public static String convertStringToBinary(String input) {
        alro.hook.StartHook.newHook("binaryConvert");
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        alro.hook.StopHook.newHook("binaryConvert");
        return result.toString();

    }
}
