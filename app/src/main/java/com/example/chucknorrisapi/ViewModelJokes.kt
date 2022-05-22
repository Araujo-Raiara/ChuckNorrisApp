package com.example.chucknorrisapi
import android.app.Service
import android.text.Editable
import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelJokes : ViewModel() {
    val service =  retrofit.create(ChuckNorrisJokesApiService::class.java)
    val liveDataCategories = MutableLiveData<ValueListOfCategories>()
    val liveDataSearchResponse = MutableLiveData<SearchResponse>()
    val liveData = MutableLiveData<Jokes>()

    fun getJokeByCategory(chosenCategory : String?) {
        service.getJokeByCategory(category = chosenCategory!!).enqueue(object : Callback<Jokes> {
            override fun onResponse(call: Call<Jokes>, response: Response<Jokes>) {
                if (response.isSuccessful) {
                    liveData.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                TODO("Not yet implemented")
            } })

    }
    fun getRandomJoke(){
        service.getRandomJoke().enqueue(object : Callback<Jokes>{
            override fun onResponse(call: Call<Jokes>, response: Response<Jokes>) {
                if (response.isSuccessful){
                    liveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<Jokes>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    fun getCategories(){
        service.getCategories().enqueue(object : Callback<ValueListOfCategories>{
            override fun onResponse(call: Call<ValueListOfCategories>, response: Response<ValueListOfCategories>) {
                if (response.isSuccessful){
                    liveDataCategories.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ValueListOfCategories>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
    fun getSearchJoke(text : String) {
        service.getSearchJoke(text).enqueue(object : Callback<SearchResponse>{
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                if (response.isSuccessful){
                    liveDataSearchResponse.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}
