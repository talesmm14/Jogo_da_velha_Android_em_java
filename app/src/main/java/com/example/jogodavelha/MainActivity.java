package com.example.jogodavelha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    //    int tabuleiro[][] = new int[3][3];
    int tabuleiro[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    Integer controle = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn0 = (Button) findViewById(R.id.btn0);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
    }

    public void jogo(View btn) {
        TextView jagador = (TextView) findViewById(R.id.jogador);
        TextView placar = (TextView) findViewById(R.id.placar);
        Button button = (Button) btn;

        switch (vencedor()) {
            case 1:
                placar.setText("Jogador O venceu!!!");
                break;
            case -1:
                placar.setText("Jogador X venceu!!!");
                break;
            case 2:
                placar.setText("Deu Velha!!!");
                break;
            default:
                placar.setText("- | -");
        }

        if (controle == -1) {
            jagador.setText("Jogador O");
            button.setText("X");
            button.setEnabled(false);
            jogada(Integer.parseInt((String) btn.getTag()), controle);
            controle = 1;
        } else if (controle == 1) {
            jagador.setText("Jogador X");
            button.setText("O");
            button.setEnabled(false);
            jogada(Integer.parseInt((String) btn.getTag()), controle);
            controle = -1;
        } else {
            placar.setText("Jogada invalida!");
        }
    }

    public void jogada(int tag, int jogador) {
        switch (tag) {
            case 0:
                tabuleiro[0][0] = jogador;
            case 1:
                tabuleiro[0][1] = jogador;
            case 2:
                tabuleiro[0][2] = jogador;
            case 3:
                tabuleiro[1][0] = jogador;
            case 4:
                tabuleiro[1][1] = jogador;
            case 5:
                tabuleiro[1][2] = jogador;
            case 6:
                tabuleiro[2][0] = jogador;
            case 7:
                tabuleiro[2][1] = jogador;
            default:
                tabuleiro[2][2] = jogador;
        }
    }

    public int vencedor() {
        System.out.println(tabuleiroCompleto());
        if (tabuleiroCompleto()) {
            for (int linha = 0; linha < 3; linha++) {

                if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == -3)
                    return -11;
                if ((tabuleiro[linha][0] + tabuleiro[linha][1] + tabuleiro[linha][2]) == 3)
                    return 1;
            }
            for (int coluna = 0; coluna < 3; coluna++) {

                if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == -3)
                    return -1;
                if ((tabuleiro[0][coluna] + tabuleiro[1][coluna] + tabuleiro[2][coluna]) == 3)
                    return 1;
            }
            if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
                return -1;
            if ((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
                return 1;
            if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
                return -1;
            if ((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
                return 1;

            return 2;
        }
        return 0;
    }

    public boolean tabuleiroCompleto() {
        for (int linha = 0; linha < 3; linha++) {
            for (int coluna = 0; coluna < 3; coluna++) {
                if (tabuleiro[linha][coluna] == 0)
                    return false;
            }
        }
        return true;
    }
}
