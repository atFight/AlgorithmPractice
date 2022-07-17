package offer.hwod;

import java.util.ArrayList;
import java.util.List;

public class FiveKeyboardOut {
//1,1,5,1,5,2,4,4
    public static int fiveKeyboardOut(int[] operators) {
        int screenCnt = 0;
        int selectCnt = 0;
        int pasteCnt = 0;

        for (int operate : operators) {
            switch (operate) {
                case 1:
                    screenCnt = screenCnt - selectCnt;
                    screenCnt++;
                    selectCnt = 0;
                    break;
                case 2:
                    pasteCnt = selectCnt;
                    break;
                case 3:
                    pasteCnt = selectCnt;
                    screenCnt = screenCnt - selectCnt;
                    break;
                case 4:
                    screenCnt = screenCnt - selectCnt;
                    selectCnt = 0;
                    screenCnt = screenCnt + pasteCnt;
                    break;
                case 5:
                    selectCnt = screenCnt;
                    break;
                default:
                    break;
            }
            System.out.println(operate + " : "+ screenCnt);
        }
        return screenCnt;
    }

}
