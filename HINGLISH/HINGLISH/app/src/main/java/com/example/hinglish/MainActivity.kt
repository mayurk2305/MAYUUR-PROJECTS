package com.example.hinglish

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions

class MainActivity : AppCompatActivity() {
    private lateinit var translateButton: Button
    private lateinit var devnagriButton: Button
    private lateinit var englishText: EditText
    private lateinit var hindiEditText: EditText
    private lateinit var devnagriEditText: EditText
    private lateinit var translator: Translator
    private var hindiTranslatedText = ""
    private lateinit var copy:ImageButton

    private lateinit var copy3:ImageButton
    private lateinit var clear :Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        translateButton = findViewById(R.id.translate)
        devnagriButton = findViewById(R.id.devnagri)
        englishText = findViewById(R.id.enter)
        hindiEditText = findViewById(R.id.recive)
        devnagriEditText = findViewById(R.id.finalresult)
        copy=findViewById(R.id.copy2)
        copy3=findViewById(R.id.copy3)
        clear=findViewById(R.id.clear)


        val options = TranslatorOptions.Builder()
            .setSourceLanguage(TranslateLanguage.ENGLISH)
            .setTargetLanguage(TranslateLanguage.HINDI)
            .build()
        translator = Translation.getClient(options)

        // Download the model if needed
        translator.downloadModelIfNeeded()
            .addOnSuccessListener {
                Log.d("Translation", "Model downloaded successfully.")
            }
            .addOnFailureListener { exception ->
                Log.e("Translation", "Failed to download model: ${exception.message}")
                exception.printStackTrace()
            }

        // Inside translateButton.setOnClickListener
        translateButton.setOnClickListener {
            val inputText = englishText.text.toString()
            Log.d("Translation", "Input Text: $inputText")

            // Translate the input text
            translator.translate(inputText)
                .addOnSuccessListener { translatedText ->
                    Log.d("Translation", "Translated Text: $translatedText")

                    // Split the translated text into lines after every five words
                    val words = translatedText.split(" ")
                    val groupedText = words.chunked(5).joinToString(System.getProperty("line.separator")) { it.joinToString(" ") }

                    // Display the translated text in Hindi
                    hindiEditText.setText(groupedText)

                    // Store the translated text for later use
                    hindiTranslatedText = translatedText
                }
                .addOnFailureListener { exception ->
                    // Handle translation failure
                    Log.e("Translation", "Translation Failure: ${exception.message}")
                    exception.printStackTrace()

                    // Additional error handling logic can be added here
                }
        }



        // Inside devnagriButton.setOnClickListener
        devnagriButton.setOnClickListener {
            // Convert the stored translated text to Devanagari
            val hindiText = hindiTranslatedText.toString()
            val hindiTransliterator = HindiToLatinTransliterator.getInstance()
            val devnagriText = hindiTransliterator.performTransliteration(hindiText)

            // Split the Devanagari text into lines after every five words
            val wordsDevnagri = devnagriText.split(" ")
            val groupedTextDevnagri = wordsDevnagri.chunked(5).joinToString(System.getProperty("line.separator")) { it.joinToString(" ") }

            // Display the translated text in Devanagari
            devnagriEditText.setText(groupedTextDevnagri)
        }

        copy.setOnClickListener {
            val hindiText = hindiTranslatedText.toString()
            copyTextToClipboard(hindiText)
        }

        copy3.setOnClickListener {
            val devnagriText = devnagriEditText.toString()
            copyTextToClipboard(devnagriText)
        }
        clear.setOnClickListener {
            clearAllEditText()
        }


    }
    fun copyTextToClipboard(text: String) {
        val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("label", text)
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_SHORT).show()
    }
    private fun clearAllEditText() {
        val editText1 = findViewById<EditText>(R.id.enter)
        val editText2 = findViewById<EditText>(R.id.recive)
        val editText3 = findViewById<EditText>(R.id.finalresult)
        // Add more EditText fields as needed

        editText1.text.clear()
        editText2.text.clear()
        editText3.text.clear()
        // Clear text for other EditText fields

        // Optionally, set focus to the first EditText field
        editText1.requestFocus()
    }
}

