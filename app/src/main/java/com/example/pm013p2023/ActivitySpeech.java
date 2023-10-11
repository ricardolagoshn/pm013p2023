package com.example.pm013p2023;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class ActivitySpeech extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 100;
    private SpeechRecognizer speechRecognizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {

                // Se llama cuando se obtienen los resultados del reconocimiento
                ArrayList<String> resultList = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (resultList != null && !resultList.isEmpty()) {
                    String recognizedText = resultList.get(0);
                    // Aquí puedes manejar el texto reconocido
                    // Por ejemplo, mostrarlo en un TextView o realizar alguna otra acción.
                }

            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });

        Button startSpeechRecognitionButton = findViewById(R.id.button);
        startSpeechRecognitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSpeechRecognition();
            }
        });
    }

    private void startSpeechRecognition() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException e) {
            // Se lanza si no se encuentra el reconocimiento de voz en el dispositivo
            Toast.makeText(this, "Reconocimiento de voz no compatible en este dispositivo", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == RESULT_OK && data != null) {
            ArrayList<String> resultList = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (resultList != null && !resultList.isEmpty()) {
                String recognizedText = resultList.get(0);
                // Aquí puedes manejar el texto reconocido
                // Por ejemplo, mostrarlo en un TextView o realizar alguna otra acción.
                TextView textViewResult = findViewById(R.id.textViewResult); // Reemplaza con el ID de tu TextView
                textViewResult.setText(recognizedText);
            }
        }
    }
}