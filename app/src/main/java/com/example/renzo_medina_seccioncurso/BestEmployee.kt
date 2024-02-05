package com.example.renzo_medina_seccioncurso

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.core.view.drawToBitmap
import java.io.File
import java.io.OutputStream
import java.util.Objects

class BestEmployee : AppCompatActivity() {

    private lateinit var file: File
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_employee)

        val bestemployee: Toolbar = findViewById(R.id.employeetoolbar)
        setSupportActionBar(bestemployee)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)

        val takephoto = findViewById<Button>(R.id.camera)
        val savephoto = findViewById<Button>(R.id.save)


        takephoto.setOnClickListener {
             startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
        val photo = findViewById<ImageView>(R.id.photo)
        savephoto.setOnClickListener {
            val imagebit = photo.drawToBitmap()
            saveImageToGallery(imagebit)

        }
    }

    //función de tomar la foto
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == Activity.RESULT_OK){
            val intent = result.data
            val imageBit = intent?.extras!!.get("data") as Bitmap
            val photo = findViewById<ImageView>(R.id.photo)
            photo.setImageBitmap(imageBit)
        }
    }


    //función para almacenar foto

    private fun saveImageToGallery(bitmap: Bitmap){
        val fos : OutputStream?
        try {
            val resolver = contentResolver
            val contenValues = ContentValues()
            contenValues.put(MediaStore.MediaColumns.DISPLAY_NAME,"Image_"+"jpg")
            contenValues.put(MediaStore.MediaColumns.MIME_TYPE,"image/jpg")
            contenValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES+File.separator+"TareaS5")
            contenValues.put(MediaStore.MediaColumns.IS_PENDING,0)
            val imageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contenValues)

            if (imageUri != null){
                resolver.openOutputStream(imageUri)?.use {
                    fos->
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                        Objects.requireNonNull(fos)
                    Toast.makeText(this, "Se guardado correctamente la foto", Toast.LENGTH_LONG).show()
                }?:run{
                    Toast.makeText(this, "Error al abrir OutputStream", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Error al obtener la URI de la imagen", Toast.LENGTH_LONG).show()
            }

        }catch (e: Exception){
            Toast.makeText(this, "${e.printStackTrace()}", Toast.LENGTH_LONG).show()
        }
    }




}