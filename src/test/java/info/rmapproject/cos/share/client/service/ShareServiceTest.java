/*******************************************************************************
 * Copyright 2016 Johns Hopkins University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * This software was produced as part of the RMap Project (http://rmap-project.info),
 * The RMap Project was funded by the Alfred P. Sloan Foundation and is a 
 * collaboration between Data Conservancy, Portico, and IEEE.
 *******************************************************************************/
package info.rmapproject.cos.share.client.service;

import static org.junit.Assert.assertNotNull;
import info.rmapproject.cos.share.client.model.ResultsPage;

import java.util.HashMap;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Tests for SHARE service
 */
public class ShareServiceTest {


    /**
     * Test get SHARE Record.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetShareRecord() throws Exception {
        
    	ObjectMapper mapper = new ObjectMapper();
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://osf.io/api/v1/share/")
                .addConverterFactory(JacksonConverterFactory.create(mapper))
                .build();
        
        ShareRetrofitService sharesvc = retrofit.create(ShareRetrofitService.class);

        HashMap<String, String> params = new HashMap<>();
        params.put("q", "heart");
        Call<ResultsPage> listCall = sharesvc.recordList(params);
        assertNotNull(listCall);
        Response<ResultsPage> res = listCall.execute();
        assertNotNull(res);
        
        ResultsPage shareRecords = null;
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
