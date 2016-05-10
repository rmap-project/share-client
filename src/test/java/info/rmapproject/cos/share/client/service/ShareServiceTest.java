package info.rmapproject.cos.share.client.service;

import static org.junit.Assert.assertNotNull;
import info.rmapproject.cos.share.client.model.RecordList;

import java.util.HashMap;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ShareServiceTest {


    @Test
    public void testGetShareRecord() throws Exception {
        
    	ObjectMapper mapper = new ObjectMapper();;
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://osf.io/api/v1/share/")
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
        
        ShareService sharesvc = retrofit.create(ShareService.class);

        HashMap<String, String> params = new HashMap<>();
        params.put("q", "heart");
        Call<RecordList> listCall = sharesvc.recordList(params);
        assertNotNull(listCall);
        Response<RecordList> res = listCall.execute();
        assertNotNull(res);
        
        RecordList shareRecords = null;
        if (!res.isSuccessful()) {
            assertNotNull(res.errorBody());
            System.err.println(res.errorBody().string());
        } else {
        	shareRecords = res.body();
        }

        assertNotNull(shareRecords);

        shareRecords.getRecords().stream().forEach(n -> {
            System.out.println("SHARE: title=" + n.getTitle());
        });
    }
}
