package ca.keaneq.uniteguide.ui.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Coming Soon!"
    }
    val text: LiveData<String> = _text
}