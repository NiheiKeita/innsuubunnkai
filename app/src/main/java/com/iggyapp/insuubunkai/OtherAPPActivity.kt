package com.iggyapp.insuubunkai

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_other_appactivity.*
import kotlinx.android.synthetic.main.adapter_other_app.view.*


class OtherAPPActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_appactivity)
        val array = arrayOf("ひたすら素因数分解","ひたすら積分","ひたすら微分","鬼封じの縄")
        val adapter = OtherAppAdapter(array)

        mRecyclerView = recycler_app as RecyclerView
        mRecyclerView!!.layoutManager = LinearLayoutManager(this)
        mRecyclerView!!.setAdapter(adapter)

        back_button.setOnClickListener {
            startActivity(Intent(this, TopActivity::class.java))
            overridePendingTransition(0, 0)
            finishAffinity()
        }
    }
    inner class OtherAppAdapter(
        var array: Array<String>,
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        inner class InformationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            fun onBind(position: Int){
                val item = array[position]
                itemView.app_title.text = item
                when(item){
                    "ひたすら素因数分解" ->{
                        itemView.app_image.setImageResource(R.drawable.soinnsuubunnkai)
                    }
                    "ひたすら積分" ->{
                        itemView.app_image.setImageResource(R.drawable.sekibunn)
                    }
                    "ひたすら微分" ->{
                        itemView.app_image.setImageResource(R.drawable.bibunn)
                    }
                    "鬼封じの縄" ->{
                        itemView.app_image.setImageResource(R.drawable.onihuuji)
                    }
                }
                itemView.setOnClickListener {
                    when(item){
                        "ひたすら素因数分解" ->{
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.iggyapp.soinnsuubunnkai"))
                            startActivity(intent)
                        }
                        "ひたすら積分" ->{
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.iggyapp.sekibunn"))
                            startActivity(intent)
                        }
                        "ひたすら微分" ->{
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.iggyapp.bibunn"))
                            startActivity(intent)
                        }
                        "鬼封じの縄" ->{
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.iggy.catchthedemon"))
                            startActivity(intent)
                        }
                    }
                }
            }
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            val v: View = LayoutInflater.from(this@OtherAPPActivity).inflate(
                R.layout.adapter_other_app,
                parent,
                false
            )
            return InformationViewHolder(v)
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            (holder as InformationViewHolder).onBind(position)
        }

        override fun getItemCount(): Int = array.size

    }
}