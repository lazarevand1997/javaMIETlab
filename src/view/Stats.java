package view;

public class Stats {
    public void print_stats(int[] buttons_clicks){
        int N = buttons_clicks.length;
        int b = 5;
        int win_proc = (100 * b)/(N + b -1);
        int max = 0;
        for(int i =0; i < N; i++){
            if (buttons_clicks[i] > max) max = buttons_clicks[i];
        }
        int win_clicks = max / 100 * win_proc;
        for(int i =0; i < N; i++){
            if (buttons_clicks[i] > win_clicks)System.out.println("Button number " + i + " is popular, clicks="
                    + buttons_clicks[i] + ". This is more then rate "+ win_proc + "% or "+ win_clicks + " clicks.");
        }
    }
}
