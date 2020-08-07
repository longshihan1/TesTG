import ddd.SaveData;

public class YUN {

    public static void main(String[] args) {
        YUU();
    }
    private static void YUU(){
        long _s_dataTime=System.currentTimeMillis();
        SaveData.saveFirst(_s_dataTime,"11","111");
        System.out.println("ccc");
        SaveData.saveFirst(_s_dataTime,"11","111");
    }
}
