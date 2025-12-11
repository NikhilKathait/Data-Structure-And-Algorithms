import java.util.*;

public class printAllMazePaths {
    public ArrayList<String> PrintAllPaths(int A, int B) {
        ArrayList<String> ans = new ArrayList<>();

        distinctWays(0, 0, A-1, B-1, "", ans);

        return ans;
    }

    public void distinctWays(int sr, int sc, int dr, int dc, String psf, ArrayList<String> ans) {

        if (sr == dr && sc == dc) {
            ans.add(psf);
            return;
        }

        if (sr+1 <= dr)
            distinctWays(sr+1, sc, dr, dc, psf+"D", ans);

        if (sc+1 <= dc)
            distinctWays(sr, sc+1, dr, dc, psf+"R", ans);
    }
}
