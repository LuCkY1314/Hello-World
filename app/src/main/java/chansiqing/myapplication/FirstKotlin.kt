package chansiqing.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.HORIZONTAL
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.io.Serializable

/**
 * kotlin实例
 *
 * @author: chansiqing
 * @date: 2018-07-25 15:46
 */
class FirstKotlin : AppCompatActivity(), LeakManager.Companion.LeakListener {
    override fun onListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var recycleView: RecyclerView
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text)
        textView.text = "sb"
        textView.setOnClickListener {
            print("sb")
        }
        recycleView = findViewById(R.id.recycle_view)
        recycleView.adapter = MyAdapter(this, initData())
        recycleView.addItemDecoration(DividerItemDecoration(this, HORIZONTAL))
        recycleView.layoutManager = LinearLayoutManager(this)
        LeakManager.instance?.addListener(this)
    }

    private fun initData(): List<MyData> {
        return listOf(MyData("sb", "11"), MyData("ss", "22"), MyData("sbb", "33"))
    }

    companion object {
        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var nameView: TextView = itemView.findViewById(R.id.name_tv)
            var ageView: TextView = itemView.findViewById(R.id.age_tv)
        }

        class MyAdapter(context: Context, data: List<MyData>?) : RecyclerView.Adapter<MyViewHolder>() {
            private var list: List<MyData>? = data
            private var context: Context = context
            private var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
                return MyViewHolder(layoutInflater.inflate(R.layout.item_list, parent, false))
            }

            override fun getItemCount(): Int {
                return list?.size ?: 0
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                var myData = list?.get(position)
                holder.nameView.text = myData?.name ?: ""
                holder.ageView.text = myData?.age ?: ""
                holder.nameView.setOnClickListener {
                    val intent = Intent(context, DrawActivity::class.java)
                    context.startActivity(intent)
                }
            }
        }

        class MyData(name: String, age: String) : Serializable {
            var name: String = name
            var age: String = age
        }
    }
}