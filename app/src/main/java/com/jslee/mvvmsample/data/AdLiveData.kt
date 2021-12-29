package com.jslee.mvvmsample.data

import androidx.lifecycle.LiveData
import com.jslee.mvvmsample.data.dao.AdData


class AdLiveData(dataList: List<AdData>) : LiveData<List<AdData>>() {
    private val adManager = AdListManager(dataList)

    //setValue(T) 메서드는 LiveData 인스턴스의 값을 업데이트하고 모든 활성 상태의 관찰자에게 변경사항을 알립니다.
    private val listener = { adDataList: List<AdData> ->
        value = adDataList
    }

    // onActive() 메서드는 LiveData 객체에 활성 상태의 관찰자가 있을 때 호출됩니다. 즉, 이 메서드에서 주가 업데이트 관찰을 시작해야 합니다.
    override fun onActive() {
        adManager.requestPriceUpdates(listener)
    }

    //onInactive() 메서드는 LiveData 객체에 활성 상태의 관찰자가 없을 때 호출됩니다. 수신 대기 중인 관찰자가 없으므로 StockManager 서비스에 연결된 상태를 유지할 필요가 없습니다.
    override fun onInactive() {
        adManager.removeUpdates(listener)
    }
}


class AdListManager(adDataList: List<AdData>){

    fun requestPriceUpdates(dataList) {

    }

    fun removeUpdates(dataList) {

    }
}