package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yandex.mapkit.MapKitFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapKitFactory.setApiKey("63b7711c-25ea-4e12-9bef-5876e37bbd07");

        Button next = findViewById(R.id.button);

        next.setOnClickListener(v -> {

            EditText userLastName = findViewById(R.id.lastName);
            EditText userFirstName = findViewById(R.id.firstName);
            EditText userEmail= findViewById(R.id.email);

            User user = new User(userFirstName.getText().toString(), userLastName.getText().toString(), userEmail.getText().toString());

            if (!userFirstName.getText().toString().equals("")) {
                Intent intent = new Intent(MainActivity.this, SightseeingSelectionActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            } else
                Toast.makeText(MainActivity.this, "Вы не ввели имя. Оно обязательно для продолжения.", Toast.LENGTH_LONG).show();
        });
    }
}
//кнопка создать маршрут, достопримечательности должны "переехать", там есть чекбокс, отметить нужные
//маршрут октрывается над кнопкой под списком, расстояние стандартными методами посчитать в виде "музей -> (2.5 км) -> монастырь"