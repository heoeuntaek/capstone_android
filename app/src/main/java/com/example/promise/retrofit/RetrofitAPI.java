package com.example.promise.retrofit;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface RetrofitAPI {

    //    Call<Model> findById(@Body Model model); //이건 바디 요청시 사용하는거
    @GET("api/users/1")
    Call<User_Model> firstUser();

    @GET("api/users/{id}")
    Call<User_Model> findById(@Path("id") Long id);


    @POST("api/users")
    Call<User_Model> register(@Body User_Model model);

    @POST("api/login")
    Call<User_Model> login(@Body User_Model model);


    @GET("api/user_id/{user_login_id}")
    Call<User_Model>findByUser_login_id(@Path("user_login_id") String user_login_id);

    @GET("api/user_id_dto/{user_login_id}")
    Call<User_Model_dto>findByUser_login_id_dto(@Path("user_login_id") String user_login_id);


    //그룹 생성
    @POST("api/group/{user_id}")
    Call<Group_Model> createGroup(@Path("user_id") Long user_id, @Body Group_Model group_model);

    @DELETE("api/group/{group_id}/{user_login_id}")
    Call<User_Model> deleteGroup(@Path("group_id") String group_id
                , @Path("user_login_id") String user_login_id);

    @GET("api/groupcode/{group_code}")
    Call<Group_Model>findBy_group_code(@Path("group_code") String group_code);

    //그룹 참가
    @PATCH("api/groupcode/{group_code}/{user_login_id}")
    Call<User_Model> participe_group(@Path("group_code") String group_code
            , @Path("user_login_id") String user_login_id);
    //group_code로 group_id 불러오기 -get
    //user_login_id로 user객체 불러와서 객체에 user_group주입, 업데이트 -patch

    //스케줄 생성
    @POST("api/schedule/{user_id}")
    Call<Schedule_Model> createSchedule(@Path("user_id") Long user_id,@Body Schedule_Model schedule_model);

    /*@GET("api/data")
    Call<Schedule_Model> getData(@Query("shcedule_name") String schedule_name, @Query("data") String data);*/

    @FormUrlEncoded
    @POST("api/data")
    Call<Schedule_Model> createSchedule(@FieldMap HashMap<String, Object> param);




    /*@FormUrlEncoded
    @POST("api/schedule/{color_data}")
    Call<Schedule_Model> setSchedule_data(
            @FieldMap Map<String, Object> fields);
    @FormUrlEncoded
    @POST("posts")
    Call<Schedule_Model> createPost(@FieldMap Map<String, String> fields);*/




//    @FormUrlEncoded
//    @POST("api/users")
//    Call<Model> postData(
//            @Field("user_id") String user_id,
//            @Field("user_pass") String user_pass,
//            @Field("user_name") String user_name
//    );

    //@FormUrlEncoded
    //@POST("/auth/overlapChecker")
    //Call<Model__CheckAlready> postOverlapCheck(@Field("phone") String phoneNum, @Field("message") String message); //이건 요청시 사용하는거 (*데이터를 보낼때)
}



