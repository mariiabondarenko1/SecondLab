package com.example.secondlabbondarenko

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Toast


class EditPetDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_pet_info)

        val editNamePet =  findViewById<EditText>(R.id.editNamePet)
        val editAgePet =  findViewById<EditText>(R.id.editAgePet)
        val editNameHuman =  findViewById<EditText>(R.id.editNameHuman)

        val buttonSaveChanges = findViewById<Button>(R.id.buttonSaveChanges)

        //Обробник кнопки "Збереження інформації"
        buttonSaveChanges.setOnClickListener {
            if (editNamePet.text.isEmpty() || editAgePet.text.isEmpty() || editNameHuman.text.isEmpty()){ //Якщо хоча б одне с поле пусте
                Toast.makeText(this, "Заполните все три поля!", Toast.LENGTH_SHORT).show()

            }else{
                // Формуємо "порожній" намір
                val intent = Intent()
                // Додаємо в намір дані
                intent.putExtra("resultEditNamePet",editNamePet.text.toString())
                intent.putExtra("resultEditAgePet",editAgePet.text.toString())
                intent.putExtra("resultEditNameHuman",editNameHuman.text.toString())

                // Устанавливаемо результат
                setResult(RESULT_OK,intent);

                // Закриваємо поточну активність
                finish();
            }
        }

    }


    //Перевизначення методу onBackPressed(), який спрацьовує коли мі натискаемо на поточній активності кнопку "Назад"
    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED)
    }


}