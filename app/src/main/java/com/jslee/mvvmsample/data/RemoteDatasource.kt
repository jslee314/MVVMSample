package com.jslee.mvvmsample.data

import com.jslee.mvvmsample.AdApi
import com.jslee.mvvmsample.data.dao.AdData

class RemoteDatasource {

    suspend fun getAdDataList(): List<AdData>{
        return AdApi.adService.callAd().data
    }

}