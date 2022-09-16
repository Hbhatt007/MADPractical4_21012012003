package com.example.madpractical4_21012012003

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText=findViewById<TextInputEditText>(R.id.textField_browse)
        val editTextCall=findViewById<TextInputEditText>(R.id.textField_call)

        val button_call=findViewById<Button>(R.id.button_call)
        button_call.setOnClickListener {
            Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel: " + editTextCall.text)).apply {
                startActivity(this)
            }
        }

        val button_url=findViewById<Button>(R.id.button_browse)
        button_url.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://" + editText.text)).apply {
                startActivity(this)
            }
        }

        val button_contact=findViewById<Button>(R.id.button_contact)
        button_contact.setOnClickListener(View.OnClickListener {
            intent=Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)
        })

        val button_calllog=findViewById<Button>(R.id.button_call_log)
        button_calllog.setOnClickListener(View.OnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("content://call_log/calls")
            startActivity(intent)
        })

        val button_gallery=findViewById<Button>(R.id.button_gallery)
        button_gallery.setOnClickListener(View.OnClickListener {
            intent= Intent()
            intent.setAction(Intent.ACTION_VIEW)
            intent.setType("image/*")
            startActivity(intent)
        })

        val button_alarm = findViewById<Button>(R.id.button_alarm)
        button_alarm.setOnClickListener(View.OnClickListener {
//            Intent(AlarmClock.ACTION_SET_ALARM).apply {
//                putExtra(AlarmClock.EXTRA_MESSAGE,"New Alarm")
//                putExtra(AlarmClock.EXTRA_HOUR,12)
//                putExtra(AlarmClock.EXTRA_MINUTES,0)
//                startActivity(this)
//            }
            Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm")
                putExtra(AlarmClock.EXTRA_HOUR, 12)
                putExtra(AlarmClock.EXTRA_MINUTES, 0)
                startActivity(this)
            }
//            intent = Intent(AlarmClock.ACTION_SET_ALARM)
//            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
//            startActivity(intent)
        })

        val button_camera = findViewById<Button>(R.id.button_camera)
        button_camera.setOnClickListener(View.OnClickListener {
            intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        })
    }
}