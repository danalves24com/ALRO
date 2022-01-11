import alro.ALRO;

public class SampleProgram {

    public static void main(String[] args) {
        /*
        ALRO HOOK IN
         */
        ALRO alro = ALRO.register(".ALRO");



        String a = "test stuff";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (String aa : a.split("")) {
            sb1.append(aa);
            sb.append(convertStringToBinary(sb1.toString()));
        }


        /*
        ALRO HOOK OUT
         */
        alro.unregister();

    }

    public static String convertStringToBinary(String input) {
        alro.hook.StartHook.newHook("convertStringToBinary");
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        alro.hook.StopHook.newHook("convertStringToBinary");
        return result.toString();

    }
}
