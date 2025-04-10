package me.gomer.nsu_mmf.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.gomer.nsu_mmf.Item

class SecondViewModel(
    private val mapper: SecondMapper
) : ViewModel() {

    private val _state: MutableLiveData<List<Item>> = MutableLiveData()
    val state: LiveData<List<Item>> = _state

    init {
        val list = mapper.getListItems()
        _state.value = list
    }

}

class SecondViewModelFactory(
    private val mapper: SecondMapper,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SecondViewModel(
            mapper = mapper,
        ) as T
    }
}