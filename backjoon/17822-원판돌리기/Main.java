import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] arr =new int[N+1][M];
        for(int i = 1; i<= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for( int t =0; t<T ;t++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken()); 
            if(D==1) {
                for(int x = X;x<=N;x+=X) {
                    for(int k= 0; k<K; k++) {
                        int a = arr[x][0];
                        for(int m = 0; m<M-1 ;m++) {
                            arr[x][m] = arr[x][m+1];
                        }
                        arr[x][M-1] = a;
                    }
                }
            }else {
                for(int x =X; x<=N;x+=X) {
                    for(int k= 0; k<K; k++) {
                        int a = arr[x][M-1];
                        for(int m = M-1; m>0 ;m--) {
                            arr[x][m] = arr[x][m-1];
                        }
                        arr[x][0] = a;
                    }
                }
            }
//            System.out.println("움직이기");
//            for(int i=1; i<=N;i++) {
//                for(int j = 0; j<M; j++) {
//                    System.out.print(arr[i][j]+ " ");
//                }
//                System.out.println();
//            }
            boolean flag = false;
            int[][] arr2 = new int[N+1][M];
            for(int i = 1;i<=N;i++) {
                System.arraycopy(arr[i],0,arr2[i],0,M);
            }
            for(int i=1; i<=N; i++) {
                for(int j = 0; j<M;j++) {
                    int a = arr[i][j];
                    if(a!=0) {
                        if(i>1 && arr[i-1][j]==a) {
                            arr2[i-1][j] =0; 
                            arr2[i][j] =0;
                            flag = true;
                        }
                        if(i<N && arr[i+1][j]==a) {
                            arr2[i+1][j]=0;
                            arr2[i][j]=0;
                            flag = true;
                        }
                        if(j>0  && arr[i][j-1]==a) {
                            arr2[i][j-1] = 0;
                            arr2[i][j] =0;
                            flag = true;
                        }
                        if(j<M-1 && arr[i][j+1] ==a) {
                            arr2[i][j+1] = 0; 
                            arr2[i][j] = 0; 
                            flag = true;
                        }
                        if(j==0 && arr[i][M-1]==a) {
                            arr2[i][M-1]= 0; 
                            arr2[i][j] =0;
                            flag = true;
                        }
                        if(j==M-1 && arr[i][0]==a) {
                            arr2[i][0] = 0;
                            arr2[i][j] = 0; 
                            flag = true;
                        }
                    }
                }
            }
            arr = arr2;
//            System.out.println("인접지우기");
//            for(int i=1; i<=N;i++) {
//                for(int j = 0; j<M; j++) {
//                    System.out.print(arr[i][j]+ " ");
//                }
//                System.out.println();
//            }
            if(!flag) {
                int sum =0;
                int cnt =0; 
                for(int i =1; i<=N; i++) { 
                    for(int j =0; j<M;j++) {
                        sum+=arr[i][j];
                        if(arr[i][j]!=0)cnt++;
                    }
                }
                double mean = 1.0*sum/cnt;
                for(int i =1; i<=N; i++) { 
                    for(int j =0; j<M;j++) {
                        if(arr[i][j]==0)continue;
                        else if(arr[i][j]<mean)arr[i][j]++;
                        else if(arr[i][j]>mean)arr[i][j]--;
                    }
                }
//                System.out.println("평균쁠마"+mean);
//                for(int i=1; i<=N;i++) {
//                    for(int j = 0; j<M; j++) {
//                        System.out.print(arr[i][j]+ " ");
//                    }
//                    System.out.println();
//                }
            }

        }
        int ans = 0; 
        for(int i =1; i<= N; i++) {
            for(int j =0; j<M; j++) {
                ans+=arr[i][j];
            }
        }
        System.out.println(ans);

    }
}