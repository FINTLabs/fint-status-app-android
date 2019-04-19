package no.fint.status

class StatusRepository(val api: StatusApi) {
    suspend fun fetchApiStatus() = api.fetchApiStatus()
}
