package first;


import java.io.BufferedReader;
        import java.io.FileInputStream;
        import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static int N;
    private static int ques[];
    private static int answer[];
    private static int ans;



    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int i=1; i<=T; i++) {
            ans = 0;
            N = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            ques = new int[N+1];
            answer = new int[N+1];
            Arrays.fill(answer, 1);
            for(int j=1; j<=N; j++) {
                ques[j] = Integer.parseInt(st.nextToken());
            }

            solve();
            System.out.println("#" + i + " " + ans);
        }

    }

    private static void solve() {
        answer[1] = 1;
        for(int i=2; i<=N; i++) {
            for(int j=i-1; j>=1; j--) {
                if(ques[i] > ques[j]) {
                    if (ans > answer[j]+1) {
                        continue;
                    } else {
                        answer[i] = answer[j] + 1;
                        ans = answer[i];
                    }
                }
            }
        }

    }
}

