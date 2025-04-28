package me.gomer.nsu_mmf.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.gomer.nsu_mmf.Item
import me.gomer.nsu_mmf.network.NumberApi

class SecondViewModel(
    private val mapper: SecondMapper,
    private val numberApi: NumberApi,
) : ViewModel() {

    private val _state: MutableStateFlow<SecondState> = MutableStateFlow(
        SecondState(
            list = emptyList(),
            title = "",
            subtitle = "",
        )
    )
    val state: StateFlow<SecondState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val response = numberApi.getNumberFacts(
                min = 1,
                max = 10,
            )
            if (response.isSuccessful) {
                val body = response.body()
            }
        }
        val list = mapper.getListItems()
        _state.update { state ->
            state.copy(
                list = list
            )
        }
    }

}

class SecondViewModelFactory(
    private val mapper: SecondMapper,
    private val numberApi: NumberApi,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SecondViewModel(
            mapper = mapper,
            numberApi = numberApi,
        ) as T
    }
}