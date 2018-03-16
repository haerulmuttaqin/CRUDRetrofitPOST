package com.haerul.crudretrofitpost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by haerul on 15/03/18.
 */

public interface ApiInterface {

    @POST("retrofit/POST/readcontacts.php")
    Call<List<Contacts>> getContacts();

    @FormUrlEncoded
    @POST("retrofit/POST/addcontact.php")
    public Call<Contacts> insertUser(
            @Field("name") String name,
            @Field("email") String email);

    @FormUrlEncoded
    @POST("retrofit/POST/editcontact.php")
    public Call<Contacts> editUser(
            @Field("id") String id,
            @Field("name") String name,
            @Field("email") String email);
}
