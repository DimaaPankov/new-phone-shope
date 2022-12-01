package ru.skillbranch.phone_shop.view.ViewModel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.skillbranch.data.network.repository.DataImpl
import ru.skillbranch.phone_shop.viewmodel.MainViewModel


class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(DataImpl) as T
    }
}


