package com.example.renzo_medina_seccioncurso

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class DetailEmployee : AppCompatActivity() {
    //list create
    var listData = ArrayList<ItemEmployee>()
    var adaptador : AdapterEmployee? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_employee)

        //up button
        val detailemployee: Toolbar = findViewById(R.id.detailemployeetoolbar)
        setSupportActionBar(detailemployee)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        listData.add(ItemEmployee("Renzo Medina Olaya",R.drawable.avatar_man, "Línea Blanca",R.id.imageButton2))
        listData.add(ItemEmployee("Elizabeth Espinoza H.",R.drawable.avatar_women, "Calzado Mujer",R.id.imageButton2))
        listData.add(ItemEmployee("Ashley Velarde H.",R.drawable.avatar_women, "Calzado Hombre",R.id.imageButton2))
        listData.add(ItemEmployee("Javier Morales C.",R.drawable.avatar_man, "Calzado niños",R.id.imageButton2))
        listData.add(ItemEmployee("Carmen Silva G.",R.drawable.avatar_women, "Tecnología",R.id.imageButton2))
        listData.add(ItemEmployee("Luis García García",R.drawable.avatar_man, "Ropa Mujer",R.id.imageButton2))
        listData.add(ItemEmployee("Denis Vidaurre G.",R.drawable.avatar_man, "Ropa Hombre",R.id.imageButton2))

        adaptador = AdapterEmployee(this, listData)
        val lis_detail = findViewById<View>(R.id.list_view_employee) as ListView

        lis_detail.adapter = adaptador
    }
}