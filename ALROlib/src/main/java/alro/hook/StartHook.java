package alro.hook;

import alro.hook.data.HookEvent;
import alro.hook.data.HookType;

public class StartHook {
    public static void newHook(String algorithm) {
        GlobalHook.eventList.add(new HookEvent(algorithm, System.nanoTime(), HookType.Start));
    }
}
