package com.jslee.mvvmsample.data

import androidx.lifecycle.LiveData
import com.jslee.mvvmsample.data.dao.AdData

class AdRepository {

    private val localDataSource = LocalDatasource()
    private val remoteDatasource = RemoteDatasource()

    suspend fun refreshAdData(){
        val dataList = remoteDatasource.getAdDataList()
        localDataSource.setAdData(dataList)
    }


    suspend fun getAdImages(): LiveData<List<String>>{
        val list = localDataSource.getAdImages()


        return
    }




}