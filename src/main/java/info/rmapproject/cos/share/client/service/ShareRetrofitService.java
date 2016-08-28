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

import info.rmapproject.cos.share.client.model.ResultsPage;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * SHARE Service interface.
 *
 * @author khanson
 */
public interface ShareRetrofitService {

    /**
     * Record list.
     *
     * @return the retrofit call
     */
    @GET("search/")
    Call<ResultsPage> recordList();

    /**
     * Record list.
     *
     * @param params the params
     * @return the retrofit call
     */
    @GET("search/")
    Call<ResultsPage> recordList(@QueryMap Map<String, String> params);
}
