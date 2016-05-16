package info.rmapproject.cos.share.client.service;

import info.rmapproject.cos.share.client.model.ResultsPage;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * SHARE Service interface
 * @author khanson
 */
public interface ShareRetrofitService {

    @GET("search/")
    Call<ResultsPage> recordList();

    @GET("search/")
    Call<ResultsPage> recordList(@QueryMap Map<String, String> params);
}
