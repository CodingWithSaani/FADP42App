package com.tutorials180.fadp42app.FBWorking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.tutorials180.fadp42app.R
import java.lang.Exception

class FirestoreWorkingActivity : AppCompatActivity() {

    private lateinit var addSingleDocumentBtn:Button
    private lateinit var addSingleDocumentWithKeyBtn:Button

    private lateinit var getSingleDocumentBtn:Button
    private lateinit var getCompleteCollectionBtn:Button

    private lateinit var fbDataTV:TextView
    private var mFirebaseFirestore = Firebase.firestore

    private lateinit var progressBar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firestore_working)

        connector()
    }

    private fun connector()
    {
        addSingleDocumentBtn = findViewById(R.id.addDataToFBBtn)
        addSingleDocumentWithKeyBtn = findViewById(R.id.addDataToFBWithKeyBtn)

        getSingleDocumentBtn = findViewById(R.id.getSingleDocumentFromFBBtn)
        getCompleteCollectionBtn = findViewById(R.id.getCompleteCollectionBtn)

        fbDataTV = findViewById(R.id.fbDataTV)
        progressBar = findViewById(R.id.progressBar)
        listeners()
    }

    private fun listeners()
    {
        addSingleDocumentBtn.setOnClickListener {
            addSingleDocumentToFirebase()
        }

        addSingleDocumentWithKeyBtn.setOnClickListener {
            addSingleDocumentWithKeyToFirebase()
        }

        getSingleDocumentBtn.setOnClickListener {
            getSingleDocument()
        }
    }

    private fun getSingleDocument() {
        try
        {
            progressBar.visibility = View.VISIBLE
            mFirebaseFirestore.collection("StudentRecord")
                .document("ahmad_hassan")
                .get()
                .addOnSuccessListener {
                    progressBar.visibility = View.INVISIBLE
                    fbDataTV.text = "${it.getString("name")} \n ${it.getLong("age")}"
                }
                .addOnFailureListener {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message.toString()}", Toast.LENGTH_SHORT).show();
                }
        }
        catch (ex:Exception)
        {
            progressBar.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun addSingleDocumentToFirebase() {
        try
        {
            var ourDocument = HashMap<String,Any>()
            ourDocument.set("name","Ali Raza")

            ourDocument.set("age",27)
            ourDocument.set("email","ar@ar.com")

            mFirebaseFirestore.collection("StudentRecord")
                .add(ourDocument)
                .addOnSuccessListener {
                    Toast.makeText(applicationContext, "Document added", Toast.LENGTH_SHORT).show();
                }
                .addOnFailureListener {
                    Toast.makeText(applicationContext, "${it.message.toString()}", Toast.LENGTH_SHORT).show();
                }
        }
        catch (ex:Exception)
        {
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }

    private fun addSingleDocumentWithKeyToFirebase() {
        try
        {
            var ourDocument = hashMapOf(
                "name" to "Ahmad Hassan",
                "age"  to 40
            )

            progressBar.visibility = View.VISIBLE
            mFirebaseFirestore.collection("StudentRecord")
                .document("ahmad_hassan")
                .set(ourDocument)
                .addOnSuccessListener { _:Void? ->
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "Document added", Toast.LENGTH_SHORT).show();
                }
                .addOnFailureListener {
                    progressBar.visibility = View.INVISIBLE
                    Toast.makeText(applicationContext, "${it.message.toString()}", Toast.LENGTH_SHORT).show();
                }
        }
        catch (ex:Exception)
        {
            progressBar.visibility = View.INVISIBLE
            Toast.makeText(applicationContext, "${ex.message}", Toast.LENGTH_SHORT).show();
        }
    }


}