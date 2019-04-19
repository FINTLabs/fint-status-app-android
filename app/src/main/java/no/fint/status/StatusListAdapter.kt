package no.fint.status

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.internal.LinkedTreeMap
import kotlinx.android.synthetic.main.status_element.view.*
import no.fint.status.model.HealthCheckResponse

class StatusListAdapter(private val context: Context) : RecyclerView.Adapter<StatusListAdapter.ViewHolder>() {

    private var statusList: List<HealthCheckResponse> = emptyList()

    fun setData(dataSet: List<HealthCheckResponse>) {
        statusList = dataSet
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.status_element, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return statusList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = statusList[position].apiBaseUrl
        if (isHealthy(statusList[position])) {
            holder.statusIcon.setImageResource(R.drawable.ic_status_up_24dp)
        } else {
            holder.statusIcon.setImageResource(R.drawable.ic_status_down_24dp)
        }
    }

    private fun isHealthy(healthCheckResponse: HealthCheckResponse): Boolean {
        val data = healthCheckResponse.event.data

        if (data?.size == 4) {
            if (data[0] is LinkedTreeMap<*, *>) {
                for (health in data) {
                    if ((health as LinkedTreeMap<*, *>)["status"]?.equals("APPLICATION_HEALTHY")!!) {
                        return true
                    }
                }
            }
        }
        return false

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.component_name
        val statusIcon: ImageView = itemView.status_icon

    }

}