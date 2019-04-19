package no.fint.status

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import no.fint.status.model.HealthCheckResponse

class StatusViewModel : ViewModel() {

    lateinit var statusRepository: StatusRepository

    private val status: MutableLiveData<List<HealthCheckResponse>> by lazy {
        MutableLiveData<List<HealthCheckResponse>>().also {
            loadStatus()
        }
    }

    fun loadStatus() {
        viewModelScope.launch {
            val deferred = async(Dispatchers.IO) { statusRepository.fetchApiStatus() }
            status.value = deferred.await()
        }
    }

    fun getApiStatus() = status
}