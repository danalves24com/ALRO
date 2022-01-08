package alrosource.services.builders;

public class HookBuilder {

    public static String[] createHookSet(String algorithmName, String language) {
        String[] set = new String[2];
        switch (language) {
            case "java":
                set = javaHook(algorithmName);
                break;

        };
        return  set;
    }

    public static String[] javaHook(String name) {
        return new String[] {
                "alro.hook.StartHook.newHook(\""+name+"\")",
                "alro.hook.StopHook.newHook(\""+name+"\")"
        };
    }

}
