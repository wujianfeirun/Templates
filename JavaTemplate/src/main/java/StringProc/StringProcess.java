package StringProc;

public class StringProcess {


    public static void main(String[] args) {
        String originStr = "=SUM(E11:F141:G134:K${ROW-4}:L10:NNN13)";
        String middleStr = fillWithBlank(originStr,"=.+?\\(");
        middleStr=fillWithBlank(middleStr,"\\$\\{ROW.*\\}");
        middleStr=fillWithBlank(middleStr,"\\$\\{COL.*\\}");
        middleStr=fillWithBlank(middleStr,"[+*-/:]");
        middleStr=fillWithBlank(middleStr,"[^0-9]");
        System.out.println(originStr.substring(0,6));
        System.out.println(originStr.substring(6,7));
        int[] replaceNums = new int[]{321,1,11,1476,9};

        String newStr = proc(originStr,middleStr,replaceNums);
        System.out.println(newStr);
    }

    public static String proc(String originStr ,String middleStr, int[] replaceNum){
        int begin=0;
        int end=0;
        boolean previousIsNum=false;
        StringBuffer newStr = new StringBuffer();
        int index = 0;
        for(int i=0;i<originStr.length();i++) {
            if (middleStr.substring(i, i + 1).equals("*")) {  //当前是*
                if (previousIsNum) { //上一个是数字
                    //TODO 通过原有行获取新的行
                    String numStr = originStr.substring(begin, end);
                    newStr.append(replaceNum[index]);
                    System.out.println("Number index begin=" + begin + " end=" + end);
                    begin = end++;
                    index++;
                } else {    //上一个是*
                    end++;
                }
                previousIsNum = false;
            } else {         //当前是数字
                if (previousIsNum) { //上一个是数字
                    end++;
                } else {    //上一个是*
                    String stringStr = originStr.substring(begin, end);
                    newStr.append(stringStr);
                    System.out.println("String index begin=" + begin + " end=" + end);
                    begin = end++;
                }
                previousIsNum = true;
            }
        }
        if(!newStr.substring(newStr.length()-1,newStr.length()).equals(")")){
            newStr.append(")");
        }
        return newStr.toString();
    }

    public static String fillWithBlank(String originStr,String regix){
        int originLength=originStr.length();
        originStr = originStr.replaceAll(regix,"~");
        int num = originLength-originStr.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num+1;i++){
            sb.append("*");
        }
        originStr = originStr.replaceAll("~",sb.toString());
        return originStr;
    }
}
