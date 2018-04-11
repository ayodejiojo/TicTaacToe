package com.example.lola.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TwoActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView button[][] = new TextView[3][3];

    private int player1Points;
    private int player2Points;

    private int roundCount;

    private boolean playerTurn1 = true;


    private TextView textViewPlayer1;

    private TextView textViewPlayer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                textViewPlayer1 = findViewById(R.id.text_view_p1);
                textViewPlayer2 = findViewById(R.id.text_view_p2);
                String buttonId = "buttn_" + i + j;
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                button[i][j] = findViewById(resId);
                button[i][j].setOnClickListener(this);

            }
        }
        TextView resetButton = findViewById(R.id.button_reset);


        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resetGame();

            }
        });

    }


    @Override
    public void onClick(View view) {
        if (!((TextView) view).getText().toString().equals("")) {

            return;
        }
        if (playerTurn1) {
            ((TextView) view).setText("x");
        } else {
            ((TextView) view).setText("o");
        }

        roundCount++;
        if (checkWin()) {
            if (playerTurn1) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 9) {

            draw();
        } else {
            playerTurn1 = !playerTurn1;
        }
    }


    private boolean checkWin() {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                field[i][j] = button[i][j].getText().toString();
            }
        }


        for (int i = 0; i < 3; i++) {

            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])

                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {

            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])


                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])

                && !field[0][0].equals("")) {
            return true;
        }

        if (
                field[0][2].equals(field[1][1])
                        && field[0][2].equals(field[2][0])

                        && !field[0][2].equals("")) {
            return true;

        }
        return false;

    }

    private void player1Wins() {
        player1Points++;
        Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show();
        updatePoints();
        resetBoard();
    }

    private void player2Wins() {
        player2Points++;
        Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
        updatePoints();
        resetBoard();
    }

    private void draw() {

        Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePoints() {
        textViewPlayer1.setText("Player1: " + player1Points);
        textViewPlayer2.setText("Player2: " + player2Points);
    }

    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setText("");
            }
        }

        roundCount = 0;
        playerTurn1 = true;
    }

    private void resetGame() {
        player1Points = 0;
        player2Points = 0;
        updatePoints();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1Points);
        outState.putInt("player2Points", player2Points);
        outState.putBoolean("playerTurn1", playerTurn1);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        roundCount = savedInstanceState.getInt("roundCount");
        player1Points =savedInstanceState.getInt("player1points");
        player2Points =savedInstanceState.getInt("player2Points");
        playerTurn1 =savedInstanceState.getBoolean("playerTurn1");
    }


}
