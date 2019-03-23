package com.calderon.brayan.kotlin

import android.support.v7.widget.RecyclerView
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.layout.view.*

//import kotlinx.android.synthetic.main.layout.view.*

class AdaptadorCustome(items:ArrayList<Persona>, var clickListener: click):RecyclerView.Adapter<AdaptadorCustome.ViewHolder>() {

    var items:ArrayList<Persona>?=null
    var viewHolder:ViewHolder? = null

    init {
        this.items = items
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {//Permite bandear la informacion con mi template
        val item = items?.get(p1)
        p0.nombre?.text = item?.nombre
        p0.nacionalidad?.text = item?.nacionalidad
        p0.foto?.setImageResource(item?.foto!!)
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewTipe: Int): AdaptadorCustome.ViewHolder{//Crea la lista... Inflate coge un archivo XML y lo inserta en la vista
    //override fun onCreateViewHolder(p0: ViewGroup?, viewType: Int): AdaptadorCustome.ViewHolder{
        val vista = LayoutInflater.from(p0?.context).inflate(R.layout.layout, p0, false)
        viewHolder = ViewHolder(vista, clickListener)
        return viewHolder!!

    }

    override fun getItemCount(): Int {//Regresa el numero de elementos que tiene mi lista de datos
        return this.items?.count()!!
    }

    class ViewHolder(vista: View, listener: click): RecyclerView.ViewHolder(vista), View.OnClickListener{

        //var listener: View.OnClickListener?=null
        var vista=vista
        var foto:ImageView? = null
        var nombre:TextView? = null
        var nacionalidad: TextView? = null
        var listener:click? = null

        init {
            foto=vista.foto
            nombre=vista.tvNombre
            nacionalidad=vista.tvApellido
            this.listener=listener
            vista.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener?.onClick(v!!, adapterPosition)
        }

    }

}