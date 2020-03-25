package com.example.secondlabbondarenko

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pet_details.*
import android.app.Activity
import android.widget.TextView
import android.widget.Toast



class PetDetails : AppCompatActivity(){


    var REQUEST_CODE = 100 //код активності, яка буде запущенна


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_details)

        initEditInfo()


    }


    //Приклад явного наміру з отриманням результату
    //Ф-ція, що ініціалізує обробник кнопки buttonChangeInfo. Ця кнопка запускає активність activity_edit_pet_info.
    private fun initEditInfo() = buttonChangeInfo.setOnClickListener {
        //Створення об'єкту класу Intent, в якому зазаначаємо, який Kotlin-клас буде запущено
        val intent = Intent(this, EditPetDetails ::class.java)
        //Передаємо у метод, що запускає іншу активність, об'єкту класу Intent та REQUEST_CODE, який відповідає активності яку ми запускаємо
        startActivityForResult(intent,REQUEST_CODE)

    }


    //Перевизначення методу onActivityResult
    @SuppressLint("MissingSuperCall", "SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) { //Якщо REQUEST_CODE відповідає саме тій активності, яка нам потрібна
            if (resultCode == Activity.RESULT_CANCELED) { //Якщо була натиснута кнопка "Назад"
                Toast.makeText(this, "Вы не сохранили данные", Toast.LENGTH_SHORT).show()
            } else if (resultCode == Activity.RESULT_OK) {  //Якщо були збережені дані
                if (data != null) {
                    val textPetName = data.getStringExtra("resultEditNamePet") //Отримуємо результат(інформацію) с іншої активності
                    val textAgePet = data.getStringExtra("resultEditAgePet")
                    val textNameHuman = data.getStringExtra("resultEditNameHuman")
                    if (textPetName != null && textAgePet != null && textNameHuman != null) {//Якщо інформація була введена, зберегіємо зміни на поточній активності
                        val tvPetName = findViewById<TextView>(R.id.petName)
                        tvPetName.setText(textPetName)

                        val tvPetAge = findViewById<TextView>(R.id.petAge)
                        tvPetAge.setText(textAgePet)

                        val tvHumanName = findViewById<TextView>(R.id.humanName)
                        tvHumanName.setText(textNameHuman)
                    }
                }
            }
        }
    }

}

