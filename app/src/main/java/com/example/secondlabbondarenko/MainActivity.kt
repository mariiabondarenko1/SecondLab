package com.example.secondlabbondarenko

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.SearchManager
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAddingPet()
        initSearchingGoogle()


    }

    //Приклад явного наміру
    //Ф-ція, що ініціалізує обробник кнопки buttonAddingPet. Ця кнопка запускає активність activity_pet_details
    private fun initSearchingGoogle() = buttonAddingPet.setOnClickListener{
        val intent = Intent(this, PetDetails::class.java) //Створення об'єкту класу Intent, в якому зазаначаємо, який Kotlin-клас буде запущено
        startActivity(intent)

    }

    //Приклад неявного наміру
    //Ф-ція, що ініціалізує обробник кнопки buttonSearchingGoogle. Ця кнопка запускає гугл-пошук
    private fun initAddingPet() = buttonSearchingGoogle.setOnClickListener{
        val search = findViewById<EditText>(R.id.textForSearching)
        val q = search.text.toString()
        val intent = Intent(Intent.ACTION_WEB_SEARCH) //Створення об'єкту класу Intent, в якому зазаначаємо, що повинен запуститися веб-додаток для пошуку
        intent.putExtra(SearchManager.QUERY, q)
        if (intent.resolveActivity(packageManager) != null) { //Перевіряємо чи виконує наш намір якусь діяльність
            startActivity(intent)
        }
    }


}
