package info.rmapproject.cos.share.client.service;

import info.rmapproject.cos.share.client.model.RecordList;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * SHARE Service interface
 * @author khanson
 */
public interface ShareService {

    @GET("search/")
    Call<RecordList> recordList();

    @GET("search/")
    Call<RecordList> recordList(@QueryMap Map<String, String> params);
}
