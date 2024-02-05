package com.example.renzo_medina_seccioncurso

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val detail_employee = findViewById<Button>(R.id.list_employees)
        detail_employee.setOnClickListener {
            val intento = Intent (this, DetailEmployee::class.java)
            startActivity(intento)
        }

        val best_employee = findViewById<Button>(R.id.employee)
        best_employee.setOnClickListener {
            val intento = Intent (this, BestEmployee::class.java)
            startActivity(intento)
        }

        val sale_kpi = findViewById<Button>(R.id.graphic)
        sale_kpi.setOnClickListener {
            val intento = Intent (this, SaleKpi::class.java)
            startActivity(intento)
        }
    }
}