package postman;

import okhttp3.*;

import java.io.IOException;

public class Tingdan {
    public static void main(String[] args) {
        pullTask();
    }

    public static void pullTask(){
        long requsetId=20000000087799647l;
        int id=355;
        for (int i = 0; i <1; i++) {
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }

            requsetId++;
            id++;
            MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            String requestBody = "{\n" +
                    "    \"dataList\": [\n" +
                    "       {\n" +
                    "    \"userId\":17095433,\n" +
                    "    \"requestId\":"+requsetId+", \n" +
                    "    \"businessType\":"+(90+10*(i%5))+",\n" +
                    "    \"userType\":2,\n" +
                    "    \"invalidTime\":1699232556,\n" +
                    "    \"title\":\"标题123\",\n" +
                    "    \"msgContent\":\"{\\\"id\\\":"+id+",\\\"content\\\":[\\\"投诉：不送货上门\\\",\\\"罚款金额：" +
                    "X元cdcddccdcdcdcdcdcdcdcdcdcdcdcdcdcdcdcdcdcdcddcdcdcdcdcdcdcdcdcdcd\\\",\\\"投诉时间：X月X日\\\"]," +
                    "\\\"desc\\\":\\\"请务必送货上门，送货上楼。\\\",\\\"title\\\":\\\"您有1条投诉，请注意！\\\"" +
                    ",\\\"pushTitle\\\":\\\""+requsetId+"你在X月X日因客户投诉罚款Y元\\\",\\\"orderid\\\":123}\",\n" +
                    "    \"summary\":287642876427\n" +
                    "}\n" +
                    "    ]\n" +
                    "}";
            Request request = new Request.Builder()
                    .url("http://notice-service.ndev.imdada.cn/notice/msg/receive")
                    .post(RequestBody.create(JSON, requestBody))
                    .addHeader("cache-control","no-cache")
                    .addHeader("content-type","application/json")
                    .addHeader("postman-token","b88c95f5-8a81-9ad1-3c1a-3ddfb855f32c")
                    .build();
            OkHttpClient okHttpClient = new OkHttpClient();
            long finalRequsetId = requsetId;
            int finalId = id;
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println("  "+e.getMessage());
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    System.out.println(finalRequsetId +":"+ finalId +" : "+response.body().string());
                }
            });
        }
    }
}
