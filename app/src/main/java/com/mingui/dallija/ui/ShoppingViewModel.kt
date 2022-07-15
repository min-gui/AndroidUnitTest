package com.mingui.dallija.ui


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androiddevs.shoppinglisttestingyt.data.local.ShoppingItem
import com.mingui.dallija.data.remote.responses.ImageResponse
import com.mingui.dallija.other.Event
import com.mingui.dallija.other.Resource
import com.mingui.dallija.repositories.ShoppingRepository
import kotlinx.coroutines.launch

class ShoppingViewModel @ViewModelInject constructor(
    private val repository: ShoppingRepository

) : ViewModel() {

    val shoppingItems = repository.observeAllShoppingItems()

    val totalPrice = repository.observeTotalPrice()

    private val _images = MutableLiveData<Event<Resource<ImageResponse>>>()
    val images: LiveData<Event<Resource<ImageResponse>>> = _images

    private val _curImages = MutableLiveData<String>()
    val curImageUrl: LiveData<String> = _curImages

    //쇼핑 아이템 입력 유효성 체크
    private val _insertShoppingItemSatatus = MutableLiveData<Event<Resource<ShoppingItem>>>()
    val insertShoppingItemSatatus: LiveData<Event<Resource<ShoppingItem>>> = _insertShoppingItemSatatus

    fun setCurImageUrl(url: String) {
        _curImages.postValue(url)
    }

    fun deleteShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.deleteShoppingItem(shoppingItem)
    }

    fun insertShoppingItemIntoDb(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.insertShoppingItem(shoppingItem)
    }

    //단지 확인용
    fun insertShoppingItem(name: String, amountString: String, priceString: String) {

    }

    //api 에서 이미지 검색
    fun searchForImage(imageQuery: String) {

    }
}
