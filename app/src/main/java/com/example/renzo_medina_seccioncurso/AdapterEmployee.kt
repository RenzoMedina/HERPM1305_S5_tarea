package com.example.renzo_medina_seccioncurso

import android.content.Context
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterEmployee:BaseAdapter {

    var contexto : Context? = null
    var dataList = ArrayList<ItemEmployee>()

    constructor(
        contexto: Context,
        lista: ArrayList<ItemEmployee>
    ):super(){
        this.contexto = contexto
        this.dataList = lista
    }
    
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var vistaDatos = p1
        val datos = dataList[p0]

        if (vistaDatos == null){
            val inflator = LayoutInflater.from(contexto)
            vistaDatos = inflator.inflate(R.layout.item_employee, null)

        }
        val imagen = vistaDatos?.findViewById<View>(R.id.imagenview) as ImageView
        val name = vistaDatos.findViewById<View>(R.id.nameemployee) as TextView
        val cargo = vistaDatos.findViewById<View>(R.id.cargoemployee) as TextView
        val iconAudio = vistaDatos.findViewById<View>(R.id.imageButton2)

        imagen.setImageResource(datos.image)
        name.text = datos.name
        cargo.text = datos.cargo
        iconAudio.setOnClickListener {
           audioPrueba()
        }
        return vistaDatos
    }

    override fun getCount(): Int {
       return dataList.size
    }

    override fun getItem(p0: Int): Any {
        return dataList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }
    //función para cargar el audio
    fun audioPrueba() {
        val audio = MediaPlayer.create(contexto, R.raw.audio_prueba)
        audio.start()
    }

}
