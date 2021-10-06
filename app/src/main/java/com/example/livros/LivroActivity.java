package com.example.livros;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.livros.MainActivity;

public class LivroActivity extends AppCompatActivity {
    private ActivityLivroBinding activityLivroBinding;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        activityLivroBinding = ActivityLivroBinding.inflate(getLayoutInflater());
        setContentView(activityLivroBinding.getRoot());

        activityLivroBinding.salvarBt.setOnClickListener(
                (View view) ->{
                    Livro livro = new Livro(
                        activityLivroBinding.tituloEt.getText().toString();
                        activityLivroBinding.isbnEt.getText().toString();
                        activityLivroBinding.primeiroAutorEt.getText().toString();
                        activityLivroBinding.editoraEt.getText().toString();
                        Integer.parseInt(activityLivroBinding.edicaoEt.getText().toString());
                        Integer.parseInt(activityLivroBinding.paginasEt.getText().toString());
                    );

                    Intent resultadoIntent = new Intent();
                    resultadoIntent.putExtra(MainActivity.EXTRA_LIVRO,livro);
                    setResult(RESULT_OK, resultadoIntent)
                    finish();
                }
        );

    }

}
