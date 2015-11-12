package com.example.anak.simon;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_orig);
    }
    public Button getRandomButton() {
        int random = (int) (Math.random() * 4);
        switch (random) {
            case 0: return this.pink;
            case 1: return this.brown;
            case 2: return this.yellow;
            default: return this.blue;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

            return super.onOptionsItemSelected(item);
    }
    public void playSequence() {
        for (Button button : sequence) {
            do {
                try {
                    Thread.sleep(200);
                }catch (InterruptedException ie){
                    System.err.println("PlaySquence thread interrupted.");
                }
            } while (locked);
            button.highlight();
        }
    }
      public void run() {
        boolean userCorrect = true;

        while (userCorrect) {

            //adds next button
            Button next = this.getRandomButton();
            this.sequence.add(next);
            this.playSequence();

            //now let user guess
            while (guesses.size() < sequence.size()) {
                try {
                    Thread.sleep(200);
                }catch (InterruptedException ie){
                    System.err.println("Delay thread interrupted.");
                }

                int i = guesses.size() - 1;
                if (i >= 0 && sequence.get(i) != guesses.get(i)) {
                    userCorrect = false;
                    System.out.println("Incorrect");
                    System.out.println("Sequence: " + sequence);
                    System.out.println("Guesses:  " + guesses);
                    break;
                }
            }
            guesses.clear();
        }

    }

    public static void main(String[] args) {
        Simon game = new Simon();
        game.run();
    }
    protected class Button extends {

        private Color onColor;
        private Color offColor;
        private String name;





            }
        }
