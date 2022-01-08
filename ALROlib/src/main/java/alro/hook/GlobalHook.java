package alro.hook;

import alro.hook.data.HookEvent;

import java.util.ArrayList;

public class GlobalHook {
    public static ArrayList<HookEvent> eventList = new ArrayList<>();
    public static double nanoToMili(double nano) {
        return nano / 1000000;
    }
    public static double getAlgorithmRuntime(String algorithm) {
        ArrayList<Long> ts = new ArrayList<Long>();
        for(HookEvent event  : eventList) {
            if(event.algorithm().equals(algorithm)) {
                ts.add(event.time());
            }
        }
        double sum = 0; int c = 0;
        for(int i = 0; i < eventList.size()-1; i += 2)
        {long s = ts.get(i+1) - ts.get(i); sum+=s;c+=1;}
        return sum / c;
    }
}
