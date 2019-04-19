package no.fint.status

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
        inflate.setOnClickListener(View.OnClickListener {

        })

        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return statusList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = statusList.get(position).apiBaseUrl
        if (statusList.get(position).event.corrId != null) {
            holder.statusIcon.setImageResource(R.drawable.ic_status_up_24dp)
        } else {
            holder.statusIcon.setImageResource(R.drawable.ic_status_down_24dp)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.component_name
        val statusIcon = itemView.status_icon

    }

}