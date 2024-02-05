package com.example.renzo_medina_seccioncurso

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph


class SaleKpi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sale_kpi)

        val kpitoolbar: Toolbar = findViewById(R.id.kpitoolbar)
        setSupportActionBar(kpitoolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)


        var puntos = ArrayList<Bar>()
        val bar1 = Bar()
        bar1.color = Color.parseColor(R.color.blue.toString())
        bar1.name = "Test1"
        bar1.value = 10f
        val bar2 = Bar()
        bar2.color = Color.parseColor(R.color.danger.toString())
        bar2.name = "Test2"
        bar2.value = 20f
        bar2.value = 20f
        puntos.add(bar1)
        puntos.add(bar2)

        val graph = findViewById<View>(R.id.graph) as BarGraph
        graph.bars = puntos

    }


}
