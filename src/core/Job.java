package core;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Job {
    private static volatile List<Job> requests_queue = new ArrayList<>();
    public static List<Job> get_response_queue(){
        if(requests_queue ==null){
            requests_queue = new ArrayList<>();
            return requests_queue;
        }else return requests_queue;
    }
    public static void try_send_all(){
        if(!requests_queue.isEmpty()){
            try{
                for (Job job : requests_queue){
                    job.send(job.getUrl(), job.getUrlParameters());
                }
            }catch (Exception e){

            }
        }
    }

    public static String send_and_get(String url, List<NameValuePair> urlParameters) throws IOException {
        String result = "";
        HttpPost post = new HttpPost(url);

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
    private boolean send(String url, List<NameValuePair> urlParameters) throws IOException {
        String result = "";
        HttpPost post = new HttpPost(url);

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());
            System.out.println(result);

        }catch (Exception e){

            e.printStackTrace();

        }

        switch (result){
            case "true": Job.requests_queue.remove(this);
                return true;
            case "false":
                System.err.println("Не удалось отправить запрос");
                return false;
            default:
                return false;
        }
    }

    private String url;
    private List<NameValuePair> urlParameters;

    public Job(String url, List<NameValuePair> urlParameters){
        this.url = url;
        this.urlParameters = urlParameters;
        Job.requests_queue.add(this);

        new Thread(() -> {
            if(!Job.requests_queue.isEmpty()){
                Job.try_send_all();
            }
        }).start();

    }

    public String getUrl() {
        return url;
    }
    public List<NameValuePair> getUrlParameters() {
        return urlParameters;
    }


}
